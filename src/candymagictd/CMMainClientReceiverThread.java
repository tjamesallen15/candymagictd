/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.awt.image.BufferedImage;
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
public class CMMainClientReceiverThread implements Runnable {

    boolean cmGameInitialization = false;
    boolean cmGameFlushOut = false;
    CandyMagicTDLobby cmtdl;
    CandyMagicPanel candyMagicPanel;
    CMCommand candyMagicCommandIn;
    ObjectOutputStream cmClientSocketOut;
    ObjectInputStream cmClientToServerIn;
    Socket cmClientSocket;
    int numberOfUpdates = 0;

    public CMMainClientReceiverThread(CandyMagicTDLobby cmtdlobby, Socket cmSocket) {
        cmtdl = cmtdlobby;
        cmClientSocket = cmSocket;
    }

    @Override
    public void run() {
        try {
            cmClientSocketOut = new ObjectOutputStream(cmClientSocket.getOutputStream());
            cmClientToServerIn = new ObjectInputStream(cmClientSocket.getInputStream());
            while (true) {
                candyMagicCommandIn = (CMCommand) cmClientToServerIn.readObject();
                //System.err.println(candyMagicCommandIn.getCMValue1());
                if (candyMagicCommandIn.getCMValue1().equals("START")) {
                    cmtdl.reconnectMainVariables("CLIENT", null, null, this);
                    cmtdl.startCandyMagicTimer();
                    cmtdl.cmTimer.start();
                } 
                else if (candyMagicCommandIn.getCMValue1().equals("DOODADTREE")) {
                    for (int a = 0; a < candyMagicPanel.getTreeList().size(); a++) {
                        Tree tr = (Tree) candyMagicPanel.getTreeList().get(a);
                        if (tr.getDoodadID() == Integer.parseInt(candyMagicCommandIn.getCMValue2())) {
                            tr.setImage((BufferedImage) candyMagicPanel.getTreeImageList().get(Integer.parseInt(candyMagicCommandIn.getCMValue3())));
                            break;
                        }
                    }
                } else if (candyMagicCommandIn.getCMValue1().equals("DOODADBUSH")) {
                    for (int a = 0; a < candyMagicPanel.getBushList().size(); a++) {
                        Bush b = (Bush) candyMagicPanel.getBushList().get(a);
                        if (b.getDoodadID() == Integer.parseInt(candyMagicCommandIn.getCMValue2())) {
                            b.setImage((BufferedImage) candyMagicPanel.getBushImageList().get(Integer.parseInt(candyMagicCommandIn.getCMValue3())));
                            break;
                        }
                    }
                } else if (candyMagicCommandIn.getCMValue1().equals("UPDATETOWER")) {
                    candyMagicPanel.setNetworkMainUpdateTower(Integer.parseInt(candyMagicCommandIn.getCMValue2()), candyMagicCommandIn.getCMValue3(), Integer.parseInt(candyMagicCommandIn.getCMValue4()), Integer.parseInt(candyMagicCommandIn.getCMValue5()), Integer.parseInt(candyMagicCommandIn.getCMValue6()));
                } else if (candyMagicCommandIn.getCMValue1().equals("PLAYERNAME")) {
                    candyMagicPanel.setNetworkServerPlayerName(candyMagicCommandIn.getCMValue2(), candyMagicCommandIn.getCMValue3(), candyMagicCommandIn.getCMValue4(), candyMagicCommandIn.getCMValue5());
                } else if (candyMagicCommandIn.getCMValue1().equals("TIMER")) {
                    if (cmGameFlushOut == false) {
                        candyMagicPanel.setGameFlushOut(Integer.parseInt(candyMagicCommandIn.getCMValue3()), Integer.parseInt(candyMagicCommandIn.cmCValue4));
                        numberOfUpdates = 0;
                        cmGameFlushOut = true;
                    }
                    candyMagicPanel.setCreepCounterForWave(Integer.parseInt(candyMagicCommandIn.getCMValue2()));
                    if (candyMagicPanel.getCreepCountForWave() == 0) {
                        if (candyMagicPanel.cmGameRenderingInitialization == false) {
                            candyMagicPanel.cmGameRenderingInitialization = true;
                            candyMagicPanel.setCreepCounterForWave(10);
                        } else {
                            if (candyMagicPanel.getCreepInside() == 0) {
                                candyMagicPanel.loadCreepWave();
                                candyMagicPanel.setCreepCounterForWave(10);
                                cmGameFlushOut = false;
                            }
                        }
                    }
                    if (cmGameInitialization == false) {
                        new RenderUpdateGame().start();
                        cmGameInitialization = true;
                    }
                } else if (candyMagicCommandIn.getCMValue1().equals("UPDATEGAME")) {
                    candyMagicPanel.setClientCastleLife(Integer.parseInt(candyMagicCommandIn.getCMValue2()));
                    candyMagicPanel.setClientLoadKillsOnLeaderBoard(Integer.parseInt(candyMagicCommandIn.getCMValue3()), Integer.parseInt(candyMagicCommandIn.getCMValue4()), Integer.parseInt(candyMagicCommandIn.getCMValue5()), Integer.parseInt(candyMagicCommandIn.getCMValue6()));
                    numberOfUpdates++;
                }
            }
        } catch (Exception ex) {
            System.err.println("Main Client Thread Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMMainClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cmClientToServerIn.close();
                cmClientSocket.close();
            } catch (Exception ex) {
                System.err.println("Main Client Thread Close ObjectInputStream Exception Message: " + ex.getMessage());
//                Logger.getLogger(CMMainClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clientBroadCastMessage(CMCommand candyMagicCommand) {
        try {
            cmClientSocketOut.writeObject(candyMagicCommand);
            cmClientSocketOut.reset();
        } catch (Exception ex) {
            System.out.println("Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMMainClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCandyMagicPanel(CandyMagicPanel cmp) {
        candyMagicPanel = cmp;
    }

    public class RenderUpdateGame extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    if (numberOfUpdates != 0) {
                        candyMagicPanel.updateCandyMagicGame();
                        numberOfUpdates -= 1;
                    }
                    candyMagicPanel.renderCandyMagicGame();
                    candyMagicPanel.paintCandyMagicGame();
                    Thread.sleep(15);
                } catch (Exception ex) {
                    System.out.println("Exception Message: " + ex.getMessage());
//                    Logger.getLogger(CMMainClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void closeSocket() {
        try {
            cmClientSocketOut.close();
            cmClientSocket.close();
        } catch (Exception ex) {
            System.out.println("Closing Main Client Thread Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMSecondaryClientReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
