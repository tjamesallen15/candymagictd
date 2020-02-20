/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author JamesAllen
 */
public class CandyMagicTDLobby extends JFrame {

    //Host and Player Variables
    String hostName;
    String playerName;
    boolean isHost = false;
    //Network objects
    ObjectOutputStream cmClientSocketOut;
    CMCommand cmc;
    Socket cmMainClientSocket;
    Socket cmSecondaryClientSocket;
    //Game Variables
    Timer cmTimer;
    int cmTimerInteger = 5;
    CMServerConnectorThread cmsct = null;
    //Multicast Variables
    InetAddress cmNetworkGroup;
    MulticastSocket cmMulticastSocket;
    String cmFinalPacket;
    String cmHostAddress;
    String hostAddress;
    String host;
    //Host List Variables
    ArrayList cmHostList;
    ArrayList cmHostAddressList;
    //Reconnector Variables
    String rcmmt;
    CMServerConnectorThread rcmsct;
    CMMainServerReceiverThread rcmmsrt;
    CMMainClientReceiverThread rcmmcrt;
    CMSecondaryClientReceiverThread rcmscrt;
    CMHostReceiverThread rcmhrt;
    CandyMagicSplashScreenLobby rcmssl;

    public CandyMagicTDLobby(CandyMagicSplashScreenLobby cmssl) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image imageCursor = tk.getImage("objects\\cursor\\cmCursor.png");
        Cursor cmCursor = tk.createCustomCursor(imageCursor, new Point(0, 0), "Custom Cursor");
        this.setCursor(cmCursor);
        initComponents();
        this.getContentPane().setBackground(Color.PINK);
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        rcmssl = cmssl;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        try {
            cmNetworkGroup = InetAddress.getByName("230.0.0.255");
            cmMulticastSocket = new MulticastSocket(8887);
            cmMulticastSocket.joinGroup(cmNetworkGroup);

            cmHostList = new ArrayList();
            cmHostAddressList = new ArrayList();

            new Thread(new CMListenPacket()).start();
            cmSearchPCAddress();
            if (cmHostAddress == null) {
                jLabelIP.setText("You are not connected to any network.");
            } else {
                jLabelIP.setText(cmHostAddress);
            }

            sendMulticastPacket("requesthosts,");
        } catch (Exception ex) {
            System.err.println("Connecting Multicast Exception Message: " + ex.getMessage());
//            Logger.getLogger(CandyMagicTDLobby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cmClientConnectToServer(String myHostAddress) {
        try {
            cmMainClientSocket = new Socket(myHostAddress, 9211);
            cmSecondaryClientSocket = new Socket(myHostAddress, 9212);
            new Thread(new CMMainClientReceiverThread(this, cmMainClientSocket)).start();
            new Thread(new CMSecondaryClientReceiverThread(this, cmSecondaryClientSocket, cmMainClientSocket, isHost)).start();
        } catch (UnknownHostException ex) {
            System.err.println("Client Connecting to Host Exception Message: " + ex.getMessage());

            showErrorDialog("Host not found");

            cmHostAddressList.clear();
            cmHostList.clear();

            if (jListPlayersHosts.getModel().getSize() != 0) {
                DefaultListModel lModel = (DefaultListModel) jListPlayersHosts.getModel();
                lModel.removeAllElements();
                jListPlayersHosts.setModel(lModel);
            }

            sendMulticastPacket("requesthosts,");
        } catch (IOException ex) {
            System.err.println("Client Connecting to Host Exception Message: " + ex.getMessage());

            showErrorDialog("Cannot connect to host");

            cmHostAddressList.clear();
            cmHostList.clear();

            if (jListPlayersHosts.getModel().getSize() != 0) {
                DefaultListModel lModel = (DefaultListModel) jListPlayersHosts.getModel();
                lModel.removeAllElements();
                jListPlayersHosts.setModel(lModel);
            }

            sendMulticastPacket("requesthosts,");
        }
    }

