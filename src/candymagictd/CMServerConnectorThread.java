package candymagictd;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JamesAllen
 */
public class CMServerConnectorThread implements Runnable {

    int cmMainHostPortNumber;
    int cmSecondaryHostPortNumber;
    int clientCount = 0;
    CandyMagicTDLobby cmtdl;
    CandyMagicPanel candyMagicPanel;
    Hashtable cmMainClientSocketList = new Hashtable();
    Hashtable cmSecondaryClientSocketList = new Hashtable();
    ServerSocket cmMainServerSocket;
    ServerSocket cmSecondaryServerSocket;
    Socket cmMainClientSocket;
    Socket cmSecondaryClientSocket;
    
    public CMServerConnectorThread(CandyMagicTDLobby cmtdlobby, int mainPort, int secPort) {
        cmtdl = cmtdlobby;
        cmMainHostPortNumber = mainPort;
        cmSecondaryHostPortNumber = secPort;
    }

    @Override
    public void run() {
        try {
            cmMainServerSocket = new ServerSocket(9211);
            cmSecondaryServerSocket = new ServerSocket(9212);
            System.out.println("Server Creation Successful!");
            while (true) {
                if(clientCount > 3) {
                    System.out.println("client count: " + clientCount);
                    cmMainClientSocket = cmMainServerSocket.accept();
                    cmSecondaryClientSocket = cmSecondaryServerSocket.accept();
                    ObjectOutputStream cmSecondaryShout = new ObjectOutputStream(cmSecondaryClientSocket.getOutputStream());
                    
                    CMCommand cmc = new CMCommand("PREGAME", "ISCONNECTED", "HOSTFULL", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                    cmSecondaryShout.writeObject(cmc);
                    cmSecondaryShout.reset();
                    
                    cmSecondaryShout = null;
                    cmSecondaryClientSocket = null;
                    cmMainClientSocket = null;
                } else {
                    if(clientCount == 0) {
                        cmSecondaryClientSocket = cmSecondaryServerSocket.accept();
                        ObjectOutputStream cmSecondaryShout = new ObjectOutputStream(cmSecondaryClientSocket.getOutputStream());
                        CMCommand cmc = new CMCommand("PREGAME", "ISCONNECTED", "HOSTNOTFULL", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                        cmSecondaryShout.writeObject(cmc);
                        cmSecondaryShout.reset();
                        cmSecondaryClientSocketList.put(cmSecondaryClientSocket, cmSecondaryShout);
                        new Thread(new CMHostServerReceiverThread(this, cmSecondaryClientSocket)).start();

                        clientCount++;
                    } else {
                        cmMainClientSocket = cmMainServerSocket.accept();
                        cmSecondaryClientSocket = cmSecondaryServerSocket.accept();
                        ObjectOutputStream cmMainShout = new ObjectOutputStream(cmMainClientSocket.getOutputStream());
                        ObjectOutputStream cmSecondaryShout = new ObjectOutputStream(cmSecondaryClientSocket.getOutputStream());
                        CMCommand cmc = new CMCommand("PREGAME", "ISCONNECTED", "HOSTNOTFULL", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                        cmSecondaryShout.writeObject(cmc);
                        cmSecondaryShout.reset();
                        cmMainClientSocketList.put(cmMainClientSocket, cmMainShout);
                        cmSecondaryClientSocketList.put(cmSecondaryClientSocket, cmSecondaryShout);
                        new Thread(new CMMainServerReceiverThread(cmtdl, this, cmSecondaryClientSocket, cmMainClientSocket)).start();

                        clientCount++;
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Server Thread Exception Message: " + ex.getMessage());
        }
    }
    
    Enumeration getMainSocketOutputStreams() {
        return cmMainClientSocketList.elements();
    }
    
    Enumeration getSecondarySocketOutputStreams() {
        return cmSecondaryClientSocketList.elements();
    }
    
    public void serverMainBroadCastMessage (CMCommand cmc) {
        for (Enumeration e = getMainSocketOutputStreams(); e.hasMoreElements();) {
            try {
                ObjectOutputStream shout = (ObjectOutputStream)e.nextElement();
                shout.writeObject(cmc);
                shout.reset();
            } catch (Exception ex) {
                System.out.println("Server Main Broadcast Exception Message: " + ex.getMessage());
            }
        }
    }
    
    public void serverSecondaryBroadCastMessage (CMCommand cmc) {
        for (Enumeration e = getSecondarySocketOutputStreams(); e.hasMoreElements();) {
            try {
                ObjectOutputStream shout = (ObjectOutputStream)e.nextElement();
                shout.writeObject(cmc);
                shout.reset();
            } catch (Exception ex) {
                System.out.println("Server Secondary Broadcast Exception Message: " + ex.getMessage());
            }
        }
    }
    
    public void setCandyMagicPanel(CandyMagicPanel cmp) {
        candyMagicPanel = cmp;
    }
    
    public CandyMagicPanel getCandyMagicPanel() {
        return candyMagicPanel;
    }
    
    public void removeSecondaryConnection(Socket s) {
        cmSecondaryClientSocketList.remove(s);
    }
    
    public void removeMainConnection(Socket s) {
        --clientCount;
        cmMainClientSocketList.remove(s);
    }
}
