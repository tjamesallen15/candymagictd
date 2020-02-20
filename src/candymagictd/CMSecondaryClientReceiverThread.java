/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JamesAllen
 */
public class CMSecondaryClientReceiverThread implements Runnable {

    boolean isHost = false;
    CandyMagicTDLobby cmtdl;
    CandyMagicPanel candyMagicPanel;
    CMCommand candyMagicCommandIn;
    ObjectOutputStream cmClientSocketOut;
    ObjectInputStream cmClientToServerIn;
    Socket cmClientSocket;
    Socket cmMainClientSocket;

    public CMSecondaryClientReceiverThread(CandyMagicTDLobby cmtdlobby, Socket cmSocket, Socket myCmMainClientSocket, boolean myIsHost) {
        cmtdl = cmtdlobby;
        cmClientSocket = cmSocket;
        isHost = myIsHost;
        cmtdl.reconnectSecondaryVariable(this);
    }

    @Override
    public void run() {
        try {
            cmClientSocketOut = new ObjectOutputStream(cmClientSocket.getOutputStream());
            cmClientToServerIn = new ObjectInputStream(cmClientSocket.getInputStream());
            while (true) {
                candyMagicCommandIn = (CMCommand) cmClientToServerIn.readObject();
                if (candyMagicCommandIn.getCMValue1().equals("BUILDTOWER")) {
                    candyMagicPanel.setNetworkBuildTower(Integer.parseInt(candyMagicCommandIn.getCMValue2()), candyMagicCommandIn.getCMValue3(), Integer.parseInt(candyMagicCommandIn.getCMValue4()), Integer.parseInt(candyMagicCommandIn.getCMValue5()));
                } else if (candyMagicCommandIn.getCMValue1().equals("SELLTOWER")) {
                    candyMagicPanel.setNetworkSellTower(Integer.parseInt(candyMagicCommandIn.getCMValue2()), Integer.parseInt(candyMagicCommandIn.getCMValue3()), Integer.parseInt(candyMagicCommandIn.getCMValue4()));
                } else if (candyMagicCommandIn.getCMValue1().equals("UPGRADETOWER")) {
                    candyMagicPanel.setNetworkUpgradeTower(Integer.parseInt(candyMagicCommandIn.getCMValue2()), Integer.parseInt(candyMagicCommandIn.getCMValue3()), Integer.parseInt(candyMagicCommandIn.getCMValue4()));
                }

                if (candyMagicCommandIn.getCMValue1().equals("PREGAME")) {
                    if (candyMagicCommandIn.getCMValue2().equals("ISCONNECTED")) {
                        if (candyMagicCommandIn.getCMValue3().equals("HOSTFULL")) {
                            cmtdl.updateForm1("ISCONNECTED", "HOSTFULL");

                            break;
                        } else if (candyMagicCommandIn.getCMValue3().equals("HOSTNOTFULL")) {
                            cmtdl.updateForm1("ISCONNECTED", "HOSTNOTFULL");
                        }
                    } else if (candyMagicCommandIn.getCMValue2().equals("ULIST")) {
                        cmtdl.updateForm2("ULIST", candyMagicCommandIn.getCMArray1());
                        cmtdl.updateForm3(candyMagicCommandIn.getCMValue3());
                    } else if (candyMagicCommandIn.getCMValue2().equals("CHAT")) {
                        cmtdl.updateForm1("CHAT", candyMagicCommandIn.getCMValue3());
                    } else if (candyMagicCommandIn.getCMValue2().equals("LEAVEUPDATE")) {
                        cmtdl.updateForm1("LEAVEUPDATE", candyMagicCommandIn.getCMValue3());
                    } else if (candyMagicCommandIn.getCMValue2().equals("KICK")) {
                        cmtdl.updateForm1("KICK", candyMagicCommandIn.getCMValue3());
                    } else if (candyMagicCommandIn.getCMValue2().equals("KICKUPDATE")) {
                        cmtdl.updateForm1("KICKUPDATE", candyMagicCommandIn.getCMValue3());
                    } else if (candyMagicCommandIn.getCMValue2().equals("DISBANDED")) {
                        cmtdl.updateForm1("DISBANDED", null);

                        break;
                    }
                }
                
                if(candyMagicCommandIn.getCMValue1().equals("INGAME")) {
                    if(candyMagicCommandIn.getCMValue2().equals("QUIT")) {
                        if(candyMagicCommandIn.getCMValue3().equals("SERVER")) {
                            candyMagicPanel.setNetworkQuitServer();
                            
                            break;
                        } else if(candyMagicCommandIn.getCMValue3().equals("CLIENT")) {
                            if(candyMagicPanel.playerName.equals(candyMagicCommandIn.getCMValue4())) {
                                break;
                            } else {
                                candyMagicPanel.setNetworkQuitClient(candyMagicCommandIn.getCMValue4());
                            }
                        }
                    }
                    
                    if(candyMagicCommandIn.getCMValue2().equals("MMSIGNAL")) {
                        candyMagicPanel.setNetworkMiniMapSignal(Integer.parseInt(candyMagicCommandIn.getCMValue3()), Integer.parseInt(candyMagicCommandIn.getCMValue4()));
                    }
                    
                    if(candyMagicCommandIn.getCMValue2().equals("FINISH")) {
                        candyMagicPanel.setNetworkFinishGame(candyMagicCommandIn.getCMValue3());
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Client Thread Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMSecondaryClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cmClientToServerIn.close();
                closeSocket();
            } catch (IOException ex) {
                System.err.println("Client Thread Closing ObjectInputStream Exception Message: " + ex.getMessage());
//                Logger.getLogger(CMSecondaryClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clientBroadCastMessage(CMCommand candyMagicCommand) {
        try {
            cmClientSocketOut.writeObject(candyMagicCommand);
            cmClientSocketOut.reset();
        } catch (Exception ex) {
            System.out.println("Sending Client Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMSecondaryClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCandyMagicPanel(CandyMagicPanel cmp) {
        candyMagicPanel = cmp;
    }

    public void closeSocket() {
        try {
            cmClientSocketOut.close();
            cmClientSocket.close();
        } catch (Exception ex) {
            System.out.println("Closing Client Thread Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMSecondaryClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
