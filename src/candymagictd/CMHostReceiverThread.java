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
 * @author Sensen
 */
public class CMHostReceiverThread implements Runnable {

    CandyMagicTDLobby cmtdl;
    CandyMagicPanel candyMagicPanel;
    CMCommand candyMagicCommandIn;
    ObjectOutputStream cmClientSocketOut;
    Socket cmClientSocket;

    public CMHostReceiverThread(CandyMagicTDLobby cmtdlobby, Socket cmSocket) {
        cmtdl = cmtdlobby;
        cmClientSocket = cmSocket;
        cmtdl.reconnectHostVariable(this);
    }

    @Override
    public void run() {
        try {
            cmClientSocketOut = new ObjectOutputStream(cmClientSocket.getOutputStream());
            ObjectInputStream cmClientToServerIn = new ObjectInputStream(cmClientSocket.getInputStream());
            while (true) {
                candyMagicCommandIn = (CMCommand) cmClientToServerIn.readObject();

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

                if (candyMagicCommandIn.getCMValue1().equals("INGAME")) {
                    if (candyMagicCommandIn.getCMValue2().equals("QUIT")) {
                        if (candyMagicCommandIn.getCMValue3().equals("SERVER")) {

                            break;
                        } else if (candyMagicCommandIn.getCMValue3().equals("CLIENT")) {
                            System.out.println("received");
                            candyMagicPanel.setNetworkQuitClient(candyMagicCommandIn.getCMValue4());
                        }
                    }

                    if (candyMagicCommandIn.getCMValue2().equals("MMSIGNAL")) {
                        candyMagicPanel.setNetworkMiniMapSignal(Integer.parseInt(candyMagicCommandIn.getCMValue3()), Integer.parseInt(candyMagicCommandIn.getCMValue4()));
                    }

                    if (candyMagicCommandIn.getCMValue2().equals("FINISH")) {
                        candyMagicPanel.setNetworkFinishGame(candyMagicCommandIn.getCMValue3());
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Host Receive Thread Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMHostReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCandyMagicPanel(CandyMagicPanel cmp) {
        candyMagicPanel = cmp;
    }

    public void clientBroadCastMessage(CMCommand candyMagicCommand) {
        try {
            cmClientSocketOut.writeObject(candyMagicCommand);
            cmClientSocketOut.reset();
        } catch (Exception ex) {
            System.out.println("Sending Host Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMSecondaryClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
