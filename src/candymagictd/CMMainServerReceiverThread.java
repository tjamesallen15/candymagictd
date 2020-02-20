/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JamesAllen
 */
public class CMMainServerReceiverThread implements Runnable {

    CandyMagicTDLobby cmtdl;
    CMServerConnectorThread cmsct;
    CMCommand candyMagicCommandIn;
    Socket cmClientSocket;
    Socket cmMainClientSocket;
    ArrayList<CMCommand> actionList;
    
    public CMMainServerReceiverThread(CandyMagicTDLobby cmtdlobby, CMServerConnectorThread cms, Socket cmSock, Socket myMainSocket) {
        cmtdl = cmtdlobby;
        cmsct = cms;
        cmClientSocket = cmSock;
        cmMainClientSocket = myMainSocket;
        actionList = new ArrayList<>();
        
        new ActionRequestOperator().start();
    }

    @Override
    public void run() {
        try {
            ObjectInputStream cmServerReceiver = new ObjectInputStream(cmClientSocket.getInputStream());
            while (true) {
                candyMagicCommandIn = (CMCommand) cmServerReceiver.readObject();
                if (candyMagicCommandIn.getCMValue1().equals("BUILDTOWER")) {
                    actionList.add(candyMagicCommandIn);
                } else if (candyMagicCommandIn.getCMValue1().equals("SELLTOWER")) {
                    actionList.add(candyMagicCommandIn);
                } else if (candyMagicCommandIn.getCMValue1().equals("UPGRADETOWER")) {
                    actionList.add(candyMagicCommandIn);
                } else if (candyMagicCommandIn.getCMValue1().equals("UPDATETOWER")) {
                    actionList.add(candyMagicCommandIn);
                } else if (candyMagicCommandIn.getCMValue1().equals("PLAYERNAME")) {
                    cmsct.getCandyMagicPanel().setNetworkClientPlayerName(candyMagicCommandIn.getCMValue2());
                } 
                
                if(candyMagicCommandIn.getCMValue1().equals("PREGAME")) {
                    actionList.add(candyMagicCommandIn);
                }
                
                if(candyMagicCommandIn.getCMValue1().equals("INGAME")) {
                    actionList.add(candyMagicCommandIn);
                }
            }
        } catch (Exception ex) {
            System.err.println("Client Server Thread Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMMainServerReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("close dito!");
                cmsct.removeMainConnection(cmMainClientSocket);
                cmsct.removeSecondaryConnection(cmClientSocket);
                cmMainClientSocket.close();
                cmClientSocket.close();
            } catch (IOException ex) {
                System.err.println("Client Server Thread Closing Socket Exception Message: " + ex.getMessage());
//                Logger.getLogger(CMMainServerReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
    public class ActionRequestOperator extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    if (actionList.size() != 0) {
                        CMCommand cmc = (CMCommand) actionList.get(0);
                        if (cmc.getCMValue1().equals("BUILDTOWER")) {
                            cmsct.getCandyMagicPanel().setNetworkBuildTower(Integer.parseInt(cmc.getCMValue2()), cmc.getCMValue3(), Integer.parseInt(cmc.getCMValue4()), Integer.parseInt(cmc.getCMValue5()));
                            cmsct.serverSecondaryBroadCastMessage(cmc);
                        } else if (cmc.getCMValue1().equals("SELLTOWER")) {
                            cmsct.getCandyMagicPanel().setNetworkSellTower(Integer.parseInt(cmc.getCMValue2()), Integer.parseInt(cmc.getCMValue3()), Integer.parseInt(cmc.getCMValue4()));
                            cmsct.serverSecondaryBroadCastMessage(cmc);
                        } else if (cmc.getCMValue1().equals("UPGRADETOWER")) {
                            cmsct.getCandyMagicPanel().setNetworkUpgradeTower(Integer.parseInt(cmc.getCMValue2()), Integer.parseInt(cmc.getCMValue3()), Integer.parseInt(cmc.getCMValue4()));
                            cmsct.serverSecondaryBroadCastMessage(cmc);
                        } else if (cmc.getCMValue1().equals("UPDATETOWER")) {
                            cmsct.getCandyMagicPanel().setNetworkClientUpdateTower(Integer.parseInt(cmc.getCMValue2()), cmc.getCMValue3(), Integer.parseInt(cmc.getCMValue4()), Integer.parseInt(cmc.getCMValue5()), Integer.parseInt(cmc.getCMValue6()));
                        }

                        if (cmc.getCMValue1().equals("PREGAME")) {
                            if (cmc.getCMValue2().equals("LEAVE")) {
                                cmc = new CMCommand("PREGAME", "LEAVEUPDATE", cmc.getCMValue3(), "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                            }
                            cmsct.serverSecondaryBroadCastMessage(cmc);
                        }
                        
                        if(cmc.getCMValue1().equals("INGAME")) {
                            cmsct.serverSecondaryBroadCastMessage(cmc);
                        }
                        actionList.remove(0);
                    }
                    Thread.sleep(100);
                } catch (Exception ex) {
                    System.out.println("Client Server Thread ActionRequestOperator Exception Message: " + ex.getMessage());
//                    Logger.getLogger(CMMainServerReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                }
            }
        }
    }
}
