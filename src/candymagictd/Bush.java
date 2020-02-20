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
public class Bush {
    int doodadID;
    int imageID;
    int bX;
    int bY;
    BufferedImage bushImage;
    
    public Bush(int did, int iid, int x, int y, BufferedImage bImage){
        setDoodadID(did);
        setImageID(iid);
        setX(x);
        setY(y);
        setImage(bImage);
    }
    
    public void setDoodadID(int id) {
        doodadID = id;
    }
    
    public int getDoodadID() {
        return doodadID;
    }
    
    public void setImageID(int id) {
        imageID = id;
    }
    
    public int getImageID() {
        return imageID;
    }
    
    public void setX(int x) {
        bX = x;
    }
    
    public int getX() {
        return bX;
    }
    
    public void setY(int y) {
        bY = y;
    }
    
    public int getY() {
        return bY;
    }
    
    public void setImage(BufferedImage bImg) {
        bushImage = bImg;
    }
    
    public BufferedImage getImage() {
        return bushImage;
    }
}
