/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author JamesAllen
 */
public class Castle {
    private int castleX;
    private int castleY;
    private int castleWidth;
    private int castleHeight;
    private int castleMaxHp;
    private int castleCurrentHp;
    private BufferedImage castleImage;
    
    public Castle(int cx, int cy, int hp, BufferedImage castleImg) {
        setX(cx);
        setY(cy);
        setCastleMaxHp(hp);
        setCastleCurrentHp(hp);
        setCastleImage(castleImg);
    }
    
    public void setX(int x) {
        castleX = x;
    }
    
    public int getX() {
        return castleX;
    }
    
    public void setY(int y) {
        castleY = y;
    }   
    
    public int getY() {
        return castleY;
    }
    
    public void setCastleMaxHp(int hp) {
        castleMaxHp = hp;
    }
    
    public int getCastleMaxHp() {
        return castleMaxHp;
    }
    
    public void setCastleCurrentHp(int hp) {
        castleCurrentHp = hp;
    }
    
    public int getCastleCurrentHp() {
        return castleCurrentHp;
    }
    
    public Rectangle getCastleRectangle() {
        return new Rectangle(castleX, castleY, castleWidth, castleHeight);
    }
    
    public void setCastleImage(BufferedImage ci) {
        castleImage = ci;
        castleWidth = castleImage.getWidth();
        castleHeight = castleImage.getHeight();
    }
    
    public BufferedImage getCastleImage() {
        return castleImage;
    }
}