    public void cmHostConnectToServer() {
        try {
            isHost = true;
            cmSecondaryClientSocket = new Socket(cmHostAddress, 9212);
            new Thread(new CMHostReceiverThread(this, cmSecondaryClientSocket)).start();
        } catch (Exception ex) {
        }
    }

    public void startCandyMagicTimer() {
        cmTimerInteger = 5;
        cmTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldChatMessage.setEditable(false);
                if(btnJoinGame.isEnabled()) {
                    btnJoinGame.setEnabled(false);
                }
                
                if (cmTimerInteger != 0) {
                    if (jTextAreaChat.getText().equals("")) {
                        jTextAreaChat.setText("Game Starting In " + cmTimerInteger + "...");
                    } else {
                        jTextAreaChat.append("\n" + "Game Starting In " + cmTimerInteger + "...");
                        jTextAreaChat.setCaretPosition(jTextAreaChat.getDocument().getLength());
                    }
                    cmTimerInteger--;
                } else {
                    cmTimer.stop();
                    rcmssl.setVisible(false);
                    setVisible(false);
                    callCandyMagicTD(rcmmt, rcmsct, rcmmsrt, rcmmcrt, rcmscrt);
                }
            }
        });
    }

    public void reconnectMainVariables(String cmmt, CMServerConnectorThread cmsct, CMMainServerReceiverThread cmmsrt, CMMainClientReceiverThread cmmcrt) {
        rcmmt = cmmt;
        rcmsct = cmsct;
        rcmmsrt = cmmsrt;
        rcmmcrt = cmmcrt;
    }

    public void reconnectSecondaryVariable(CMSecondaryClientReceiverThread cmscrt) {
        rcmscrt = cmscrt;
    }

    public void reconnectHostVariable(CMHostReceiverThread cmhrt) {
        rcmhrt = cmhrt;
    }

    public void callCandyMagicTD(String cmmt, CMServerConnectorThread conThread, CMMainServerReceiverThread serverRecThread, CMMainClientReceiverThread clientMainRecThread, CMSecondaryClientReceiverThread clientSecRecThread) {
        new CandyMagicTD(txtPlayerName.getText(), cmmt, conThread, serverRecThread, clientMainRecThread, clientSecRecThread, rcmhrt, this);
    }

    public void cmSearchPCAddress() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface current = interfaces.nextElement();
            if (!current.isUp() || current.isLoopback() || current.isVirtual()) {
                continue;
            }
            Enumeration<InetAddress> addresses = current.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress current_addr = addresses.nextElement();
                if (current_addr instanceof Inet4Address) {
                    cmHostAddress = current_addr.getHostAddress();
                    break;
                }
                break;
            }
        }
    }

    public void sendMulticastPacket(String packetMessage) {
        try {
            DatagramPacket packSend = new DatagramPacket(packetMessage.getBytes(), packetMessage.length(), cmNetworkGroup, 8887);
            cmMulticastSocket.send(packSend);
        } catch (IOException ex) {
            System.out.println("Packet Sending Exception Message: " + ex.getMessage());
        }
    }

    public class CMListenPacket implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    byte[] buf = new byte[9999];
                    DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
                    cmMulticastSocket.receive(receivePacket);
                    host = new String(receivePacket.getData());
                    System.out.println("received: " + host);
                    int separator = host.indexOf(",");
                    String cmHostAddress = host.substring(0, separator);
                    if (cmHostAddress.equals("requesthosts")) {
                        if (!btnJoinGame.isEnabled()) {
                            if(btnJoinGame.getText().equals("Join Game")) {
                                sendMulticastPacket(cmFinalPacket);
                            }
                        }
                    } else if (cmHostAddress.equals("disbandhost")) {
                        if (jLabelTrueHostName.getText().equals("You are not joined in any room")) {
                            if (jListPlayersHosts.getModel().getSize() != 0) {
                                DefaultListModel lModel = (DefaultListModel) jListPlayersHosts.getModel();
                                lModel.removeAllElements();
                                jListPlayersHosts.setModel(lModel);
                            }

                            cmHostAddressList.clear();
                            cmHostList.clear();
                        }
                    } else {
                        if (btnJoinGame.isEnabled()) {
                            addHost(host);
                        }
                    }
                    host = null;
                } catch (IOException ex) {
                    System.err.println("Packet Receiving Exception Message: " + ex.getMessage());
                }
            }
        }
    }

    public void addHost(String host) {
        int separator = host.indexOf(",");
        String cmHostAddress = host.substring(0, separator);
        String hostName = host.substring(separator + 1, host.length());

        if (jListPlayersHosts.getModel().getSize() == 0) {
            cmHostList.add(hostName);
            cmHostAddressList.add(cmHostAddress);
            DefaultListModel listModel = new DefaultListModel();
            listModel.addElement(hostName.toString().trim());
            jListPlayersHosts.setModel(listModel);
        } else if (jListPlayersHosts.getModel().getSize() > 0) {
            for (int a = 0; a < cmHostList.size(); a++) {
                if (hostName.equals(cmHostList.get(a))) {
                    break;
                } else {
                    cmHostList.add(hostName);
                    cmHostAddressList.add(cmHostAddress);

                    DefaultListModel listModel = new DefaultListModel();
                    for (int i = 0; i < cmHostList.size(); i++) {
                        listModel.addElement(cmHostList.get(i).toString());
                    }
                    jListPlayersHosts.setModel(listModel);
                    break;
                }
            }
        }
    }

    public void sendCommand(CMCommand cmc) {
        try {
        } catch (Exception ex) {
            System.err.println("Client BroadCasting Exception Message: " + ex.getMessage());
//            Logger.getLogger(CandyMagicTDLobby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showErrorDialog(String message) {
        JOptionPane pane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = pane.createDialog("Error!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnJoinGame = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelCreateStart = new javax.swing.JPanel();
        btnStartGame = new javax.swing.JButton();
        tbtnCreateDisband = new javax.swing.JToggleButton();
        txtPlayerName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPlayersHosts = new javax.swing.JList();
        jLabelHostName = new javax.swing.JLabel();
        jLabelTrueHostName = new javax.swing.JLabel();
        jLabelGamesPlayers = new javax.swing.JLabel();
        btnKick = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jTextFieldChatMessage = new javax.swing.JTextField();
        jPanelManualJoin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jButtonFindJoin = new javax.swing.JButton();
        jLabelLIP = new javax.swing.JLabel();
        jLabelIP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Candy Magic TD");
        setUndecorated(true);
        setResizable(false);

        btnJoinGame.setBackground(new java.awt.Color(255, 255, 255));
        btnJoinGame.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnJoinGame.setText("Join Game");
        btnJoinGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinGameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Player Name:");

        panelCreateStart.setBackground(new java.awt.Color(255, 204, 204));
        panelCreateStart.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Room Creation"));

        btnStartGame.setBackground(new java.awt.Color(255, 255, 255));
        btnStartGame.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnStartGame.setText("Start Game");
        btnStartGame.setEnabled(false);
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });

        tbtnCreateDisband.setBackground(new java.awt.Color(255, 255, 255));
        tbtnCreateDisband.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tbtnCreateDisband.setText("Create Host");
        tbtnCreateDisband.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnCreateDisbandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCreateStartLayout = new javax.swing.GroupLayout(panelCreateStart);
        panelCreateStart.setLayout(panelCreateStartLayout);
        panelCreateStartLayout.setHorizontalGroup(
            panelCreateStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateStartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCreateStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCreateStartLayout.createSequentialGroup()
                        .addComponent(tbtnCreateDisband, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCreateStartLayout.setVerticalGroup(
            panelCreateStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateStartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbtnCreateDisband, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPlayerName.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txtPlayerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPlayerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlayerNameActionPerformed(evt);
            }
        });

        jListPlayersHosts.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jListPlayersHosts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListPlayersHostsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListPlayersHosts);

        jLabelHostName.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabelHostName.setText("Host Name:");

        jLabelTrueHostName.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabelTrueHostName.setText("You are not joined in any room");

        jLabelGamesPlayers.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabelGamesPlayers.setText("Available Rooms:");

        btnKick.setBackground(new java.awt.Color(255, 255, 255));
        btnKick.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnKick.setText("Kick");
        btnKick.setEnabled(false);
        btnKick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKickActionPerformed(evt);
            }
        });

        jTextAreaChat.setEditable(false);
        jTextAreaChat.setColumns(20);
        jTextAreaChat.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextAreaChat.setRows(5);
        jTextAreaChat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(jTextAreaChat);

        jTextFieldChatMessage.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextFieldChatMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldChatMessage.setEnabled(false);
        jTextFieldChatMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldChatMessageKeyReleased(evt);
            }
        });

        jPanelManualJoin.setBackground(new java.awt.Color(255, 204, 204));
        jPanelManualJoin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Manual Join"));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("IP Address:");

        jTextFieldIP.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jButtonFindJoin.setBackground(new java.awt.Color(255, 255, 255));
        jButtonFindJoin.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButtonFindJoin.setText("Find & Join");
        jButtonFindJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindJoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelManualJoinLayout = new javax.swing.GroupLayout(jPanelManualJoin);
        jPanelManualJoin.setLayout(jPanelManualJoinLayout);
        jPanelManualJoinLayout.setHorizontalGroup(
            jPanelManualJoinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManualJoinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelManualJoinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldIP)
                    .addGroup(jPanelManualJoinLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonFindJoin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelManualJoinLayout.setVerticalGroup(
            jPanelManualJoinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManualJoinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFindJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabelLIP.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabelLIP.setText("Your IP:");

        jLabelIP.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldChatMessage)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabelHostName))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelTrueHostName)
                                            .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabelGamesPlayers)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnJoinGame, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnKick, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelCreateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelManualJoin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIP, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtPlayerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHostName)
                            .addComponent(jLabelTrueHostName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelGamesPlayers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKick, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnJoinGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelCreateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelManualJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldChatMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelLIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelIP, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJoinGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinGameActionPerformed
        if (btnJoinGame.getText().equals("Join Game")) {
            if (jListPlayersHosts.getSelectedIndex() != -1) {
                if (txtPlayerName.getText().equals("")) {
                    showErrorDialog("Please enter your player name");
                } else {
                    playerName = txtPlayerName.getText();
                    hostName = (String) jListPlayersHosts.getModel().getElementAt(jListPlayersHosts.getSelectedIndex()).toString().trim();
                    hostAddress = (String) cmHostAddressList.get(jListPlayersHosts.getSelectedIndex());
                    System.out.println("address ng host: " + hostAddress);
                    cmClientConnectToServer((String) cmHostAddressList.get(jListPlayersHosts.getSelectedIndex()));
                }
            }
        } else if (btnJoinGame.getText().equals("Leave")) {
            cmc = new CMCommand("PREGAME", "LEAVE", txtPlayerName.getText(), "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
            rcmscrt.clientBroadCastMessage(cmc);
        }
    }//GEN-LAST:event_btnJoinGameActionPerformed

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        btnStartGame.setEnabled(false);
        CMCommand cmc = new CMCommand("START", "XD", "XD", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
        cmsct.serverMainBroadCastMessage(cmc);
        reconnectMainVariables("SERVER", cmsct, null, null);
        reconnectSecondaryVariable(null);
        startCandyMagicTimer();
        cmTimer.start();
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void tbtnCreateDisbandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnCreateDisbandActionPerformed
        // TODO add your handling code here:
        if (txtPlayerName.getText().equals("")) {
            showErrorDialog("Please enter your player name");
            tbtnCreateDisband.setSelected(false);
        } else {
            if (!tbtnCreateDisband.isSelected()) {
                tbtnCreateDisband.setEnabled(false);
                cmc = new CMCommand("PREGAME", "DISBAND", "XD", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                rcmhrt.clientBroadCastMessage(cmc);

                sendMulticastPacket("disbandhost,");
            } else {
                tbtnCreateDisband.setEnabled(false);
                if (jListPlayersHosts.getModel().getSize() != 0) {
                    DefaultListModel lModel = (DefaultListModel) jListPlayersHosts.getModel();
                    lModel.removeAllElements();
                    jListPlayersHosts.setModel(lModel);
                }

                hostName = txtPlayerName.getText();
                playerName = txtPlayerName.getText();
                jLabelTrueHostName.setText(hostName);
                jLabelGamesPlayers.setText("The Candystein");
                tbtnCreateDisband.setText("Disband");
                jTextFieldIP.setEnabled(false);
                jButtonFindJoin.setEnabled(false);
                txtPlayerName.setEditable(false);
                btnStartGame.setEnabled(true);
                btnJoinGame.setEnabled(false);
                jTextFieldChatMessage.setEnabled(true);

                cmsct = new CMServerConnectorThread(this, 9211, 9212);
                new Thread(cmsct).start();
                cmHostConnectToServer();

                String hostName = txtPlayerName.getText();
                cmFinalPacket = cmHostAddress + "," + hostName;
                sendMulticastPacket(cmFinalPacket);

                tbtnCreateDisband.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tbtnCreateDisbandActionPerformed

    private void btnKickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKickActionPerformed
        // TODO add your handling code here:
        cmc = new CMCommand("PREGAME", "KICK", jListPlayersHosts.getSelectedValue().toString(), "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
        rcmhrt.clientBroadCastMessage(cmc);

        ArrayList players = new ArrayList();

        for (int i = 0; i < jListPlayersHosts.getModel().getSize(); i++) {
            players.add(jListPlayersHosts.getModel().getElementAt(i));
        }

        for (int j = 0; j < players.size(); j++) {
            if (players.get(j).equals(jListPlayersHosts.getSelectedValue())) {
                players.remove(j);
            }
        }

        DefaultListModel listModel = new DefaultListModel();
        for (int k = 0; k < players.size(); k++) {
            listModel.addElement(players.get(k));
        }
        jListPlayersHosts.setModel(listModel);
    }//GEN-LAST:event_btnKickActionPerformed

    private void jListPlayersHostsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListPlayersHostsValueChanged
        // TODO add your handling code here:
        if (jListPlayersHosts.getSelectedIndex() == -1) {
            btnKick.setEnabled(false);
        } else {
            if (jLabelGamesPlayers.getText().equals("The Candystein")) {
                if (btnJoinGame.getText().equals("Join Game")) {
                    if (btnStartGame.isEnabled()) {
                        btnKick.setEnabled(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_jListPlayersHostsValueChanged

    private void jTextFieldChatMessageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldChatMessageKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!jTextFieldChatMessage.getText().equals("")) {
                String message = txtPlayerName.getText() + ": " + jTextFieldChatMessage.getText();
                cmc = new CMCommand("PREGAME", "CHAT", message, "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                if (!isHost) {
                    rcmscrt.clientBroadCastMessage(cmc);
                } else {
                    rcmhrt.clientBroadCastMessage(cmc);
                }

                jTextFieldChatMessage.setText("");
            }
        }
    }//GEN-LAST:event_jTextFieldChatMessageKeyReleased

    private void txtPlayerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlayerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlayerNameActionPerformed

    private void jButtonFindJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindJoinActionPerformed
        // TODO add your handling code here:
        if (txtPlayerName.getText().equals("")) {
            showErrorDialog("Please enter your player name");
        } else {
            playerName = txtPlayerName.getText();
            cmClientConnectToServer(jTextFieldIP.getText());
        }
    }//GEN-LAST:event_jButtonFindJoinActionPerformed

    public void updateForm1(String type, String update) {
        if (type.equals("ISCONNECTED")) {
            if (update.equals("HOSTNOTFULL")) {
                jLabelTrueHostName.setText(hostName);
                jLabelGamesPlayers.setText("The Candystein");
                txtPlayerName.setEditable(false);
                jTextFieldChatMessage.setEnabled(true);
                btnKick.setEnabled(false);

                if (btnJoinGame.isEnabled()) {
                    btnJoinGame.setText("Leave");
                    tbtnCreateDisband.setEnabled(false);
                    jTextFieldIP.setEnabled(false);
                    jButtonFindJoin.setEnabled(false);
                    String[] playerList = new String[2];
                    playerList[0] = "host";
                    playerList[1] = playerName;
                    cmc = new CMCommand("PREGAME", "ULIST", "XD", "XD", "XD", "XD", "XD", "XD", "XD", "XD", playerList);
                    rcmscrt.clientBroadCastMessage(cmc);
                }
            } else if (update.equals("HOSTFULL")) {
                showErrorDialog("This room is full");
            }
        } else if (type.equals("CHAT")) {
            String message = update;
            if (jTextAreaChat.getText().equals("")) {
                jTextAreaChat.setText(message);
            } else {
                String t = jTextAreaChat.getText();
                t += "\n" + message;
                jTextAreaChat.append("\n" + message);
                jTextAreaChat.setCaretPosition(jTextAreaChat.getDocument().getLength());
            }
        } else if (type.equals("LEAVEUPDATE")) {
            if (!btnJoinGame.isEnabled()) {
                ArrayList players = new ArrayList();

                for (int i = 0; i < jListPlayersHosts.getModel().getSize(); i++) {
                    players.add(jListPlayersHosts.getModel().getElementAt(i));
                }

                for (int j = 0; j < players.size(); j++) {
                    if (players.get(j).equals(update)) {
                        players.remove(j);
                    }
                }

                DefaultListModel listModel = new DefaultListModel();
                for (int k = 0; k < players.size(); k++) {
                    listModel.addElement(players.get(k));
                }
                jListPlayersHosts.setModel(listModel);
            } else {
                if (txtPlayerName.getText().equals(update)) {
                    jLabelTrueHostName.setText("You are not joined in any room");
                    jLabelGamesPlayers.setText("Available Rooms:");
                    tbtnCreateDisband.setText("Create Host");
                    txtPlayerName.setEditable(true);
                    btnJoinGame.setText("Join Game");
                    tbtnCreateDisband.setEnabled(true);
                    jTextFieldIP.setEnabled(true);
                    jButtonFindJoin.setEnabled(true);
                    jTextFieldChatMessage.setEnabled(false);
                    jTextAreaChat.setText("");
                    jTextFieldChatMessage.setText("");

                    DefaultListModel listModel = (DefaultListModel) jListPlayersHosts.getModel();
                    listModel.removeAllElements();
                    jListPlayersHosts.setModel(listModel);

                    sendMulticastPacket("requesthosts,");

                    rcmmcrt.closeSocket();
                } else {
                    ArrayList players = new ArrayList();

                    for (int i = 0; i < jListPlayersHosts.getModel().getSize(); i++) {
                        players.add(jListPlayersHosts.getModel().getElementAt(i));
                    }

                    for (int j = 0; j < players.size(); j++) {
                        if (players.get(j).equals(update)) {
                            players.remove(j);
                        }
                    }

                    DefaultListModel listModel = new DefaultListModel();
                    for (int k = 0; k < players.size(); k++) {
                        listModel.addElement(players.get(k));
                    }
                    jListPlayersHosts.setModel(listModel);
                }
            }
        } else if (type.equals("KICK")) {
            if (playerName.equals(update)) {
                cmc = new CMCommand("PREGAME", "KICKUPDATE", update, "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
                rcmscrt.clientBroadCastMessage(cmc);
            }
        } else if (type.equals("KICKUPDATE")) {
            if (txtPlayerName.getText().equals(update)) {
                jLabelTrueHostName.setText("You are not joined in any room");
                jLabelGamesPlayers.setText("Available Rooms:");
                tbtnCreateDisband.setText("Create Host");
                txtPlayerName.setEditable(true);
                btnJoinGame.setText("Join Game");
                tbtnCreateDisband.setEnabled(true);
                jTextFieldIP.setEnabled(true);
                jButtonFindJoin.setEnabled(true);
                jTextFieldChatMessage.setEnabled(false);
                jTextAreaChat.setText("");
                jTextFieldChatMessage.setText("");

                DefaultListModel listModel = (DefaultListModel) jListPlayersHosts.getModel();
                listModel.removeAllElements();
                jListPlayersHosts.setModel(listModel);

                sendMulticastPacket("requesthosts,");

                showErrorDialog("You have been kicked out of the room");

                rcmmcrt.closeSocket();
            } else {
                ArrayList players = new ArrayList();

                for (int i = 0; i < jListPlayersHosts.getModel().getSize(); i++) {
                    players.add(jListPlayersHosts.getModel().getElementAt(i));
                }

                for (int j = 0; j < players.size(); j++) {
                    if (players.get(j).equals(update)) {
                        players.remove(j);
                    }
                }

                DefaultListModel listModel = new DefaultListModel();
                for (int k = 0; k < players.size(); k++) {
                    listModel.addElement(players.get(k));
                }
                jListPlayersHosts.setModel(listModel);
            }
        } else if (type.equals("DISBANDED")) {
            if (btnJoinGame.isEnabled()) {
                jLabelTrueHostName.setText("You are not joined in any room");
                jLabelGamesPlayers.setText("Available Rooms:");
                tbtnCreateDisband.setText("Create Game");
                txtPlayerName.setEditable(true);
                btnJoinGame.setText("Join Game");
                tbtnCreateDisband.setEnabled(true);
                jTextFieldIP.setEnabled(true);
                jButtonFindJoin.setEnabled(true);
                jTextFieldChatMessage.setEnabled(false);
                jTextAreaChat.setText("");
                jTextFieldChatMessage.setText("");

                if (jListPlayersHosts.getModel().getSize() != 0) {
                    DefaultListModel listModel = (DefaultListModel) jListPlayersHosts.getModel();
                    listModel.removeAllElements();
                    jListPlayersHosts.setModel(listModel);
                }

                showErrorDialog("Room has been disbanded");

                cmHostAddressList.clear();
                cmHostList.clear();

                sendMulticastPacket("requesthosts,");
            } else {
                jLabelTrueHostName.setText("You are not joined in any room");
                jLabelGamesPlayers.setText("Available Rooms:");
                tbtnCreateDisband.setText("Create Game");
                txtPlayerName.setEditable(true);
                btnJoinGame.setEnabled(true);
                btnJoinGame.setText("Join Game");
                tbtnCreateDisband.setEnabled(true);
                jTextFieldIP.setEnabled(true);
                jButtonFindJoin.setEnabled(true);
                jTextFieldChatMessage.setEnabled(false);
                jTextAreaChat.setText("");
                jTextFieldChatMessage.setText("");

                isHost = false;

                if (jListPlayersHosts.getModel().getSize() != 0) {
                    DefaultListModel listModel = (DefaultListModel) jListPlayersHosts.getModel();
                    listModel.removeAllElements();
                    jListPlayersHosts.setModel(listModel);
                }

                tbtnCreateDisband.setEnabled(true);

                cmHostAddressList.clear();
                cmHostList.clear();

                sendMulticastPacket("requesthosts,");
            }
        }
    }

    public void updateForm2(String type, String[] list) {
        if (type.equals("ULIST")) {
            if (!btnJoinGame.isEnabled()) {
                if (list[0].equals("host")) {
                    String players[];
                    if (jListPlayersHosts.getModel().getSize() == 0) {
                        players = new String[2];
                        players[0] = "client";
                        players[1] = (String) list[1];
                    } else {
                        players = new String[jListPlayersHosts.getModel().getSize() + 2];
                        players[0] = "client";
                        for (int i = 0; i < players.length - 2; i++) {
                            players[i + 1] = (String) jListPlayersHosts.getModel().getElementAt(i);
                        }
                        players[players.length - 1] = (String) list[1];
                    }

                    DefaultListModel listModel = new DefaultListModel();
                    for (int j = 1; j < players.length; j++) {
                        listModel.addElement(players[j]);
                    }
                    jListPlayersHosts.setModel(listModel);

                    cmc = new CMCommand("PREGAME", "ULIST", hostName, "XD", "XD", "XD", "XD", "XD", "XD", "XD", players);
                    rcmhrt.clientBroadCastMessage(cmc);
                }
            } else {
                if (list[0].equals("client")) {
                    if (jListPlayersHosts.getModel().getSize() != 0) {
                        DefaultListModel lModel = (DefaultListModel) jListPlayersHosts.getModel();
                        lModel.removeAllElements();
                        jListPlayersHosts.setModel(lModel);
                    }

                    DefaultListModel listModel = new DefaultListModel();
                    for (int j = 1; j < list.length; j++) {
                        listModel.addElement(list[j].toString());
                    }
                    jListPlayersHosts.setModel(listModel);
                }
            }
        }
    }

    public void updateForm3(String update) {
        jLabelTrueHostName.setText(update);
    }
    
    public void quitGame(String cmUserType) {
        if(cmUserType.equals("SERVER")) {
            this.setVisible(true);

            jLabelTrueHostName.setText("You are not joined in any room");
            jLabelGamesPlayers.setText("Available Rooms:");
            tbtnCreateDisband.setEnabled(true);
            tbtnCreateDisband.setSelected(false);
            tbtnCreateDisband.setText("Create Game");
            txtPlayerName.setEditable(true);
            btnJoinGame.setEnabled(true);
            btnJoinGame.setText("Join Game");
            tbtnCreateDisband.setEnabled(true);
            jTextFieldIP.setEnabled(true);
            jButtonFindJoin.setEnabled(true);
            jTextFieldChatMessage.setEnabled(false);
            jTextAreaChat.setText("");
            jTextFieldChatMessage.setText("");

            isHost = false;

            if (jListPlayersHosts.getModel().getSize() != 0) {
                DefaultListModel listModel = (DefaultListModel) jListPlayersHosts.getModel();
                listModel.removeAllElements();
                jListPlayersHosts.setModel(listModel);
            }

            tbtnCreateDisband.setEnabled(true);

            cmHostAddressList.clear();
            cmHostList.clear();

            sendMulticastPacket("requesthosts,");
        } else if(cmUserType.equals("CLIENT")) {
            this.setVisible(true);

            jLabelTrueHostName.setText("You are not joined in any room");
            jLabelGamesPlayers.setText("Available Rooms:");
            tbtnCreateDisband.setEnabled(true);
            tbtnCreateDisband.setText("Create Game");
            txtPlayerName.setEditable(true);
            btnJoinGame.setEnabled(true);
            btnJoinGame.setText("Join Game");
            tbtnCreateDisband.setEnabled(true);
            jTextFieldIP.setEnabled(true);
            jButtonFindJoin.setEnabled(true);
            jTextFieldChatMessage.setEnabled(false);
            jTextAreaChat.setText("");
            jTextFieldChatMessage.setText("");

            if (jListPlayersHosts.getModel().getSize() != 0) {
                DefaultListModel listModel = (DefaultListModel) jListPlayersHosts.getModel();
                listModel.removeAllElements();
                jListPlayersHosts.setModel(listModel);
            }

            cmHostAddressList.clear();
            cmHostList.clear();

            sendMulticastPacket("requesthosts,");
        }
    }
    
    public void finishGame(String cmUserType) {
        this.setVisible(true);
        
        if(cmUserType.equals("SERVER")) {
            tbtnCreateDisband.setEnabled(true);
            btnStartGame.setEnabled(true);
            jTextFieldChatMessage.setEditable(true);
        } else if(cmUserType.equals("CLIENT")) {
            jTextFieldChatMessage.setEditable(true);
            btnJoinGame.setEnabled(true);
        }
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJoinGame;
    private javax.swing.JButton btnKick;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JButton jButtonFindJoin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelGamesPlayers;
    private javax.swing.JLabel jLabelHostName;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JLabel jLabelLIP;
    private javax.swing.JLabel jLabelTrueHostName;
    private javax.swing.JList jListPlayersHosts;
    private javax.swing.JPanel jPanelManualJoin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextField jTextFieldChatMessage;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JPanel panelCreateStart;
    private javax.swing.JToggleButton tbtnCreateDisband;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables
}
