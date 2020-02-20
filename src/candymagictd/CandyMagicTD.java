/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author JamesAllen
 */
public class CandyMagicTD extends JFrame {

    public CandyMagicTD(String pn, String cmmt, CMServerConnectorThread cms, CMMainServerReceiverThread rcmmsrt, CMMainClientReceiverThread rcmmcrt, CMSecondaryClientReceiverThread rcmscrt, CMHostReceiverThread rcmhcrt, CandyMagicTDLobby myLobby) {
        add(new CandyMagicPanel(pn, cmmt, cms, rcmmsrt, rcmmcrt, rcmscrt, rcmhcrt, myLobby, this));
        setTitle(cmmt);
        setUndecorated(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(1024, 768);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CandyMagicSplashScreen();
    }
}
