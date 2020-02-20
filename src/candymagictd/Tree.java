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
public class Tree {
    int doodadID;
    int imageID;
    int tX;
    int tY;
    BufferedImage treeImage;
    
    public Tree(int did, int iid, int x, int y, BufferedImage tImage) {
        setDoodadID(did);
        setImageID(iid);
        setX(x);
        setY(y);
        setImage(tImage);
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
        tX = x;
    }
    
    public int getX() {
        return tX;
    }
    
    public void setY(int y) {
        tY = y;
    }
    
    public int getY() {
        return tY;
    }
    
    public void setImage(BufferedImage tImg) {
        treeImage = tImg;
    }
    
    public BufferedImage getImage() {
        return treeImage;
    }
}
