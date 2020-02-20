/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sensen
 */
public class CMHostServerReceiverThread implements Runnable {

    CMServerConnectorThread cmsct;
    CMCommand candyMagicCommandIn;
    Socket cmClientSocket;
    
    public CMHostServerReceiverThread(CMServerConnectorThread cms, Socket cmSock) {
        cmsct = cms;
        cmClientSocket = cmSock;
    }
    
    @Override
    public void run() {
        try {
            ObjectInputStream cmServerReceiver = new ObjectInputStream(cmClientSocket.getInputStream());
            while (true) {
                candyMagicCommandIn = (CMCommand) cmServerReceiver.readObject();
                
                if(candyMagicCommandIn.getCMValue1().equals("PREGAME")) {
                    if(candyMagicCommandIn.getCMValue2().equals("DISBAND")) {
                        cmsct.cmMainServerSocket.close();
                        cmsct.cmSecondaryServerSocket.close();
                        candyMagicCommandIn = new CMCommand("PREGAME", "DISBANDED", "XD", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                        cmsct.serverSecondaryBroadCastMessage(candyMagicCommandIn);
                    } else if(candyMagicCommandIn.getCMValue2().equals("ULIST")) {
                        cmsct.serverSecondaryBroadCastMessage(candyMagicCommandIn);
                    }
                }
                
                if(candyMagicCommandIn.getCMValue1().equals("INGAME")) {
                    if(candyMagicCommandIn.getCMValue2().equals("QUIT")) {
                        cmsct.cmMainServerSocket.close();
                        cmsct.cmSecondaryServerSocket.close();
                        cmsct.serverSecondaryBroadCastMessage(candyMagicCommandIn);
                    }
                }
                cmsct.serverSecondaryBroadCastMessage(candyMagicCommandIn);
            }
        } catch (Exception ex) {
            System.out.println("Sending Host Server Exception Message: " + ex.getMessage());
//            Logger.getLogger(CMHostServerReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cmClientSocket.close();
                cmsct.removeSecondaryConnection(cmClientSocket);
            } catch (IOException ex) {
                System.out.println("Sending Host Server Closing Socket Exception Message: " + ex.getMessage());
//                Logger.getLogger(CMHostServerReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
