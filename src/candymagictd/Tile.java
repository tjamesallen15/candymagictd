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
public class Tile {
    
    private int tileX;
    private int tileY;
    private boolean tileVacancy;
    private BufferedImage tileImage;
    private String tileType;
    
    public Tile(int tx, int ty, boolean vy, BufferedImage ti, String type) {
        setX(tx);
        setY(ty);
        setTileVacancy(vy);
        setTileImage(ti);
        setTileType(type);
    }
    
    public void setX(int x) {
        tileX = x;
    }
    
    public int getX() {
        return tileX;
    }
    
    public void setY(int y) {
        tileY = y;
    }
    
    public int getY() {
        return tileY;
    }
   
    public void setTileVacancy(boolean tv) {
        tileVacancy = tv;
    }
    
    public boolean getTileVacancy() {
        return tileVacancy;
    }
    
    public void setTileImage(BufferedImage bti) {
        tileImage = bti;
    }
    
    public BufferedImage getTileImage() {
        return tileImage;
    }

    public void setTileType(String type) {
        tileType = type;
    }

    public String getTileType() {
        return tileType;
    }

}
