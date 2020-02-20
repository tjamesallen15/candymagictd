/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author JamesAllen
 */
public class CandyMagicPanel extends JPanel implements Runnable {

    //CandyMagic Classes
    CandyMagicTD cmMagicTD;
    CandyMagicTDLobby cmMagicTDLobby;
    //Game Events Instances
    private Thread candyMagicThread;
    private Graphics drawOffScreen,signalOffScreen;
    private Image candyMagicImage;
    CMCommand cmc;
    //Tilemap Creation
    private int tileX = 0;
    private int tileY = 0;
    private int tileRow;
    private int tileColumn;
    private int tileSetIterator = 0;
    private String tileTemp;
    private String[] tileSet;
    private String[][] tileMap;
    private File fileMap;
    private BufferedReader readerMap;
    //Mouse Variables
    int mouseX;
    int mouseY;
    int finalMouseX;
    int finalMouseY;
    int camX = 1200;
    int camY = 1400;
    int maxCamX;
    int maxCamY;
    int minpX = 0;
    int minpY = 0;
    int signalX = 0;
    int signalY = 0;
    int signalStart = 133;
    int screenWidth = 1024;
    int screenHeight = 768;
    int timeForSpawn = 50;
    //Doodad Variables
    int doodadID = 0;
    //Creep Waves
    private int creepCountForWave = 10;
    private int creepInside = 0;
    private int creepWave = 0;
    private int creepMovementAnimationPerSecond;
    private Timer cmTimer;
    private Timer signalTimer;
    private int spawnXL1 = 0;
    private int spawnYL1 = 525;
    private int spawnXL2 = 0;
    private int spawnYL2 = 525;
    private int spawnXL3 = 0;
    private int spawnYL3 = 525;
    private int spawnXL4 = 1075;
    private int spawnYL4 = 0;
    private int spawnXL5 = 1075;
    private int spawnYL5 = 0;
    private int spawnXL6 = 1075;
    private int spawnYL6 = 0;
    private int spawnXL7 = 2275;
    private int spawnYL7 = 0;
    private int spawnXL8 = 2275;
    private int spawnYL8 = 0;
    private int spawnXL9 = 3350;
    private int spawnYL9 = 525;
    private int spawnXL10 = 3350;
    private int spawnYL10 = 525;
    private int spawnXL11 = 3350;
    private int spawnYL11 = 1675;
    private int spawnXL12 = 3350;
    private int spawnYL12 = 1675;
    private int spawnXL13 = 3350;
    private int spawnYL13 = 1675;
    private int spawnXL14 = 3350;
    private int spawnYL14 = 2825;
    private int spawnXL15 = 3350;
    private int spawnYL15 = 2825;
    private int spawnXL16 = 3350;
    private int spawnYL16 = 2825;
    private int spawnXL17 = 2275;
    private int spawnYL17 = 3350;
    private int spawnXL18 = 2275;
    private int spawnYL18 = 3350;
    private int spawnXL19 = 2275;
    private int spawnYL19 = 3350;
    private int spawnXL20 = 1075;
    private int spawnYL20 = 3350;
    private int spawnXL21 = 1075;
    private int spawnYL21 = 3350;
    private int spawnXL22 = 0;
    private int spawnYL22 = 2825;
    private int spawnXL23 = 0;
    private int spawnYL23 = 2825;
    private int spawnXL24 = 0;
    private int spawnYL24 = 1675;
    private int spawnXL25 = 0;
    private int spawnYL25 = 1675;
    private int spawnXL26 = 0;
    private int spawnYL26 = 1675;
    //Build Variables
    private int towerType;
    private int onClickTowerLevel = 0;
    private boolean onBuild = false;
    private boolean onClick = false;
    private boolean isSignal = false;
    private volatile boolean isListen = false;
    private String onClickTowerType = "";
    //Player Variables
    private int playerGold = 3000;
    String playerName = "Player";
    String player1 = "-";
    String player2 = "-";
    String player3 = "-";
    String player4 = "-";
    int p1Kills = 0;
    int p2Kills = 0;
    int p3Kills = 0;
    int p4Kills = 0;
    //Random Variables Purposes
    private int randInt;
    private Random randObject = new Random();
    //ArrayList of Images && Single Images;
    private BufferedImage candyMagicBackground;
    private BufferedImage candyMagicInGameLoading;
    private BufferedImage hudImage;
    private BufferedImage lifeImage;
    private BufferedImage coinBundleImage;
    private BufferedImage tileImage;
    private BufferedImage castleImage;
    private BufferedImage doodadImage;
    private BufferedImage towerGridImage;
    private BufferedImage animationImage;
    private BufferedImage leaderboardPanelImage;
    private BufferedImage towerImage;
    private BufferedImage creepImage;
    private BufferedImage bulletImage;
    private BufferedImage waveNoImage;
    private BufferedImage waveNoTagImage;
    private ArrayList<BufferedImage> tileImageList;
    private ArrayList<BufferedImage> treeImageList;
    private ArrayList<BufferedImage> bushImageList;
    private ArrayList<BufferedImage> castleImageList;
    private ArrayList<BufferedImage> towerGridImageList;
    private ArrayList<BufferedImage> animationImageList;
    private ArrayList<BufferedImage> towerIceDropImageList;
    private ArrayList<BufferedImage> towerIceImageList;
    private ArrayList<BufferedImage> towerCherryBoltImageList;
    private ArrayList<BufferedImage> towerCandyMachineImageList;
    private ArrayList<BufferedImage> towerMentosImageList;
    private ArrayList<BufferedImage> towerSingleIceDropImageList;
    private ArrayList<BufferedImage> towerStickOImageList;
    private ArrayList<BufferedImage> creepImageList;
    private ArrayList<BufferedImage> bulletImageList;
    private ArrayList<BufferedImage> towerHudImageList;
    private ArrayList<BufferedImage> towerHudButtonImageList;
    private ArrayList<BufferedImage> waveNoImageList;
    private ArrayList<BufferedImage> waveNoTagImageList;
    //ArrayList of Objects && Single Objects
    private ArrayList<Tile> tileObjectList;
    private ArrayList<Tree> treeObjectList;
    private ArrayList<Bush> bushObjectList;
    private ArrayList<TowerIceDrop> towerIceDropList;
    private ArrayList<TowerIce> towerIceList;
    private ArrayList<TowerCherryBolt> towerCherryBoltList;
    private ArrayList<TowerCandyMachine> towerCandyMachineList;
    private ArrayList<TowerMentos> towerMentosList;
    private ArrayList<TowerSingleIceDrop> towerSingleIceDropList;
    private ArrayList<TowerStickO> towerStickOList;
    private ArrayList<CreepEgg> creepEggList;
    private ArrayList<CreepBigEgg> creepBigEggList;
    private ArrayList<CreepRageEgg> creepRageEggList;
    private ArrayList<CreepBlackAnt> creepBlackAntList;
    private ArrayList<CreepRedAnt> creepRedAntList;
    private ArrayList<CreepRat> creepRatList;
    private ArrayList<CreepButterfly> creepButterflyList;
    private ArrayList<CreepBee> creepBeeList;
    private ArrayList<CreepBoxerAnt> creepBoxerAntList;
    private ArrayList<CreepSpearmanAnt> creepSpearmanAntList;
    private ArrayList<CreepSwordsmanAnt> creepSwordsmanAntList;
    private ArrayList<CreepKingAnt> creepKingAntList;
    private ArrayList<BulletTID> bulletTIDList;
    private ArrayList<BulletTI> bulletTIList;
    private ArrayList<BulletCB> bulletCBList;
    private ArrayList<BulletCM> bulletCMList;
    private ArrayList<BulletM> bulletMList;
    private ArrayList<BulletSID> bulletSIDList;
    private ArrayList<BulletSO> bulletSOList;
    private ArrayList<ObjectAnimation> objectAnimationList;
    private Castle candyCastle;
    //Sound Variables
    private CMSound cmSound;
    private int cmSoundCounter = 100;
    private int cmSoundNEGCounter = 50;
    private boolean cmSoundOn = false;
    private boolean cmSoundNEG = false;
    //Hud Variables
    private int hudTowerLevel;
    private String hudTowerName;
    private String hudTowerDamage;
    private String hudTowerAttackSpeed;
    private String hudTowerPrimaryAbility;
    private String hudTowerSecondaryAbility;
    private boolean hudTowerVisibility = false;
    //Button Variables
    Rectangle btnQ;
    Rectangle btnW;
    Rectangle btnE;
    Rectangle btnR;
    Rectangle btnA;
    Rectangle btnS;
    Rectangle btnD;
    Rectangle btnF;
    //Network Variables
    String cmMachineType = "";
    CMServerConnectorThread cmsct = null;
    CMMainServerReceiverThread cmmsrt = null;
    CMMainClientReceiverThread cmmcrt = null;
    CMSecondaryClientReceiverThread cmscrt = null;
    CMHostReceiverThread cmhcrt = null;
    boolean cmGameDoodadInitialization = false;
    boolean cmGameRenderingInitialization = false;
    boolean cmClientSendNameInitialization = false;
    int cmGameServerTowerUpdate = 75;
    int cmGameClientTowerUpdate = 50;

    public CandyMagicPanel(String pn, String cmmt, CMServerConnectorThread cms, CMMainServerReceiverThread rcmmsrt, CMMainClientReceiverThread rcmmcrt, CMSecondaryClientReceiverThread rcmscrt, CMHostReceiverThread rcmhcrt, CandyMagicTDLobby myLobby, CandyMagicTD myCandyMagicTD) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image imageCursor = tk.getImage("objects\\cursor\\cmCursor.png");
        Cursor cmCursor = tk.createCustomCursor(imageCursor, new Point(0, 0), "Custom Cursor");
        this.setCursor(cmCursor);
        setFocusable(true);
        requestFocus();
        playerName = pn;
        cmMachineType = cmmt;
        cmsct = cms;
        cmmsrt = rcmmsrt;
        cmmcrt = rcmmcrt;
        cmscrt = rcmscrt;
        cmhcrt = rcmhcrt;
        cmMagicTDLobby = myLobby;
        cmMagicTD = myCandyMagicTD;
        if (cmMachineType.equals("CLIENT")) {
            cmmcrt.setCandyMagicPanel(this);
            cmscrt.setCandyMagicPanel(this);
            setBroadCastClientPlayerName();
        } else if (cmMachineType.equals("SERVER")) {
            cmsct.setCandyMagicPanel(this);
            cmhcrt.setCandyMagicPanel(this);
            player1 = pn;
        }

        startCandyMagicGame();
        
