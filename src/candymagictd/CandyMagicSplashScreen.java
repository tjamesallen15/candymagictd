/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author JamesAllen
 */
public class CandyMagicSplashScreen extends JFrame {

    Timer cmTimer;
    int cmTimerInteger = 0;

    public CandyMagicSplashScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image imageCursor = tk.getImage("objects\\cursor\\cmCursor.png");
        Cursor cmCursor = tk.createCustomCursor(imageCursor, new Point(0, 0), "Custom Cursor");
        this.setCursor(cmCursor);
        setUndecorated(true);
        initComponents();
        setTitle("Candy Magic TD");
        setVisible(true);
        try {
            lblSplashScreen.setIcon(new ImageIcon(ImageIO.read(new File("objects\\splashscreen\\Hailstorm Entertainment.png"))));
        } catch (Exception ex) {
            System.out.println("Exception Message: " + ex.getMessage());
        }
        loadCandyMagicTimer();
        cmTimer.start();
    }

    public final void loadCandyMagicTimer() {
        cmTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmTimerInteger == 5) {
                    try {
                        lblSplashScreen.setIcon(new ImageIcon(ImageIO.read(new File("objects\\splashscreen\\CMMainSplashScreen.png"))));
                    } catch (Exception ex) {
                        System.out.println("Exception Message: " + ex.getMessage());
                    }
                } else if (cmTimerInteger == 10) {
                    cmTimer.stop();
                    new CandyMagicSplashScreenLobby();
                    splashClose();
                }
                cmTimerInteger += 1;

            }
        });
    }
    
    public void splashClose() {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSplashScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSplashScreen.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSplashScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSplashScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSplashScreen;
    // End of variables declaration//GEN-END:variables
}
