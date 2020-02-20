/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.awt.image.BufferedImage;

/**
 *
 * @author JamesAllen
 */
public class ObjectAnimation {
    private int objectX;
    private int objectY;
    private int objectAnimationType;
    private int objectAnimationTime;
    private int objectAnimationCounter;
    private int objectLevelFactor;
    private boolean objectAnimationVisibility;
    private BufferedImage objectAnimationImage;
    
    public ObjectAnimation(int oax, int oay, int oat, int oac, boolean oavis, int level, BufferedImage oImg) {
        setX(oax);
        setY(oay);
        setObjectAnimationType(oat);
        setObjectAnimationTime(oac);
        setObjectAnimationCounter(0);
        setObjectAnimationVisibility(oavis);
        setObjectLevelFactor(level);
        setObjectAnimationImage(oImg);
    }
    
    public void setX(int x) {
        objectX = x;
    }
    
    public int getX() {
        return objectX;
    }
    
    public void setY(int y) {
        objectY = y;
    }
    
    public int getY() {
        return objectY;
    }
    
    public void setObjectAnimationType(int type) {
        objectAnimationType = type;
    }
    
    public int getObjectAnimationType() {
        return objectAnimationType;
    }
    
    public void setObjectAnimationTime(int time) {
        objectAnimationTime = time;
    }
    
    public int getObjectAnimationTime() {
        return objectAnimationTime;
    }
    
    public void setObjectAnimationCounter(int counter) {
        objectAnimationCounter = counter;
    }
    
    public int getObjectAnimationCounter() {
        return objectAnimationCounter;
    }
    
    public void setObjectLevelFactor(int factor) {
        objectLevelFactor = factor;
    }
    
    public int getObjectLevelFactor() {
        return objectLevelFactor;
    }
    
    public void setObjectAnimationVisibility(boolean oav) {
        objectAnimationVisibility = oav;
    }
    
    public boolean getObjectAnimationVisibility() {
        return objectAnimationVisibility;
    }
    
    public void setObjectAnimationImage(BufferedImage oImg) {
        objectAnimationImage = oImg;
    }
    
    public BufferedImage getObjectAnimationImage() {
        return objectAnimationImage;
    }
}
