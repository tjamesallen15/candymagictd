/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author JamesAllen
 */
public class CMSound {

    Random soundRandomizer = new Random();
    int soundInteger;
    AudioStream cmSoundAudio;
    InputStream cmSoundFile;

    public void cmSoundBuildPlacement() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\build\\soundBuildPlacement.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTIDLaunch() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\icedrop\\soundTIDLaunch.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTILaunch() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\ice\\soundTILaunch.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTIHit() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\ice\\soundTIHit.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTCBLaunch() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\cherrybolt\\soundTCBLaunch.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTCBHit() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\cherrybolt\\soundTCBHit.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTCMLaunch() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\candymachine\\soundTCMLaunch.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTCMHit() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\candymachine\\soundTCMHit.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTMLaunch() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\mentos\\soundTMLaunch.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTSIDLaunch() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\singleicedrop\\soundTSIDLaunch.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTCOLaunch() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\sticko\\soundTCOLaunch.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundTCOHit() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\sticko\\soundTCOHit.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundNotEnoughGold() {
        soundInteger = soundRandomizer.nextInt(3);
        try {
            if (soundInteger == 0) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\NotEnoughGold1.wav");
            } else if (soundInteger == 1) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\NotEnoughGold2.wav");
            } else if (soundInteger == 2) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\NotEnoughGold3.wav");
            }
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundUnderAttack() {
        soundInteger = soundRandomizer.nextInt(5);
        try {
            if (soundInteger == 0) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\UnderAttack1.wav");
            } else if (soundInteger == 1) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\UnderAttack2.wav");
            } else if (soundInteger == 2) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\UnderAttack3.wav");
            } else if (soundInteger == 3) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\UnderAttack4.wav");
            } else if (soundInteger == 4) {
                cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\UnderAttack5.wav");
            }
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cmSoundSignal() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\Signal.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cmSoundCandysteinVictory() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\CandysteinVictory.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cmSoundInsectoVictory() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\InsectVictory.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cmSoundKingCandylonz() {
        try {
            cmSoundFile = new FileInputStream("objects\\sounds\\dialogue\\SadDialogue.wav");
            cmSoundAudio = new AudioStream(cmSoundFile);
            AudioPlayer.player.start(cmSoundAudio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