        cmMagicTD.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "WARNING", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    stopThread();
                    cmMagicTD.dispose();
                    setBroadCastQuit();
                    if (cmMachineType.equals("SERVER")) {
                        cmMagicTDLobby.quitGame("SERVER");
                    } else if (cmMachineType.equals("CLIENT")) {
                        cmMagicTDLobby.quitGame("CLIENT");
                    }
                }
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    if (camX != 0) {
                        camX -= 50;
                    }
                }

                if (key == KeyEvent.VK_RIGHT) {
                    if (camX != maxCamX) {
                        camX += 50;
                    }
                }

                if (key == KeyEvent.VK_UP) {
                    if (camY != 0) {
                        camY -= 50;
                    }
                }

                if (key == KeyEvent.VK_DOWN) {
                    if (camY != maxCamY) {
                        camY += 50;
                    }
                }
                minpX = ((camX * 180) / 3350) + 10;
                minpY = ((camY * 180) / 3350) + 575;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (onBuild == false && onClick == false) {
                    if (e.getKeyCode() == KeyEvent.VK_Q) {
                        if (playerGold >= 300) {
                            //Tower Ice Drop
                            onBuild = true;
                            towerType = 1;
                        } else {
                            onPlaySoundClip(13);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_W) {
                        if (playerGold >= 100) {
                            //Tower Ice
                            onBuild = true;
                            towerType = 2;
                        } else {
                            onPlaySoundClip(13);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_E) {
                        if (playerGold >= 500) {
                            //Tower Cherrybolt
                            onBuild = true;
                            towerType = 3;
                        } else {
                            onPlaySoundClip(13);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_R) {
                        if (playerGold >= 400) {
                            //Tower CandyMachine
                            onBuild = true;
                            towerType = 4;
                        } else {
                            onPlaySoundClip(13);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_A) {
                        if (playerGold >= 2500) {
                            //Tower Mentos
                            onBuild = true;
                            towerType = 5;
                        } else {
                            onPlaySoundClip(13);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_S) {
                        if (playerGold >= 800) {
                            //Tower Single Ice Drop
                            onBuild = true;
                            towerType = 6;
                        } else {
                            onPlaySoundClip(13);
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_D) {
                        if (playerGold >= 250) {
                            //Tower Stick O
                            onBuild = true;
                            towerType = 7;
                        } else {
                            onPlaySoundClip(13);
                        }
                    }
                } else if (onBuild == true && onClick == false) {
                    if (e.getKeyCode() == KeyEvent.VK_F) {
                        onBuild = false;
                        towerType = 0;
                    }
                } else if (onBuild == false && onClick == true) {
                    if (e.getKeyCode() == KeyEvent.VK_Q) {
                        onClickTowerUpgrade();
                    } else if (e.getKeyCode() == KeyEvent.VK_W) {
                        onClick = false;
                        onClickTowerSell();
                        onClickTowerDeselection();
                    } else if (e.getKeyCode() == KeyEvent.VK_F) {
                        onClick = false;
                        onClickTowerDeselection();
                    }
                }
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (onBuild == false && onClick == false) {
                        if (btnQ.contains(mouseX, mouseY)) {
                            if (playerGold >= 300) {
                                //Tower Ice Drop
                                onBuild = true;
                                towerType = 1;
                            } else {
                                onPlaySoundClip(13);
                            }
                        } else if (btnW.contains(mouseX, mouseY)) {
                            if (playerGold >= 100) {
                                //Tower Ice
                                onBuild = true;
                                towerType = 2;
                            } else {
                                onPlaySoundClip(13);
                            }
                        } else if (btnE.contains(mouseX, mouseY)) {
                            if (playerGold >= 500) {
                                //Tower Cherrybolt
                                onBuild = true;
                                towerType = 3;
                            } else {
                                onPlaySoundClip(13);
                            }
                        } else if (btnR.contains(mouseX, mouseY)) {
                            if (playerGold >= 400) {
                                //Tower CandyMachine
                                onBuild = true;
                                towerType = 4;
                            } else {
                                onPlaySoundClip(13);
                            }
                        } else if (btnA.contains(mouseX, mouseY)) {
                            if (playerGold >= 2500) {
                                //Tower Mentos
                                onBuild = true;
                                towerType = 5;
                            } else {
                                onPlaySoundClip(13);
                            }
                        } else if (btnS.contains(mouseX, mouseY)) {
                            if (playerGold >= 800) {
                                //Tower Single Ice Drop
                                onBuild = true;
                                towerType = 6;
                            } else {
                                onPlaySoundClip(13);
                            }
                        } else if (btnD.contains(mouseX, mouseY)) {
                            if (playerGold >= 250) {
                                //Tower Stick O
                                onBuild = true;
                                towerType = 7;
                            } else {
                                onPlaySoundClip(13);
                            }
                        } else {
                            onBuild = false;
                            onClickTowerDeselection();
                            onClickTower();
                        }
                    } else if (onBuild == true && onClick == false) {
                        if (btnF.contains(mouseX, mouseY)) {
                            onBuild = false;
                            onClickTowerDeselection();
                        } else {
                            for (int a = 0; a < getTileObjectList().size(); a++) {
                                Tile tl = (Tile) getTileObjectList().get(a);
                                if (tl.getX() == finalMouseX && tl.getY() == finalMouseY) {
                                    if (tl.getTileVacancy() == false) {
                                        onBuild = false;
                                        onClick = false;
                                        onBuildTower(towerType);
                                        break;
                                    } else if (tl.getTileVacancy() == true) {
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (onBuild == false && onClick == true) {
                        if (btnQ.contains(mouseX, mouseY)) {
                            onClickTowerUpgrade();
                        } else if (btnW.contains(mouseX, mouseY)) {
                            onClickTowerSell();
                            onClickTowerDeselection();
                        } else {
                            onClickTower();
                        }
                    }

                    if ((mouseX > 10 && mouseX < 190) && (mouseY > 575 && mouseY < 755)) {
                        int mX = mouseX - 10;
                        int mY = mouseY - 575;
                        int mcX = ((mX * 3350) / 180) - 512;
                        int mcY = ((mY * 3350) / 180) - 384;

                        if (mcX < 0) {
                            camX = 0;
                        } else if (mcX > 2350) {
                            camX = 2350;
                        } else {
                            mcX = (mcX / 50) * 50;
                            camX = mcX;
                        }

                        if (mcY < 0) {
                            camY = 0;
                        } else if (mcY > 2750) {
                            camY = 2750;
                        } else {
                            mcY = (mcY / 50) * 50;
                            camY = mcY;
                        }

                        minpX = ((camX * 180) / 3350) + 10;
                        minpY = ((camY * 180) / 3350) + 575;
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    onBuild = false;
                    onClick = false;
                    onClickTowerDeselection();
                }
                
                if(e.isAltDown() && e.getButton() == MouseEvent.BUTTON1) {
                    setBroadCastSignalMiniMap();
                    onPlaySoundClip(15);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                finalMouseX = (mouseX / 50) * 50 + camX;
                finalMouseY = (mouseY / 50) * 50 + camY;

                if (e.getX() < 1) {
                    if (camX != 0) {
                        camX -= 50;
                    }
                }

                if (e.getX() > 1020) {
                    if (camX != maxCamX) {
                        camX += 50;
                    }
                }

                if (e.getY() < 1) {
                    if (camY != 0) {
                        camY -= 50;
                    }
                }

                if (e.getY() > 764) {
                    if (camY != maxCamY) {
                        camY += 50;
                    }
                }
                minpX = ((camX * 180) / 3350) + 10;
                minpY = ((camY * 180) / 3350) + 575;
            }
        });
    }

    @Override
    public void run() {
        while (!isListen) {
            if (cmMachineType.equals("SERVER")) {
                updateCandyMagicGame();
                renderCandyMagicGame();
                paintCandyMagicGame();
                try {
                    Thread.sleep(15);
                } catch (Exception ex) {
                }
            }
        }
    }
    
    //Interfaces---------------------------------------------------------------------------
    public void startCandyMagicGame() {
        loadInterfaces();

        if (cmMachineType.contains("SERVER")) {
            loadCandyMagicTimer();
            candyMagicThread = new Thread(this);
            candyMagicThread.start();
        }
    }

    public void updateCandyMagicGame() {
        if (cmMachineType.equals("SERVER")) {
            if (creepWave == 24 && creepInside == 0) {
                setBroadCastFinishGame("WIN");
            } else {
                if (creepInside == 0) {
                    cmTimer.start();
                }
            }
        }

        if (creepInside != 0 && creepCountForWave == 10) {
            //BUILDINGS
            if (cmMachineType.equals("SERVER")) {
                cmc = new CMCommand("UPDATEGAME", Integer.toString(candyCastle.getCastleCurrentHp()), Integer.toString(p1Kills), Integer.toString(p2Kills), Integer.toString(p3Kills), Integer.toString(p4Kills), "XD", "XD", "XD", "XD", null);
                cmsct.serverMainBroadCastMessage(cmc);

                if (cmGameServerTowerUpdate == 0) {
                    setBroadCastMainUpdateTower();
                    cmGameServerTowerUpdate = 75;
                } else {
                    cmGameServerTowerUpdate -= 1;
                }
            } else if (cmMachineType.equals("CLIENT")) {
                if (cmGameClientTowerUpdate == 0) {
                    setBroadCastClientUpdateTower();
                    cmGameClientTowerUpdate = 50;
                } else {
                    cmGameClientTowerUpdate -= 1;
                }
            }
            
            if (candyCastle.getCastleCurrentHp() > 75) {
                candyCastle.setCastleImage((BufferedImage) getCastleImageList().get(0));
            } else if (candyCastle.getCastleCurrentHp() > 50) {
                candyCastle.setCastleImage((BufferedImage) getCastleImageList().get(1));
            } else if (candyCastle.getCastleCurrentHp() > 25) {
                candyCastle.setCastleImage((BufferedImage) getCastleImageList().get(2));
            } else if(candyCastle.getCastleCurrentHp() < 0) {
                if(cmMachineType.equals("SERVER")) {
                    setBroadCastFinishGame("LOSE");
                }
            } else {
                candyCastle.setCastleImage((BufferedImage) getCastleImageList().get(3));
            }

            for (int a = 0; a < getTowerIceDropList().size(); a++) {
                TowerIceDrop ti = (TowerIceDrop) getTowerIceDropList().get(a);
                if (ti.getTowerVisibility() == true) {
                    ti.towerSingleEnemyDetection();
                    if (ti.getTowerAttackSpeedCounter() == 0) {
                        ti.towerAddBullet();
                    } else if (ti.getTowerAttackSpeedCounter() >= ti.getTowerAttackSpeed()) {
                        ti.towerAddBullet();
                        ti.setTowerAttackSpeedCounter(0);
                    }

                    if (ti.getTowerShootingStatus() == true) {
                        ti.towerChangeDirection();
                    }

                    ti.setTowerAttackSpeedCounter(ti.getTowerAttackSpeedCounter() + 10);
                } else {
                    getTowerIceDropList().remove(ti);
                }
            }

            for (int a = 0; a < getTowerIceList().size(); a++) {
                TowerIce ti = (TowerIce) getTowerIceList().get(a);
                if (ti.getTowerVisibility() == true) {
                    ti.towerSingleEnemyDetection();
                    if (ti.getTowerAttackSpeedCounter() == 0) {
                        ti.towerAddBullet();
                    } else if (ti.getTowerAttackSpeedCounter() >= ti.getTowerAttackSpeed()) {
                        ti.towerAddBullet();
                        ti.setTowerAttackSpeedCounter(0);
                    }
                    ti.setTowerAttackSpeedCounter(ti.getTowerAttackSpeedCounter() + 10);
                } else {
                    getTowerIceList().remove(ti);
                }
            }

            for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
                TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
                if (tcb.getTowerVisibility() == true) {
                    tcb.towerSingleEnemyDetection();
                    if (tcb.getTowerAttackSpeedCounter() == 0) {
                        tcb.towerAddBullet();
                    } else if (tcb.getTowerAttackSpeedCounter() >= tcb.getTowerAttackSpeed()) {
                        tcb.towerAddBullet();
                        tcb.setTowerAttackSpeedCounter(0);
                    } else {
                        if (tcb.getTowerShootingStatus() == true) {
                            tcb.towerChangeDirection();
                        }
                    }
                    tcb.setTowerAttackSpeedCounter(tcb.getTowerAttackSpeedCounter() + 10);
                } else {
                    getTowerCherryBoltList().remove(tcb);
                }
            }

            for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
                TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
                if (tcm.getTowerVisibility() == true) {
                    tcm.towerSingleEnemyDetection();
                    if (tcm.getTowerAttackSpeedCounter() == 0) {
                        tcm.towerAddBullet();
                    } else if (tcm.getTowerAttackSpeedCounter() >= tcm.getTowerAttackSpeed()) {
                        tcm.towerAddBullet();
                        tcm.setTowerAttackSpeedCounter(0);
                    }
                    tcm.setTowerAttackSpeedCounter(tcm.getTowerAttackSpeedCounter() + 10);
                } else {
                    getTowerCandyMachineList().remove(tcm);
                }
            }

            for (int a = 0; a < getTowerMentosList().size(); a++) {
                TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
                if (tm.getTowerVisibility() == true) {
                    if (tm.getTowerAttackSpeedCounter() == 0) {
                        tm.towerMultipleEnemyDetection();
                        tm.setTowerMaxTargetCounter(0);
                    } else if (tm.getTowerAttackSpeedCounter() >= tm.getTowerAttackSpeed()) {
                        tm.towerMultipleEnemyDetection();
                        tm.setTowerAttackSpeedCounter(0);
                        tm.setTowerMaxTargetCounter(0);
                    }
                    tm.setTowerAttackSpeedCounter(tm.getTowerAttackSpeedCounter() + 10);
                } else {
                    getTowerMentosList().remove(tm);
                }
            }

            for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
                TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
                if (tsid.getTowerVisibility() == true) {
                    tsid.towerSingleEnemyDetection();
                    if (tsid.getTowerAttackSpeedCounter() == 0) {
                        tsid.towerAddBullet();
                    } else if (tsid.getTowerAttackSpeedCounter() >= tsid.getTowerAttackSpeed()) {
                        tsid.towerAddBullet();
                        tsid.setTowerAttackSpeedCounter(0);
                    }

                    if (tsid.getTowerShootingStatus() == true) {
                        tsid.towerChangeDirection();
                    }

                    tsid.setTowerAttackSpeedCounter(tsid.getTowerAttackSpeedCounter() + 10);
                } else {
                    getTowerSingleIceDropList().remove(tsid);
                }
            }

            for (int a = 0; a < getTowerStickOList().size(); a++) {
                TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
                if (tco.getTowerVisibility() == true) {
                    tco.towerSingleEnemyDetection();
                    if (tco.getTowerAttackSpeedCounter() == 0) {
                        tco.towerAddBullet();
                    } else if (tco.getTowerAttackSpeedCounter() >= tco.getTowerAttackSpeed()) {
                        tco.towerAddBullet();
                        tco.setTowerAttackSpeedCounter(0);
                    }
                    tco.setTowerAttackSpeedCounter(tco.getTowerAttackSpeedCounter() + 10);
                } else {
                    getTowerStickOList().remove(tco);
                }
            }

            //CREEPS
            for (int a = 0; a < getCreepEggList().size(); a++) {
                CreepEgg ce = (CreepEgg) getCreepEggList().get(a);
                if (ce.getCreepVisibility() == true) {
                    ce.creepStatusChillFreezeAilment();
                    ce.creepStatusPoisonAilment();
                    ce.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        ce.creepMovementStepAnimation();
                    }
                } else {
                    if (ce.getCreepCollideOnCastle() == false) {
                        if (ce.getCreepKilledBy().equals(playerName)) {
                            playerGold += ce.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(ce.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepEggList().remove(ce);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepBigEggList().size(); a++) {
                CreepBigEgg cbe = (CreepBigEgg) getCreepBigEggList().get(a);
                if (cbe.getCreepVisibility() == true) {
                    cbe.creepStatusChillFreezeAilment();
                    cbe.creepStatusPoisonAilment();
                    cbe.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cbe.creepMovementStepAnimation();
                    }
                } else {
                    if (cbe.getCreepCollideOnCastle() == false) {
                        if (cbe.getCreepKilledBy().equals(playerName)) {
                            playerGold += cbe.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cbe.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepBigEggList().remove(cbe);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepRageEggList().size(); a++) {
                CreepRageEgg cre = (CreepRageEgg) getCreepRageEggList().get(a);
                if (cre.getCreepVisibility() == true) {
                    cre.creepStatusChillFreezeAilment();
                    cre.creepStatusPoisonAilment();
                    cre.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cre.creepMovementStepAnimation();
                    }
                } else {
                    if (cre.getCreepCollideOnCastle() == false) {
                        if (cre.getCreepKilledBy().equals(playerName)) {
                            playerGold += cre.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cre.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepRageEggList().remove(cre);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepBlackAntList().size(); a++) {
                CreepBlackAnt cba = (CreepBlackAnt) getCreepBlackAntList().get(a);
                if (cba.getCreepVisibility() == true) {
                    cba.creepStatusChillFreezeAilment();
                    cba.creepStatusPoisonAilment();
                    cba.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cba.creepMovementStepAnimation();
                    }
                } else {
                    if (cba.getCreepCollideOnCastle() == false) {
                        if (cba.getCreepKilledBy().equals(playerName)) {
                            playerGold += cba.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cba.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepBlackAntList().remove(cba);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepRedAntList().size(); a++) {
                CreepRedAnt cra = (CreepRedAnt) getCreepRedAntList().get(a);
                if (cra.getCreepVisibility() == true) {
                    cra.creepStatusChillFreezeAilment();
                    cra.creepStatusPoisonAilment();
                    cra.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cra.creepMovementStepAnimation();
                    }
                } else {
                    if (cra.getCreepCollideOnCastle() == false) {
                        if (cra.getCreepKilledBy().equals(playerName)) {
                            playerGold += cra.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cra.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepRedAntList().remove(cra);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepRatList().size(); a++) {
                CreepRat cr = (CreepRat) getCreepRatList().get(a);
                if (cr.getCreepVisibility() == true) {
                    cr.creepStatusChillFreezeAilment();
                    cr.creepStatusPoisonAilment();
                    cr.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cr.creepMovementStepAnimation();
                    }
                } else {
                    if (cr.getCreepCollideOnCastle() == false) {
                        if (cr.getCreepKilledBy().equals(playerName)) {
                            playerGold += cr.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cr.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepRatList().remove(cr);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepButterflyList().size(); a++) {
                CreepButterfly cb = (CreepButterfly) getCreepButterflyList().get(a);
                if (cb.getCreepVisibility() == true) {
                    cb.creepStatusChillFreezeAilment();
                    cb.creepStatusPoisonAilment();
                    cb.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cb.creepMovementStepAnimation();
                    }
                } else {
                    if (cb.getCreepCollideOnCastle() == false) {
                        if (cb.getCreepKilledBy().equals(playerName)) {
                            playerGold += cb.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cb.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepButterflyList().remove(cb);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepBeeList().size(); a++) {
                CreepBee cbb = (CreepBee) getCreepBeeList().get(a);
                if (cbb.getCreepVisibility() == true) {
                    cbb.creepStatusChillFreezeAilment();
                    cbb.creepStatusPoisonAilment();
                    cbb.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cbb.creepMovementStepAnimation();
                    }
                } else {
                    if (cbb.getCreepCollideOnCastle() == false) {
                        if (cbb.getCreepKilledBy().equals(playerName)) {
                            playerGold += cbb.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cbb.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepBeeList().remove(cbb);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepBoxerAntList().size(); a++) {
                CreepBoxerAnt crba = (CreepBoxerAnt) getCreepBoxerAntList().get(a);
                if (crba.getCreepVisibility() == true) {
                    crba.creepStatusChillFreezeAilment();
                    crba.creepStatusPoisonAilment();
                    crba.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        crba.creepMovementStepAnimation();
                    }
                } else {
                    if (crba.getCreepCollideOnCastle() == false) {
                        if (crba.getCreepKilledBy().equals(playerName)) {
                            playerGold += crba.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(crba.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepBoxerAntList().remove(crba);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepSpearmanAntList().size(); a++) {
                CreepSpearmanAnt csa = (CreepSpearmanAnt) getCreepSpearmanAntList().get(a);
                if (csa.getCreepVisibility() == true) {
                    csa.creepStatusChillFreezeAilment();
                    csa.creepStatusPoisonAilment();
                    csa.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        csa.creepMovementStepAnimation();
                    }
                } else {
                    if (csa.getCreepCollideOnCastle() == false) {
                        if (csa.getCreepKilledBy().equals(playerName)) {
                            playerGold += csa.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(csa.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepSpearmanAntList().remove(csa);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepSwordsmanAntList().size(); a++) {
                CreepSwordsmanAnt crsa = (CreepSwordsmanAnt) getCreepSwordsmanAntList().get(a);
                if (crsa.getCreepVisibility() == true) {
                    crsa.creepStatusChillFreezeAilment();
                    crsa.creepStatusPoisonAilment();
                    crsa.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        crsa.creepMovementStepAnimation();
                    }
                } else {
                    if (crsa.getCreepCollideOnCastle() == false) {
                        if (crsa.getCreepKilledBy().equals(playerName)) {
                            playerGold += crsa.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(crsa.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepSwordsmanAntList().remove(crsa);
                    creepInsideReduction();
                }
            }

            for (int a = 0; a < getCreepKingAntList().size(); a++) {
                CreepKingAnt cka = (CreepKingAnt) getCreepKingAntList().get(a);
                if (cka.getCreepVisibility() == true) {
                    cka.creepStatusChillFreezeAilment();
                    cka.creepStatusPoisonAilment();
                    cka.creepMovementAnimation();
                    if (creepMovementAnimationPerSecond >= 100) {
                        cka.creepMovementStepAnimation();
                    }
                } else {
                    if (cka.getCreepCollideOnCastle() == false) {
                        if (cka.getCreepKilledBy().equals(playerName)) {
                            playerGold += cka.getCreepGoldBounty();
                        }
                        
                        if (cmMachineType.equals("SERVER")) {
                            setServerLoadKillsOnLeaderBoard(cka.getCreepKilledBy());
                        }
                    } else {
                        if (cmSoundOn == false) {
                            onPlaySoundClip(14);
                            cmSoundOn = true;
                        }
                    }
                    getCreepKingAntList().remove(cka);
                    creepInsideReduction();
                }
            }
            
            if (cmSoundOn) {
                if (cmSoundCounter != 0) {
                    cmSoundCounter -= 1;
                } else {
                    cmSoundCounter = 100;
                    cmSoundOn = false;
                }
            }
            
            if (cmSoundNEG) {
                if (cmSoundNEGCounter != 0) {
                    cmSoundNEGCounter -= 1;
                } else {
                    cmSoundNEGCounter = 50;
                    cmSoundNEG = false;
                }
            }


            if (creepMovementAnimationPerSecond >= 100) {
                creepMovementAnimationPerSecond = 0;
            }

            creepMovementAnimationPerSecond += 20;

            //BULLETS
            for (int a = 0; a < getBulletTIDList().size(); a++) {
                BulletTID bti = (BulletTID) getBulletTIDList().get(a);
                if (bti.getBulletVisibility() == true) {
                    bti.bulletTargetHomingAnimation();
                } else {
                    getBulletTIDList().remove(bti);
                }
            }

            for (int a = 0; a < getBulletTIList().size(); a++) {
                BulletTI bti = (BulletTI) getBulletTIList().get(a);
                if (bti.getBulletVisibility() == true) {
                    bti.bulletTargetHomingAnimation();
                } else {
                    getBulletTIList().remove(bti);
                }
            }

            for (int a = 0; a < getBulletCBList().size(); a++) {
                BulletCB bcb = (BulletCB) getBulletCBList().get(a);
                if (bcb.getBulletVisibility() == true) {
                    bcb.bulletTargetHomingAnimation();
                } else {
                    getBulletCBList().remove(bcb);
                }
            }

            for (int a = 0; a < getBulletCMList().size(); a++) {
                BulletCM bcm = (BulletCM) getBulletCMList().get(a);
                if (bcm.getBulletVisibility() == true) {
                    bcm.bulletTargetHomingAnimation();
                } else {
                    getBulletCMList().remove(bcm);
                }
            }

            for (int a = 0; a < getBulletMList().size(); a++) {
                BulletM bm = (BulletM) getBulletMList().get(a);
                if (bm.getBulletVisibility() == true) {
                    bm.bulletTargetHomingAnimation();
                } else {
                    getBulletMList().remove(bm);
                }
            }

            for (int a = 0; a < getBulletSIDList().size(); a++) {
                BulletSID bsid = (BulletSID) getBulletSIDList().get(a);
                if (bsid.getBulletVisibility() == true) {
                    bsid.bulletTargetHomingAnimation();
                } else {
                    getBulletSIDList().remove(bsid);
                }
            }

            for (int a = 0; a < getBulletSOList().size(); a++) {
                BulletSO bso = (BulletSO) getBulletSOList().get(a);
                if (bso.getBulletVisibility() == true) {
                    bso.bulletTargetHomingAnimation();
                } else {
                    getBulletSOList().remove(bso);
                }
            }

            for (int a = 0; a < getObjectAnimationList().size(); a++) {
                ObjectAnimation oa = (ObjectAnimation) getObjectAnimationList().get(a);
                if (oa.getObjectAnimationVisibility() == true) {
                    if (oa.getObjectAnimationType() == 1 || oa.getObjectAnimationType() == 2 || oa.getObjectAnimationType() == 3) {
                        if (oa.getObjectAnimationTime() > oa.getObjectAnimationCounter()) {
                            oa.setY(oa.getY() - 1);
                            oa.setObjectAnimationCounter(oa.getObjectAnimationCounter() + 1);
                        } else {
                            oa.setObjectAnimationVisibility(false);
                        }
                    } else if (oa.getObjectAnimationType() == 4) {
                        if (oa.getObjectAnimationTime() > oa.getObjectAnimationCounter()) {
                            if (oa.getObjectAnimationCounter() == 0) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(0));
                            } else if (oa.getObjectAnimationCounter() == 1) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(1));
                            } else if (oa.getObjectAnimationCounter() == 2) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(2));
                            } else if (oa.getObjectAnimationCounter() == 3) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(3));
                            } else if (oa.getObjectAnimationCounter() == 4) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(4));
                            } else if (oa.getObjectAnimationCounter() == 5) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(5));
                            }
                            oa.setObjectAnimationCounter(oa.getObjectAnimationCounter() + 1);
                        } else {
                            oa.setObjectAnimationVisibility(false);
                        }
                    } else if (oa.getObjectAnimationType() == 5) {
                        if (oa.getObjectAnimationTime() > oa.getObjectAnimationCounter()) {
                            if (oa.getObjectAnimationCounter() == 0) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(6));
                            } else if (oa.getObjectAnimationCounter() == 1) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(7));
                            } else if (oa.getObjectAnimationCounter() == 2) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(8));
                            } else if (oa.getObjectAnimationCounter() == 3) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(9));
                            } else if (oa.getObjectAnimationCounter() == 4) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(10));
                            } else if (oa.getObjectAnimationCounter() == 5) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(11));
                            } else if (oa.getObjectAnimationCounter() == 6) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(12));
                            } else if (oa.getObjectAnimationCounter() == 7) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(13));
                            } else if (oa.getObjectAnimationCounter() == 8) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(14));
                            } else if (oa.getObjectAnimationCounter() == 9) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(15));
                            } else if (oa.getObjectAnimationCounter() == 10) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(16));
                            }
                            oa.setObjectAnimationCounter(oa.getObjectAnimationCounter() + 1);
                        } else {
                            oa.setObjectAnimationVisibility(false);
                        }
                    } else if (oa.getObjectAnimationType() == 6) {
                        if (oa.getObjectAnimationTime() > oa.getObjectAnimationCounter()) {
                            if (oa.getObjectAnimationCounter() == 0) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(17));
                            } else if (oa.getObjectAnimationCounter() == 1) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(18));
                            } else if (oa.getObjectAnimationCounter() == 2) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(19));
                            } else if (oa.getObjectAnimationCounter() == 3) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(20));
                            } else if (oa.getObjectAnimationCounter() == 4) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(21));
                            } else if (oa.getObjectAnimationCounter() == 5) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(22));
                            } else if (oa.getObjectAnimationCounter() == 6) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(23));
                            } else if (oa.getObjectAnimationCounter() == 7) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(24));
                            } else if (oa.getObjectAnimationCounter() == 8) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(25));
                            } else if (oa.getObjectAnimationCounter() == 9) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(26));
                            } else if (oa.getObjectAnimationCounter() == 10) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(27));
                            } else if (oa.getObjectAnimationCounter() == 11) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(28));
                            } else if (oa.getObjectAnimationCounter() == 12) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(29));
                            } else if (oa.getObjectAnimationCounter() == 13) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(30));
                            } else if (oa.getObjectAnimationCounter() == 14) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(31));
                            }
                            oa.setObjectAnimationCounter(oa.getObjectAnimationCounter() + 1);
                        } else {
                            oa.setObjectAnimationVisibility(false);
                        }
                    } else if (oa.getObjectAnimationType() == 7) {
                        if (oa.getObjectAnimationTime() > oa.getObjectAnimationCounter()) {
                            if (oa.getObjectAnimationCounter() == 0) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(32));
                            } else if (oa.getObjectAnimationCounter() == 1) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(33));
                            } else if (oa.getObjectAnimationCounter() == 2) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(34));
                            } else if (oa.getObjectAnimationCounter() == 3) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(35));
                            } else if (oa.getObjectAnimationCounter() == 4) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(36));
                            } else if (oa.getObjectAnimationCounter() == 5) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(37));
                            } else if (oa.getObjectAnimationCounter() == 6) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(38));
                            } else if (oa.getObjectAnimationCounter() == 7) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(39));
                            } else if (oa.getObjectAnimationCounter() == 8) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(40));
                            } else if (oa.getObjectAnimationCounter() == 9) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(41));
                            }
                            oa.setObjectAnimationCounter(oa.getObjectAnimationCounter() + 1);
                        } else {
                            oa.setObjectAnimationVisibility(false);
                        }
                    } else if (oa.getObjectAnimationType() == 8) {
                        if (oa.getObjectAnimationTime() > oa.getObjectAnimationCounter()) {
                            if (oa.getObjectAnimationCounter() == 0) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(42));
                            } else if (oa.getObjectAnimationCounter() == 4) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(43));
                            } else if (oa.getObjectAnimationCounter() == 9) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(44));
                            } else if (oa.getObjectAnimationCounter() == 14) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(45));
                            } else if (oa.getObjectAnimationCounter() == 19) {
                                oa.setObjectAnimationImage((BufferedImage) getAnimationImageList().get(46));
                            }
                            oa.setObjectAnimationCounter(oa.getObjectAnimationCounter() + 1);
                        } else {
                            oa.setObjectAnimationVisibility(false);
                        }
                    }
                } else {
                    getObjectAnimationList().remove(oa);
                }
            }
        }
    }

    public void renderCandyMagicGame() {
        if (candyMagicImage == null) {
            candyMagicImage = createImage(1024, 768);
            if (candyMagicImage == null) {
                return;
            } else {
                drawOffScreen = candyMagicImage.getGraphics();
                signalOffScreen = candyMagicImage.getGraphics();
            }
        }

        Font candyFont = new Font("Arial", Font.BOLD, 14);
        drawOffScreen.setFont(candyFont);
        drawOffScreen.setColor(Color.BLACK);
        drawOffScreen.drawImage(candyMagicBackground, 0, 0, null);

        if (cmGameRenderingInitialization == true) {
            for (int a = 0; a < getTileObjectList().size(); a++) {
                Tile tl = (Tile) getTileObjectList().get(a);
                if (tl.getX() >= camX && tl.getX() <= (camX + screenWidth)) {
                    if (tl.getY() >= camY && tl.getY() <= (camY + screenHeight)) {
                        drawOffScreen.drawImage(tl.getTileImage(), tl.getX() - camX, tl.getY() - camY, null);
                    }
                }
            }

            //BUILDINGS
            drawOffScreen.drawImage(candyCastle.getCastleImage(), candyCastle.getX() - camX, candyCastle.getY() - camY, null);
            drawOffScreen.setColor(Color.BLACK);
            drawOffScreen.drawRect((candyCastle.getX() + 25) - camX, (candyCastle.getY() + 250) - camY, 150, 5);
            drawOffScreen.setColor(Color.RED);
            drawOffScreen.fillRect((candyCastle.getX() + 25) - camX, (candyCastle.getY() + 250) - camY, 150, 5);
            drawOffScreen.setColor(Color.GREEN);
            double castleHealthBar = ((candyCastle.getCastleCurrentHp() + 0.00) / 100.00) * 150.00;
            drawOffScreen.fillRect((candyCastle.getX() + 25) - camX, (candyCastle.getY() + 250) - camY, (int) castleHealthBar, 5);

            for (int a = 0; a < getTowerIceDropList().size(); a++) {
                TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
                if (tid.getTowerVisibility() == true) {
                    if (tid.getX() >= camX && tid.getX() <= (camX + screenWidth)) {
                        if (tid.getY() >= camY && tid.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(tid.getTowerImage(), tid.getX() - camX, tid.getY() - camY, null);
                            if (onBuild == false) {
                                if (tid.getTowerClicked() == true) {
                                    drawOffScreen.setColor(Color.YELLOW);
                                    drawOffScreen.drawOval(tid.getX() - camX, tid.getY() - camY, 50, 50);
                                    drawOffScreen.setColor(Color.GREEN);
                                    drawOffScreen.drawOval(tid.getX() - tid.getTowerRangeDeductor() - camX, tid.getY() - tid.getTowerRangeDeductor() - camY, tid.getTowerRangeWidth(), tid.getTowerRangeHeight());

                                    hudTowerName = "Ice Drop " + tid.getTowerLevel();
                                    hudTowerDamage = Integer.toString(tid.getTowerDamage());
                                    hudTowerAttackSpeed = Integer.toString(tid.getTowerAttackSpeed()) + "ms";
                                    hudTowerPrimaryAbility = "Rapid Fire";
                                    hudTowerSecondaryAbility = "N/A";
                                    hudTowerLevel = tid.getTowerLevel();
                                    hudTowerVisibility = true;
                                }
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getTowerIceList().size(); a++) {
                TowerIce ti = (TowerIce) getTowerIceList().get(a);
                if (ti.getTowerVisibility() == true) {
                    if (ti.getX() >= camX && ti.getX() <= (camX + screenWidth)) {
                        if (ti.getY() >= camY && ti.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(ti.getTowerImage(), ti.getX() - camX, ti.getY() - camY, null);
                            if (onBuild == false) {
                                if (ti.getTowerClicked() == true) {
                                    drawOffScreen.setColor(Color.YELLOW);
                                    drawOffScreen.drawOval(ti.getX() - camX, ti.getY() - camY, 50, 50);
                                    drawOffScreen.setColor(Color.GREEN);
                                    drawOffScreen.drawOval(ti.getX() - ti.getTowerRangeDeductor() - camX, ti.getY() - ti.getTowerRangeDeductor() - camY, ti.getTowerRangeWidth(), ti.getTowerRangeHeight());

                                    hudTowerName = "Ice " + ti.getTowerLevel();
                                    hudTowerDamage = Integer.toString(ti.getTowerDamage());
                                    hudTowerAttackSpeed = Integer.toString(ti.getTowerAttackSpeed()) + "ms";
                                    if (ti.getTowerLevel() == 1) {
                                        hudTowerPrimaryAbility = "Chill (35%)";
                                        hudTowerSecondaryAbility = "N/A";
                                    } else if (ti.getTowerLevel() == 2) {
                                        hudTowerPrimaryAbility = "Chill (45%)";
                                        hudTowerSecondaryAbility = "N/A";
                                    } else {
                                        hudTowerPrimaryAbility = "Chill (55%)";
                                        hudTowerSecondaryAbility = "Freeze (10%)";
                                    }
                                    hudTowerLevel = ti.getTowerLevel();
                                    hudTowerVisibility = true;
                                }
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
                TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
                if (tcb.getTowerVisibility() == true) {
                    if (tcb.getX() >= camX && tcb.getX() <= (camX + screenWidth)) {
                        if (tcb.getY() >= camY && tcb.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(tcb.getTowerImage(), tcb.getX() - camX, tcb.getY() - camY, null);
                            if (onBuild == false) {
                                if (tcb.getTowerClicked() == true) {
                                    drawOffScreen.setColor(Color.YELLOW);
                                    drawOffScreen.drawOval(tcb.getX() - camX, tcb.getY() - camY, 50, 50);
                                    drawOffScreen.setColor(Color.GREEN);
                                    drawOffScreen.drawOval(tcb.getX() - tcb.getTowerRangeDeductor() - camX, tcb.getY() - tcb.getTowerRangeDeductor() - camY, tcb.getTowerRangeWidth(), tcb.getTowerRangeHeight());

                                    hudTowerName = "Cherrybolt " + tcb.getTowerLevel();
                                    hudTowerDamage = Integer.toString(tcb.getTowerDamage());
                                    hudTowerAttackSpeed = Integer.toString(tcb.getTowerAttackSpeed()) + "ms";
                                    hudTowerPrimaryAbility = "Splash";
                                    hudTowerSecondaryAbility = "N/A";
                                    hudTowerLevel = tcb.getTowerLevel();
                                    hudTowerVisibility = true;
                                }
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
                TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
                if (tcm.getTowerVisibility() == true) {
                    if (tcm.getX() >= camX && tcm.getX() <= (camX + screenWidth)) {
                        if (tcm.getY() >= camY && tcm.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(tcm.getTowerImage(), tcm.getX() - camX, tcm.getY() - camY, null);
                            if (onBuild == false) {
                                if (tcm.getTowerClicked() == true) {
                                    drawOffScreen.setColor(Color.YELLOW);
                                    drawOffScreen.drawOval(tcm.getX() - camX, tcm.getY() - camY, 50, 50);
                                    drawOffScreen.setColor(Color.GREEN);
                                    drawOffScreen.drawOval(tcm.getX() - tcm.getTowerRangeDeductor() - camX, tcm.getY() - tcm.getTowerRangeDeductor() - camY, tcm.getTowerRangeWidth(), tcm.getTowerRangeHeight());

                                    hudTowerName = "Candy Machine " + tcm.getTowerLevel();
                                    hudTowerDamage = Integer.toString(tcm.getTowerDamage());
                                    hudTowerAttackSpeed = Integer.toString(tcm.getTowerAttackSpeed()) + "ms";
                                    if (tcm.getTowerLevel() == 1) {
                                        hudTowerPrimaryAbility = "Sniper";
                                        hudTowerSecondaryAbility = "Bleed (30)";
                                    } else if (tcm.getTowerLevel() == 2) {
                                        hudTowerPrimaryAbility = "Sniper";
                                        hudTowerSecondaryAbility = "Bleed (40)";
                                    } else {
                                        hudTowerPrimaryAbility = "Sniper";
                                        hudTowerSecondaryAbility = "Bleed (70)";
                                    }
                                    hudTowerLevel = tcm.getTowerLevel();
                                    hudTowerVisibility = true;
                                }
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getTowerMentosList().size(); a++) {
                TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
                if (tm.getTowerVisibility() == true) {
                    if (tm.getX() >= camX && tm.getX() <= (camX + screenWidth)) {
                        if (tm.getY() >= camY && tm.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(tm.getTowerImage(), tm.getX() - camX, tm.getY() - camY, null);
                            if (onBuild == false) {
                                if (tm.getTowerClicked() == true) {
                                    drawOffScreen.setColor(Color.YELLOW);
                                    drawOffScreen.drawOval(tm.getX() - camX, tm.getY() - camY, 50, 50);
                                    drawOffScreen.setColor(Color.GREEN);
                                    drawOffScreen.drawOval(tm.getX() - tm.getTowerRangeDeductor() - camX, tm.getY() - tm.getTowerRangeDeductor() - camY, tm.getTowerRangeWidth(), tm.getTowerRangeHeight());

                                    hudTowerName = "Mentos " + tm.getTowerLevel();
                                    hudTowerDamage = Integer.toString(tm.getTowerDamage());
                                    hudTowerAttackSpeed = Integer.toString(tm.getTowerAttackSpeed()) + "ms";
                                    if (tm.getTowerLevel() == 1) {
                                        hudTowerPrimaryAbility = "True Sight";
                                        hudTowerSecondaryAbility = "Multishot (3)";
                                    } else if (tm.getTowerLevel() == 2) {
                                        hudTowerPrimaryAbility = "True Sight";
                                        hudTowerSecondaryAbility = "Multishot (5)";
                                    } else {
                                        hudTowerPrimaryAbility = "True Sight";
                                        hudTowerSecondaryAbility = "Multishot (7)";
                                    }
                                    hudTowerLevel = tm.getTowerLevel();
                                    hudTowerVisibility = true;
                                }
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
                TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
                if (tsid.getTowerVisibility() == true) {
                    if (tsid.getX() >= camX && tsid.getX() <= (camX + screenWidth)) {
                        if (tsid.getY() >= camY && tsid.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(tsid.getTowerImage(), tsid.getX() - camX, tsid.getY() - camY, null);
                            if (onBuild == false) {
                                if (tsid.getTowerClicked() == true) {
                                    drawOffScreen.setColor(Color.YELLOW);
                                    drawOffScreen.drawOval(tsid.getX() - camX, tsid.getY() - camY, 50, 50);
                                    drawOffScreen.setColor(Color.GREEN);
                                    drawOffScreen.drawOval(tsid.getX() - tsid.getTowerRangeDeductor() - camX, tsid.getY() - tsid.getTowerRangeDeductor() - camY, tsid.getTowerRangeWidth(), tsid.getTowerRangeHeight());

                                    hudTowerName = "Single Ice Drop " + tsid.getTowerLevel();
                                    hudTowerDamage = Integer.toString(tsid.getTowerDamage());
                                    hudTowerAttackSpeed = Integer.toString(tsid.getTowerAttackSpeed()) + "ms";
                                    if (tsid.getTowerLevel() == 1) {
                                        hudTowerPrimaryAbility = "Fatal (40x) (25%)";
                                        hudTowerSecondaryAbility = "N/A";
                                    } else if (tsid.getTowerLevel() == 2) {
                                        hudTowerPrimaryAbility = "Fatal (50x) (25%)";
                                        hudTowerSecondaryAbility = "N/A";
                                    } else {
                                        hudTowerPrimaryAbility = "Fatal (60x) (25%)";
                                        hudTowerSecondaryAbility = "N/A";
                                    }
                                    hudTowerLevel = tsid.getTowerLevel();
                                    hudTowerVisibility = true;
                                }
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getTowerStickOList().size(); a++) {
                TowerStickO tso = (TowerStickO) getTowerStickOList().get(a);
                if (tso.getTowerVisibility() == true) {
                    if (tso.getX() >= camX && tso.getX() <= (camX + screenWidth)) {
                        if (tso.getY() >= camY && tso.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(tso.getTowerImage(), tso.getX() - camX, tso.getY() - camY, null);
                            if (onBuild == false) {
                                if (tso.getTowerClicked() == true) {
                                    drawOffScreen.setColor(Color.YELLOW);
                                    drawOffScreen.drawOval(tso.getX() - camX, tso.getY() - camY, 50, 50);
                                    drawOffScreen.setColor(Color.GREEN);
                                    drawOffScreen.drawOval(tso.getX() - tso.getTowerRangeDeductor() - camX, tso.getY() - tso.getTowerRangeDeductor() - camY, tso.getTowerRangeWidth(), tso.getTowerRangeHeight());

                                    hudTowerName = "Stick O " + tso.getTowerLevel();
                                    hudTowerDamage = Integer.toString(tso.getTowerDamage());
                                    hudTowerAttackSpeed = Integer.toString(tso.getTowerAttackSpeed()) + "ms";
                                    if (tso.getTowerLevel() == 1) {
                                        hudTowerPrimaryAbility = "Splash";
                                        hudTowerSecondaryAbility = "Poison (20)";
                                    } else if (tso.getTowerLevel() == 2) {
                                        hudTowerPrimaryAbility = "Splash";
                                        hudTowerSecondaryAbility = "Poison (40)";
                                    } else {
                                        hudTowerPrimaryAbility = "Splash";
                                        hudTowerSecondaryAbility = "Poison (70)";
                                    }
                                    hudTowerLevel = tso.getTowerLevel();
                                    hudTowerVisibility = true;
                                }
                            }
                        }
                    }
                }
            }

            //CREEPS
            for (int a = 0; a < getCreepEggList().size(); a++) {
                CreepEgg ce = (CreepEgg) getCreepEggList().get(a);
                if (ce.getCreepVisibility() == true && ce.getCreepDetection() == true) {
                    if (ce.getX() >= camX && ce.getX() <= (camX + screenWidth)) {
                        if (ce.getY() >= camY && ce.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(ce.getCreepImage(), ce.getX() - camX, ce.getY() - camY, null);
                            if (ce.getCreepCurrentHp() < ce.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(ce.getX() - camX, ce.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(ce.getX() - camX, ce.getY() - camY, 50, 5);
                                double healthBar = ((ce.getCreepCurrentHp() + 0.00) / (ce.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(ce.getX() - camX, ce.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepBigEggList().size(); a++) {
                CreepBigEgg cbe = (CreepBigEgg) getCreepBigEggList().get(a);
                if (cbe.getCreepVisibility() == true && cbe.getCreepDetection() == true) {
                    if (cbe.getX() >= camX && cbe.getX() <= (camX + screenWidth)) {
                        if (cbe.getY() >= camY && cbe.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cbe.getCreepImage(), cbe.getX() - camX, cbe.getY() - camY, null);
                            if (cbe.getCreepCurrentHp() < cbe.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cbe.getX() - camX, cbe.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cbe.getX() - camX, cbe.getY() - camY, 50, 5);
                                double healthBar = ((cbe.getCreepCurrentHp() + 0.00) / (cbe.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cbe.getX() - camX, cbe.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepRageEggList().size(); a++) {
                CreepRageEgg cre = (CreepRageEgg) getCreepRageEggList().get(a);
                if (cre.getCreepVisibility() == true && cre.getCreepDetection() == true) {
                    if (cre.getX() >= camX && cre.getX() <= (camX + screenWidth)) {
                        if (cre.getY() >= camY && cre.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cre.getCreepImage(), cre.getX() - camX, cre.getY() - camY, null);
                            if (cre.getCreepCurrentHp() < cre.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cre.getX() - camX, cre.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cre.getX() - camX, cre.getY() - camY, 50, 5);
                                double healthBar = ((cre.getCreepCurrentHp() + 0.00) / (cre.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cre.getX() - camX, cre.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepBlackAntList().size(); a++) {
                CreepBlackAnt cba = (CreepBlackAnt) getCreepBlackAntList().get(a);
                if (cba.getCreepVisibility() == true && cba.getCreepDetection() == true) {
                    if (cba.getX() >= camX && cba.getX() <= (camX + screenWidth)) {
                        if (cba.getY() >= camY && cba.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cba.getCreepImage(), cba.getX() - camX, cba.getY() - camY, null);
                            if (cba.getCreepCurrentHp() < cba.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cba.getX() - camX, cba.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cba.getX() - camX, cba.getY() - camY, 50, 5);
                                double healthBar = ((cba.getCreepCurrentHp() + 0.00) / (cba.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cba.getX() - camX, cba.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepRedAntList().size(); a++) {
                CreepRedAnt cra = (CreepRedAnt) getCreepRedAntList().get(a);
                if (cra.getCreepVisibility() == true && cra.getCreepDetection() == true) {
                    if (cra.getX() >= camX && cra.getX() <= (camX + screenWidth)) {
                        if (cra.getY() >= camY && cra.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cra.getCreepImage(), cra.getX() - camX, cra.getY() - camY, null);
                            if (cra.getCreepCurrentHp() < cra.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cra.getX() - camX, cra.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cra.getX() - camX, cra.getY() - camY, 50, 5);
                                double healthBar = ((cra.getCreepCurrentHp() + 0.00) / (cra.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cra.getX() - camX, cra.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepRatList().size(); a++) {
                CreepRat cr = (CreepRat) getCreepRatList().get(a);
                if (cr.getCreepVisibility() == true && cr.getCreepDetection() == true) {
                    if (cr.getX() >= camX && cr.getX() <= (camX + screenWidth)) {
                        if (cr.getY() >= camY && cr.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cr.getCreepImage(), cr.getX() - camX, cr.getY() - camY, null);
                            if (cr.getCreepCurrentHp() < cr.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cr.getX() - camX, cr.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cr.getX() - camX, cr.getY() - camY, 50, 5);
                                double healthBar = ((cr.getCreepCurrentHp() + 0.00) / (cr.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cr.getX() - camX, cr.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepButterflyList().size(); a++) {
                CreepButterfly cb = (CreepButterfly) getCreepButterflyList().get(a);
                if (cb.getCreepVisibility() == true && cb.getCreepDetection() == true) {
                    if (cb.getX() >= camX && cb.getX() <= (camX + screenWidth)) {
                        if (cb.getY() >= camY && cb.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cb.getCreepImage(), cb.getX() - camX, cb.getY() - camY, null);
                            if (cb.getCreepCurrentHp() < cb.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cb.getX() - camX, cb.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cb.getX() - camX, cb.getY() - camY, 50, 5);
                                double healthBar = ((cb.getCreepCurrentHp() + 0.00) / (cb.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cb.getX() - camX, cb.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepBeeList().size(); a++) {
                CreepBee cbb = (CreepBee) getCreepBeeList().get(a);
                if (cbb.getCreepVisibility() == true && cbb.getCreepDetection() == true) {
                    if (cbb.getX() >= camX && cbb.getX() <= (camX + screenWidth)) {
                        if (cbb.getY() >= camY && cbb.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cbb.getCreepImage(), cbb.getX() - camX, cbb.getY() - camY, null);
                            if (cbb.getCreepCurrentHp() < cbb.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cbb.getX() - camX, cbb.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cbb.getX() - camX, cbb.getY() - camY, 50, 5);
                                double healthBar = ((cbb.getCreepCurrentHp() + 0.00) / (cbb.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cbb.getX() - camX, cbb.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepBoxerAntList().size(); a++) {
                CreepBoxerAnt cba = (CreepBoxerAnt) getCreepBoxerAntList().get(a);
                if (cba.getCreepVisibility() == true && cba.getCreepDetection() == true) {
                    if (cba.getX() >= camX && cba.getX() <= (camX + screenWidth)) {
                        if (cba.getY() >= camY && cba.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cba.getCreepImage(), cba.getX() - camX, cba.getY() - camY, null);
                            if (cba.getCreepCurrentHp() < cba.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cba.getX() - camX, cba.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cba.getX() - camX, cba.getY() - camY, 50, 5);
                                double healthBar = ((cba.getCreepCurrentHp() + 0.00) / (cba.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cba.getX() - camX, cba.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepSpearmanAntList().size(); a++) {
                CreepSpearmanAnt csa = (CreepSpearmanAnt) getCreepSpearmanAntList().get(a);
                if (csa.getCreepVisibility() == true && csa.getCreepDetection() == true) {
                    if (csa.getX() >= camX && csa.getX() <= (camX + screenWidth)) {
                        if (csa.getY() >= camY && csa.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(csa.getCreepImage(), csa.getX() - camX, csa.getY() - camY, null);
                            if (csa.getCreepCurrentHp() < csa.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(csa.getX() - camX, csa.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(csa.getX() - camX, csa.getY() - camY, 50, 5);
                                double healthBar = ((csa.getCreepCurrentHp() + 0.00) / (csa.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(csa.getX() - camX, csa.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepSwordsmanAntList().size(); a++) {
                CreepSwordsmanAnt csa = (CreepSwordsmanAnt) getCreepSwordsmanAntList().get(a);
                if (csa.getCreepVisibility() == true && csa.getCreepDetection() == true) {
                    if (csa.getX() >= camX && csa.getX() <= (camX + screenWidth)) {
                        if (csa.getY() >= camY && csa.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(csa.getCreepImage(), csa.getX() - camX, csa.getY() - camY, null);
                            if (csa.getCreepCurrentHp() < csa.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(csa.getX() - camX, csa.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(csa.getX() - camX, csa.getY() - camY, 50, 5);
                                double healthBar = ((csa.getCreepCurrentHp() + 0.00) / (csa.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(csa.getX() - camX, csa.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            for (int a = 0; a < getCreepKingAntList().size(); a++) {
                CreepKingAnt cka = (CreepKingAnt) getCreepKingAntList().get(a);
                if (cka.getCreepVisibility() == true && cka.getCreepDetection() == true) {
                    if (cka.getX() >= camX && cka.getX() <= (camX + screenWidth)) {
                        if (cka.getY() >= camY && cka.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(cka.getCreepImage(), cka.getX() - camX, cka.getY() - camY, null);
                            if (cka.getCreepCurrentHp() < cka.getCreepMaxHp()) {
                                drawOffScreen.setColor(Color.BLACK);
                                drawOffScreen.drawRect(cka.getX() - camX, cka.getY() - camY, 50, 5);
                                drawOffScreen.setColor(Color.RED);
                                drawOffScreen.fillRect(cka.getX() - camX, cka.getY() - camY, 50, 5);
                                double healthBar = ((cka.getCreepCurrentHp() + 0.00) / (cka.getCreepMaxHp() + 0.00)) * 50.00;
                                drawOffScreen.setColor(Color.GREEN);
                                drawOffScreen.fillRect(cka.getX() - camX, cka.getY() - camY, (int) healthBar, 5);
                            }
                        }
                    }
                }
            }

            //DOODADS
            for (int a = 0; a < getBushObjectList().size(); a++) {
                Bush b = (Bush) getBushObjectList().get(a);
                if (b.getX() >= camX && b.getX() <= (camX + screenWidth)) {
                    if (b.getY() >= camY && b.getY() <= (camY + screenHeight)) {
                        drawOffScreen.drawImage(b.getImage(), b.getX() - camX, b.getY() - camY, null);
                    }
                }

            }

            for (int a = 0; a < getTreeObjectList().size(); a++) {
                Tree tr = (Tree) getTreeObjectList().get(a);
                if (tr.getX() >= camX && tr.getX() <= (camX + screenWidth)) {
                    if (tr.getY() >= camY && tr.getY() <= (camY + screenHeight)) {
                        drawOffScreen.drawImage(tr.getImage(), tr.getX() - camX, tr.getY() - camY, null);
                    }
                }

            }

            candyFont = new Font("Arial", Font.BOLD, 14);
            drawOffScreen.setFont(candyFont);
            //BULLETS
            for (int a = 0; a < getBulletTIDList().size(); a++) {
                BulletTID bti = (BulletTID) getBulletTIDList().get(a);
                if (bti.getBulletVisibility() == true) {
                    if (bti.getX() >= camX && bti.getX() <= (camX + screenWidth)) {
                        if (bti.getY() >= camY && bti.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(bti.getBulletImage(), bti.getX() - camX, bti.getY() - camY, null);
                        }
                    }
                }
            }

            for (int a = 0; a < getBulletTIList().size(); a++) {
                BulletTI bti = (BulletTI) getBulletTIList().get(a);
                if (bti.getBulletVisibility() == true) {
                    if (bti.getX() >= camX && bti.getX() <= (camX + screenWidth)) {
                        if (bti.getY() >= camY && bti.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(bti.getBulletImage(), bti.getX() - camX, bti.getY() - camY, null);
                        }
                    }
                }
            }

            for (int a = 0; a < getBulletCBList().size(); a++) {
                BulletCB bcb = (BulletCB) getBulletCBList().get(a);
                if (bcb.getBulletVisibility() == true) {
                    if (bcb.getX() >= camX && bcb.getX() <= (camX + screenWidth)) {
                        if (bcb.getY() >= camY && bcb.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(bcb.getBulletImage(), bcb.getX() - camX, bcb.getY() - camY, null);
                        }
                    }
                }
            }

            for (int a = 0; a < getBulletCMList().size(); a++) {
                BulletCM bcm = (BulletCM) getBulletCMList().get(a);
                if (bcm.getBulletVisibility() == true) {
                    if (bcm.getX() >= camX && bcm.getX() <= (camX + screenWidth)) {
                        if (bcm.getY() >= camY && bcm.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(bcm.getBulletImage(), bcm.getX() - camX, bcm.getY() - camY, null);
                        }
                    }
                }
            }

            for (int a = 0; a < getBulletMList().size(); a++) {
                BulletM bm = (BulletM) getBulletMList().get(a);
                if (bm.getBulletVisibility() == true) {
                    if (bm.getX() >= camX && bm.getX() <= (camX + screenWidth)) {
                        if (bm.getY() >= camY && bm.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(bm.getBulletImage(), bm.getX() - camX, bm.getY() - camY, null);
                        }
                    }
                }
            }

            for (int a = 0; a < getBulletSIDList().size(); a++) {
                BulletSID bsid = (BulletSID) getBulletSIDList().get(a);
                if (bsid.getBulletVisibility() == true) {
                    if (bsid.getX() >= camX && bsid.getX() <= (camX + screenWidth)) {
                        if (bsid.getY() >= camY && bsid.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(bsid.getBulletImage(), bsid.getX() - camX, bsid.getY() - camY, null);
                        }
                    }
                }
            }

            for (int a = 0; a < getBulletSOList().size(); a++) {
                BulletSO bso = (BulletSO) getBulletSOList().get(a);
                if (bso.getBulletVisibility() == true) {
                    if (bso.getX() >= camX && bso.getX() <= (camX + screenWidth)) {
                        if (bso.getY() >= camY && bso.getY() <= (camY + screenHeight)) {
                            drawOffScreen.drawImage(bso.getBulletImage(), bso.getX() - camX, bso.getY() - camY, null);
                        }
                    }
                }
            }

            if (onBuild == true) {
                for (int a = 0; a < getTileObjectList().size(); a++) {
                    Tile tl = (Tile) getTileObjectList().get(a);
                    if (tl.getX() == finalMouseX && tl.getY() == finalMouseY) {
                        if (tl.getTileVacancy() == false) {
                            if (towerType == 1) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(0), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 2) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(2), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 3) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(4), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 4) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(6), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 5) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(8), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 6) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(10), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 7) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(12), finalMouseX - camX, finalMouseY - camY, null);
                            }
                        } else {
                            if (towerType == 1) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(1), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 2) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(3), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 3) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(5), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 4) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(7), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 5) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(9), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 6) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(11), finalMouseX - camX, finalMouseY - camY, null);
                            } else if (towerType == 7) {
                                drawOffScreen.drawImage((BufferedImage) getTowerGridImageList().get(13), finalMouseX - camX, finalMouseY - camY, null);
                            }
                        }
                    }
                }
            }

            drawOffScreen.setColor(Color.BLACK);
            drawOffScreen.drawImage(coinBundleImage, 8, 10, null);
            drawOffScreen.drawString("" + playerGold, 40, 25);
            if (creepInside < 10) {
                drawOffScreen.drawString("Creeps: " + creepInside, (screenWidth / 2 - 30), 40);
            } else if (creepInside < 100) {
                drawOffScreen.drawString("Creeps: " + creepInside, (screenWidth / 2 - 36), 40);
            } else if (creepInside < 1000) {
                drawOffScreen.drawString("Creeps: " + creepInside, (screenWidth / 2 - 38), 40);
            } else if (creepInside < 10000) {
                drawOffScreen.drawString("Creeps: " + creepInside, (screenWidth / 2 - 44), 40);
            }
            drawOffScreen.drawString("Wave " + creepWave + " of 25", 470, 20);
            drawOffScreen.drawString("" + candyCastle.getCastleCurrentHp(), 40, 60);
            drawOffScreen.drawImage(lifeImage, 10, 45, null);
            
            candyFont = new Font("Arial", Font.BOLD, 14);
            drawOffScreen.setFont(candyFont);

            for (int a = 0; a < getObjectAnimationList().size(); a++) {
                ObjectAnimation oa = (ObjectAnimation) getObjectAnimationList().get(a);
                if (oa.getObjectAnimationVisibility() == true) {
                    if (oa.getObjectAnimationType() == 1) {
                        drawOffScreen.setColor(Color.YELLOW);
                        drawOffScreen.drawString("+" + oa.getObjectLevelFactor(), oa.getX() - camX, oa.getY() - camY);
                    } else if (oa.getObjectAnimationType() == 2) {
                        drawOffScreen.setColor(Color.RED);
                        if (oa.getObjectLevelFactor() == 1) {
                            drawOffScreen.drawString("160!", oa.getX() - camX, oa.getY() - camY);
                        } else if (oa.getObjectLevelFactor() == 2) {
                            drawOffScreen.drawString("300!", oa.getX() - camX, oa.getY() - camY);
                        } else if (oa.getObjectLevelFactor() == 3) {
                            drawOffScreen.drawString("480!", oa.getX() - camX, oa.getY() - camY);
                        }
                    } else if (oa.getObjectAnimationType() == 3) {
                        drawOffScreen.setColor(Color.GREEN);
                        drawOffScreen.drawString("-" + oa.getObjectLevelFactor(), oa.getX() - camX, oa.getY() - camY);
                    } else if (oa.getObjectAnimationType() == 4 || oa.getObjectAnimationType() == 5 || oa.getObjectAnimationType() == 6 || oa.getObjectAnimationType() == 7 || oa.getObjectAnimationType() == 8) {
                        drawOffScreen.drawImage(oa.getObjectAnimationImage(), oa.getX() - camX, oa.getY() - camY, null);
                    }
                }
            }
            
            drawOffScreen.drawImage(leaderboardPanelImage, 845, 3, null);
            candyFont = new Font("Calibri", Font.BOLD, 12);
            drawOffScreen.setFont(candyFont);
            drawOffScreen.setColor(Color.BLACK);
            drawOffScreen.drawString("Candy Magic TD Leaderboard", 855, 20);
            drawOffScreen.drawString("Name", 865, 40);
            drawOffScreen.drawString(player1, 865, 55);
            drawOffScreen.drawString(player2, 865, 70);
            drawOffScreen.drawString(player3, 865, 85);
            drawOffScreen.drawString(player4, 865, 100);
            drawOffScreen.drawString("Kills", 965, 40);
            drawOffScreen.drawString("" + p1Kills, 965, 55);
            drawOffScreen.drawString("" + p2Kills, 965, 70);
            drawOffScreen.drawString("" + p3Kills, 965, 85);
            drawOffScreen.drawString("" + p4Kills, 965, 100);
            
            candyFont = new Font("Arial", Font.BOLD, 14);
            drawOffScreen.setFont(candyFont);

            if (creepInside != 0 && creepWave != 26) {
                drawOffScreen.drawImage((BufferedImage) getWaveNoTagImageList().get(creepWave - 1), screenWidth / 2 - waveNoTagImage.getWidth() / 2, 45, null);
            }
            
            //HUD
            drawOffScreen.drawImage(hudImage, 0, 0, null);
            for (int a = 0; a < getTileObjectList().size(); a++) {
                Tile tl = (Tile) getTileObjectList().get(a);
                if (tl.getTileType().equals("o") || tl.getTileType().equals("t") || tl.getTileType().equals("b")) {
                    drawOffScreen.setColor(Color.WHITE);
                } else {
                    drawOffScreen.setColor(Color.LIGHT_GRAY);
                }
                int ceX = tl.getX();
                int ceY = tl.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 2, (int) 2);
                drawOffScreen.fillRect(miniX, miniY, (int) 2, (int) 2);
            }

            drawOffScreen.setColor(Color.RED);
            for (int a = 0; a < getCreepEggList().size(); a++) {
                CreepEgg ce = (CreepEgg) getCreepEggList().get(a);
                if (ce.getCreepVisibility() == true && ce.getCreepDetection() == true) {
                    if ((ce.getY() > 0 && ce.getY() < 3350) && (ce.getX() > 0 && ce.getX() < 3350)) {
                        int ceX = ce.getX();
                        int ceY = ce.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepBigEggList().size(); a++) {
                CreepBigEgg cbe = (CreepBigEgg) getCreepBigEggList().get(a);
                if (cbe.getCreepVisibility() == true && cbe.getCreepDetection() == true) {
                    if ((cbe.getY() > 0 && cbe.getY() < 3350) && (cbe.getX() > 0 && cbe.getX() < 3350)) {
                        int ceX = cbe.getX();
                        int ceY = cbe.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepRageEggList().size(); a++) {
                CreepRageEgg cre = (CreepRageEgg) getCreepRageEggList().get(a);
                if (cre.getCreepVisibility() == true && cre.getCreepDetection() == true) {
                    if ((cre.getY() > 0 && cre.getY() < 3350) && (cre.getX() > 0 && cre.getX() < 3350)) {
                        int ceX = cre.getX();
                        int ceY = cre.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepBlackAntList().size(); a++) {
                CreepBlackAnt cba = (CreepBlackAnt) getCreepBlackAntList().get(a);
                if (cba.getCreepVisibility() == true && cba.getCreepDetection() == true) {
                    if ((cba.getY() > 0 && cba.getY() < 3350) && (cba.getX() > 0 && cba.getX() < 3350)) {
                        int ceX = cba.getX();
                        int ceY = cba.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepRedAntList().size(); a++) {
                CreepRedAnt cra = (CreepRedAnt) getCreepRedAntList().get(a);
                if (cra.getCreepVisibility() == true && cra.getCreepDetection() == true) {
                    if ((cra.getY() > 0 && cra.getY() < 3350) && (cra.getX() > 0 && cra.getX() < 3350)) {
                        int ceX = cra.getX();
                        int ceY = cra.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepRatList().size(); a++) {
                CreepRat cr = (CreepRat) getCreepRatList().get(a);
                if (cr.getCreepVisibility() == true && cr.getCreepDetection() == true) {
                    if ((cr.getY() > 0 && cr.getY() < 3350) && (cr.getX() > 0 && cr.getX() < 3350)) {
                        int ceX = cr.getX();
                        int ceY = cr.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepButterflyList().size(); a++) {
                CreepButterfly cbu = (CreepButterfly) getCreepButterflyList().get(a);
                if (cbu.getCreepVisibility() == true && cbu.getCreepDetection() == true) {
                    if ((cbu.getY() > 0 && cbu.getY() < 3350) && (cbu.getX() > 0 && cbu.getX() < 3350)) {
                        int ceX = cbu.getX();
                        int ceY = cbu.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepBeeList().size(); a++) {
                CreepBee cb = (CreepBee) getCreepBeeList().get(a);
                if (cb.getCreepVisibility() == true && cb.getCreepDetection() == true) {
                    if ((cb.getY() > 0 && cb.getY() < 3350) && (cb.getX() > 0 && cb.getX() < 3350)) {
                        int ceX = cb.getX();
                        int ceY = cb.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepBoxerAntList().size(); a++) {
                CreepBoxerAnt cboa = (CreepBoxerAnt) getCreepBoxerAntList().get(a);
                if (cboa.getCreepVisibility() == true && cboa.getCreepDetection() == true) {
                    if ((cboa.getY() > 0 && cboa.getY() < 3350) && (cboa.getX() > 0 && cboa.getX() < 3350)) {
                        int ceX = cboa.getX();
                        int ceY = cboa.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepSpearmanAntList().size(); a++) {
                CreepSpearmanAnt cspa = (CreepSpearmanAnt) getCreepSpearmanAntList().get(a);
                if (cspa.getCreepVisibility() == true && cspa.getCreepDetection() == true) {
                    if ((cspa.getY() > 0 && cspa.getY() < 3350) && (cspa.getX() > 0 && cspa.getX() < 3350)) {
                        int ceX = cspa.getX();
                        int ceY = cspa.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepSwordsmanAntList().size(); a++) {
                CreepSwordsmanAnt cswa = (CreepSwordsmanAnt) getCreepSwordsmanAntList().get(a);
                if (cswa.getCreepVisibility() == true && cswa.getCreepDetection() == true) {
                    if ((cswa.getY() > 0 && cswa.getY() < 3350) && (cswa.getX() > 0 && cswa.getX() < 3350)) {
                        int ceX = cswa.getX();
                        int ceY = cswa.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            for (int a = 0; a < getCreepKingAntList().size(); a++) {
                CreepKingAnt cka = (CreepKingAnt) getCreepKingAntList().get(a);
                if (cka.getCreepVisibility() == true && cka.getCreepDetection() == true) {
                    if ((cka.getY() > 0 && cka.getY() < 3350) && (cka.getX() > 0 && cka.getX() < 3350)) {
                        int ceX = cka.getX();
                        int ceY = cka.getY();
                        int miniX = ((ceX * 180) / 3350) + 10;
                        int miniY = ((ceY * 180) / 3350) + 575;

                        drawOffScreen.drawRect(miniX, miniY, (int) .1, (int) .1);
                        drawOffScreen.fillRect(miniX, miniY, (int) .1, (int) .1);
                    }
                }
            }

            int rceX = candyCastle.getX();
            int rceY = candyCastle.getY();
            int rminiX = ((rceX * 180) / 3350) + 13;
            int rminiY = ((rceY * 180) / 3350) + 584;
            drawOffScreen.setColor(Color.BLACK);
            drawOffScreen.drawRect(rminiX, rminiY, (int) 4, (int) 4);
            drawOffScreen.setColor(Color.CYAN);
            drawOffScreen.fillRect(rminiX, rminiY, (int) 4, (int) 4);

            for (int a = 0; a < getTowerIceDropList().size(); a++) {
                TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
                if (tid.getTowerOwner().equals(playerName)) {
                    drawOffScreen.setColor(Color.BLUE);
                } else {
                    drawOffScreen.setColor(Color.CYAN);
                }
                int ceX = tid.getX();
                int ceY = tid.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 1.5, (int) 1.5);
                drawOffScreen.fillRect(miniX, miniY, (int) 1.5, (int) 1.5);
            }

            for (int a = 0; a < getTowerIceList().size(); a++) {
                TowerIce ti = (TowerIce) getTowerIceList().get(a);
                if (ti.getTowerOwner().equals(playerName)) {
                    drawOffScreen.setColor(Color.BLUE);
                } else {
                    drawOffScreen.setColor(Color.CYAN);
                }
                int ceX = ti.getX();
                int ceY = ti.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 1.5, (int) 1.5);
                drawOffScreen.fillRect(miniX, miniY, (int) 1.5, (int) 1.5);
            }

            for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
                TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
                if (tcb.getTowerOwner().equals(playerName)) {
                    drawOffScreen.setColor(Color.BLUE);
                } else {
                    drawOffScreen.setColor(Color.CYAN);
                }
                int ceX = tcb.getX();
                int ceY = tcb.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 1.5, (int) 1.5);
                drawOffScreen.fillRect(miniX, miniY, (int) 1.5, (int) 1.5);
            }

            for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
                TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
                if (tcm.getTowerOwner().equals(playerName)) {
                    drawOffScreen.setColor(Color.BLUE);
                } else {
                    drawOffScreen.setColor(Color.CYAN);
                }
                int ceX = tcm.getX();
                int ceY = tcm.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 1.5, (int) 1.5);
                drawOffScreen.fillRect(miniX, miniY, (int) 1.5, (int) 1.5);
            }

            for (int a = 0; a < getTowerMentosList().size(); a++) {
                TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
                if (tm.getTowerOwner().equals(playerName)) {
                    drawOffScreen.setColor(Color.BLUE);
                } else {
                    drawOffScreen.setColor(Color.CYAN);
                }
                int ceX = tm.getX();
                int ceY = tm.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 1.5, (int) 1.5);
                drawOffScreen.fillRect(miniX, miniY, (int) 1.5, (int) 1.5);
            }

            for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
                TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
                if (tsid.getTowerOwner().equals(playerName)) {
                    drawOffScreen.setColor(Color.BLUE);
                } else {
                    drawOffScreen.setColor(Color.CYAN);
                }
                int ceX = tsid.getX();
                int ceY = tsid.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 1.5, (int) 1.5);
                drawOffScreen.fillRect(miniX, miniY, (int) 1.5, (int) 1.5);
            }

            for (int a = 0; a < getTowerStickOList().size(); a++) {
                TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
                if (tco.getTowerOwner().equals(playerName)) {
                    drawOffScreen.setColor(Color.BLUE);
                } else {
                    drawOffScreen.setColor(Color.CYAN);
                }
                int ceX = tco.getX();
                int ceY = tco.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;

                drawOffScreen.drawRect(miniX, miniY, (int) 1.5, (int) 1.5);
                drawOffScreen.fillRect(miniX, miniY, (int) 1.5, (int) 1.5);
            }

            
            for (int a = 0; a < getTreeList().size(); a++) {
                Tree t = (Tree) getTreeList().get(a);
                int ceX = t.getX();
                int ceY = t.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;
                drawOffScreen.setColor(Color.BLACK);
                drawOffScreen.drawRect(miniX, miniY, (int) 1, (int) 1);
                drawOffScreen.setColor(Color.GREEN);
                drawOffScreen.fillRect(miniX, miniY, (int) 1, (int) 1);
            }

            for (int a = 0; a < getBushList().size(); a++) {
                Bush b = (Bush) getBushList().get(a);
                int ceX = b.getX();
                int ceY = b.getY();
                int miniX = ((ceX * 180) / 3350) + 10;
                int miniY = ((ceY * 180) / 3350) + 575;
                drawOffScreen.setColor(Color.BLACK);
                drawOffScreen.drawRect(miniX, miniY, (int) 1, (int) 1);
                drawOffScreen.setColor(Color.GREEN);
                drawOffScreen.fillRect(miniX, miniY, (int) 1, (int) 1);
            }
            
            if(isSignal) {
               signalOffScreen.setColor(Color.RED);
               signalOffScreen.drawRect(signalX, signalY, 10, 10);
               signalOffScreen.fillRect(signalX, signalY, 10, 10);
            }
            
            drawOffScreen.setColor(Color.BLACK);
            drawOffScreen.drawRect(minpX, minpY, 55, 41);

            if (hudTowerVisibility) {
                drawOffScreen.setColor(Color.YELLOW);
                drawOffScreen.drawString(hudTowerName, 602 - (hudTowerName.length() * 3), 670);
                drawOffScreen.drawString("Damage: " + hudTowerDamage, 465, 715);
                drawOffScreen.drawString("PA: " + hudTowerPrimaryAbility, 620, 715);
                drawOffScreen.drawString("ATK Speed: " + hudTowerAttackSpeed, 465, 740);
                drawOffScreen.drawString("SA: " + hudTowerSecondaryAbility, 620, 740);

                if (hudTowerName.startsWith("Ice Drop")) {
                    if (hudTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(0), 340, 620, null);
                    } else if (hudTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(1), 340, 620, null);
                    } else if (hudTowerLevel == 3) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(2), 340, 620, null);
                    }
                } else if (hudTowerName.startsWith("Ice")) {
                    if (hudTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(3), 340, 620, null);
                    } else if (hudTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(4), 340, 620, null);
                    } else if (hudTowerLevel == 3) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(5), 340, 620, null);
                    }
                } else if (hudTowerName.startsWith("Cherry")) {
                    if (hudTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(6), 340, 620, null);
                    } else if (hudTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(7), 340, 620, null);
                    } else if (hudTowerLevel == 3) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(8), 340, 620, null);
                    }
                } else if (hudTowerName.startsWith("Candy")) {
                    if (hudTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(9), 340, 620, null);
                    } else if (hudTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(10), 340, 620, null);
                    } else if (hudTowerLevel == 3) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(11), 340, 620, null);
                    }
                } else if (hudTowerName.startsWith("Mentos")) {
                    if (hudTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(12), 340, 620, null);
                    } else if (hudTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(13), 340, 620, null);
                    } else if (hudTowerLevel == 3) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(14), 340, 620, null);
                    }
                } else if (hudTowerName.startsWith("Single")) {
                    if (hudTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(15), 340, 620, null);
                    } else if (hudTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(16), 340, 620, null);
                    } else if (hudTowerLevel == 3) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(17), 340, 620, null);
                    }
                } else if (hudTowerName.startsWith("Stick")) {
                    if (hudTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(18), 340, 620, null);
                    } else if (hudTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(19), 340, 620, null);
                    } else if (hudTowerLevel == 3) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudImageList().get(20), 340, 620, null);
                    }
                }
            }

            if (onBuild == false && onClick == false) {
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(0), 764, 625, null);
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(3), 829, 625, null);
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(6), 896, 625, null);
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(9), 969, 625, null);
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(12), 764, 702, null);
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(15), 829, 702, null);
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(18), 896, 702, null);
            } else if (onClick == true) {
                if (onClickTowerType.equals("1")) {
                    if (onClickTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(1), 764, 625, null);
                    } else if (onClickTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(2), 764, 625, null);
                    }
                    drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(21), 829, 625, null);
                } else if (onClickTowerType.equals("2")) {
                    if (onClickTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(4), 764, 625, null);
                    } else if (onClickTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(5), 764, 625, null);
                    }
                } else if (onClickTowerType.equals("3")) {
                    if (onClickTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(7), 764, 625, null);
                    } else if (onClickTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(8), 764, 625, null);
                    }
                } else if (onClickTowerType.equals("4")) {
                    if (onClickTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(10), 764, 625, null);
                    } else if (onClickTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(11), 764, 625, null);
                    }
                } else if (onClickTowerType.equals("5")) {
                    if (onClickTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(13), 764, 625, null);
                    } else if (onClickTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(14), 764, 625, null);
                    }
                } else if (onClickTowerType.equals("6")) {
                    if (onClickTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(16), 764, 625, null);
                    } else if (onClickTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(17), 764, 625, null);
                    }
                } else if (onClickTowerType.equals("7")) {
                    if (onClickTowerLevel == 1) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(19), 764, 625, null);
                    } else if (onClickTowerLevel == 2) {
                        drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(20), 764, 625, null);
                    }
                }
                drawOffScreen.drawImage((BufferedImage) getTowerHudButtonImageList().get(21), 829, 625, null);
            }
            drawOffScreen.setColor(Color.BLACK);
            drawOffScreen.drawString("X: " + mouseX + "/" + finalMouseX, mouseX + 25, mouseY);
            drawOffScreen.drawString("Y: " + mouseY + "/" + finalMouseY, mouseX + 25, mouseY + 20);
            drawOffScreen.drawString("Cam X: " + camX, mouseX + 25, mouseY + 40);
            drawOffScreen.drawString("Cam Y: " + camY, mouseX + 25, mouseY + 60);

            candyFont = new Font("Arial", Font.BOLD, 30);
            drawOffScreen.setFont(candyFont);
            if (creepInside == 0) {
                if (creepCountForWave == 10) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(0), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 9) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(1), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 8) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(2), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 7) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(3), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 6) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(4), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 5) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(5), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 4) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(6), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 3) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(7), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 2) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(8), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 1) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(9), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                } else if (creepCountForWave == 0) {
                    drawOffScreen.drawImage((BufferedImage) getWaveNoImageList().get(10), screenWidth / 2 - waveNoImage.getWidth() / 2, screenHeight / 2 - waveNoImage.getHeight(), null);
                }
            }
        } else {
            drawOffScreen.drawImage(candyMagicInGameLoading, 0, 0, null);
        }
    }

    public void paintCandyMagicGame() {
        Graphics drawOnScreen;
        try {
            drawOnScreen = this.getGraphics();
            if (drawOnScreen != null && candyMagicImage != null) {
                drawOnScreen.drawImage(candyMagicImage, 0, 0, null);
                Toolkit.getDefaultToolkit().sync();
                drawOnScreen.dispose();
            }
        } catch (Exception ex) {
        }
    }

    //Functions----------------------------------------------------------------------------
    public void loadInterfaces() {
        //MAP CODE
        try {
            fileMap = new File("objects\\tilemap\\TileMap.txt");
            readerMap = new BufferedReader(new FileReader(fileMap));
            tileRow = Integer.parseInt(readerMap.readLine());
            tileColumn = Integer.parseInt(readerMap.readLine());
            maxCamX = (tileRow - 21) * 50;
            maxCamY = (tileColumn - 13) * 50;
            System.out.println("Map Total Tile Rows: " + tileRow);
            System.out.println("Map Total Tile Columns: " + tileColumn);
            System.out.println("Max Cam X: " + maxCamX);
            System.out.println("Max Cam Y: " + maxCamY);
            tileSet = new String[tileColumn];
            tileMap = new String[tileRow][tileColumn];
            while ((tileTemp = readerMap.readLine()) != null) {
                tileSet[tileSetIterator] = tileTemp;
                tileSetIterator++;
            }

            for (int a = 0; a < tileColumn; a++) {
                for (int b = 0; b < tileRow; b++) {
                    tileMap[b][a] = "" + tileSet[a].charAt(b);
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }

        castleImageList = new ArrayList<>();
        tileImageList = new ArrayList<>();
        treeImageList = new ArrayList<>();
        bushImageList = new ArrayList<>();
        animationImageList = new ArrayList<>();
        towerIceDropImageList = new ArrayList<>();
        towerIceImageList = new ArrayList<>();
        towerCherryBoltImageList = new ArrayList<>();
        towerCandyMachineImageList = new ArrayList<>();
        towerMentosImageList = new ArrayList<>();
        towerSingleIceDropImageList = new ArrayList<>();
        towerStickOImageList = new ArrayList<>();
        towerGridImageList = new ArrayList<>();
        creepImageList = new ArrayList<>();
        bulletImageList = new ArrayList<>();
        towerHudImageList = new ArrayList<>();
        towerHudButtonImageList = new ArrayList<>();
        waveNoImageList = new ArrayList<>();
        waveNoTagImageList = new ArrayList<>();

        try {
            candyMagicBackground = ImageIO.read(new File("objects\\background\\CandyMagicBackground.png"));
            candyMagicInGameLoading = ImageIO.read(new File("objects\\splashscreen\\CMInGameSplashScreen.png"));
            hudImage = ImageIO.read(new File("objects\\panel\\Hud.png"));
            lifeImage = ImageIO.read(new File("objects\\panel\\Heart.png"));
            coinBundleImage = ImageIO.read(new File("objects\\panel\\CoinBundle.png"));
            castleImage = ImageIO.read(new File("objects\\castle\\Castle100.png"));
            castleImageList.add(castleImage);
            castleImage = ImageIO.read(new File("objects\\castle\\Castle75.png"));
            castleImageList.add(castleImage);
            castleImage = ImageIO.read(new File("objects\\castle\\Castle50.png"));
            castleImageList.add(castleImage);
            castleImage = ImageIO.read(new File("objects\\castle\\Castle25.png"));
            castleImageList.add(castleImage);
            leaderboardPanelImage = ImageIO.read(new File("objects\\leaderboard\\LeaderboardPanel.png"));
            tileImage = ImageIO.read(new File("objects\\tile\\1.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\2.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\3.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\4.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\6.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\7.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\8.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\9.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\l.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\r.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\u.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\d.png"));
            tileImageList.add(tileImage);
            tileImage = ImageIO.read(new File("objects\\tile\\o.png"));
            tileImageList.add(tileImage);

            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree1.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree2.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree3.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree4.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree5.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree6.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree7.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree8.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree9.png"));
            treeImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\tree\\Tree10.png"));
            treeImageList.add(doodadImage);

            doodadImage = ImageIO.read(new File("objects\\doodads\\bush\\Bush1.png"));
            bushImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\bush\\Bush2.png"));
            bushImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\bush\\Bush3.png"));
            bushImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\bush\\Bush4.png"));
            bushImageList.add(doodadImage);
            doodadImage = ImageIO.read(new File("objects\\doodads\\bush\\Bush5.png"));
            bushImageList.add(doodadImage);

            animationImage = ImageIO.read(new File("objects\\animations\\build\\BuildEffect1.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\build\\BuildEffect2.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\build\\BuildEffect3.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\build\\BuildEffect4.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\build\\BuildEffect5.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\build\\BuildEffect6.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect1.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect2.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect3.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect4.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect5.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect6.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect7.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect8.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect9.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect10.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\icedrop\\IceDropEffect11.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect1.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect2.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect3.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect4.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect5.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect6.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect7.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect8.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect9.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect10.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect11.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect12.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect13.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect14.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\cherrybolt\\CherryboltEffect15.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect1.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect2.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect3.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect4.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect5.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect6.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect7.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect8.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect9.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sticko\\StickOEffect10.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sell\\SellEffect1.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sell\\SellEffect2.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sell\\SellEffect3.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sell\\SellEffect4.png"));
            animationImageList.add(animationImage);
            animationImage = ImageIO.read(new File("objects\\animations\\sell\\SellEffect5.png"));
            animationImageList.add(animationImage);

            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-0.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-45.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-90.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-135.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-180.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-225.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-270.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT1-315.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-0.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-45.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-90.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-135.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-180.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-225.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-270.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT2-315.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-0.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-45.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-90.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-135.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-180.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-225.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-270.png"));
            towerIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDT3-315.png"));
            towerIceDropImageList.add(towerImage);

            towerImage = ImageIO.read(new File("objects\\tower\\ice\\IT1.png"));
            towerIceImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\ice\\IT2.png"));
            towerIceImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\ice\\IT3.png"));
            towerIceImageList.add(towerImage);

            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1-45.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1F-45.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1-135.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1F-135.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1-225.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1F-225.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1-315.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT1F-315.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2-45.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2F-45.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2-135.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2F-135.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2-225.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2F-225.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2-315.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT2F-315.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3-45.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3F-45.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3-135.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3F-135.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3-225.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3F-225.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3-315.png"));
            towerCherryBoltImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBT3F-315.png"));
            towerCherryBoltImageList.add(towerImage);

            towerImage = ImageIO.read(new File("objects\\tower\\candymachine\\CM1.png"));
            towerCandyMachineImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\candymachine\\CM2.png"));
            towerCandyMachineImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\candymachine\\CM3.png"));
            towerCandyMachineImageList.add(towerImage);

            towerImage = ImageIO.read(new File("objects\\tower\\mentos\\MT1.png"));
            towerMentosImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\mentos\\MT2.png"));
            towerMentosImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\mentos\\MT3.png"));
            towerMentosImageList.add(towerImage);

            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-0.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-45.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-90.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-135.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-180.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-225.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-270.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT1-315.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-0.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-45.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-90.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-135.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-180.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-225.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-270.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT2-315.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-0.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-45.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-90.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-135.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-180.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-225.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-270.png"));
            towerSingleIceDropImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDT3-315.png"));
            towerSingleIceDropImageList.add(towerImage);

            towerImage = ImageIO.read(new File("objects\\tower\\sticko\\SO1.png"));
            towerStickOImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\sticko\\SO2.png"));
            towerStickOImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\tower\\sticko\\SO3.png"));
            towerStickOImageList.add(towerImage);

            towerGridImage = ImageIO.read(new File("objects\\tower\\icedrop\\ONIDT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\icedrop\\OFFIDT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\ice\\ONIT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\ice\\OFFIT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\ONCBT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\OFFCBT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\candymachine\\ONCM.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\candymachine\\OFFCM.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\mentos\\ONMT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\mentos\\OFFMT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\ONSIDT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\OFFSIDT.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\sticko\\ONSO.png"));
            towerGridImageList.add(towerGridImage);
            towerGridImage = ImageIO.read(new File("objects\\tower\\sticko\\OFFSO.png"));
            towerGridImageList.add(towerGridImage);

            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\egg\\Egg2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bigegg\\BigEgg2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rageegg\\RageEgg2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\blackant\\BlackAnt2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\redant\\RedAnt2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\rat\\Rat2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\butterfly\\Butterfly2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\bee\\Bee2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\boxerant\\BoxerAnt2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\spearmanant\\SpearmanAnt2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\swordsmanant\\SwordsmanAnt2-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt1.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt1-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt1-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt1-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt1-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt1-PF.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt2.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt2-C.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt2-F.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt2-P.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt2-PC.png"));
            creepImageList.add(creepImage);
            creepImage = ImageIO.read(new File("objects\\creep\\kingant\\KingAnt2-PF.png"));
            creepImageList.add(creepImage);

            bulletImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDB1.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDB2.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\icedrop\\IDB3.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\ice\\IB1.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\ice\\IB2.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\ice\\IB3.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBB1.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBB2.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\cherrybolt\\CBB3.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\candymachine\\CMB1.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\candymachine\\CMB2.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\candymachine\\CMB3.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\mentos\\MB1.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\mentos\\MB2.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\mentos\\MB3.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDB1.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDB2.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\singleicedrop\\SIDB3.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\sticko\\SOB1.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\sticko\\SOB2.png"));
            bulletImageList.add(bulletImage);
            bulletImage = ImageIO.read(new File("objects\\tower\\sticko\\SOB3.png"));
            bulletImageList.add(bulletImage);

            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\ID1.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\ID2.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\ID3.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\I1.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\I2.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\I3.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\CB1.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\CB2.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\CB3.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\CM1.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\CM2.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\CM3.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\M1.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\M2.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\M3.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\SID1.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\SID2.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\SID3.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\SO1.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\SO2.png"));
            towerHudImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudtowerimages\\SO3.png"));
            towerHudImageList.add(towerImage);

            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNIDT1.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNIDT2.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNIDT3.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNIT1.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNIT2.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNIT3.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNCBT1.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNCBT2.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNCBT3.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNCM1.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNCM2.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNCM3.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNMT1.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNMT2.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNMT3.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNSIDT1.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNSIDT2.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNSIDT3.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNSO1.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNSO2.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNSO3.png"));
            towerHudButtonImageList.add(towerImage);
            towerImage = ImageIO.read(new File("objects\\panel\\hudbuttonimages\\BTNSELL.png"));
            towerHudButtonImageList.add(towerImage);
            
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo10.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo9.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo8.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo7.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo6.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo5.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo4.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo3.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo2.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo1.png"));
            waveNoImageList.add(waveNoImage);
            waveNoImage = ImageIO.read(new File("objects\\wave\\CWaveNo0.png"));
            waveNoImageList.add(waveNoImage);
            
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave1.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave2.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave3.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave4.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave5.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave6.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave7.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave8.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave9.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave10.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave11.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave12.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave13.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave14.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave15.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave16.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave17.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave18.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave19.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave20.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave21.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave22.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave23.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave24.png"));
            waveNoTagImageList.add(waveNoTagImage);
            waveNoTagImage = ImageIO.read(new File("objects\\wavetag\\Wave25.png"));
            waveNoTagImageList.add(waveNoTagImage);
        } catch (Exception ex) {
            System.err.println("Exception Message: " + ex.getMessage());
        }

        tileObjectList = new ArrayList<>();
        bushObjectList = new ArrayList<>();
        treeObjectList = new ArrayList<>();
        towerIceDropList = new ArrayList<>();
        towerIceList = new ArrayList<>();
        towerCherryBoltList = new ArrayList<>();
        towerCandyMachineList = new ArrayList<>();
        towerMentosList = new ArrayList<>();
        towerSingleIceDropList = new ArrayList<>();
        towerStickOList = new ArrayList<>();
        creepEggList = new ArrayList<>();
        creepBigEggList = new ArrayList<>();
        creepRageEggList = new ArrayList<>();
        creepBlackAntList = new ArrayList<>();
        creepRedAntList = new ArrayList<>();
        creepRatList = new ArrayList<>();
        creepButterflyList = new ArrayList<>();
        creepBeeList = new ArrayList<>();
        creepBoxerAntList = new ArrayList<>();
        creepSpearmanAntList = new ArrayList<>();
        creepSwordsmanAntList = new ArrayList<>();
        creepKingAntList = new ArrayList<>();
        bulletTIDList = new ArrayList<>();
        bulletTIList = new ArrayList<>();
        bulletCBList = new ArrayList<>();
        bulletCMList = new ArrayList<>();
        bulletMList = new ArrayList<>();
        bulletSIDList = new ArrayList<>();
        bulletSOList = new ArrayList<>();
        objectAnimationList = new ArrayList<>();

        for (int a = 0; a < tileRow; a++) {
            for (int b = 0; b < tileColumn; b++) {
                if (tileMap[a][b].equals("1")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(0), "1"));
                } else if (tileMap[a][b].equals("2")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(1), "2"));
                } else if (tileMap[a][b].equals("3")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(2), "3"));
                } else if (tileMap[a][b].equals("4")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(3), "4"));
                } else if (tileMap[a][b].equals("6")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(4), "6"));
                } else if (tileMap[a][b].equals("7")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(5), "7"));
                } else if (tileMap[a][b].equals("8")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(6), "8"));
                } else if (tileMap[a][b].equals("9")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(7), "9"));
                } else if (tileMap[a][b].equals("l")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(8), "l"));
                } else if (tileMap[a][b].equals("r")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(9), "r"));
                } else if (tileMap[a][b].equals("u")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(10), "u"));
                } else if (tileMap[a][b].equals("d")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(11), "d"));
                } else if (tileMap[a][b].equals("o")) {
                    tileObjectList.add(new Tile(tileX, tileY, false, (BufferedImage) tileImageList.get(12), "o"));
                } else if (tileMap[a][b].equals("x")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(12), "x"));
                    candyCastle = new Castle(tileX - 50, tileY - 150, 100, (BufferedImage) getCastleImageList().get(0));
                } else if (tileMap[a][b].equals("c")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(12), "c"));
                } else if (tileMap[a][b].equals("t")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(12), "t"));
                    randInt = randObject.nextInt(10);
                    doodadID += 1;
                    treeObjectList.add(new Tree(doodadID, randInt, tileX, tileY - 50, (BufferedImage) treeImageList.get(randInt)));
                } else if (tileMap[a][b].equals("b")) {
                    tileObjectList.add(new Tile(tileX, tileY, true, (BufferedImage) tileImageList.get(12), "b"));
                    randInt = randObject.nextInt(5);
                    doodadID += 1;
                    bushObjectList.add(new Bush(doodadID, randInt, tileX, tileY, (BufferedImage) bushImageList.get(randInt)));
                }
                tileY += 50;
            }
            tileX += 50;
            tileY = 0;
        }

        btnQ = new Rectangle(764, 625, 60, 65);
        btnW = new Rectangle(829, 625, 60, 65);
        btnE = new Rectangle(896, 625, 60, 65);
        btnR = new Rectangle(969, 625, 60, 65);
        btnA = new Rectangle(764, 702, 60, 65);
        btnS = new Rectangle(829, 702, 60, 65);
        btnD = new Rectangle(896, 702, 60, 65);
        btnF = new Rectangle(969, 702, 60, 65);
        
        cmSound = new CMSound();
    }

    public void loadDoodads() {
        for (int a = 0; a < getTreeList().size(); a++) {
            Tree tr = (Tree) getTreeList().get(a);
            cmc = new CMCommand("DOODADTREE", Integer.toString(tr.getDoodadID()), Integer.toString(tr.getImageID()), "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }

        for (int a = 0; a < getBushList().size(); a++) {
            Bush b = (Bush) getBushList().get(a);
           cmc = new CMCommand("DOODADBUSH", Integer.toString(b.getDoodadID()), Integer.toString(b.getImageID()), "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
    }
    
    public void loadCandyMagicTimer() {
        cmTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creepInside == 0) {
                    if (creepCountForWave == 0) {
                        if (cmGameRenderingInitialization == false) {
                            if (cmGameDoodadInitialization == false) {
                                setBroadCastServerPlayerName();
                                loadDoodads();
                                cmGameDoodadInitialization = true;
                            }
                            cmGameRenderingInitialization = true;
                            cmTimer.stop();
                            creepCountForWave = 10;
                        } else {
                            cmTimer.stop();
                            loadCreepWave();
                            creepCountForWave = 10;
                        }
                    } else {
                        creepCountForWave--;
                        cmc = new CMCommand("TIMER", Integer.toString(creepCountForWave), Integer.toString(creepInside), Integer.toString(candyCastle.getCastleCurrentHp()), "XD", "XD", "XD", "XD", "XD", "XD", null);
                        cmsct.serverMainBroadCastMessage(cmc);
                    }
                }
            }
        });
    }
    
    public void loadCreepWave() {
        if (creepCountForWave == 0) {
            playerGold += 1000;
            resetWaveSpawns();
            if (creepInside == 0) {
                if (creepWave == 0) { //Wave 1
                    for (int a = 0; a < 40; a++) {
                        //Left Upper
                        getCreepEggList().add(new CreepEgg(this, spawnXL1, spawnYL1, 120, 5, false, true, 4, 1, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL1 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL2, spawnYL2, 120, 5, false, true, 4, 2, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL2 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL3, spawnYL3, 120, 5, false, true, 4, 3, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepEggList().add(new CreepEgg(this, spawnXL24, spawnYL24, 120, 5, false, true, 4, 24, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL24 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL25, spawnYL25, 120, 5, false, true, 4, 25, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL25 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL26, spawnYL26, 120, 5, false, true, 4, 26, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepEggList().add(new CreepEgg(this, spawnXL22, spawnYL22, 120, 5, false, true, 4, 22, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL22 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL23, spawnYL23, 120, 5, false, true, 4, 23, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepEggList().add(new CreepEgg(this, spawnXL9, spawnYL9, 120, 5, false, true, 4, 9, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL9 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL10, spawnYL10, 120, 5, false, true, 4, 10, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepEggList().add(new CreepEgg(this, spawnXL11, spawnYL11, 120, 5, false, true, 4, 11, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL11 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL12, spawnYL12, 120, 5, false, true, 4, 12, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL12 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL13, spawnYL13, 120, 5, false, true, 4, 13, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepEggList().add(new CreepEgg(this, spawnXL14, spawnYL14, 120, 5, false, true, 4, 14, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL14 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL15, spawnYL15, 120, 5, false, true, 4, 15, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL15 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL16, spawnYL16, 120, 5, false, true, 4, 16, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepEggList().add(new CreepEgg(this, spawnXL4, spawnYL4, 120, 5, false, true, 4, 4, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL4 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL5, spawnYL5, 120, 5, false, true, 4, 5, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL5 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL6, spawnYL6, 120, 5, false, true, 4, 6, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepEggList().add(new CreepEgg(this, spawnXL7, spawnYL7, 120, 5, false, true, 4, 7, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL7 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL8, spawnYL8, 120, 5, false, true, 4, 8, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepEggList().add(new CreepEgg(this, spawnXL17, spawnYL17, 120, 5, false, true, 4, 17, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL17 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL18, spawnYL18, 120, 5, false, true, 4, 18, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL18 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL19, spawnYL19, 120, 5, false, true, 4, 19, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepEggList().add(new CreepEgg(this, spawnXL20, spawnYL20, 120, 5, false, true, 4, 20, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL20 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL21, spawnYL21, 120, 5, false, true, 4, 21, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL21 += 75;
                    }
                    creepInside = 1040;
                    creepWave = 1;
                } else if (creepWave == 1) { //Wave 2
                    for (int a = 0; a < 40; a++) {
                        //Left Upper
                        getCreepEggList().add(new CreepEgg(this, spawnXL1, spawnYL1, 120, 5, false, true, 4, 1, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL1 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL2, spawnYL2, 120, 5, false, true, 4, 2, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL2 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL3, spawnYL3, 120, 5, false, true, 4, 3, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepEggList().add(new CreepEgg(this, spawnXL24, spawnYL24, 120, 5, false, true, 4, 24, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL24 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL25, spawnYL25, 120, 5, false, true, 4, 25, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL25 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL26, spawnYL26, 120, 5, false, true, 4, 26, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepEggList().add(new CreepEgg(this, spawnXL22, spawnYL22, 120, 5, false, true, 4, 22, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL22 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL23, spawnYL23, 120, 5, false, true, 4, 23, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepEggList().add(new CreepEgg(this, spawnXL9, spawnYL9, 120, 5, false, true, 4, 9, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL9 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL10, spawnYL10, 120, 5, false, true, 4, 10, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepEggList().add(new CreepEgg(this, spawnXL11, spawnYL11, 120, 5, false, true, 4, 11, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL11 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL12, spawnYL12, 120, 5, false, true, 4, 12, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL12 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL13, spawnYL13, 120, 5, false, true, 4, 13, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepEggList().add(new CreepEgg(this, spawnXL14, spawnYL14, 120, 5, false, true, 4, 14, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL14 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL15, spawnYL15, 120, 5, false, true, 4, 15, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL15 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL16, spawnYL16, 120, 5, false, true, 4, 16, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL16 += 125;
                    }
                    for (int a = 0; a < 30; a++) {
                        //Upper Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL4, spawnYL4, 180, 5, false, true, 5, 4, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL4 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL5, spawnYL5, 180, 5, false, true, 5, 5, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL5 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL6, spawnYL6, 180, 5, false, true, 5, 6, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL7, spawnYL7, 180, 5, false, true, 5, 7, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL7 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL8, spawnYL8, 180, 5, false, true, 5, 8, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL17, spawnYL17, 180, 5, false, true, 5, 17, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL17 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL18, spawnYL18, 180, 5, false, true, 5, 18, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL18 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL19, spawnYL19, 180, 5, false, true, 5, 19, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL20, spawnYL20, 180, 5, false, true, 5, 20, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL20 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL21, spawnYL21, 180, 5, false, true, 5, 21, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL21 += 75;
                    }
                    creepInside = 940;
                    creepWave = 2;
                } else if (creepWave == 2) { //Wave 3
                    for (int a = 0; a < 30; a++) {
                        //Left Upper
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL1, spawnYL1, 180, 5, false, true, 5, 1, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL1 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL2, spawnYL2, 180, 5, false, true, 5, 2, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL2 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL3, spawnYL3, 180, 5, false, true, 5, 3, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL3 -= 125;
                        //Left Lower
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL22, spawnYL22, 180, 5, false, true, 5, 22, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL22 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL23, spawnYL23, 180, 5, false, true, 5, 23, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL9, spawnYL9, 180, 5, false, true, 5, 9, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL9 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL10, spawnYL10, 180, 5, false, true, 5, 10, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL10 += 75;
                        //Right Lower
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL14, spawnYL14, 180, 5, false, true, 5, 14, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL14 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL15, spawnYL15, 180, 5, false, true, 5, 15, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL15 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL16, spawnYL16, 180, 5, false, true, 5, 16, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL4, spawnYL4, 180, 5, false, true, 5, 4, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL4 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL5, spawnYL5, 180, 5, false, true, 5, 5, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL5 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL6, spawnYL6, 180, 5, false, true, 5, 6, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL7, spawnYL7, 180, 5, false, true, 5, 7, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL7 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL8, spawnYL8, 180, 5, false, true, 5, 8, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL17, spawnYL17, 180, 5, false, true, 5, 17, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL17 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL18, spawnYL18, 180, 5, false, true, 5, 18, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL18 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL19, spawnYL19, 180, 5, false, true, 5, 19, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL20, spawnYL20, 180, 5, false, true, 5, 20, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL20 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL21, spawnYL21, 180, 5, false, true, 5, 21, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL21 += 75;
                    }
                    for (int a = 0; a < 4; a++) {
                        //Right Middle
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL11, spawnYL11, 800, 6, false, true, 100, 11, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL11 += 50;
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL12, spawnYL12, 800, 6, false, true, 100, 12, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL12 += 75;
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL13, spawnYL13, 800, 6, false, true, 100, 13, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL13 += 125;
                        //Left Middle
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL24, spawnYL24, 800, 6, false, true, 100, 24, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL24 -= 50;
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL25, spawnYL25, 800, 6, false, true, 100, 25, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL25 -= 75;
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL26, spawnYL26, 800, 6, false, true, 100, 26, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL26 -= 125;
                    }
                    creepInside = 624;
                    creepWave = 3;
                } else if (creepWave == 3) { //Wave 4
                    for (int a = 0; a < 25; a++) {
                        //Left Upper
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL1, spawnYL1, 200, 6, false, true, 5, 1, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL1 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL2, spawnYL2, 200, 6, false, true, 5, 2, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL2 -= 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL3, spawnYL3, 200, 6, false, true, 5, 3, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL24, spawnYL24, 200, 6, false, true, 5, 24, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL24 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL25, spawnYL25, 200, 6, false, true, 5, 25, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL25 -= 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL26, spawnYL26, 200, 6, false, true, 5, 26, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL22, spawnYL22, 200, 6, false, true, 5, 22, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL22 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL23, spawnYL23, 200, 6, false, true, 5, 23, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL9, spawnYL9, 200, 6, false, true, 5, 9, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL9 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL10, spawnYL10, 200, 6, false, true, 5, 10, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL11, spawnYL11, 200, 6, false, true, 5, 11, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL11 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL12, spawnYL12, 200, 6, false, true, 5, 12, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL12 += 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL13, spawnYL13, 200, 6, false, true, 5, 13, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL14, spawnYL14, 200, 6, false, true, 5, 14, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL14 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL15, spawnYL15, 200, 6, false, true, 5, 15, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL15 += 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL16, spawnYL16, 200, 6, false, true, 5, 16, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL4, spawnYL4, 200, 6, false, true, 5, 4, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL4 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL5, spawnYL5, 200, 6, false, true, 5, 5, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL5 -= 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL6, spawnYL6, 200, 6, false, true, 5, 6, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL7, spawnYL7, 200, 6, false, true, 5, 7, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL7 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL8, spawnYL8, 200, 6, false, true, 5, 8, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL17, spawnYL17, 200, 6, false, true, 5, 17, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL17 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL18, spawnYL18, 200, 6, false, true, 5, 18, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL18 += 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL19, spawnYL19, 200, 6, false, true, 5, 19, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL20, spawnYL20, 200, 6, false, true, 5, 20, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL20 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL21, spawnYL21, 200, 6, false, true, 5, 21, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL21 += 75;
                    }
                    creepInside = 650;
                    creepWave = 4;
                } else if (creepWave == 4) { //Wave 5
                    for (int a = 0; a < 20; a++) {
                        //Left Upper
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL1, spawnYL1, 700, 4, false, true, 7, 1, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL1 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL2, spawnYL2, 700, 4, false, true, 7, 2, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL2 -= 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL3, spawnYL3, 700, 4, false, true, 7, 3, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL24, spawnYL24, 700, 4, false, true, 7, 24, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL24 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL25, spawnYL25, 700, 4, false, true, 7, 25, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL25 -= 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL26, spawnYL26, 700, 4, false, true, 7, 26, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL22, spawnYL22, 700, 4, false, true, 7, 22, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL22 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL23, spawnYL23, 700, 4, false, true, 7, 23, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL9, spawnYL9, 700, 4, false, true, 7, 9, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL9 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL10, spawnYL10, 700, 4, false, true, 7, 10, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL11, spawnYL11, 700, 4, false, true, 7, 11, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL11 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL12, spawnYL12, 700, 4, false, true, 7, 12, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL12 += 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL13, spawnYL13, 700, 4, false, true, 7, 13, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL14, spawnYL14, 700, 4, false, true, 7, 14, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL14 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL15, spawnYL15, 700, 4, false, true, 7, 15, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL15 += 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL16, spawnYL16, 700, 4, false, true, 7, 16, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL16 += 125;
                    }
                    creepInside = 320;
                    creepWave = 5;
                } else if (creepWave == 5) { //Wave 6
                    for (int a = 0; a < 50; a++) {
                        //Left Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL24, spawnYL24, 300, 6, true, false, 5, 24, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL24 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL25, spawnYL25, 300, 6, true, false, 5, 25, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL25 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL26, spawnYL26, 300, 6, true, false, 5, 26, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL26 -= 125;
                        //Right Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL11, spawnYL11, 300, 6, true, false, 5, 11, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL11 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL12, spawnYL12, 300, 6, true, false, 5, 12, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL12 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL13, spawnYL13, 300, 6, true, false, 5, 13, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL13 += 125;

                        //Upper Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL4, spawnYL4, 300, 6, true, false, 5, 4, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL4 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL5, spawnYL5, 300, 6, true, false, 5, 5, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL5 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL6, spawnYL6, 300, 6, true, false, 5, 6, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL7, spawnYL7, 300, 6, true, false, 5, 7, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL7 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL8, spawnYL8, 300, 6, true, false, 5, 8, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL17, spawnYL17, 300, 6, true, false, 5, 17, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL17 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL18, spawnYL18, 300, 6, true, false, 5, 18, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL18 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL19, spawnYL19, 300, 6, true, false, 5, 19, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL20, spawnYL20, 300, 6, true, false, 5, 20, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL20 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL21, spawnYL21, 300, 6, true, false, 5, 21, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL21 += 75;
                    }
                    creepInside = 800;
                    creepWave = 6;
                } else if (creepWave == 6) { //Wave 7
                    for (int a = 0; a < 30; a++) {
                        //Left Upper
                        getCreepBeeList().add(new CreepBee(this, spawnXL1, spawnYL1, 500, 5, false, true, 7, 1, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL1 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL2, spawnYL2, 500, 5, false, true, 7, 2, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL2 -= 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL3, spawnYL3, 500, 5, false, true, 7, 3, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepBeeList().add(new CreepBee(this, spawnXL24, spawnYL24, 500, 5, false, true, 7, 24, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL24 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL25, spawnYL25, 500, 5, false, true, 7, 25, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL25 -= 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL26, spawnYL26, 500, 5, false, true, 7, 26, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepBeeList().add(new CreepBee(this, spawnXL22, spawnYL22, 500, 5, false, true, 7, 22, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL22 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL23, spawnYL23, 500, 5, false, true, 7, 23, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBeeList().add(new CreepBee(this, spawnXL9, spawnYL9, 500, 5, false, true, 7, 9, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL9 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL10, spawnYL10, 500, 5, false, true, 7, 10, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepBeeList().add(new CreepBee(this, spawnXL11, spawnYL11, 500, 5, false, true, 7, 11, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL11 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL12, spawnYL12, 500, 5, false, true, 7, 12, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL12 += 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL13, spawnYL13, 500, 5, false, true, 7, 13, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepBeeList().add(new CreepBee(this, spawnXL14, spawnYL14, 500, 5, false, true, 7, 14, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL14 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL15, spawnYL15, 500, 5, false, true, 7, 15, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL15 += 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL16, spawnYL16, 500, 5, false, true, 7, 16, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepBeeList().add(new CreepBee(this, spawnXL4, spawnYL4, 500, 5, false, true, 7, 4, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL4 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL5, spawnYL5, 500, 5, false, true, 7, 5, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL5 -= 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL6, spawnYL6, 500, 5, false, true, 7, 6, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBeeList().add(new CreepBee(this, spawnXL7, spawnYL7, 500, 5, false, true, 7, 7, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL7 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL8, spawnYL8, 500, 5, false, true, 7, 8, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBeeList().add(new CreepBee(this, spawnXL17, spawnYL17, 500, 5, false, true, 7, 17, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL17 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL18, spawnYL18, 500, 5, false, true, 7, 18, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL18 += 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL19, spawnYL19, 500, 5, false, true, 7, 19, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBeeList().add(new CreepBee(this, spawnXL20, spawnYL20, 500, 5, false, true, 7, 20, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL20 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL21, spawnYL21, 500, 5, false, true, 7, 21, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL21 += 75;
                    }
                    creepInside = 780;
                    creepWave = 7;
                } else if (creepWave == 7) { //Wave 8
                    for (int a = 0; a < 30; a++) {
                        //Left Upper
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL1, spawnYL1, 800, 4, false, true, 8, 1, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL1 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL2, spawnYL2, 800, 4, false, true, 8, 2, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL2 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL3, spawnYL3, 800, 4, false, true, 8, 3, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL24, spawnYL24, 800, 4, false, true, 8, 24, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL24 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL25, spawnYL25, 800, 4, false, true, 8, 25, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL25 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL26, spawnYL26, 800, 4, false, true, 8, 26, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL22, spawnYL22, 800, 4, false, true, 8, 22, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL22 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL23, spawnYL23, 800, 4, false, true, 8, 23, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL9, spawnYL9, 800, 4, false, true, 8, 9, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL9 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL10, spawnYL10, 800, 4, false, true, 8, 10, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL11, spawnYL11, 800, 4, false, true, 8, 11, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL11 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL12, spawnYL12, 800, 4, false, true, 8, 12, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL12 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL13, spawnYL13, 800, 4, false, true, 8, 13, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL14, spawnYL14, 800, 4, false, true, 8, 14, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL14 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL15, spawnYL15, 800, 4, false, true, 8, 15, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL15 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL16, spawnYL16, 800, 4, false, true, 8, 16, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL4, spawnYL4, 800, 4, false, true, 8, 4, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL4 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL5, spawnYL5, 800, 4, false, true, 8, 5, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL5 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL6, spawnYL6, 800, 4, false, true, 8, 6, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL7, spawnYL7, 800, 4, false, true, 8, 7, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL7 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL8, spawnYL8, 800, 4, false, true, 8, 8, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL17, spawnYL17, 800, 4, false, true, 8, 17, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL17 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL18, spawnYL18, 800, 4, false, true, 8, 18, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL18 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL19, spawnYL19, 800, 4, false, true, 8, 19, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL20, spawnYL20, 800, 4, false, true, 8, 20, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL20 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL21, spawnYL21, 800, 4, false, true, 8, 21, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL21 += 75;
                    }
                    creepInside = 780;
                    creepWave = 8;
                } else if (creepWave == 8) { //Wave 9
                    for (int a = 0; a < 15; a++) {
                        //Left Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL24, spawnYL24, 700, 5, false, true, 7, 24, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL24 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL25, spawnYL25, 700, 5, false, true, 7, 25, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL25 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL26, spawnYL26, 700, 5, false, true, 7, 26, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL26 -= 125;
                        //Right Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL11, spawnYL11, 700, 5, false, true, 7, 11, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL11 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL12, spawnYL12, 700, 5, false, true, 7, 12, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL12 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL13, spawnYL13, 700, 5, false, true, 7, 13, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL13 += 125;
                        //Upper Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL4, spawnYL4, 700, 5, false, true, 7, 4, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL4 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL5, spawnYL5, 700, 5, false, true, 7, 5, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL5 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL6, spawnYL6, 700, 5, false, true, 7, 6, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL7, spawnYL7, 700, 5, false, true, 7, 7, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL7 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL8, spawnYL8, 700, 5, false, true, 7, 8, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL17, spawnYL17, 700, 5, false, true, 7, 17, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL17 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL18, spawnYL18, 700, 5, false, true, 7, 18, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL18 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL19, spawnYL19, 700, 5, false, true, 7, 19, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL20, spawnYL20, 700, 5, false, true, 7, 20, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL20 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL21, spawnYL21, 700, 5, false, true, 7, 21, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL21 += 75;
                    }
                    for (int a = 0; a < 2; a++) {
                        //Left Upper
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL1, spawnYL1, 2400, 5, false, true, 150, 1, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL1 -= 50;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL2, spawnYL2, 2400, 5, false, true, 150, 2, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL2 -= 75;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL3, spawnYL3, 2400, 5, false, true, 150, 3, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL3 -= 125;
                        //Left Lower
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL22, spawnYL22, 2400, 5, false, true, 150, 22, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL22 -= 50;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL23, spawnYL23, 2400, 5, false, true, 150, 23, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL23 -= 75;
                        //Right Upper
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL9, spawnYL9, 2400, 5, false, true, 150, 9, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL9 += 50;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL10, spawnYL10, 2400, 5, false, true, 150, 10, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL10 += 75;
                        //Right Lower
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL14, spawnYL14, 2400, 5, false, true, 150, 14, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL14 += 50;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL15, spawnYL15, 2400, 5, false, true, 150, 15, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL15 += 75;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL16, spawnYL16, 2400, 5, false, true, 150, 16, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL16 += 125;
                    }
                    creepInside = 260;
                    creepWave = 9;
                } else if (creepWave == 9) { //Wave 10
                    for (int a = 0; a < 5; a++) {
                        //Left Upper
                        getCreepRatList().add(new CreepRat(this, spawnXL1, spawnYL1, 800, 7, false, true, 10, 1, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL1 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL2, spawnYL2, 800, 7, false, true, 10, 2, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL2 -= 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL3, spawnYL3, 800, 7, false, true, 10, 3, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepRatList().add(new CreepRat(this, spawnXL24, spawnYL24, 800, 7, false, true, 10, 24, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL24 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL25, spawnYL25, 800, 7, false, true, 10, 25, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL25 -= 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL26, spawnYL26, 800, 7, false, true, 10, 26, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepRatList().add(new CreepRat(this, spawnXL22, spawnYL22, 800, 7, false, true, 10, 22, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL22 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL23, spawnYL23, 800, 7, false, true, 10, 23, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepRatList().add(new CreepRat(this, spawnXL9, spawnYL9, 800, 7, false, true, 10, 9, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL9 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL10, spawnYL10, 800, 7, false, true, 10, 10, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepRatList().add(new CreepRat(this, spawnXL11, spawnYL11, 800, 7, false, true, 10, 11, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL11 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL12, spawnYL12, 800, 7, false, true, 10, 12, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL12 += 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL13, spawnYL13, 800, 7, false, true, 10, 13, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepRatList().add(new CreepRat(this, spawnXL14, spawnYL14, 800, 7, false, true, 10, 14, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL14 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL15, spawnYL15, 800, 7, false, true, 10, 15, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL15 += 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL16, spawnYL16, 800, 7, false, true, 10, 16, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepRatList().add(new CreepRat(this, spawnXL4, spawnYL4, 800, 7, false, true, 10, 4, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL4 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL5, spawnYL5, 800, 7, false, true, 10, 5, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL5 -= 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL6, spawnYL6, 800, 7, false, true, 10, 6, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepRatList().add(new CreepRat(this, spawnXL7, spawnYL7, 800, 7, false, true, 10, 7, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL7 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL8, spawnYL8, 800, 7, false, true, 10, 8, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepRatList().add(new CreepRat(this, spawnXL17, spawnYL17, 800, 7, false, true, 10, 17, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL17 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL18, spawnYL18, 800, 7, false, true, 10, 18, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL18 += 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL19, spawnYL19, 800, 7, false, true, 10, 19, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepRatList().add(new CreepRat(this, spawnXL20, spawnYL20, 800, 7, false, true, 10, 20, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL20 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL21, spawnYL21, 800, 7, false, true, 10, 21, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL21 += 75;
                    }
                    creepInside = 130;
                    creepWave = 10;
                } else if (creepWave == 10) { //Wave 11
                    for (int a = 0; a < 30; a++) {
                        //Upper Left
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL4, spawnYL4, 1000, 5, false, true, 5, 4, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL4 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL5, spawnYL5, 1000, 5, false, true, 5, 5, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL5 -= 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL6, spawnYL6, 1000, 5, false, true, 5, 6, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL7, spawnYL7, 1000, 5, false, true, 5, 7, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL7 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL8, spawnYL8, 1000, 5, false, true, 5, 8, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL17, spawnYL17, 1000, 5, false, true, 5, 17, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL17 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL18, spawnYL18, 1000, 5, false, true, 5, 18, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL18 += 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL19, spawnYL19, 1000, 5, false, true, 5, 19, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL20, spawnYL20, 1000, 5, false, true, 5, 20, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL20 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL21, spawnYL21, 1000, 5, false, true, 5, 21, (BufferedImage) getCreepImageList().get(48)));
                        spawnYL21 += 75;

                        //Right Middle
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL11, spawnYL11, 1000, 5, false, true, 5, 11, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL11 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL12, spawnYL12, 1000, 5, false, true, 5, 12, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL12 += 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL13, spawnYL13, 1000, 5, false, true, 5, 13, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL13 += 125;

                        //Left Middle
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL24, spawnYL24, 1000, 5, false, true, 5, 24, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL24 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL25, spawnYL25, 1000, 5, false, true, 5, 25, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL25 -= 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL26, spawnYL26, 1000, 5, false, true, 5, 26, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL26 -= 125;
                    }
                    creepInside = 480;
                    creepWave = 11;
                } else if (creepWave == 11) { //Wave 12
                    for (int a = 0; a < 30; a++) {
                        //Left Lower
                        getCreepBeeList().add(new CreepBee(this, spawnXL22, spawnYL22, 2400, 4, true, false, 30, 22, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL22 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL23, spawnYL23, 2400, 4, true, false, 30, 23, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBeeList().add(new CreepBee(this, spawnXL9, spawnYL9, 2400, 4, true, false, 30, 9, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL9 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL10, spawnYL10, 2400, 4, true, false, 30, 10, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL10 += 75;
                    }
                    creepInside = 120;
                    creepWave = 12;
                } else if (creepWave == 12) { //Wave 13
                    for (int a = 0; a < 20; a++) {
                        //Left Upper
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL1, spawnYL1, 1500, 6, false, true, 8, 1, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL1 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL2, spawnYL2, 1500, 6, false, true, 8, 2, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL2 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL3, spawnYL3, 1500, 6, false, true, 8, 3, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL24, spawnYL24, 1500, 6, false, true, 8, 24, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL24 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL25, spawnYL25, 1500, 6, false, true, 8, 25, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL25 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL26, spawnYL26, 1500, 6, false, true, 8, 26, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL22, spawnYL22, 1500, 6, false, true, 8, 22, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL22 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL23, spawnYL23, 1500, 6, false, true, 8, 23, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL9, spawnYL9, 1500, 6, false, true, 8, 9, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL9 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL10, spawnYL10, 1500, 6, false, true, 8, 10, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL11, spawnYL11, 1500, 6, false, true, 8, 11, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL11 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL12, spawnYL12, 1500, 6, false, true, 8, 12, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL12 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL13, spawnYL13, 1500, 6, false, true, 8, 13, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL14, spawnYL14, 1500, 6, false, true, 8, 14, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL14 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL15, spawnYL15, 1500, 6, false, true, 8, 15, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL15 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL16, spawnYL16, 1500, 6, false, true, 8, 16, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL4, spawnYL4, 1500, 6, false, true, 8, 4, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL4 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL5, spawnYL5, 1500, 6, false, true, 8, 5, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL5 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL6, spawnYL6, 1500, 6, false, true, 8, 6, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL7, spawnYL7, 1500, 6, false, true, 8, 7, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL7 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL8, spawnYL8, 1500, 6, false, true, 8, 8, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL17, spawnYL17, 1500, 6, false, true, 8, 17, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL17 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL18, spawnYL18, 1500, 6, false, true, 8, 18, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL18 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL19, spawnYL19, 1500, 6, false, true, 8, 19, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL20, spawnYL20, 1500, 6, false, true, 8, 20, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL20 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL21, spawnYL21, 1500, 6, false, true, 8, 21, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL21 += 75;
                    }
                    creepInside = 520;
                    creepWave = 13;
                } else if (creepWave == 13) { //Wave 14
                    for (int a = 0; a < 30; a++) {
                        //Left Upper
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL1, spawnYL1, 1500, 7, false, true, 10, 1, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL1 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL2, spawnYL2, 1500, 7, false, true, 10, 2, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL2 -= 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL3, spawnYL3, 1500, 7, false, true, 10, 3, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL3 -= 125;
                        //Left Lower
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL22, spawnYL22, 1500, 7, false, true, 10, 22, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL22 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL23, spawnYL23, 1500, 7, false, true, 10, 23, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL9, spawnYL9, 1500, 7, false, true, 10, 9, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL9 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL10, spawnYL10, 1500, 7, false, true, 10, 10, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL10 += 75;
                        //Right Lower
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL14, spawnYL14, 1500, 7, false, true, 10, 14, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL14 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL15, spawnYL15, 1500, 7, false, true, 10, 15, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL15 += 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL16, spawnYL16, 1500, 7, false, true, 10, 16, (BufferedImage) getCreepImageList().get(36)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL4, spawnYL4, 1500, 7, false, true, 10, 4, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL4 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL5, spawnYL5, 1500, 7, false, true, 10, 5, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL5 -= 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL6, spawnYL6, 1500, 7, false, true, 10, 6, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL7, spawnYL7, 1500, 7, false, true, 10, 7, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL7 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL8, spawnYL8, 1500, 7, false, true, 10, 8, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL17, spawnYL17, 1500, 7, false, true, 10, 17, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL17 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL18, spawnYL18, 1500, 7, false, true, 10, 18, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL18 += 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL19, spawnYL19, 1500, 7, false, true, 10, 19, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL20, spawnYL20, 1500, 7, false, true, 10, 20, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL20 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL21, spawnYL21, 1500, 7, false, true, 10, 21, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL21 += 75;
                    }
                    creepInside = 600;
                    creepWave = 14;
                } else if (creepWave == 14) { //Wave 15
                    for (int a = 0; a < 15; a++) {
                        //Left Upper
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL1, spawnYL1, 3500, 4, true, false, 10, 1, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL1 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL2, spawnYL2, 3500, 4, true, false, 10, 2, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL2 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL3, spawnYL3, 3500, 4, true, false, 10, 3, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL24, spawnYL24, 3500, 4, true, false, 10, 24, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL24 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL25, spawnYL25, 3500, 4, true, false, 10, 25, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL25 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL26, spawnYL26, 3500, 4, true, false, 10, 26, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL22, spawnYL22, 3500, 4, true, false, 10, 22, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL22 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL23, spawnYL23, 3500, 4, true, false, 10, 23, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL9, spawnYL9, 3500, 4, true, false, 10, 9, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL9 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL10, spawnYL10, 3500, 4, true, false, 10, 10, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL11, spawnYL11, 3500, 4, true, false, 10, 11, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL11 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL12, spawnYL12, 3500, 4, true, false, 10, 12, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL12 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL13, spawnYL13, 3500, 4, true, false, 10, 13, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL14, spawnYL14, 3500, 4, true, false, 10, 14, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL14 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL15, spawnYL15, 3500, 4, true, false, 10, 15, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL15 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL16, spawnYL16, 3500, 4, true, false, 10, 16, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL4, spawnYL4, 3500, 4, true, false, 10, 4, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL4 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL5, spawnYL5, 3500, 4, true, false, 10, 5, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL5 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL6, spawnYL6, 3500, 4, true, false, 10, 6, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL7, spawnYL7, 3500, 4, true, false, 10, 7, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL7 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL8, spawnYL8, 3500, 4, true, false, 10, 8, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL17, spawnYL17, 3500, 4, true, false, 10, 17, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL17 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL18, spawnYL18, 3500, 4, true, false, 10, 18, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL18 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL19, spawnYL19, 3500, 4, true, false, 10, 19, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL20, spawnYL20, 3500, 4, true, false, 10, 20, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL20 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL21, spawnYL21, 3500, 4, true, false, 10, 21, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL21 += 75;
                    }
                    creepInside = 390;
                    creepWave = 15;
                } else if (creepWave == 15) { //Wave 16
                    for (int a = 0; a < 15; a++) {
                        //Left Upper
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL1, spawnYL1, 6000, 4, false, true, 30, 1, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL1 -= 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL2, spawnYL2, 6000, 4, false, true, 30, 2, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL2 -= 75;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL3, spawnYL3, 6000, 4, false, true, 30, 3, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL24, spawnYL24, 6000, 4, false, true, 30, 24, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL24 -= 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL25, spawnYL25, 6000, 4, false, true, 30, 25, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL25 -= 75;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL26, spawnYL26, 6000, 4, false, true, 30, 26, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL22, spawnYL22, 6000, 4, false, true, 30, 22, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL22 -= 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL23, spawnYL23, 6000, 4, false, true, 30, 23, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL9, spawnYL9, 6000, 4, false, true, 30, 9, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL9 += 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL10, spawnYL10, 6000, 4, false, true, 30, 10, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL11, spawnYL11, 6000, 4, false, true, 30, 11, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL11 += 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL12, spawnYL12, 6000, 4, false, true, 30, 12, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL12 += 75;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL13, spawnYL13, 6000, 4, false, true, 30, 13, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL14, spawnYL14, 6000, 4, false, true, 30, 14, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL14 += 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL15, spawnYL15, 6000, 4, false, true, 30, 15, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL15 += 75;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL16, spawnYL16, 6000, 4, false, true, 30, 16, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL4, spawnYL4, 6000, 4, false, true, 30, 4, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL4 -= 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL5, spawnYL5, 6000, 4, false, true, 30, 5, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL5 -= 75;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL6, spawnYL6, 6000, 4, false, true, 30, 6, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL7, spawnYL7, 6000, 4, false, true, 30, 7, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL7 -= 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL8, spawnYL8, 6000, 4, false, true, 30, 8, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL17, spawnYL17, 6000, 4, false, true, 30, 17, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL17 += 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL18, spawnYL18, 6000, 4, false, true, 30, 18, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL18 += 75;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL19, spawnYL19, 6000, 4, false, true, 30, 19, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL20, spawnYL20, 6000, 4, false, true, 30, 20, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL20 += 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL21, spawnYL21, 6000, 4, false, true, 30, 21, (BufferedImage) getCreepImageList().get(120)));
                        spawnYL21 += 75;
                    }
                    creepInside = 390;
                    creepWave = 16;
                } else if (creepWave == 16) { //Wave 17
                    for (int a = 0; a < 30; a++) {
                        //Left Upper
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL1, spawnYL1, 4000, 5, false, true, 8, 1, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL1 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL2, spawnYL2, 4000, 5, false, true, 8, 2, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL2 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL3, spawnYL3, 4000, 5, false, true, 8, 3, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL24, spawnYL24, 4000, 5, false, true, 8, 24, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL24 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL25, spawnYL25, 4000, 5, false, true, 8, 25, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL25 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL26, spawnYL26, 4000, 5, false, true, 8, 26, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL22, spawnYL22, 4000, 5, false, true, 8, 22, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL22 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL23, spawnYL23, 4000, 5, false, true, 8, 23, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL9, spawnYL9, 4000, 5, false, true, 8, 9, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL9 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL10, spawnYL10, 4000, 5, false, true, 8, 10, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL11, spawnYL11, 4000, 5, false, true, 8, 11, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL11 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL12, spawnYL12, 4000, 5, false, true, 8, 12, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL12 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL13, spawnYL13, 4000, 5, false, true, 8, 13, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL14, spawnYL14, 4000, 5, false, true, 8, 14, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL14 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL15, spawnYL15, 4000, 5, false, true, 8, 15, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL15 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL16, spawnYL16, 4000, 5, false, true, 8, 16, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL4, spawnYL4, 4000, 5, false, true, 8, 4, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL4 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL5, spawnYL5, 4000, 5, false, true, 8, 5, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL5 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL6, spawnYL6, 4000, 5, false, true, 8, 6, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL7, spawnYL7, 4000, 5, false, true, 8, 7, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL7 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL8, spawnYL8, 4000, 5, false, true, 8, 8, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL17, spawnYL17, 4000, 5, false, true, 8, 17, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL17 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL18, spawnYL18, 4000, 5, false, true, 8, 18, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL18 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL19, spawnYL19, 4000, 5, false, true, 8, 19, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL20, spawnYL20, 4000, 5, false, true, 8, 20, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL20 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL21, spawnYL21, 4000, 5, false, true, 8, 21, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL21 += 75;
                    }
                    creepInside = 780;
                    creepWave = 17;
                } else if (creepWave == 17) { //Wave 18
                    for (int a = 0; a < 15; a++) {
                        //Left Upper
                        getCreepRatList().add(new CreepRat(this, spawnXL1, spawnYL1, 5000, 4, false, true, 10, 1, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL1 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL2, spawnYL2, 5000, 4, false, true, 10, 2, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL2 -= 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL3, spawnYL3, 5000, 4, false, true, 10, 3, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepRatList().add(new CreepRat(this, spawnXL24, spawnYL24, 5000, 4, false, true, 10, 24, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL24 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL25, spawnYL25, 5000, 4, false, true, 10, 25, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL25 -= 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL26, spawnYL26, 5000, 4, false, true, 10, 26, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepRatList().add(new CreepRat(this, spawnXL22, spawnYL22, 5000, 4, false, true, 10, 22, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL22 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL23, spawnYL23, 5000, 4, false, true, 10, 23, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepRatList().add(new CreepRat(this, spawnXL9, spawnYL9, 5000, 4, false, true, 10, 9, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL9 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL10, spawnYL10, 5000, 4, false, true, 10, 10, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepRatList().add(new CreepRat(this, spawnXL11, spawnYL11, 5000, 4, false, true, 10, 11, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL11 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL12, spawnYL12, 5000, 4, false, true, 10, 12, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL12 += 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL13, spawnYL13, 5000, 4, false, true, 10, 13, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepRatList().add(new CreepRat(this, spawnXL14, spawnYL14, 5000, 4, false, true, 10, 14, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL14 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL15, spawnYL15, 5000, 4, false, true, 10, 15, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL15 += 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL16, spawnYL16, 5000, 4, false, true, 10, 16, (BufferedImage) getCreepImageList().get(60)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepRatList().add(new CreepRat(this, spawnXL4, spawnYL4, 5000, 4, false, true, 10, 4, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL4 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL5, spawnYL5, 5000, 4, false, true, 10, 5, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL5 -= 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL6, spawnYL6, 5000, 4, false, true, 10, 6, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepRatList().add(new CreepRat(this, spawnXL7, spawnYL7, 5000, 4, false, true, 10, 7, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL7 -= 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL8, spawnYL8, 5000, 4, false, true, 10, 8, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepRatList().add(new CreepRat(this, spawnXL17, spawnYL17, 5000, 4, false, true, 10, 17, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL17 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL18, spawnYL18, 5000, 4, false, true, 10, 18, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL18 += 75;
                        getCreepRatList().add(new CreepRat(this, spawnXL19, spawnYL19, 5000, 4, false, true, 10, 19, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepRatList().add(new CreepRat(this, spawnXL20, spawnYL20, 5000, 4, false, true, 10, 20, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL20 += 50;
                        getCreepRatList().add(new CreepRat(this, spawnXL21, spawnYL21, 5000, 4, false, true, 10, 21, (BufferedImage) getCreepImageList().get(60)));
                        spawnYL21 += 75;
                    }
                    creepInside = 390;
                    creepWave = 18;
                } else if (creepWave == 18) { //Wave 19
                    for (int a = 0; a < 15; a++) {
                        //Left Upper
                        getCreepBeeList().add(new CreepBee(this, spawnXL1, spawnYL1, 5500, 4, false, true, 10, 1, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL1 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL2, spawnYL2, 5500, 4, false, true, 10, 2, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL2 -= 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL3, spawnYL3, 5500, 4, false, true, 10, 3, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL3 -= 125;
                        //Left Lower
                        getCreepBeeList().add(new CreepBee(this, spawnXL22, spawnYL22, 5500, 4, false, true, 10, 22, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL22 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL23, spawnYL23, 5500, 4, false, true, 10, 23, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBeeList().add(new CreepBee(this, spawnXL9, spawnYL9, 5500, 4, false, true, 10, 9, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL9 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL10, spawnYL10, 5500, 4, false, true, 10, 10, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL10 += 75;
                        //Right Lower
                        getCreepBeeList().add(new CreepBee(this, spawnXL14, spawnYL14, 5500, 4, false, true, 10, 14, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL14 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL15, spawnYL15, 5500, 4, false, true, 10, 15, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL15 += 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL16, spawnYL16, 5500, 4, false, true, 10, 16, (BufferedImage) getCreepImageList().get(84)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepBeeList().add(new CreepBee(this, spawnXL4, spawnYL4, 5500, 4, false, true, 10, 4, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL4 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL5, spawnYL5, 5500, 4, false, true, 10, 5, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL5 -= 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL6, spawnYL6, 5500, 4, false, true, 10, 6, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBeeList().add(new CreepBee(this, spawnXL7, spawnYL7, 5500, 4, false, true, 10, 7, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL7 -= 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL8, spawnYL8, 5500, 4, false, true, 10, 8, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBeeList().add(new CreepBee(this, spawnXL17, spawnYL17, 5500, 4, false, true, 10, 17, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL17 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL18, spawnYL18, 5500, 4, false, true, 10, 18, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL18 += 75;
                        getCreepBeeList().add(new CreepBee(this, spawnXL19, spawnYL19, 5500, 4, false, true, 10, 19, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBeeList().add(new CreepBee(this, spawnXL20, spawnYL20, 5500, 4, false, true, 10, 20, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL20 += 50;
                        getCreepBeeList().add(new CreepBee(this, spawnXL21, spawnYL21, 5500, 4, false, true, 10, 21, (BufferedImage) getCreepImageList().get(84)));
                        spawnYL21 += 75;
                    }

                    for (int a = 0; a < 10; a++) {
                        //Right Middle
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL11, spawnYL11, 4000, 7, false, true, 8, 11, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL11 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL12, spawnYL12, 4000, 7, false, true, 8, 12, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL12 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL13, spawnYL13, 4000, 7, false, true, 8, 13, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL13 += 125;
                        //Left Middle
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL24, spawnYL24, 4000, 7, false, true, 8, 24, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL24 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL25, spawnYL25, 4000, 7, false, true, 8, 25, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL25 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL26, spawnYL26, 4000, 7, false, true, 8, 26, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL26 -= 125;
                    }

                    creepInside = 360;
                    creepWave = 19;
                } else if (creepWave == 19) { //Wave 20
                    for (int a = 0; a < 20; a++) {
                        //Left Upper
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL1, spawnYL1, 5000, 6, false, true, 15, 1, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL1 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL2, spawnYL2, 5000, 6, false, true, 15, 2, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL2 -= 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL3, spawnYL3, 5000, 6, false, true, 15, 3, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL24, spawnYL24, 5000, 6, false, true, 15, 24, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL24 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL25, spawnYL25, 5000, 6, false, true, 15, 25, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL25 -= 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL26, spawnYL26, 5000, 6, false, true, 15, 26, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL22, spawnYL22, 5000, 6, false, true, 15, 22, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL22 -= 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL23, spawnYL23, 5000, 6, false, true, 15, 23, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL9, spawnYL9, 5000, 6, false, true, 15, 9, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL9 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL10, spawnYL10, 5000, 6, false, true, 15, 10, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL11, spawnYL11, 5000, 6, false, true, 15, 11, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL11 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL12, spawnYL12, 5000, 6, false, true, 15, 12, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL12 += 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL13, spawnYL13, 5000, 6, false, true, 15, 13, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL14, spawnYL14, 5000, 6, false, true, 15, 14, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL14 += 50;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL15, spawnYL15, 5000, 6, false, true, 15, 15, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL15 += 75;
                        getCreepRedAntList().add(new CreepRedAnt(this, spawnXL16, spawnYL16, 5000, 6, false, true, 15, 16, (BufferedImage) getCreepImageList().get(48)));
                        spawnXL16 += 125;
                    }

                    for (int a = 0; a < 10; a++) {
                        //Upper Left
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL4, spawnYL4, 4000, 7, false, true, 10, 4, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL4 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL5, spawnYL5, 4000, 7, false, true, 10, 5, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL5 -= 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL6, spawnYL6, 4000, 7, false, true, 10, 6, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL7, spawnYL7, 4000, 7, false, true, 10, 7, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL7 -= 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL8, spawnYL8, 4000, 7, false, true, 10, 8, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL17, spawnYL17, 4000, 7, false, true, 10, 17, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL17 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL18, spawnYL18, 4000, 7, false, true, 10, 18, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL18 += 75;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL19, spawnYL19, 4000, 7, false, true, 10, 19, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL20, spawnYL20, 4000, 7, false, true, 10, 20, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL20 += 50;
                        getCreepBlackAntList().add(new CreepBlackAnt(this, spawnXL21, spawnYL21, 4000, 7, false, true, 10, 21, (BufferedImage) getCreepImageList().get(36)));
                        spawnYL21 += 75;
                    }
                    creepInside = 420;
                    creepWave = 20;
                } else if (creepWave == 20) { //Wave 21
                    for (int a = 0; a < 10; a++) {
                        //Left Upper
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL1, spawnYL1, 8000, 4, false, true, 30, 1, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL1 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL2, spawnYL2, 8000, 4, false, true, 30, 2, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL2 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL3, spawnYL3, 8000, 4, false, true, 30, 3, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL3 -= 125;
                        //Left Lower
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL22, spawnYL22, 8000, 4, false, true, 30, 22, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL22 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL23, spawnYL23, 8000, 4, false, true, 30, 23, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL9, spawnYL9, 8000, 4, false, true, 30, 9, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL9 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL10, spawnYL10, 8000, 4, false, true, 30, 10, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL10 += 75;
                        //Right Lower
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL14, spawnYL14, 8000, 4, false, true, 30, 14, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL14 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL15, spawnYL15, 8000, 4, false, true, 30, 15, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL15 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL16, spawnYL16, 8000, 4, false, true, 30, 16, (BufferedImage) getCreepImageList().get(72)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL4, spawnYL4, 8000, 4, false, true, 30, 4, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL4 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL5, spawnYL5, 8000, 4, false, true, 30, 5, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL5 -= 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL6, spawnYL6, 8000, 4, false, true, 30, 6, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL7, spawnYL7, 8000, 4, false, true, 30, 7, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL7 -= 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL8, spawnYL8, 8000, 4, false, true, 30, 8, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL17, spawnYL17, 8000, 4, false, true, 30, 17, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL17 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL18, spawnYL18, 8000, 4, false, true, 30, 18, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL18 += 75;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL19, spawnYL19, 8000, 4, false, true, 30, 19, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL20, spawnYL20, 8000, 4, false, true, 30, 20, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL20 += 50;
                        getCreepButterflyList().add(new CreepButterfly(this, spawnXL21, spawnYL21, 8000, 4, false, true, 30, 21, (BufferedImage) getCreepImageList().get(72)));
                        spawnYL21 += 75;
                    }
                    //Left Middle
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL24, spawnYL24, 14000, 4, false, true, 250, 24, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL24 -= 50;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL25, spawnYL25, 14000, 4, false, true, 250, 25, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL25 -= 75;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL26, spawnYL26, 14000, 4, false, true, 250, 26, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL26 -= 125;
                    //Right Middle
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL11, spawnYL11, 14000, 4, false, true, 250, 11, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL11 += 50;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL12, spawnYL12, 14000, 4, false, true, 250, 12, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL12 += 75;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL13, spawnYL13, 14000, 4, false, true, 250, 13, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL13 += 125;
                    creepInside = 206;
                    creepWave = 21;
                } else if (creepWave == 21) { //Wave 22
                    for (int a = 0; a < 20; a++) {
                        //Left Upper
                        getCreepEggList().add(new CreepEgg(this, spawnXL1, spawnYL1, 6000, 5, false, true, 20, 1, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL1 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL2, spawnYL2, 6000, 5, false, true, 20, 2, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL2 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL3, spawnYL3, 6000, 5, false, true, 20, 3, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepEggList().add(new CreepEgg(this, spawnXL24, spawnYL24, 6000, 5, false, true, 20, 24, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL24 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL25, spawnYL25, 6000, 5, false, true, 20, 25, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL25 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL26, spawnYL26, 6000, 5, false, true, 20, 26, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepEggList().add(new CreepEgg(this, spawnXL22, spawnYL22, 6000, 5, false, true, 20, 22, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL22 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL23, spawnYL23, 6000, 5, false, true, 20, 23, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepEggList().add(new CreepEgg(this, spawnXL9, spawnYL9, 6000, 5, false, true, 20, 9, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL9 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL10, spawnYL10, 6000, 5, false, true, 20, 10, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepEggList().add(new CreepEgg(this, spawnXL11, spawnYL11, 6000, 5, false, true, 20, 11, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL11 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL12, spawnYL12, 6000, 5, false, true, 20, 12, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL12 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL13, spawnYL13, 6000, 5, false, true, 20, 13, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepEggList().add(new CreepEgg(this, spawnXL14, spawnYL14, 6000, 5, false, true, 20, 14, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL14 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL15, spawnYL15, 6000, 5, false, true, 20, 15, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL15 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL16, spawnYL16, 6000, 5, false, true, 20, 16, (BufferedImage) getCreepImageList().get(0)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepEggList().add(new CreepEgg(this, spawnXL4, spawnYL4, 6000, 5, false, true, 20, 4, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL4 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL5, spawnYL5, 6000, 5, false, true, 20, 5, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL5 -= 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL6, spawnYL6, 6000, 5, false, true, 20, 6, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepEggList().add(new CreepEgg(this, spawnXL7, spawnYL7, 6000, 5, false, true, 20, 7, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL7 -= 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL8, spawnYL8, 6000, 5, false, true, 20, 8, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepEggList().add(new CreepEgg(this, spawnXL17, spawnYL17, 6000, 5, false, true, 20, 17, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL17 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL18, spawnYL18, 6000, 5, false, true, 20, 18, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL18 += 75;
                        getCreepEggList().add(new CreepEgg(this, spawnXL19, spawnYL19, 6000, 5, false, true, 20, 19, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepEggList().add(new CreepEgg(this, spawnXL20, spawnYL20, 6000, 5, false, true, 20, 20, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL20 += 50;
                        getCreepEggList().add(new CreepEgg(this, spawnXL21, spawnYL21, 6000, 5, false, true, 20, 21, (BufferedImage) getCreepImageList().get(0)));
                        spawnYL21 += 75;
                    }
                    creepInside = 520;
                    creepWave = 22;
                } else if (creepWave == 22) { //Wave 23
                    for (int a = 0; a < 5; a++) {
                        //Left Upper
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL1, spawnYL1, 9000, 5, false, true, 20, 1, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL1 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL2, spawnYL2, 9000, 5, false, true, 20, 2, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL2 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL3, spawnYL3, 9000, 5, false, true, 20, 3, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL24, spawnYL24, 9000, 5, false, true, 20, 24, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL24 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL25, spawnYL25, 9000, 5, false, true, 20, 25, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL25 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL26, spawnYL26, 9000, 5, false, true, 20, 26, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL22, spawnYL22, 9000, 5, false, true, 20, 22, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL22 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL23, spawnYL23, 9000, 5, false, true, 20, 23, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL9, spawnYL9, 9000, 5, false, true, 20, 9, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL9 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL10, spawnYL10, 9000, 5, false, true, 20, 10, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL11, spawnYL11, 9000, 5, false, true, 20, 11, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL11 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL12, spawnYL12, 9000, 5, false, true, 20, 12, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL12 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL13, spawnYL13, 9000, 5, false, true, 20, 13, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL14, spawnYL14, 9000, 5, false, true, 20, 14, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL14 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL15, spawnYL15, 9000, 5, false, true, 20, 15, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL15 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL16, spawnYL16, 9000, 5, false, true, 20, 16, (BufferedImage) getCreepImageList().get(12)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL4, spawnYL4, 9000, 5, false, true, 20, 4, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL4 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL5, spawnYL5, 9000, 5, false, true, 20, 5, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL5 -= 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL6, spawnYL6, 9000, 5, false, true, 20, 6, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL7, spawnYL7, 9000, 5, false, true, 20, 7, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL7 -= 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL8, spawnYL8, 9000, 5, false, true, 20, 8, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL17, spawnYL17, 9000, 5, false, true, 20, 17, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL17 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL18, spawnYL18, 9000, 5, false, true, 20, 18, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL18 += 75;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL19, spawnYL19, 9000, 5, false, true, 20, 19, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL20, spawnYL20, 9000, 5, false, true, 20, 20, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL20 += 50;
                        getCreepBigEggList().add(new CreepBigEgg(this, spawnXL21, spawnYL21, 9000, 5, false, true, 20, 21, (BufferedImage) getCreepImageList().get(12)));
                        spawnYL21 += 75;
                    }
                    creepInside = 130;
                    creepWave = 23;
                } else if (creepWave == 23) { //Wave 24
                    for (int a = 0; a < 10; a++) {
                        //Left Upper
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL1, spawnYL1, 7000, 7, false, true, 15, 1, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL1 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL2, spawnYL2, 7000, 7, false, true, 15, 2, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL2 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL3, spawnYL3, 7000, 7, false, true, 15, 3, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL3 -= 125;
                        //Left Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL24, spawnYL24, 7000, 7, false, true, 15, 24, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL24 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL25, spawnYL25, 7000, 7, false, true, 15, 25, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL25 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL26, spawnYL26, 7000, 7, false, true, 15, 26, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL26 -= 125;
                        //Left Lower
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL22, spawnYL22, 7000, 7, false, true, 15, 22, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL22 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL23, spawnYL23, 7000, 7, false, true, 15, 23, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL9, spawnYL9, 7000, 7, false, true, 15, 9, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL9 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL10, spawnYL10, 7000, 7, false, true, 15, 10, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL10 += 75;
                        //Right Middle
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL11, spawnYL11, 7000, 7, false, true, 15, 11, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL11 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL12, spawnYL12, 7000, 7, false, true, 15, 12, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL12 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL13, spawnYL13, 7000, 7, false, true, 15, 13, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL13 += 125;
                        //Right Lower
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL14, spawnYL14, 7000, 7, false, true, 15, 14, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL14 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL15, spawnYL15, 7000, 7, false, true, 15, 15, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL15 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL16, spawnYL16, 7000, 7, false, true, 15, 16, (BufferedImage) getCreepImageList().get(24)));
                        spawnXL16 += 125;

                        //Upper Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL4, spawnYL4, 7000, 7, false, true, 15, 4, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL4 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL5, spawnYL5, 7000, 7, false, true, 15, 5, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL5 -= 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL6, spawnYL6, 7000, 7, false, true, 15, 6, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL6 -= 125;
                        //Upper Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL7, spawnYL7, 7000, 7, false, true, 15, 7, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL7 -= 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL8, spawnYL8, 7000, 7, false, true, 15, 8, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL8 -= 75;

                        //Lower Right
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL17, spawnYL17, 7000, 7, false, true, 15, 17, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL17 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL18, spawnYL18, 7000, 7, false, true, 15, 18, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL18 += 75;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL19, spawnYL19, 7000, 7, false, true, 15, 19, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL19 += 125;
                        //Lower Left
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL20, spawnYL20, 7000, 7, false, true, 15, 20, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL20 += 50;
                        getCreepRageEggList().add(new CreepRageEgg(this, spawnXL21, spawnYL21, 7000, 7, false, true, 15, 21, (BufferedImage) getCreepImageList().get(24)));
                        spawnYL21 += 75;
                    }
                    creepInside = 260;
                    creepWave = 24;
                } else if (creepWave == 24) { //Wave 25
                    for (int a = 0; a < 5; a++) {
                        //Left Upper
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL1, spawnYL1, 11000, 6, false, true, 300, 1, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL1 -= 50;
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL2, spawnYL2, 11000, 6, false, true, 300, 2, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL2 -= 75;
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL3, spawnYL3, 11000, 6, false, true, 300, 3, (BufferedImage) getCreepImageList().get(96)));
                        spawnXL3 -= 125;
                        //Left Lower
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL22, spawnYL22, 16000, 6, false, true, 300, 22, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL22 -= 50;
                        getCreepSwordsmanAntList().add(new CreepSwordsmanAnt(this, spawnXL23, spawnYL23, 16000, 6, false, true, 300, 23, (BufferedImage) getCreepImageList().get(120)));
                        spawnXL23 -= 75;

                        //Right Upper
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL9, spawnYL9, 11000, 6, false, true, 300, 9, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL9 += 50;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL10, spawnYL10, 11000, 6, false, true, 300, 10, (BufferedImage) getCreepImageList().get(108)));
                        spawnXL10 += 75;

                        //Upper Right
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL7, spawnYL7, 11000, 6, false, true, 300, 7, (BufferedImage) getCreepImageList().get(108)));
                        spawnYL7 -= 50;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL8, spawnYL8, 11000, 6, false, true, 300, 8, (BufferedImage) getCreepImageList().get(108)));
                        spawnYL8 -= 75;
                        //Lower Left
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL20, spawnYL20, 11000, 6, false, true, 300, 20, (BufferedImage) getCreepImageList().get(96)));
                        spawnYL20 += 50;
                        getCreepBoxerAntList().add(new CreepBoxerAnt(this, spawnXL21, spawnYL21, 11000, 6, false, true, 300, 21, (BufferedImage) getCreepImageList().get(96)));
                        spawnYL21 += 75;
                        //Lower Right
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL17, spawnYL17, 11000, 6, false, true, 300, 17, (BufferedImage) getCreepImageList().get(108)));
                        spawnYL17 += 50;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL18, spawnYL18, 11000, 6, false, true, 300, 18, (BufferedImage) getCreepImageList().get(108)));
                        spawnYL18 += 75;
                        getCreepSpearmanAntList().add(new CreepSpearmanAnt(this, spawnXL19, spawnYL19, 11000, 6, false, true, 300, 19, (BufferedImage) getCreepImageList().get(108)));
                        spawnYL19 += 125;
                    }
                    //Upper Left
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL4, spawnYL4, 30000, 6, false, true, 300, 4, (BufferedImage) getCreepImageList().get(132)));
                    spawnYL4 -= 50;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL5, spawnYL5, 30000, 6, false, true, 300, 5, (BufferedImage) getCreepImageList().get(132)));
                    spawnYL5 -= 75;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL6, spawnYL6, 30000, 6, false, true, 300, 6, (BufferedImage) getCreepImageList().get(132)));
                    spawnYL6 -= 125;
                    //Right Lower
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL14, spawnYL14, 16000, 6, false, true, 300, 14, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL14 += 50;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL15, spawnYL15, 16000, 6, false, true, 300, 15, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL15 += 75;
                    getCreepKingAntList().add(new CreepKingAnt(this, spawnXL16, spawnYL16, 16000, 6, false, true, 300, 16, (BufferedImage) getCreepImageList().get(132)));
                    spawnXL16 += 125;
                    creepInside = 76;
                    creepWave = 25;
                }
            }
        }
    }

    public void resetWaveSpawns() {
        spawnXL1 = 0;
        spawnYL1 = 525;
        spawnXL2 = 0;
        spawnYL2 = 525;
        spawnXL3 = 0;
        spawnYL3 = 525;
        spawnXL4 = 1075;
        spawnYL4 = 0;
        spawnXL5 = 1075;
        spawnYL5 = 0;
        spawnXL6 = 1075;
        spawnYL6 = 0;
        spawnXL7 = 2275;
        spawnYL7 = 0;
        spawnXL8 = 2275;
        spawnYL8 = 0;
        spawnXL9 = 3350;
        spawnYL9 = 525;
        spawnXL10 = 3350;
        spawnYL10 = 525;
        spawnXL11 = 3350;
        spawnYL11 = 1675;
        spawnXL12 = 3350;
        spawnYL12 = 1675;
        spawnXL13 = 3350;
        spawnYL13 = 1675;
        spawnXL14 = 3350;
        spawnYL14 = 2825;
        spawnXL15 = 3350;
        spawnYL15 = 2825;
        spawnXL16 = 3350;
        spawnYL16 = 2825;
        spawnXL17 = 2275;
        spawnYL17 = 3350;
        spawnXL18 = 2275;
        spawnYL18 = 3350;
        spawnXL19 = 2275;
        spawnYL19 = 3350;
        spawnXL20 = 1075;
        spawnYL20 = 3350;
        spawnXL21 = 1075;
        spawnYL21 = 3350;
        spawnXL22 = 0;
        spawnYL22 = 2825;
        spawnXL23 = 0;
        spawnYL23 = 2825;
        spawnXL24 = 0;
        spawnYL24 = 1675;
        spawnXL25 = 0;
        spawnYL25 = 1675;
        spawnXL26 = 0;
        spawnYL26 = 1675;
    }

    private synchronized void stopThread() {
        isListen = true;
    }
    
    public void onPlaySoundClip(int soundToPlay) {
        if (soundToPlay == 1) {
            cmSound.cmSoundBuildPlacement();
        } else if (soundToPlay == 2) {
            cmSound.cmSoundTIDLaunch();
        } else if (soundToPlay == 3) {
            cmSound.cmSoundTILaunch();
        } else if (soundToPlay == 4) {
            cmSound.cmSoundTIHit();
        } else if (soundToPlay == 5) {
            cmSound.cmSoundTCBLaunch();
        } else if (soundToPlay == 6) {
            cmSound.cmSoundTCBHit();
        } else if (soundToPlay == 7) {
            cmSound.cmSoundTCMLaunch();
        } else if (soundToPlay == 8) {
            cmSound.cmSoundTCMHit();
        } else if (soundToPlay == 9) {
            cmSound.cmSoundTMLaunch();
        } else if (soundToPlay == 10) {
            cmSound.cmSoundTSIDLaunch();
        } else if (soundToPlay == 11) {
            cmSound.cmSoundTCOLaunch();
        } else if (soundToPlay == 12) {
            cmSound.cmSoundTCOHit();
        } else if (soundToPlay == 13) {
            if (cmSoundNEG == false) {
                cmSound.cmSoundNotEnoughGold();
                cmSoundNEG = true;
            }
        } else if (soundToPlay == 14) {
            cmSound.cmSoundUnderAttack();
        } else if (soundToPlay == 15) {
            cmSound.cmSoundSignal();
        } else if (soundToPlay == 16) {
            cmSound.cmSoundCandysteinVictory();
        } else if (soundToPlay == 17) {
            cmSound.cmSoundInsectoVictory();
        } else if (soundToPlay == 18) {
            cmSound.cmSoundKingCandylonz();
        }
    }
    
    public void onBuildTower(int ttype) {
        onClickTowerDeselection();

        for (int a = 0; a < tileObjectList.size(); a++) {
            Tile tl = (Tile) tileObjectList.get(a);
            if (tl.getTileVacancy() == false) {
                if (tl.getX() == finalMouseX && tl.getY() == finalMouseY) {
                    if (ttype == 1) {
                        onPlaySoundClip(1);
                        getTowerIceDropList().add(new TowerIceDrop(this, finalMouseX, finalMouseY, (BufferedImage) getTowerIceDropImageList().get(5), playerName));
                        playerGold -= 300;
                        setBroadCastBuildTower(1, finalMouseX, finalMouseY);
                    } else if (ttype == 2) {
                        onPlaySoundClip(1);
                        getTowerIceList().add(new TowerIce(this, finalMouseX, finalMouseY, (BufferedImage) getTowerIceImageList().get(0), playerName));
                        playerGold -= 100;
                        setBroadCastBuildTower(2, finalMouseX, finalMouseY);
                    } else if (ttype == 3) {
                        onPlaySoundClip(1);
                        getTowerCherryBoltList().add(new TowerCherryBolt(this, finalMouseX, finalMouseY, (BufferedImage) getTowerCherryBoltImageList().get(4), playerName));
                        playerGold -= 500;
                        setBroadCastBuildTower(3, finalMouseX, finalMouseY);
                    } else if (ttype == 4) {
                        onPlaySoundClip(1);
                        getTowerCandyMachineList().add(new TowerCandyMachine(this, finalMouseX, finalMouseY, (BufferedImage) getTowerCandyMachineImageList().get(0), playerName));
                        playerGold -= 400;
                        setBroadCastBuildTower(4, finalMouseX, finalMouseY);
                    } else if (ttype == 5) {
                        onPlaySoundClip(1);
                        getTowerMentosList().add(new TowerMentos(this, finalMouseX, finalMouseY, (BufferedImage) getTowerMentosImageList().get(0), playerName));
                        playerGold -= 2500;
                        setBroadCastBuildTower(5, finalMouseX, finalMouseY);
                    } else if (ttype == 6) {
                        onPlaySoundClip(1);
                        getTowerSingleIceDropList().add(new TowerSingleIceDrop(this, finalMouseX, finalMouseY, (BufferedImage) getTowerSingleIceDropImageList().get(5), playerName));
                        playerGold -= 800;
                        setBroadCastBuildTower(6, finalMouseX, finalMouseY);
                    } else if (ttype == 7) {
                        onPlaySoundClip(1);
                        getTowerStickOList().add(new TowerStickO(this, finalMouseX, finalMouseY, (BufferedImage) getTowerStickOImageList().get(0), playerName));
                        playerGold -= 250;
                        setBroadCastBuildTower(7, finalMouseX, finalMouseY);
                    }
                    addObjectAnimation(finalMouseX, finalMouseY, 4, 6, true, 1);
                    tl.setTileVacancy(true);
                    onBuild = false;
                    break;
                }
            }
        }
    }

    public void onClickTower() {
        onClickTowerDeselection();

        for (int a = 0; a < getTowerIceDropList().size(); a++) {
            TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
            if (tid.getX() == finalMouseX && tid.getY() == finalMouseY) {
                tid.setTowerClicked(true);
                onClickTowerType = "1";
                onClickTowerLevel = tid.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerIceList().size(); a++) {
            TowerIce ti = (TowerIce) getTowerIceList().get(a);
            if (ti.getX() == finalMouseX && ti.getY() == finalMouseY) {
                ti.setTowerClicked(true);
                onClickTowerType = "2";
                onClickTowerLevel = ti.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
            TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
            if (tcb.getX() == finalMouseX && tcb.getY() == finalMouseY) {
                tcb.setTowerClicked(true);
                onClickTowerType = "3";
                onClickTowerLevel = tcb.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
            TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
            if (tcm.getX() == finalMouseX && tcm.getY() == finalMouseY) {
                tcm.setTowerClicked(true);
                onClickTowerType = "4";
                onClickTowerLevel = tcm.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerMentosList().size(); a++) {
            TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
            if (tm.getX() == finalMouseX && tm.getY() == finalMouseY) {
                tm.setTowerClicked(true);
                onClickTowerType = "5";
                onClickTowerLevel = tm.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
            TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
            if (tsid.getX() == finalMouseX && tsid.getY() == finalMouseY) {
                tsid.setTowerClicked(true);
                onClickTowerType = "6";
                onClickTowerLevel = tsid.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerStickOList().size(); a++) {
            TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
            if (tco.getX() == finalMouseX && tco.getY() == finalMouseY) {
                tco.setTowerClicked(true);
                onClickTowerType = "7";
                onClickTowerLevel = tco.getTowerLevel();
                onClick = true;
                break;
            }
        }
    }

    public void onClickTowerDeselection() {
        for (int a = 0; a < getTowerIceDropList().size(); a++) {
            TowerIceDrop ti = (TowerIceDrop) getTowerIceDropList().get(a);
            ti.setTowerClicked(false);
        }

        for (int a = 0; a < getTowerIceList().size(); a++) {
            TowerIce ti = (TowerIce) getTowerIceList().get(a);
            ti.setTowerClicked(false);
        }

        for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
            TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
            tcb.setTowerClicked(false);
        }

        for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
            TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
            tcm.setTowerClicked(false);
        }

        for (int a = 0; a < getTowerMentosList().size(); a++) {
            TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
            tm.setTowerClicked(false);
        }

        for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
            TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
            tsid.setTowerClicked(false);
        }

        for (int a = 0; a < getTowerStickOList().size(); a++) {
            TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
            tco.setTowerClicked(false);
        }

        onClick = false;
        hudTowerVisibility = false;
    }

    public void onClickTowerUpgrade() {
        for (int a = 0; a < getTowerIceDropList().size(); a++) {
            TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
            if (tid.getTowerClicked() == true && tid.getTowerOwner().equals(playerName)) {
                if (tid.getTowerLevel() == 1) {
                    if (playerGold >= tid.getTowerUpgradeCost()) {
                        playerGold -= tid.getTowerUpgradeCost();
                        tid.setTowerLevel(2);
                        tid.setTowerUpgradeCost(500);
                        tid.setTowerDamage(75);
                        tid.setTowerAttackSpeed(200);
                        tid.setTowerRangeDeductor(130);
                        tid.setTowerRangeHeight(300);
                        tid.setTowerRangeWidth(300);
                        tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(13));
                    } else {
                        onPlaySoundClip(13);
                    }
                } else if (tid.getTowerLevel() == 2) {
                    if (playerGold >= tid.getTowerUpgradeCost()) {
                        playerGold -= tid.getTowerUpgradeCost();
                        tid.setTowerLevel(3);
                        tid.setTowerDamage(100);
                        tid.setTowerAttackSpeed(100);
                        tid.setTowerRangeDeductor(175);
                        tid.setTowerRangeHeight(400);
                        tid.setTowerRangeWidth(400);
                        tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(21));
                    } else {
                        onPlaySoundClip(13);
                    }
                }

                if (tid.getTowerLevel() <= 3) {
                    if (playerGold >= tid.getTowerUpgradeCost()) {
                        setBroadCastUpgradeTower(1, tid.getX(), tid.getY());
                    }
                }
                onClickTowerType = "1";
                onClickTowerLevel = tid.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerIceList().size(); a++) {
            TowerIce ti = (TowerIce) getTowerIceList().get(a);
            if (ti.getTowerClicked() == true && ti.getTowerOwner().equals(playerName)) {
                if (ti.getTowerLevel() == 1) {
                    if (playerGold >= ti.getTowerUpgradeCost()) {
                        playerGold -= ti.getTowerUpgradeCost();
                        ti.setTowerLevel(2);
                        ti.setTowerUpgradeCost(250);
                        ti.setTowerDamage(45);
                        ti.setTowerAttackSpeed(500);
                        ti.setTowerRangeDeductor(130);
                        ti.setTowerRangeHeight(300);
                        ti.setTowerRangeWidth(300);
                        ti.setTowerImage((BufferedImage) getTowerIceImageList().get(1));
                    } else {
                        onPlaySoundClip(13);
                    }
                } else if (ti.getTowerLevel() == 2) {
                    if (playerGold >= ti.getTowerUpgradeCost()) {
                        playerGold -= ti.getTowerUpgradeCost();
                        ti.setTowerLevel(3);
                        ti.setTowerDamage(60);
                        ti.setTowerAttackSpeed(250);
                        ti.setTowerRangeDeductor(175);
                        ti.setTowerRangeHeight(400);
                        ti.setTowerRangeWidth(400);
                        ti.setTowerImage((BufferedImage) getTowerIceImageList().get(2));
                    } else {
                        onPlaySoundClip(13);
                    }
                }

                if (ti.getTowerLevel() <= 3) {
                    if (playerGold >= ti.getTowerUpgradeCost()) {
                        setBroadCastUpgradeTower(2, ti.getX(), ti.getY());
                    }
                }
                onClickTowerType = "2";
                onClickTowerLevel = ti.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
            TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
            if (tcb.getTowerClicked() == true && tcb.getTowerOwner().equals(playerName)) {
                if (tcb.getTowerLevel() == 1) {
                    if (playerGold >= tcb.getTowerUpgradeCost()) {
                        playerGold -= tcb.getTowerUpgradeCost();
                        tcb.setTowerLevel(2);
                        tcb.setTowerUpgradeCost(1500);
                        tcb.setTowerDamage(150);
                        tcb.setTowerAttackSpeed(300);
                        tcb.setTowerRangeDeductor(130);
                        tcb.setTowerRangeHeight(300);
                        tcb.setTowerRangeWidth(300);
                        tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(12));
                    } else {
                        onPlaySoundClip(13);
                    }
                } else if (tcb.getTowerLevel() == 2) {
                    if (playerGold >= tcb.getTowerUpgradeCost()) {
                        playerGold -= tcb.getTowerUpgradeCost();
                        tcb.setTowerLevel(3);
                        tcb.setTowerDamage(400);
                        tcb.setTowerAttackSpeed(100);
                        tcb.setTowerRangeDeductor(175);
                        tcb.setTowerRangeHeight(400);
                        tcb.setTowerRangeWidth(400);
                        tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(20));
                    } else {
                        onPlaySoundClip(13);
                    }
                }

                if (tcb.getTowerLevel() <= 3) {
                    if (playerGold >= tcb.getTowerUpgradeCost()) {
                        setBroadCastUpgradeTower(3, tcb.getX(), tcb.getY());
                    }
                }
                onClickTowerType = "3";
                onClickTowerLevel = tcb.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
            TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
            if (tcm.getTowerClicked() == true && tcm.getTowerOwner().equals(playerName)) {
                if (tcm.getTowerLevel() == 1) {
                    if (playerGold >= tcm.getTowerUpgradeCost()) {
                        playerGold -= tcm.getTowerUpgradeCost();
                        tcm.setTowerLevel(2);
                        tcm.setTowerUpgradeCost(500);
                        tcm.setTowerDamage(40);
                        tcm.setTowerAttackSpeed(150);
                        tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(1));
                    } else {
                        onPlaySoundClip(13);
                    }
                } else if (tcm.getTowerLevel() == 2) {
                    if (playerGold >= tcm.getTowerUpgradeCost()) {
                        playerGold -= tcm.getTowerUpgradeCost();
                        tcm.setTowerLevel(3);
                        tcm.setTowerDamage(70);
                        tcm.setTowerAttackSpeed(100);
                        tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(2));
                    } else {
                        onPlaySoundClip(13);
                    }
                }

                if (tcm.getTowerLevel() <= 3) {
                    if (playerGold >= tcm.getTowerUpgradeCost()) {
                        setBroadCastUpgradeTower(4, tcm.getX(), tcm.getY());
                    }
                }
                onClickTowerType = "4";
                onClickTowerLevel = tcm.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerMentosList().size(); a++) {
            TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
            if (tm.getTowerClicked() == true && tm.getTowerOwner().equals(playerName)) {
                if (tm.getTowerLevel() == 1) {
                    if (playerGold >= tm.getTowerUpgradeCost()) {
                        playerGold -= tm.getTowerUpgradeCost();
                        tm.setTowerLevel(2);
                        tm.setTowerMaxTarget(5);
                        tm.setTowerUpgradeCost(2000);
                        tm.setTowerDamage(100);
                        tm.setTowerAttackSpeed(200);
                        tm.setTowerRangeDeductor(130);
                        tm.setTowerRangeHeight(300);
                        tm.setTowerRangeWidth(300);
                        tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(1));
                    } else {
                        onPlaySoundClip(13);
                    }
                } else if (tm.getTowerLevel() == 2) {
                    if (playerGold >= tm.getTowerUpgradeCost()) {
                        playerGold -= tm.getTowerUpgradeCost();
                        tm.setTowerLevel(3);
                        tm.setTowerMaxTarget(7);
                        tm.setTowerDamage(150);
                        tm.setTowerAttackSpeed(100);
                        tm.setTowerRangeDeductor(175);
                        tm.setTowerRangeHeight(400);
                        tm.setTowerRangeWidth(400);
                        tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(2));
                    } else {
                        onPlaySoundClip(13);
                    }
                }

                if (tm.getTowerLevel() <= 3) {
                    if (playerGold >= tm.getTowerUpgradeCost()) {
                        setBroadCastUpgradeTower(5, tm.getX(), tm.getY());
                    }
                }
                onClickTowerType = "5";
                onClickTowerLevel = tm.getTowerLevel();
                onClick = true;
                break;
            }

        }

        for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
            TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
            if (tsid.getTowerClicked() == true) {
                if (tsid.getTowerLevel() == 1 && tsid.getTowerOwner().equals(playerName)) {
                    if (playerGold >= tsid.getTowerUpgradeCost()) {
                        playerGold -= tsid.getTowerUpgradeCost();
                        tsid.setTowerLevel(2);
                        tsid.setTowerUpgradeCost(1200);
                        tsid.setTowerDamage(6);
                        tsid.setTowerAttackSpeed(60);
                        tsid.setTowerRangeDeductor(130);
                        tsid.setTowerRangeHeight(300);
                        tsid.setTowerRangeWidth(300);
                        tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(13));
                    } else {
                        onPlaySoundClip(13);
                    }
                } else if (tsid.getTowerLevel() == 2) {
                    if (playerGold >= tsid.getTowerUpgradeCost()) {
                        playerGold -= tsid.getTowerUpgradeCost();
                        tsid.setTowerLevel(3);
                        tsid.setTowerDamage(8);
                        tsid.setTowerAttackSpeed(40);
                        tsid.setTowerRangeDeductor(175);
                        tsid.setTowerRangeHeight(400);
                        tsid.setTowerRangeWidth(400);
                        tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(21));
                    } else {
                        onPlaySoundClip(13);
                    }
                }

                if (tsid.getTowerLevel() <= 3) {
                    if (playerGold >= tsid.getTowerUpgradeCost()) {
                        setBroadCastUpgradeTower(6, tsid.getX(), tsid.getY());
                    }
                }
                onClickTowerType = "6";
                onClickTowerLevel = tsid.getTowerLevel();
                onClick = true;
                break;
            }
        }

        for (int a = 0; a < getTowerStickOList().size(); a++) {
            TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
            if (tco.getTowerClicked() == true && tco.getTowerOwner().equals(playerName)) {
                if (tco.getTowerLevel() == 1) {
                    if (playerGold >= tco.getTowerUpgradeCost()) {
                        playerGold -= tco.getTowerUpgradeCost();
                        tco.setTowerLevel(2);
                        tco.setTowerUpgradeCost(500);
                        tco.setTowerDamage(30);
                        tco.setTowerAttackSpeed(500);
                        tco.setTowerRangeDeductor(130);
                        tco.setTowerRangeHeight(300);
                        tco.setTowerRangeWidth(300);
                        tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(1));
                    } else {
                        onPlaySoundClip(13);
                    }
                } else if (tco.getTowerLevel() == 2) {
                    if (playerGold >= tco.getTowerUpgradeCost()) {
                        playerGold -= tco.getTowerUpgradeCost();
                        tco.setTowerLevel(3);
                        tco.setTowerDamage(50);
                        tco.setTowerAttackSpeed(400);
                        tco.setTowerRangeDeductor(175);
                        tco.setTowerRangeHeight(400);
                        tco.setTowerRangeWidth(400);
                        tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(2));
                    } else {
                        onPlaySoundClip(13);
                    }
                }

                if (tco.getTowerLevel() <= 3) {
                    if (playerGold >= tco.getTowerUpgradeCost()) {
                        setBroadCastUpgradeTower(7, tco.getX(), tco.getY());
                    }
                }
                onClickTowerType = "7";
                onClickTowerLevel = tco.getTowerLevel();
                onClick = true;
                break;
            }
        }
    }

    public void onClickTowerSell() {
        for (int a = 0; a < getTowerIceDropList().size(); a++) {
            TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
            if (tid.getTowerClicked() == true && tid.getTowerOwner().equals(playerName)) {
                playerGold += 300;
                getTowerIceDropList().remove(tid);
                setBroadCastSellTower(1, tid.getX(), tid.getY());
                for (int b = 0; b < getTileObjectList().size(); b++) {
                    Tile tl = (Tile) getTileObjectList().get(b);
                    if (tl.getX() == tid.getX() && tl.getY() == tid.getY()) {
                        tl.setTileVacancy(false);
                        break;
                    }
                }
                addObjectAnimation(tid.getX(), tid.getY(), 8, 20, true, 1);
                break;
            }
        }

        for (int a = 0; a < getTowerIceList().size(); a++) {
            TowerIce ti = (TowerIce) getTowerIceList().get(a);
            if (ti.getTowerClicked() == true && ti.getTowerOwner().equals(playerName)) {
                playerGold += 100;
                getTowerIceList().remove(ti);
                setBroadCastSellTower(2, ti.getX(), ti.getY());
                for (int b = 0; b < getTileObjectList().size(); b++) {
                    Tile tl = (Tile) getTileObjectList().get(b);
                    if (tl.getX() == ti.getX() && tl.getY() == ti.getY()) {
                        tl.setTileVacancy(false);
                        break;
                    }
                }
                addObjectAnimation(ti.getX(), ti.getY(), 8, 20, true, 1);
                break;
            }
        }

        for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
            TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
            if (tcb.getTowerClicked() == true && tcb.getTowerOwner().equals(playerName)) {
                playerGold += 500;
                getTowerCherryBoltList().remove(tcb);
                setBroadCastSellTower(3, tcb.getX(), tcb.getY());
                for (int b = 0; b < getTileObjectList().size(); b++) {
                    Tile tl = (Tile) getTileObjectList().get(b);
                    if (tl.getX() == tcb.getX() && tl.getY() == tcb.getY()) {
                        tl.setTileVacancy(false);
                        break;
                    }
                }
                addObjectAnimation(tcb.getX(), tcb.getY(), 8, 20, true, 1);
                break;
            }
        }

        for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
            TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
            if (tcm.getTowerClicked() == true && tcm.getTowerOwner().equals(playerName)) {
                playerGold += 400;
                getTowerCandyMachineList().remove(tcm);
                setBroadCastSellTower(4, tcm.getX(), tcm.getY());
                for (int b = 0; b < getTileObjectList().size(); b++) {
                    Tile tl = (Tile) getTileObjectList().get(b);
                    if (tl.getX() == tcm.getX() && tl.getY() == tcm.getY()) {
                        tl.setTileVacancy(false);
                        break;
                    }
                }
                addObjectAnimation(tcm.getX(), tcm.getY(), 8, 20, true, 1);
                break;
            }
        }

        for (int a = 0; a < getTowerMentosList().size(); a++) {
            TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
            if (tm.getTowerClicked() == true && tm.getTowerOwner().equals(playerName)) {
                playerGold += 2500;
                getTowerMentosList().remove(tm);
                setBroadCastSellTower(5, tm.getX(), tm.getY());
                for (int b = 0; b < getTileObjectList().size(); b++) {
                    Tile tl = (Tile) getTileObjectList().get(b);
                    if (tl.getX() == tm.getX() && tl.getY() == tm.getY()) {
                        tl.setTileVacancy(false);
                        break;
                    }
                }
                addObjectAnimation(tm.getX(), tm.getY(), 8, 20, true, 1);
                break;
            }
        }

        for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
            TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
            if (tsid.getTowerClicked() == true && tsid.getTowerOwner().equals(playerName)) {
                playerGold += 800;
                getTowerSingleIceDropList().remove(tsid);
                setBroadCastSellTower(6, tsid.getX(), tsid.getY());
                for (int b = 0; b < getTileObjectList().size(); b++) {
                    Tile tl = (Tile) getTileObjectList().get(b);
                    if (tl.getX() == tsid.getX() && tl.getY() == tsid.getY()) {
                        tl.setTileVacancy(false);
                        break;
                    }
                }
                addObjectAnimation(tsid.getX(), tsid.getY(), 8, 20, true, 1);
                break;
            }
        }

        for (int a = 0; a < getTowerStickOList().size(); a++) {
            TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
            if (tco.getTowerClicked() == true && tco.getTowerOwner().equals(playerName)) {
                playerGold += 250;
                getTowerStickOList().remove(tco);
                setBroadCastSellTower(7, tco.getX(), tco.getY());
                for (int b = 0; b < getTileObjectList().size(); b++) {
                    Tile tl = (Tile) getTileObjectList().get(b);
                    if (tl.getX() == tco.getX() && tl.getY() == tco.getY()) {
                        tl.setTileVacancy(false);
                        break;
                    }
                }
                addObjectAnimation(tco.getX(), tco.getY(), 8, 20, true, 1);
                break;
            }
        }
    }

    public void addBullet(int ttype, int tlevel, int bx, int by, int bdmg, int btype, boolean vb, CreepEgg ce, CreepBigEgg cbe, CreepRageEgg cre, CreepBlackAnt cba, CreepRedAnt cra, CreepRat cr, CreepButterfly cb, CreepBee cbb, CreepBoxerAnt crba, CreepSpearmanAnt csa, CreepSwordsmanAnt crsa, CreepKingAnt cka, String owner) {
        if (bx >= camX && bx <= (camX + screenWidth)) {
            if (by >= camY && by <= (camY + screenHeight)) {
                if (ttype == 1) {
                    onPlaySoundClip(2);
                } else if (ttype == 2) {
                    onPlaySoundClip(3);
                } else if (ttype == 3) {
                    onPlaySoundClip(5);
                } else if (ttype == 4) {
                    onPlaySoundClip(7);
                } else if (ttype == 5) {
                    onPlaySoundClip(9);
                } else if (ttype == 6) {
                    onPlaySoundClip(10);
                } else if (ttype == 7) {
                    onPlaySoundClip(11);
                }
            }
        }
        
        if (ttype == 1) {
            if (tlevel == 1) {
                getBulletTIDList().add(new BulletTID(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(0), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 2) {
                getBulletTIDList().add(new BulletTID(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(1), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 3) {
                getBulletTIDList().add(new BulletTID(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(2), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            }
        } else if (ttype == 2) {
            if (tlevel == 1) {
                getBulletTIList().add(new BulletTI(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(3), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 2) {
                getBulletTIList().add(new BulletTI(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(4), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 3) {
                getBulletTIList().add(new BulletTI(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(5), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            }
        } else if (ttype == 3) {
            if (tlevel == 1) {
                getBulletCBList().add(new BulletCB(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(6), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 2) {
                getBulletCBList().add(new BulletCB(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(7), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 3) {
                getBulletCBList().add(new BulletCB(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(8), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            }

        } else if (ttype == 4) {
            if (tlevel == 1) {
                getBulletCMList().add(new BulletCM(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(9), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 2) {
                getBulletCMList().add(new BulletCM(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(10), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 3) {
                getBulletCMList().add(new BulletCM(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(11), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            }
        } else if (ttype == 5) {
            if (tlevel == 1) {
                getBulletMList().add(new BulletM(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(12), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 2) {
                getBulletMList().add(new BulletM(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(13), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 3) {
                getBulletMList().add(new BulletM(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(14), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            }
        } else if (ttype == 6) {
            if (tlevel == 1) {
                getBulletSIDList().add(new BulletSID(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(15), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 2) {
                getBulletSIDList().add(new BulletSID(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(16), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 3) {
                getBulletSIDList().add(new BulletSID(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(17), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            }
        } else if (ttype == 7) {
            if (tlevel == 1) {
                getBulletSOList().add(new BulletSO(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(18), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 2) {
                getBulletSOList().add(new BulletSO(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(19), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            } else if (tlevel == 3) {
                getBulletSOList().add(new BulletSO(this, bx, by, bdmg, btype, tlevel, vb, (BufferedImage) getBulletImageList().get(20), ce, cbe, cre, cba, cra, cr, cb, cbb, crba, csa, crsa, cka, owner));
            }
        }
    }

    public void creepInsideReduction() {
        creepInside--;
    }

    public void addObjectAnimation(int oax, int oay, int type, int counter, boolean oavis, int lvl) {
        if (type == 1 || type == 2 || type == 3) {
            getObjectAnimationList().add(new ObjectAnimation(oax, oay, type, counter, oavis, lvl, null));
        } else if (type == 4) {
            getObjectAnimationList().add(new ObjectAnimation(oax, oay, type, counter, oavis, lvl, (BufferedImage) getAnimationImageList().get(0)));
        } else if (type == 5) {
            getObjectAnimationList().add(new ObjectAnimation(oax, oay, type, counter, oavis, lvl, (BufferedImage) getAnimationImageList().get(6)));
        } else if (type == 6) {
            getObjectAnimationList().add(new ObjectAnimation(oax, oay, type, counter, oavis, lvl, (BufferedImage) getAnimationImageList().get(17)));
        } else if (type == 7) {
            getObjectAnimationList().add(new ObjectAnimation(oax, oay, type, counter, oavis, lvl, (BufferedImage) getAnimationImageList().get(32)));
        } else if (type == 8) {
            getObjectAnimationList().add(new ObjectAnimation(oax, oay, type, counter, oavis, lvl, (BufferedImage) getAnimationImageList().get(42)));
        }
    }

    public void setServerLoadKillsOnLeaderBoard(String killer) {
         if (cmMachineType.equals("SERVER")) {
            if (killer.equals(player1)) {
                p1Kills += 1;
            } else if (killer.equals(player2)) {
                p2Kills += 1;
            } else if (killer.equals(player3)) {
                p3Kills += 1;
            } else if (killer.equals(player4)) {
                p4Kills += 1;
            }
        }
    }
    
    public synchronized void setClientCastleLife(int life) {
        candyCastle.setCastleCurrentHp(life);
    }
    
    public synchronized void setClientLoadKillsOnLeaderBoard(int p1, int p2, int p3, int p4) {
        p1Kills = p1;
        p2Kills = p2;
        p3Kills = p3;
        p4Kills = p4;
    }
    
    public void setBroadCastBuildTower(int type, int fX, int fY) {
        cmc = new CMCommand("BUILDTOWER", Integer.toString(type), playerName, Integer.toString(fX), Integer.toString(fY), "XD", "XD", "XD", "XD", "XD", null);

        if (cmMachineType.equals("SERVER")) {
            cmsct.serverSecondaryBroadCastMessage(cmc);
        } else if (cmMachineType.equals("CLIENT")) {
            cmscrt.clientBroadCastMessage(cmc);
        }
    }

    public synchronized void setNetworkBuildTower(int type, String pN, int fX, int fY) {
        for (int a = 0; a < tileObjectList.size(); a++) {
            Tile tl = (Tile) tileObjectList.get(a);
            if (tl.getTileVacancy() == false) {
                if (tl.getX() == fX && tl.getY() == fY) {
                    if (type == 1) {
                        getTowerIceDropList().add(new TowerIceDrop(this, fX, fY, (BufferedImage) getTowerIceDropImageList().get(5), pN));
                    } else if (type == 2) {
                        getTowerIceList().add(new TowerIce(this, fX, fY, (BufferedImage) getTowerIceImageList().get(0), pN));
                    } else if (type == 3) {
                        getTowerCherryBoltList().add(new TowerCherryBolt(this, fX, fY, (BufferedImage) getTowerCherryBoltImageList().get(4), pN));
                    } else if (type == 4) {
                        getTowerCandyMachineList().add(new TowerCandyMachine(this, fX, fY, (BufferedImage) getTowerCandyMachineImageList().get(0), pN));
                    } else if (type == 5) {
                        getTowerMentosList().add(new TowerMentos(this, fX, fY, (BufferedImage) getTowerMentosImageList().get(0), pN));
                    } else if (type == 6) {
                        getTowerSingleIceDropList().add(new TowerSingleIceDrop(this, fX, fY, (BufferedImage) getTowerSingleIceDropImageList().get(5), pN));
                    } else if (type == 7) {
                        getTowerStickOList().add(new TowerStickO(this, fX, fY, (BufferedImage) getTowerStickOImageList().get(0), pN));
                    }
                    addObjectAnimation(tl.getX(), tl.getY(), 4, 6, true, 1);
                    tl.setTileVacancy(true);
                    break;
                }
            }
        }
    }

    public void setBroadCastSellTower(int type, int sX, int sY) {
        cmc = new CMCommand("SELLTOWER", Integer.toString(type), Integer.toString(sX), Integer.toString(sY), "XD", "XD", "XD", "XD", "XD", "XD", null);

        if (cmMachineType.equals("SERVER")) {
            cmsct.serverSecondaryBroadCastMessage(cmc);
        } else if (cmMachineType.equals("CLIENT")) {
            cmscrt.clientBroadCastMessage(cmc);
        }
    }

    public synchronized void setNetworkSellTower(int type, int sX, int sY) {
        if (type == 1) {
            for (int a = 0; a < getTowerIceDropList().size(); a++) {
                TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
                if (tid.getX() == sX && tid.getY() == sY) {
                    getTowerIceDropList().remove(tid);
                    for (int b = 0; b < getTileObjectList().size(); b++) {
                        Tile tl = (Tile) getTileObjectList().get(b);
                        if (tl.getX() == tid.getX() && tl.getY() == tid.getY()) {
                            tl.setTileVacancy(false);
                            break;
                        }
                    }
                    addObjectAnimation(tid.getX(), tid.getY(), 8, 20, true, 1);
                    break;
                }
            }
        }

        if (type == 2) {
            for (int a = 0; a < getTowerIceList().size(); a++) {
                TowerIce ti = (TowerIce) getTowerIceList().get(a);
                if (ti.getX() == sX && ti.getY() == sY) {
                    getTowerIceList().remove(ti);
                    for (int b = 0; b < getTileObjectList().size(); b++) {
                        Tile tl = (Tile) getTileObjectList().get(b);
                        if (tl.getX() == ti.getX() && tl.getY() == ti.getY()) {
                            tl.setTileVacancy(false);
                            break;
                        }
                    }
                    addObjectAnimation(ti.getX(), ti.getY(), 8, 20, true, 1);
                    break;
                }
            }
        }

        if (type == 3) {
            for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
                TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
                if (tcb.getX() == sX && tcb.getY() == sY) {
                    getTowerCherryBoltList().remove(tcb);
                    for (int b = 0; b < getTileObjectList().size(); b++) {
                        Tile tl = (Tile) getTileObjectList().get(b);
                        if (tl.getX() == tcb.getX() && tl.getY() == tcb.getY()) {
                            tl.setTileVacancy(false);
                            break;
                        }
                    }
                    addObjectAnimation(tcb.getX(), tcb.getY(), 8, 20, true, 1);
                    break;
                }
            }
        }

        if (type == 4) {
            for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
                TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
                if (tcm.getX() == sX && tcm.getY() == sY) {
                    getTowerCandyMachineList().remove(tcm);
                    for (int b = 0; b < getTileObjectList().size(); b++) {
                        Tile tl = (Tile) getTileObjectList().get(b);
                        if (tl.getX() == tcm.getX() && tl.getY() == tcm.getY()) {
                            tl.setTileVacancy(false);
                            break;
                        }
                    }
                    addObjectAnimation(tcm.getX(), tcm.getY(), 8, 20, true, 1);
                    break;
                }
            }
        }

        if (type == 5) {
            for (int a = 0; a < getTowerMentosList().size(); a++) {
                TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
                if (tm.getX() == sX && tm.getY() == sY) {
                    getTowerMentosList().remove(tm);
                    for (int b = 0; b < getTileObjectList().size(); b++) {
                        Tile tl = (Tile) getTileObjectList().get(b);
                        if (tl.getX() == tm.getX() && tl.getY() == tm.getY()) {
                            tl.setTileVacancy(false);
                            break;
                        }
                    }
                    addObjectAnimation(tm.getX(), tm.getY(), 8, 20, true, 1);
                    break;
                }
            }
        }

        if (type == 6) {
            for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
                TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
                if (tsid.getX() == sX && tsid.getY() == sY) {
                    getTowerSingleIceDropList().remove(tsid);
                    for (int b = 0; b < getTileObjectList().size(); b++) {
                        Tile tl = (Tile) getTileObjectList().get(b);
                        if (tl.getX() == tsid.getX() && tl.getY() == tsid.getY()) {
                            tl.setTileVacancy(false);
                            break;
                        }
                    }
                    addObjectAnimation(tsid.getX(), tsid.getY(), 8, 20, true, 1);
                    break;
                }
            }
        }

        if (type == 7) {
            for (int a = 0; a < getTowerStickOList().size(); a++) {
                TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
                if (tco.getX() == sX && tco.getY() == sY) {
                    getTowerStickOList().remove(tco);
                    for (int b = 0; b < getTileObjectList().size(); b++) {
                        Tile tl = (Tile) getTileObjectList().get(b);
                        if (tl.getX() == tco.getX() && tl.getY() == tco.getY()) {
                            tl.setTileVacancy(false);
                            break;
                        }
                    }
                    addObjectAnimation(tco.getX(), tco.getY(), 8, 20, true, 1);
                    break;
                }
            }
        }
    }

    public void setBroadCastQuit() {
        if(cmMachineType.equals("SERVER")) {
            cmc = new CMCommand("INGAME", "QUIT", "SERVER", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);  
            cmhcrt.clientBroadCastMessage(cmc);
        } else if(cmMachineType.equals("CLIENT")) {
            cmc = new CMCommand("INGAME", "QUIT", "CLIENT", playerName, "XD", "XD", "XD", "XD", "XD", "XD", null);
            cmscrt.clientBroadCastMessage(cmc); 
        }
    }
    
    public void setNetworkQuitServer() {
        JOptionPane pane = new JOptionPane("Host Disconnected!", JOptionPane.ERROR_MESSAGE);
        JDialog dialog = pane.createDialog("Error!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        
        cmMagicTD.dispose();
        cmMagicTDLobby.quitGame("CLIENT");
    }
    
    public void setNetworkQuitClient(String name) {
        System.out.println("name: " + name);
        if(player2.equals(name)) {
            player2 += " (DC)";
            System.out.println("pasok2");
        } else if(player3.equals(name)) {
            player3 += " (DC)";
            System.out.println("pasok3");
        } else if(player4.equals(name)) {
            player4 += " (DC)";
            System.out.println("pasok4");
        }
    }
    
    public void setBroadCastUpgradeTower(int type, int sX, int sY) {
        cmc = new CMCommand("UPGRADETOWER", Integer.toString(type), Integer.toString(sX), Integer.toString(sY), "XD", "XD", "XD", "XD", "XD", "XD", null);

        if (cmMachineType.equals("SERVER")) {
            cmsct.serverSecondaryBroadCastMessage(cmc);
        } else if (cmMachineType.equals("CLIENT")) {
            cmscrt.clientBroadCastMessage(cmc);
        }
    }

    public synchronized void setNetworkUpgradeTower(int type, int uX, int uY) {
        if (type == 1) {
            for (int a = 0; a < getTowerIceDropList().size(); a++) {
                TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
                if (tid.getX() == uX && tid.getY() == uY && !tid.getTowerOwner().equals(playerName)) {
                    if (tid.getTowerLevel() == 1) {
                        tid.setTowerLevel(2);
                        tid.setTowerUpgradeCost(500);
                        tid.setTowerDamage(75);
                        tid.setTowerAttackSpeed(200);
                        tid.setTowerRangeDeductor(130);
                        tid.setTowerRangeHeight(300);
                        tid.setTowerRangeWidth(300);
                        tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(13));
                    } else if (tid.getTowerLevel() == 2) {
                        tid.setTowerLevel(3);
                        tid.setTowerDamage(100);
                        tid.setTowerAttackSpeed(100);
                        tid.setTowerRangeDeductor(175);
                        tid.setTowerRangeHeight(400);
                        tid.setTowerRangeWidth(400);
                        tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(21));
                    }
                    break;
                }
            }
        } else if (type == 2) {
            for (int a = 0; a < getTowerIceList().size(); a++) {
                TowerIce ti = (TowerIce) getTowerIceList().get(a);
                if (ti.getX() == uX && ti.getY() == uY && !ti.getTowerOwner().equals(playerName)) {
                    if (ti.getTowerLevel() == 1) {
                        ti.setTowerLevel(2);
                        ti.setTowerUpgradeCost(250);
                        ti.setTowerDamage(45);
                        ti.setTowerAttackSpeed(500);
                        ti.setTowerRangeDeductor(130);
                        ti.setTowerRangeHeight(300);
                        ti.setTowerRangeWidth(300);
                        ti.setTowerImage((BufferedImage) getTowerIceImageList().get(1));
                    } else if (ti.getTowerLevel() == 2) {
                        ti.setTowerLevel(3);
                        ti.setTowerDamage(60);
                        ti.setTowerAttackSpeed(250);
                        ti.setTowerRangeDeductor(175);
                        ti.setTowerRangeHeight(400);
                        ti.setTowerRangeWidth(400);
                        ti.setTowerImage((BufferedImage) getTowerIceImageList().get(2));
                    }
                    break;
                }
            }
        } else if (type == 3) {
            for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
                TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
                if (tcb.getX() == uX && tcb.getY() == uY && !tcb.getTowerOwner().equals(playerName)) {
                    if (tcb.getTowerLevel() == 1) {
                         tcb.setTowerLevel(2);
                        tcb.setTowerUpgradeCost(1500);
                        tcb.setTowerDamage(150);
                        tcb.setTowerAttackSpeed(300);
                        tcb.setTowerRangeDeductor(130);
                        tcb.setTowerRangeHeight(300);
                        tcb.setTowerRangeWidth(300);
                        tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(12));
                    } else if (tcb.getTowerLevel() == 2) {
                        tcb.setTowerLevel(3);
                        tcb.setTowerDamage(400);
                        tcb.setTowerAttackSpeed(100);
                        tcb.setTowerRangeDeductor(175);
                        tcb.setTowerRangeHeight(400);
                        tcb.setTowerRangeWidth(400);
                        tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(20));
                    }
                    break;
                }
            }
        } else if (type == 4) {
            for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
                TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
                if (tcm.getX() == uX && tcm.getY() == uY && !tcm.getTowerOwner().equals(playerName)) {
                    if (tcm.getTowerLevel() == 1) {
                        tcm.setTowerLevel(2);
                        tcm.setTowerUpgradeCost(500);
                        tcm.setTowerDamage(40);
                        tcm.setTowerAttackSpeed(150);
                        tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(1));
                    } else if (tcm.getTowerLevel() == 2) {
                        tcm.setTowerLevel(3);
                        tcm.setTowerDamage(70);
                        tcm.setTowerAttackSpeed(100);
                        tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(2));
                    }
                    break;
                }
            }
        } else if (type == 5) {
            for (int a = 0; a < getTowerMentosList().size(); a++) {
                TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
                if (tm.getX() == uX && tm.getY() == uY && !tm.getTowerOwner().equals(playerName)) {
                    if (tm.getTowerLevel() == 1) {
                        tm.setTowerLevel(2);
                        tm.setTowerMaxTarget(5);
                        tm.setTowerUpgradeCost(2000);
                        tm.setTowerDamage(100);
                        tm.setTowerAttackSpeed(200);
                        tm.setTowerRangeDeductor(130);
                        tm.setTowerRangeHeight(300);
                        tm.setTowerRangeWidth(300);
                        tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(1));
                    } else if (tm.getTowerLevel() == 2) {
                        tm.setTowerLevel(3);
                        tm.setTowerMaxTarget(7);
                        tm.setTowerDamage(150);
                        tm.setTowerAttackSpeed(100);
                        tm.setTowerRangeDeductor(175);
                        tm.setTowerRangeHeight(400);
                        tm.setTowerRangeWidth(400);
                        tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(2));
                    }
                    break;
                }

            }
        } else if (type == 6) {
            for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
                TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
                if (tsid.getX() == uX && tsid.getY() == uY && !tsid.getTowerOwner().equals(playerName)) {
                    if (tsid.getTowerLevel() == 1) {
                        tsid.setTowerLevel(2);
                        tsid.setTowerUpgradeCost(1200);
                        tsid.setTowerDamage(6);
                        tsid.setTowerAttackSpeed(60);
                        tsid.setTowerRangeDeductor(130);
                        tsid.setTowerRangeHeight(300);
                        tsid.setTowerRangeWidth(300);
                        tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(13));
                    } else if (tsid.getTowerLevel() == 2) {
                        tsid.setTowerLevel(3);
                        tsid.setTowerDamage(8);
                        tsid.setTowerAttackSpeed(40);
                        tsid.setTowerRangeDeductor(175);
                        tsid.setTowerRangeHeight(400);
                        tsid.setTowerRangeWidth(400);
                        tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(21));
                    }
                    break;
                }
            }
        } else if (type == 7) {
            for (int a = 0; a < getTowerStickOList().size(); a++) {
                TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
                if (tco.getX() == uX && tco.getY() == uY && !tco.getTowerOwner().equals(playerName)) {
                    if (tco.getTowerLevel() == 1) {
                        tco.setTowerLevel(2);
                        tco.setTowerUpgradeCost(500);
                        tco.setTowerDamage(30);
                        tco.setTowerAttackSpeed(500);
                        tco.setTowerRangeDeductor(130);
                        tco.setTowerRangeHeight(300);
                        tco.setTowerRangeWidth(300);
                        tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(1));
                    } else if (tco.getTowerLevel() == 2) {
                       tco.setTowerLevel(3);
                        tco.setTowerDamage(50);
                        tco.setTowerAttackSpeed(400);
                        tco.setTowerRangeDeductor(175);
                        tco.setTowerRangeHeight(400);
                        tco.setTowerRangeWidth(400);
                        tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(2));
                    }
                    break;
                }
            }
        }
    }

    public void setBroadCastMainUpdateTower() {
        for (int a = 0; a < getTowerIceDropList().size(); a++) {
            TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
            cmc = new CMCommand("UPDATETOWER", Integer.toString(tid.getTowerType()), tid.getTowerOwner(), Integer.toString(tid.getX()), Integer.toString(tid.getY()), Integer.toString(tid.getTowerLevel()), "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
        
        for (int a = 0; a < getTowerIceList().size(); a++) {
            TowerIce ti = (TowerIce) getTowerIceList().get(a);
            cmc = new CMCommand("UPDATETOWER", Integer.toString(ti.getTowerType()), ti.getTowerOwner(), Integer.toString(ti.getX()), Integer.toString(ti.getY()), Integer.toString(ti.getTowerLevel()), "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
        
        for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
            TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
            cmc = new CMCommand("UPDATETOWER", Integer.toString(tcb.getTowerType()), tcb.getTowerOwner(), Integer.toString(tcb.getX()), Integer.toString(tcb.getY()), Integer.toString(tcb.getTowerLevel()), "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
        
        for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
            TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
            cmc = new CMCommand("UPDATETOWER", Integer.toString(tcm.getTowerType()), tcm.getTowerOwner(), Integer.toString(tcm.getX()), Integer.toString(tcm.getY()), Integer.toString(tcm.getTowerLevel()), "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
        
        for (int a = 0; a < getTowerMentosList().size(); a++) {
            TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
            cmc = new CMCommand("UPDATETOWER", Integer.toString(tm.getTowerType()), tm.getTowerOwner(), Integer.toString(tm.getX()), Integer.toString(tm.getY()), Integer.toString(tm.getTowerLevel()), "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
        
        for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
            TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
            cmc = new CMCommand("UPDATETOWER", Integer.toString(tsid.getTowerType()), tsid.getTowerOwner(), Integer.toString(tsid.getX()), Integer.toString(tsid.getY()), Integer.toString(tsid.getTowerLevel()), "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
        
        for (int a = 0; a < getTowerStickOList().size(); a++) {
            TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
            cmc = new CMCommand("UPDATETOWER", Integer.toString(tco.getTowerType()), tco.getTowerOwner(), Integer.toString(tco.getX()), Integer.toString(tco.getY()), Integer.toString(tco.getTowerLevel()), "XD", "XD", "XD", "XD", null);
            cmsct.serverMainBroadCastMessage(cmc);
        }
    }

    public synchronized void setNetworkMainUpdateTower(int type, String name, int sX, int sY, int sLvl) {
        if (!name.equals(playerName)) {
            if (type == 1) {
                for (int a = 0; a < getTowerIceDropList().size(); a++) {
                    TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
                    if (tid.getTowerOwner().equals(name) && tid.getX() == sX && tid.getY() == sY) {
                        if (tid.getTowerLevel() != sLvl) {
                            if (sLvl == 1) {
                                tid.setTowerLevel(1);
                                tid.setTowerUpgradeCost(400);
                                tid.setTowerDamage(50);
                                tid.setTowerAttackSpeed(300);
                                tid.setTowerRangeDeductor(75);
                                tid.setTowerRangeHeight(200);
                                tid.setTowerRangeWidth(200);
                                tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(5));
                            } else if (sLvl == 2) {
                                tid.setTowerLevel(2);
                                tid.setTowerUpgradeCost(500);
                                tid.setTowerDamage(75);
                                tid.setTowerAttackSpeed(200);
                                tid.setTowerRangeDeductor(130);
                                tid.setTowerRangeHeight(300);
                                tid.setTowerRangeWidth(300);
                                tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(13));
                            } else if (sLvl == 3) {
                                tid.setTowerLevel(3);
                                tid.setTowerDamage(100);
                                tid.setTowerAttackSpeed(100);
                                tid.setTowerRangeDeductor(175);
                                tid.setTowerRangeHeight(400);
                                tid.setTowerRangeWidth(400);
                                tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(21));
                            }
                        }
                        break;
                    }
                }
            } else if (type == 2) {
                for (int a = 0; a < getTowerIceList().size(); a++) {
                    TowerIce ti = (TowerIce) getTowerIceList().get(a);
                    if (ti.getTowerOwner().equals(name) && ti.getX() == sX && ti.getY() == sY) {
                        if (ti.getTowerLevel() != sLvl) {
                            if (sLvl == 1) {
                                ti.setTowerLevel(1);
                                ti.setTowerUpgradeCost(200);
                                ti.setTowerDamage(25);
                                ti.setTowerAttackSpeed(600);
                                ti.setTowerRangeDeductor(75);
                                ti.setTowerRangeHeight(200);
                                ti.setTowerRangeWidth(200);
                                ti.setTowerImage((BufferedImage) getTowerIceImageList().get(0));
                            } else if (sLvl == 2) {
                                ti.setTowerLevel(2);
                                ti.setTowerUpgradeCost(250);
                                ti.setTowerDamage(45);
                                ti.setTowerAttackSpeed(500);
                                ti.setTowerRangeDeductor(130);
                                ti.setTowerRangeHeight(300);
                                ti.setTowerRangeWidth(300);
                                ti.setTowerImage((BufferedImage) getTowerIceImageList().get(1));
                            } else if (sLvl == 3) {
                                ti.setTowerLevel(3);
                                ti.setTowerDamage(60);
                                ti.setTowerAttackSpeed(250);
                                ti.setTowerRangeDeductor(175);
                                ti.setTowerRangeHeight(400);
                                ti.setTowerRangeWidth(400);
                                ti.setTowerImage((BufferedImage) getTowerIceImageList().get(2));
                            }
                        }
                        break;
                    }
                }
            } else if (type == 3) {
                for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
                    TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
                    if (tcb.getTowerOwner().equals(name) && tcb.getX() == sX && tcb.getY() == sY) {
                        if (tcb.getTowerLevel() != sLvl) {
                            if (sLvl == 1) {
                                tcb.setTowerLevel(1);
                                tcb.setTowerUpgradeCost(500);
                                tcb.setTowerDamage(10);
                                tcb.setTowerAttackSpeed(400);
                                tcb.setTowerRangeDeductor(75);
                                tcb.setTowerRangeHeight(200);
                                tcb.setTowerRangeWidth(200);
                                tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(4));
                            } else if (sLvl == 2) {
                                tcb.setTowerLevel(2);
                                tcb.setTowerUpgradeCost(1500);
                                tcb.setTowerDamage(150);
                                tcb.setTowerAttackSpeed(300);
                                tcb.setTowerRangeDeductor(130);
                                tcb.setTowerRangeHeight(300);
                                tcb.setTowerRangeWidth(300);
                                tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(12));
                            } else if (sLvl == 3) {
                                tcb.setTowerLevel(3);
                                tcb.setTowerDamage(400);
                                tcb.setTowerAttackSpeed(100);
                                tcb.setTowerRangeDeductor(175);
                                tcb.setTowerRangeHeight(400);
                                tcb.setTowerRangeWidth(400);
                                tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(20));
                            }
                        }
                        break;
                    }
                }
            } else if (type == 4) {
                for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
                    TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
                    if (tcm.getTowerOwner().equals(name) && tcm.getX() == sX && tcm.getY() == sY) {
                        if (tcm.getTowerLevel() != sLvl) {
                            if (sLvl == 1) {
                                tcm.setTowerLevel(1);
                                tcm.setTowerUpgradeCost(500);
                                tcm.setTowerDamage(30);
                                tcm.setTowerAttackSpeed(200);
                                tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(0));
                            } else if (sLvl == 2) {
                                tcm.setTowerLevel(2);
                                tcm.setTowerUpgradeCost(500);
                                tcm.setTowerDamage(40);
                                tcm.setTowerAttackSpeed(150);
                                tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(1));
                            } else if (sLvl == 3) {
                                tcm.setTowerLevel(3);
                                tcm.setTowerDamage(70);
                                tcm.setTowerAttackSpeed(100);
                                tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(2));
                            }
                        }
                        break;
                    }
                }
            } else if (type == 5) {
                for (int a = 0; a < getTowerMentosList().size(); a++) {
                    TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
                    if (tm.getTowerOwner().equals(name) && tm.getX() == sX && tm.getY() == sY) {
                        if (tm.getTowerLevel() != sLvl) {
                            if (sLvl == 1) {
                                tm.setTowerLevel(1);
                                tm.setTowerMaxTarget(3);
                                tm.setTowerUpgradeCost(1000);
                                tm.setTowerDamage(90);
                                tm.setTowerAttackSpeed(300);
                                tm.setTowerRangeDeductor(75);
                                tm.setTowerRangeHeight(200);
                                tm.setTowerRangeWidth(200);
                                tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(0));
                            } else if (sLvl == 2) {
                                tm.setTowerLevel(2);
                                tm.setTowerMaxTarget(5);
                                tm.setTowerUpgradeCost(2000);
                                tm.setTowerDamage(100);
                                tm.setTowerAttackSpeed(200);
                                tm.setTowerRangeDeductor(130);
                                tm.setTowerRangeHeight(300);
                                tm.setTowerRangeWidth(300);
                                tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(1));
                            } else if (sLvl == 3) {
                                tm.setTowerLevel(3);
                                tm.setTowerMaxTarget(7);
                                tm.setTowerDamage(150);
                                tm.setTowerAttackSpeed(100);
                                tm.setTowerRangeDeductor(175);
                                tm.setTowerRangeHeight(400);
                                tm.setTowerRangeWidth(400);
                                tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(2));
                            }
                        }
                        break;
                    }
                }
            } else if (type == 6) {
                for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
                    TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
                    if (tsid.getTowerOwner().equals(name) && tsid.getX() == sX && tsid.getY() == sY) {
                        if (tsid.getTowerLevel() != sLvl) {
                            if (sLvl == 1) {
                                tsid.setTowerLevel(1);
                                tsid.setTowerUpgradeCost(1000);
                                tsid.setTowerDamage(4);
                                tsid.setTowerAttackSpeed(75);
                                tsid.setTowerRangeDeductor(75);
                                tsid.setTowerRangeHeight(200);
                                tsid.setTowerRangeWidth(200);
                                tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(5));
                            } else if (sLvl == 2) {
                                tsid.setTowerLevel(2);
                                tsid.setTowerUpgradeCost(1200);
                                tsid.setTowerDamage(6);
                                tsid.setTowerAttackSpeed(60);
                                tsid.setTowerRangeDeductor(130);
                                tsid.setTowerRangeHeight(300);
                                tsid.setTowerRangeWidth(300);
                                tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(13));
                            } else if (sLvl == 3) {
                                tsid.setTowerLevel(3);
                                tsid.setTowerDamage(8);
                                tsid.setTowerAttackSpeed(40);
                                tsid.setTowerRangeDeductor(175);
                                tsid.setTowerRangeHeight(400);
                                tsid.setTowerRangeWidth(400);
                                tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(21));
                            }
                        }
                        break;
                    }
                }
            } else if (type == 7) {
                for (int a = 0; a < getTowerStickOList().size(); a++) {
                    TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
                    if (tco.getTowerOwner().equals(name) && tco.getX() == sX && tco.getY() == sY) {
                        if (tco.getTowerLevel() != sLvl) {
                            if (sLvl == 1) {
                                tco.setTowerLevel(1);
                                tco.setTowerUpgradeCost(500);
                                tco.setTowerDamage(20);
                                tco.setTowerAttackSpeed(700);
                                tco.setTowerRangeDeductor(75);
                                tco.setTowerRangeHeight(200);
                                tco.setTowerRangeWidth(200);
                                tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(0));
                            } else if (sLvl == 2) {
                                tco.setTowerLevel(2);
                                tco.setTowerUpgradeCost(500);
                                tco.setTowerDamage(30);
                                tco.setTowerAttackSpeed(500);
                                tco.setTowerRangeDeductor(130);
                                tco.setTowerRangeHeight(300);
                                tco.setTowerRangeWidth(300);
                                tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(1));
                            } else if (sLvl == 3) {
                                tco.setTowerLevel(3);
                                tco.setTowerDamage(50);
                                tco.setTowerAttackSpeed(400);
                                tco.setTowerRangeDeductor(175);
                                tco.setTowerRangeHeight(400);
                                tco.setTowerRangeWidth(400);
                                tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(2));
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public void setBroadCastClientUpdateTower() {
        for (int a = 0; a < getTowerIceDropList().size(); a++) {
            TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
            if (tid.getTowerOwner().equals(playerName)) {
                cmc = new CMCommand("UPDATETOWER", Integer.toString(tid.getTowerType()), tid.getTowerOwner(), Integer.toString(tid.getX()), Integer.toString(tid.getY()), Integer.toString(tid.getTowerLevel()), "XD", "XD", "XD", "XD", null);
                cmscrt.clientBroadCastMessage(cmc);
            }
        }

        for (int a = 0; a < getTowerIceList().size(); a++) {
            TowerIce ti = (TowerIce) getTowerIceList().get(a);
            if (ti.getTowerOwner().equals(playerName)) {
                cmc = new CMCommand("UPDATETOWER", Integer.toString(ti.getTowerType()), ti.getTowerOwner(), Integer.toString(ti.getX()), Integer.toString(ti.getY()), Integer.toString(ti.getTowerLevel()), "XD", "XD", "XD", "XD", null);
                cmscrt.clientBroadCastMessage(cmc);
            }
        }

        for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
            TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
            if (tcb.getTowerOwner().equals(playerName)) {
                cmc = new CMCommand("UPDATETOWER", Integer.toString(tcb.getTowerType()), tcb.getTowerOwner(), Integer.toString(tcb.getX()), Integer.toString(tcb.getY()), Integer.toString(tcb.getTowerLevel()), "XD", "XD", "XD", "XD", null);
                cmscrt.clientBroadCastMessage(cmc);
            }
        }

        for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
            TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
            if (tcm.getTowerOwner().equals(playerName)) {
                cmc = new CMCommand("UPDATETOWER", Integer.toString(tcm.getTowerType()), tcm.getTowerOwner(), Integer.toString(tcm.getX()), Integer.toString(tcm.getY()), Integer.toString(tcm.getTowerLevel()), "XD", "XD", "XD", "XD", null);
                cmscrt.clientBroadCastMessage(cmc);
            }
        }

        for (int a = 0; a < getTowerMentosList().size(); a++) {
            TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
            if (tm.getTowerOwner().equals(playerName)) {
                cmc = new CMCommand("UPDATETOWER", Integer.toString(tm.getTowerType()), tm.getTowerOwner(), Integer.toString(tm.getX()), Integer.toString(tm.getY()), Integer.toString(tm.getTowerLevel()), "XD", "XD", "XD", "XD", null);
                cmscrt.clientBroadCastMessage(cmc);
            }
        }

        for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
            TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
            if (tsid.getTowerOwner().equals(playerName)) {
                cmc = new CMCommand("UPDATETOWER", Integer.toString(tsid.getTowerType()), tsid.getTowerOwner(), Integer.toString(tsid.getX()), Integer.toString(tsid.getY()), Integer.toString(tsid.getTowerLevel()), "XD", "XD", "XD", "XD", null);
                cmscrt.clientBroadCastMessage(cmc);
            }
        }

        for (int a = 0; a < getTowerStickOList().size(); a++) {
            TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
            if (tco.getTowerOwner().equals(playerName)) {
                cmc = new CMCommand("UPDATETOWER", Integer.toString(tco.getTowerType()), tco.getTowerOwner(), Integer.toString(tco.getX()), Integer.toString(tco.getY()), Integer.toString(tco.getTowerLevel()), "XD", "XD", "XD", "XD", null);
                cmscrt.clientBroadCastMessage(cmc);
            }
        }
    }

    public synchronized void setNetworkClientUpdateTower(int type, String name, int sX, int sY, int sLvl) {
        if (type == 1) {
            for (int a = 0; a < getTowerIceDropList().size(); a++) {
                TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
                if (tid.getTowerOwner().equals(name) && tid.getX() == sX && tid.getY() == sY) {
                    if (tid.getTowerLevel() != sLvl) {
                        if (sLvl == 1) {
                            tid.setTowerLevel(1);
                            tid.setTowerUpgradeCost(400);
                            tid.setTowerDamage(50);
                            tid.setTowerAttackSpeed(300);
                            tid.setTowerRangeDeductor(75);
                            tid.setTowerRangeHeight(200);
                            tid.setTowerRangeWidth(200);
                            tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(5));
                        } else if (sLvl == 2) {
                            tid.setTowerLevel(2);
                            tid.setTowerUpgradeCost(500);
                            tid.setTowerDamage(75);
                            tid.setTowerAttackSpeed(200);
                            tid.setTowerRangeDeductor(130);
                            tid.setTowerRangeHeight(300);
                            tid.setTowerRangeWidth(300);
                            tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(13));
                        } else if (sLvl == 3) {
                            tid.setTowerLevel(3);
                            tid.setTowerDamage(100);
                            tid.setTowerAttackSpeed(100);
                            tid.setTowerRangeDeductor(175);
                            tid.setTowerRangeHeight(400);
                            tid.setTowerRangeWidth(400);
                            tid.setTowerImage((BufferedImage) getTowerIceDropImageList().get(21));
                        }
                    }
                    break;
                }
            }
        } else if (type == 2) {
            for (int a = 0; a < getTowerIceList().size(); a++) {
                TowerIce ti = (TowerIce) getTowerIceList().get(a);
                if (ti.getTowerOwner().equals(name) && ti.getX() == sX && ti.getY() == sY) {
                    if (ti.getTowerLevel() != sLvl) {
                        if (sLvl == 1) {
                            ti.setTowerLevel(1);
                            ti.setTowerUpgradeCost(200);
                            ti.setTowerDamage(25);
                            ti.setTowerAttackSpeed(600);
                            ti.setTowerRangeDeductor(75);
                            ti.setTowerRangeHeight(200);
                            ti.setTowerRangeWidth(200);
                            ti.setTowerImage((BufferedImage) getTowerIceImageList().get(0));
                        } else if (sLvl == 2) {
                            ti.setTowerLevel(2);
                            ti.setTowerUpgradeCost(250);
                            ti.setTowerDamage(45);
                            ti.setTowerAttackSpeed(500);
                            ti.setTowerRangeDeductor(130);
                            ti.setTowerRangeHeight(300);
                            ti.setTowerRangeWidth(300);
                            ti.setTowerImage((BufferedImage) getTowerIceImageList().get(1));
                        } else if (sLvl == 3) {
                            ti.setTowerLevel(3);
                            ti.setTowerDamage(60);
                            ti.setTowerAttackSpeed(250);
                            ti.setTowerRangeDeductor(175);
                            ti.setTowerRangeHeight(400);
                            ti.setTowerRangeWidth(400);
                            ti.setTowerImage((BufferedImage) getTowerIceImageList().get(2));
                        }
                    }
                    break;
                }
            }
        } else if (type == 3) {
            for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
                TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
                if (tcb.getTowerOwner().equals(name) && tcb.getX() == sX && tcb.getY() == sY) {
                    if (tcb.getTowerLevel() != sLvl) {
                        if (sLvl == 1) {
                            tcb.setTowerLevel(1);
                            tcb.setTowerUpgradeCost(500);
                            tcb.setTowerDamage(10);
                            tcb.setTowerAttackSpeed(400);
                            tcb.setTowerRangeDeductor(75);
                            tcb.setTowerRangeHeight(200);
                            tcb.setTowerRangeWidth(200);
                            tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(4));
                        } else if (sLvl == 2) {
                            tcb.setTowerLevel(2);
                            tcb.setTowerUpgradeCost(1500);
                            tcb.setTowerDamage(150);
                            tcb.setTowerAttackSpeed(300);
                            tcb.setTowerRangeDeductor(130);
                            tcb.setTowerRangeHeight(300);
                            tcb.setTowerRangeWidth(300);
                            tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(12));
                        } else if (sLvl == 3) {
                            tcb.setTowerLevel(3);
                            tcb.setTowerDamage(400);
                            tcb.setTowerAttackSpeed(100);
                            tcb.setTowerRangeDeductor(175);
                            tcb.setTowerRangeHeight(400);
                            tcb.setTowerRangeWidth(400);
                            tcb.setTowerImage((BufferedImage) getTowerCherryBoltImageList().get(20));
                        }
                    }
                    break;
                }
            }
        } else if (type == 4) {
            for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
                TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
                if (tcm.getTowerOwner().equals(name) && tcm.getX() == sX && tcm.getY() == sY) {
                    if (tcm.getTowerLevel() != sLvl) {
                        if (sLvl == 1) {
                            tcm.setTowerLevel(1);
                            tcm.setTowerUpgradeCost(500);
                            tcm.setTowerDamage(30);
                            tcm.setTowerAttackSpeed(200);
                            tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(0));
                        } else if (sLvl == 2) {
                            tcm.setTowerLevel(2);
                            tcm.setTowerUpgradeCost(500);
                            tcm.setTowerDamage(40);
                            tcm.setTowerAttackSpeed(150);
                            tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(1));
                        } else if (sLvl == 3) {
                            tcm.setTowerLevel(3);
                            tcm.setTowerDamage(70);
                            tcm.setTowerAttackSpeed(100);
                            tcm.setTowerImage((BufferedImage) getTowerCandyMachineImageList().get(2));
                        }
                    }
                    break;
                }
            }
        } else if (type == 5) {
            for (int a = 0; a < getTowerMentosList().size(); a++) {
                TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
                if (tm.getTowerOwner().equals(name) && tm.getX() == sX && tm.getY() == sY) {
                    if (tm.getTowerLevel() != sLvl) {
                        if (sLvl == 1) {
                            tm.setTowerLevel(1);
                            tm.setTowerMaxTarget(3);
                            tm.setTowerUpgradeCost(1000);
                            tm.setTowerDamage(90);
                            tm.setTowerAttackSpeed(300);
                            tm.setTowerRangeDeductor(75);
                            tm.setTowerRangeHeight(200);
                            tm.setTowerRangeWidth(200);
                            tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(0));
                        } else if (sLvl == 2) {
                            tm.setTowerLevel(2);
                            tm.setTowerMaxTarget(5);
                            tm.setTowerUpgradeCost(2000);
                            tm.setTowerDamage(100);
                            tm.setTowerAttackSpeed(200);
                            tm.setTowerRangeDeductor(130);
                            tm.setTowerRangeHeight(300);
                            tm.setTowerRangeWidth(300);
                            tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(1));
                        } else if (sLvl == 3) {
                            tm.setTowerLevel(3);
                            tm.setTowerMaxTarget(7);
                            tm.setTowerDamage(150);
                            tm.setTowerAttackSpeed(100);
                            tm.setTowerRangeDeductor(175);
                            tm.setTowerRangeHeight(400);
                            tm.setTowerRangeWidth(400);
                            tm.setTowerImage((BufferedImage) getTowerMentosImageList().get(2));
                        }
                    }
                    break;
                }
            }
        } else if (type == 6) {
            for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
                TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
                if (tsid.getTowerOwner().equals(name) && tsid.getX() == sX && tsid.getY() == sY) {
                    if (tsid.getTowerLevel() != sLvl) {
                        if (sLvl == 1) {
                            tsid.setTowerLevel(1);
                            tsid.setTowerUpgradeCost(1000);
                            tsid.setTowerDamage(4);
                            tsid.setTowerAttackSpeed(75);
                            tsid.setTowerRangeDeductor(75);
                            tsid.setTowerRangeHeight(200);
                            tsid.setTowerRangeWidth(200);
                            tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(5));
                        } else if (sLvl == 2) {
                            tsid.setTowerLevel(2);
                            tsid.setTowerUpgradeCost(1200);
                            tsid.setTowerDamage(6);
                            tsid.setTowerAttackSpeed(60);
                            tsid.setTowerRangeDeductor(130);
                            tsid.setTowerRangeHeight(300);
                            tsid.setTowerRangeWidth(300);
                            tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(13));
                        } else if (sLvl == 3) {
                            tsid.setTowerLevel(3);
                            tsid.setTowerDamage(8);
                            tsid.setTowerAttackSpeed(40);
                            tsid.setTowerRangeDeductor(175);
                            tsid.setTowerRangeHeight(400);
                            tsid.setTowerRangeWidth(400);
                            tsid.setTowerImage((BufferedImage) getTowerSingleIceDropImageList().get(21));
                        }
                    }
                    break;
                }
            }
        } else if (type == 7) {
            for (int a = 0; a < getTowerStickOList().size(); a++) {
                TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
                if (tco.getTowerOwner().equals(name) && tco.getX() == sX && tco.getY() == sY) {
                    if (tco.getTowerLevel() != sLvl) {
                        if (sLvl == 1) {
                            tco.setTowerLevel(1);
                            tco.setTowerUpgradeCost(500);
                            tco.setTowerDamage(20);
                            tco.setTowerAttackSpeed(700);
                            tco.setTowerRangeDeductor(75);
                            tco.setTowerRangeHeight(200);
                            tco.setTowerRangeWidth(200);
                            tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(0));
                        } else if (sLvl == 2) {
                            tco.setTowerLevel(2);
                            tco.setTowerUpgradeCost(500);
                            tco.setTowerDamage(30);
                            tco.setTowerAttackSpeed(500);
                            tco.setTowerRangeDeductor(130);
                            tco.setTowerRangeHeight(300);
                            tco.setTowerRangeWidth(300);
                            tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(1));
                        } else if (sLvl == 3) {
                            tco.setTowerLevel(3);
                            tco.setTowerDamage(50);
                            tco.setTowerAttackSpeed(400);
                            tco.setTowerRangeDeductor(175);
                            tco.setTowerRangeHeight(400);
                            tco.setTowerRangeWidth(400);
                            tco.setTowerImage((BufferedImage) getTowerStickOImageList().get(2));
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public void setNetworkMiniMapSignal(int x, int y) {
        signalX = ((x * 180) / 3350) + 5;
        signalY = ((y * 180) / 3350) + 570;
        signalStart = 133;
        initSignalTimer();
        isSignal = true;
        signalTimer.start();
    }
    
    public void initSignalTimer() {
        signalTimer = new Timer(15, new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if(signalStart < 0) {
                   isSignal = false;
                   signalTimer.stop();
               }
               signalStart--;
           } 
        });
    }
    
    public void setBroadCastSignalMiniMap() {
        cmc = new CMCommand("INGAME", "MMSIGNAL", Integer.toString(finalMouseX), Integer.toString(finalMouseY), "XD", "XD", "XD", "XD", "XD", "XD", null);
        
        if(cmMachineType.equals("SERVER")) {
            cmhcrt.clientBroadCastMessage(cmc);
        } else if(cmMachineType.equals("CLIENT")) {
            cmscrt.clientBroadCastMessage(cmc);
        }
    }
    
    public void setBroadCastFinishGame(String finishType) {
        cmc = new CMCommand("INGAME", "FINISH", finishType, "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
        cmhcrt.clientBroadCastMessage(cmc);
    }
    
    public void setNetworkFinishGame(String finishType) {
        if(finishType.equals("WIN")) {
            onPlaySoundClip(16);
            
            stopThread();
            cmMagicTD.dispose();
            cmMagicTDLobby.finishGame(cmMachineType);
            
            JOptionPane pane = new JOptionPane("You Are Victorious!", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog("CandyMagicTD Says!");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } else if(finishType.equals("LOSE")) {
            onPlaySoundClip(17);
            onPlaySoundClip(18);
            
            stopThread();
            cmMagicTD.dispose();
            cmMagicTDLobby.finishGame(cmMachineType);
            
            JOptionPane pane = new JOptionPane("Game Over!", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog("CandyMagicTD Says!");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }
    
    public void setBroadCastClientPlayerName() {
        cmc = new CMCommand("PLAYERNAME", playerName, "XD", "XD", "XD", "XD", "XD", "XD", "XD", "XD", null);
        cmscrt.clientBroadCastMessage(cmc);   
    }
    
    public synchronized void setNetworkClientPlayerName(String name) {
        if (player2.equals("-")) {
            player2 = name;
        } else if (player3.equals("-")) {
            player3 = name;
        } else if (player4.equals("-")) {
            player4 = name;
        }
    }
    
    public void setBroadCastServerPlayerName() {
        cmc = new CMCommand("PLAYERNAME", player1, player2, player3, player4, "XD", "XD", "XD", "XD", "XD", null);
        cmsct.serverMainBroadCastMessage(cmc);
    }
    
    public synchronized void setNetworkServerPlayerName(String n1, String n2, String n3, String n4) {
        player1 = n1;
        player2 = n2;
        player3 = n3;
        player4 = n4;
    }
    
    public synchronized void setGameFlushOut(int cwn, int candyLife) {
        getCreepEggList().clear();
        getCreepBigEggList().clear();
        getCreepRageEggList().clear();
        getCreepBlackAntList().clear();
        getCreepRedAntList().clear();
        getCreepRatList().clear();
        getCreepButterflyList().clear();
        getCreepBeeList().clear();
        creepInside = cwn;
        candyCastle.setCastleCurrentHp(candyLife);
        for (int a = 0; a < getTowerIceDropList().size(); a++) {
            TowerIceDrop tid = (TowerIceDrop) getTowerIceDropList().get(a);
            tid.setCreepEggTarget(null);
            tid.setCreepBigEggTarget(null);
            tid.setCreepRageEggTarget(null);
            tid.setCreepBlackAntTarget(null);
            tid.setCreepRedAntTarget(null);
            tid.setCreepRatTarget(null);
            tid.setCreepButterflyTarget(null);
            tid.setCreepBeeTarget(null);
            tid.setCreepBoxerAntTarget(null);
            tid.setCreepSpearmanAntTarget(null);
            tid.setCreepSwordsmanAntTarget(null);
            tid.setCreepKingAntTarget(null);
            tid.setTowerShootingStatus(false);
        }

        for (int a = 0; a < getTowerIceList().size(); a++) {
            TowerIce ti = (TowerIce) getTowerIceList().get(a);
            ti.setCreepEggTarget(null);
            ti.setCreepBigEggTarget(null);
            ti.setCreepRageEggTarget(null);
            ti.setCreepBlackAntTarget(null);
            ti.setCreepRedAntTarget(null);
            ti.setCreepRatTarget(null);
            ti.setCreepButterflyTarget(null);
            ti.setCreepBeeTarget(null);
            ti.setCreepBoxerAntTarget(null);
            ti.setCreepSpearmanAntTarget(null);
            ti.setCreepSwordsmanAntTarget(null);
            ti.setCreepKingAntTarget(null);
            ti.setTowerShootingStatus(false);
        }

        for (int a = 0; a < getTowerCherryBoltList().size(); a++) {
            TowerCherryBolt tcb = (TowerCherryBolt) getTowerCherryBoltList().get(a);
            tcb.setCreepEggTarget(null);
            tcb.setCreepBigEggTarget(null);
            tcb.setCreepRageEggTarget(null);
            tcb.setCreepBlackAntTarget(null);
            tcb.setCreepRedAntTarget(null);
            tcb.setCreepRatTarget(null);
            tcb.setCreepButterflyTarget(null);
            tcb.setCreepBeeTarget(null);
            tcb.setCreepBoxerAntTarget(null);
            tcb.setCreepSpearmanAntTarget(null);
            tcb.setCreepSwordsmanAntTarget(null);
            tcb.setCreepKingAntTarget(null);
            tcb.setTowerShootingStatus(false);
        }

        for (int a = 0; a < getTowerCandyMachineList().size(); a++) {
            TowerCandyMachine tcm = (TowerCandyMachine) getTowerCandyMachineList().get(a);
            tcm.setCreepEggTarget(null);
            tcm.setCreepBigEggTarget(null);
            tcm.setCreepRageEggTarget(null);
            tcm.setCreepBlackAntTarget(null);
            tcm.setCreepRedAntTarget(null);
            tcm.setCreepRatTarget(null);
            tcm.setCreepButterflyTarget(null);
            tcm.setCreepBeeTarget(null);
            tcm.setCreepBoxerAntTarget(null);
            tcm.setCreepSpearmanAntTarget(null);
            tcm.setCreepSwordsmanAntTarget(null);
            tcm.setCreepKingAntTarget(null);
            tcm.setTowerShootingStatus(false);
        }

        for (int a = 0; a < getTowerMentosList().size(); a++) {
            TowerMentos tm = (TowerMentos) getTowerMentosList().get(a);
            tm.setCreepEggTarget(null);
            tm.setCreepBigEggTarget(null);
            tm.setCreepRageEggTarget(null);
            tm.setCreepBlackAntTarget(null);
            tm.setCreepRedAntTarget(null);
            tm.setCreepRatTarget(null);
            tm.setCreepButterflyTarget(null);
            tm.setCreepBeeTarget(null);
            tm.setCreepBoxerAntTarget(null);
            tm.setCreepSpearmanAntTarget(null);
            tm.setCreepSwordsmanAntTarget(null);
            tm.setCreepKingAntTarget(null);
            tm.setTowerShootingStatus(false);
        }

        for (int a = 0; a < getTowerSingleIceDropList().size(); a++) {
            TowerSingleIceDrop tsid = (TowerSingleIceDrop) getTowerSingleIceDropList().get(a);
            tsid.setCreepEggTarget(null);
            tsid.setCreepBigEggTarget(null);
            tsid.setCreepRageEggTarget(null);
            tsid.setCreepBlackAntTarget(null);
            tsid.setCreepRedAntTarget(null);
            tsid.setCreepRatTarget(null);
            tsid.setCreepButterflyTarget(null);
            tsid.setCreepBeeTarget(null);
            tsid.setCreepBoxerAntTarget(null);
            tsid.setCreepSpearmanAntTarget(null);
            tsid.setCreepSwordsmanAntTarget(null);
            tsid.setCreepKingAntTarget(null);
            tsid.setTowerShootingStatus(false);
        }

        for (int a = 0; a < getTowerStickOList().size(); a++) {
            TowerStickO tco = (TowerStickO) getTowerStickOList().get(a);
            tco.setCreepEggTarget(null);
            tco.setCreepBigEggTarget(null);
            tco.setCreepRageEggTarget(null);
            tco.setCreepBlackAntTarget(null);
            tco.setCreepRedAntTarget(null);
            tco.setCreepRatTarget(null);
            tco.setCreepButterflyTarget(null);
            tco.setCreepBeeTarget(null);
            tco.setCreepBoxerAntTarget(null);
            tco.setCreepSpearmanAntTarget(null);
            tco.setCreepSwordsmanAntTarget(null);
            tco.setCreepKingAntTarget(null);
            tco.setTowerShootingStatus(false);
        }
    }

    public ArrayList getTileObjectList() {
        return tileObjectList;
    }

    public ArrayList getCastleImageList() {
        return castleImageList;
    }
    
    public ArrayList getTreeImageList() {
        return treeImageList;
    }

    public ArrayList getBushImageList() {
        return bushImageList;
    }

    public ArrayList getAnimationImageList() {
        return animationImageList;
    }

    public ArrayList getTowerGridImageList() {
        return towerGridImageList;
    }

    public ArrayList getTowerIceDropImageList() {
        return towerIceDropImageList;
    }

    public ArrayList getTowerIceImageList() {
        return towerIceImageList;
    }

    public ArrayList getTowerCherryBoltImageList() {
        return towerCherryBoltImageList;
    }

    public ArrayList getTowerCandyMachineImageList() {
        return towerCandyMachineImageList;
    }

    public ArrayList getTowerMentosImageList() {
        return towerMentosImageList;
    }

    public ArrayList getTowerSingleIceDropImageList() {
        return towerSingleIceDropImageList;
    }

    public ArrayList getTowerStickOImageList() {
        return towerStickOImageList;
    }

    public ArrayList getCreepImageList() {
        return creepImageList;
    }

    public ArrayList getBulletImageList() {
        return bulletImageList;
    }

    public ArrayList getTowerHudImageList() {
        return towerHudImageList;
    }

    public ArrayList getTowerHudButtonImageList() {
        return towerHudButtonImageList;
    }
    
    public ArrayList getWaveNoImageList() {
        return waveNoImageList;
    }
    
    public ArrayList getWaveNoTagImageList() {
        return waveNoTagImageList;
    }
    
    public Castle getCandyCastle() {
        return candyCastle;
    }

    public ArrayList getTreeObjectList() {
        return treeObjectList;
    }

    public ArrayList getBushObjectList() {
        return bushObjectList;
    }

    public ArrayList getTowerIceDropList() {
        return towerIceDropList;
    }

    public ArrayList getTowerIceList() {
        return towerIceList;
    }

    public ArrayList getTowerCherryBoltList() {
        return towerCherryBoltList;
    }

    public ArrayList getTowerCandyMachineList() {
        return towerCandyMachineList;
    }

    public ArrayList getTowerMentosList() {
        return towerMentosList;
    }

    public ArrayList getTowerSingleIceDropList() {
        return towerSingleIceDropList;
    }

    public ArrayList getTowerStickOList() {
        return towerStickOList;
    }

    public ArrayList getCreepEggList() {
        return creepEggList;
    }

    public ArrayList getCreepBigEggList() {
        return creepBigEggList;
    }

    public ArrayList getCreepRageEggList() {
        return creepRageEggList;
    }

    public ArrayList getCreepBlackAntList() {
        return creepBlackAntList;
    }

    public ArrayList getCreepRedAntList() {
        return creepRedAntList;
    }

    public ArrayList getCreepRatList() {
        return creepRatList;
    }

    public ArrayList getCreepButterflyList() {
        return creepButterflyList;
    }

    public ArrayList getCreepBeeList() {
        return creepBeeList;
    }

    public ArrayList getCreepBoxerAntList() {
        return creepBoxerAntList;
    }

    public ArrayList getCreepSpearmanAntList() {
        return creepSpearmanAntList;
    }

    public ArrayList getCreepSwordsmanAntList() {
        return creepSwordsmanAntList;
    }

    public ArrayList getCreepKingAntList() {
        return creepKingAntList;
    }

    public ArrayList getBulletTIDList() {
        return bulletTIDList;
    }

    public ArrayList getBulletTIList() {
        return bulletTIList;
    }

    public ArrayList getBulletCBList() {
        return bulletCBList;
    }

    public ArrayList getBulletCMList() {
        return bulletCMList;
    }

    public ArrayList getBulletMList() {
        return bulletMList;
    }

    public ArrayList getBulletSIDList() {
        return bulletSIDList;
    }

    public ArrayList getBulletSOList() {
        return bulletSOList;
    }

    public ArrayList getObjectAnimationList() {
        return objectAnimationList;
    }

    public void setCreepCounterForWave(int crp) {
        creepCountForWave = crp;
    }

    public int getCreepCountForWave() {
        return creepCountForWave;
    }

    public int getCreepInside() {
        return creepInside;
    }

    public ArrayList getTreeList() {
        return treeObjectList;
    }

    public ArrayList getBushList() {
        return bushObjectList;
    }
}
