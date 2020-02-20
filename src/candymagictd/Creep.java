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
public class Creep {
    private int creepX;
    private int creepY;
    private int creepWidth;
    private int creepHeight;
    private int creepMaxHp;
    private int creepCurrentHp;
    private int creepMoveSpeed;
    private int creepMoveSpeedHolder;
    private int creepSpawnLocation;
    private int creepGoldBounty;
    private int creepGoldCoinX;
    private int creepGoldCoinY;
    private int creepAnimationFrame;
    private int creepStatusChillAilmentTime;
    private int creepStatusChillAilmentTimeCounter;
    private int creepStatusChillAilmentFactor;
    private int creepStatusPoisonAilmentTime;
    private int creepStatusPoisonAilmentTimeCounter;
    private int creepStatusPoisonAilmentFactor;
    private String creepStatusChillAilment;
    private String creepStatusPoisonAilment;
    private boolean creepCollideOnCastle;
    private boolean creepDetected;
    private boolean creepInvisibility;
    private boolean creepVisibility;
    private boolean stopX = false;
    private boolean stopY = false;
    private String creepKilledBy = "";
    
    private BufferedImage creepImage;
    public CandyMagicPanel candyMagicPanel;
    
    public void setX(int x) {
        creepX = x;
    }
    
    public int getX() {
        return creepX;
    }
    
    public void setY(int y) {
        creepY = y;
    }
    
    public int getY() {
        return creepY;
    }
    
    public void setCreepMaxHp(int hp) {
        creepMaxHp = hp;
    }
    
    public int getCreepMaxHp() {
        return creepMaxHp;
    }
    
    public void setCreepCurrentHp(int hp) {
        creepCurrentHp = hp;
    }
    
    public int getCreepCurrentHp() {
        return creepCurrentHp;
    }
    
    public void setCreepMoveSpeed(int ms) {
        creepMoveSpeed = ms;
    }
    
    public int getCreepMoveSpeed() {
        return creepMoveSpeed;
    }
    
    public void setCreepMoveSpeedHolder(int ms) {
        creepMoveSpeedHolder = ms;
    }
    
    public int getCreepMoveSpeedHolder() {
        return creepMoveSpeedHolder;
    }
    
    public void setCreepSpawnLocation(int sl) {
        creepSpawnLocation = sl;
    }
    
    public int getCreepSpawnLocation() {
        return creepSpawnLocation;
    }
    
    public void setCreepGoldBounty(int bounty) {
        creepGoldBounty = bounty;
    }
    
    public int getCreepGoldBounty() {
        return creepGoldBounty;
    }
    
    public void setCreepAnimation(int at) {
        creepAnimationFrame = at;
    }
    
    public int getCreepAnimation() {
        return creepAnimationFrame;
    }
    
    public void setCreepGoldCoinX(int cx) {
        creepGoldCoinX = cx;
    }
    
    public int getCreepGoldCoinX() {
        return creepGoldCoinX;
    }
    
    public void setCreepGoldCoinY(int cy) {
        creepGoldCoinY = cy;
    }
    
    public int getCreepGoldCoinY() {
        return creepGoldCoinY;
    }
    
    public void setCreepStatusChillAilmentTime(int cscat) {
        creepStatusChillAilmentTime = cscat;
    }
    
    public int getCreepStatusChillAilmentTime() {
        return creepStatusChillAilmentTime;
    }
    
    public void setCreepStatusChillAilmentTimeCounter(int cscatc) {
        creepStatusChillAilmentTimeCounter = cscatc;
    }
    
    public int getCreepStatusChillAilmentTimeCounter() {
        return creepStatusChillAilmentTimeCounter;
    }
    
    public void setCreepStatusChillAilmentFactor(int cscaf) {
        creepStatusChillAilmentFactor = cscaf;
    }
    
    public int getCreepStatusChillAilmentFactor() {
        return creepStatusChillAilmentFactor;
    }
    
    public void setCreepStatusChillAilment(String csca) {
        creepStatusChillAilment = csca;
    }
    
    public String getCreepStatusChillAilment() {
        return creepStatusChillAilment;
    }
    
    public void setCreepStatusPoisonAilmentTime(int cspat) {
        creepStatusPoisonAilmentTime = cspat;
    }
    
    public int getCreepStatusPoisonAilmentTime() {
        return creepStatusPoisonAilmentTime;
    }
    
    public void setCreepStatusPoisonAilmentTimeCounter(int cspatc) {
        creepStatusPoisonAilmentTimeCounter = cspatc;
    }
    
    public int getCreepStatusPoisonAilmentTimeCounter() {
        return creepStatusPoisonAilmentTimeCounter;
    }
    
    public void setCreepStatusPoisonAilmentFactor(int cspaf) {
        creepStatusPoisonAilmentFactor = cspaf;
    }
    
    public int getCreepStatusPoisonAilmentFactor() {
        return creepStatusPoisonAilmentFactor;
    }
    
    public void setCreepStatusPoisonAilment(String cspa) {
        creepStatusPoisonAilment = cspa;
    }
    
    public String getCreepStatusPoisonAilment() {
        return creepStatusPoisonAilment;
    }
    
    public Rectangle getCreepRectangle() {
        return new Rectangle(creepX, creepY, creepWidth, creepHeight);
    }
    
    public void setCreepCollideOnCastle(boolean collide) {
        creepCollideOnCastle = collide;
    }
    
    public boolean getCreepCollideOnCastle() {
        return creepCollideOnCastle;
    }
    
    public void setCreepDetection(boolean det) {
        creepDetected = det;
    }
    
    public boolean getCreepDetection() {
        return creepDetected;
    }
    
    public void setCreepInvisibility(boolean inv) {
        creepInvisibility = inv;
    }
    
    public boolean getCreepInvisibility() {
        return creepInvisibility;
    }
    
    public void setCreepVisibility() {
        if (creepCurrentHp > 0) {
            creepVisibility = true;
        } else {
            creepVisibility = false;
            setCreepGoldCoinX(getX());
            setCreepGoldCoinY(getY());
        }
    }
    
    public boolean getCreepVisibility() {
        return creepVisibility;
    }
    
    public void setStopX(boolean stop) {
        stopX = stop;
    }
    
    public boolean getStopX() {
        return stopX;
    }
    
    public void setStopY(boolean stop) {
        stopY = stop;
    }
    
    public boolean getStopY() {
        return stopY;
    }
    
    public void setCreepKilledBy(String name) {
        creepKilledBy = name;
    }
    
    public String getCreepKilledBy() {
        return creepKilledBy;
    }
    
    public void setCreepImage(BufferedImage creepImg) {
        creepImage = creepImg;
        creepWidth = creepImage.getWidth();
        creepHeight = creepImage.getHeight();
    }
    
    public BufferedImage getCreepImage() {
        return creepImage;
    }
    
    public void setCandyMagicPanel(CandyMagicPanel cmp) {
        candyMagicPanel = cmp;
    }
    
    public void creepStatusChillFreezeAilment() {
        if (getCreepStatusChillAilment().equals("NORMAL")) {
            setCreepMoveSpeed(getCreepMoveSpeedHolder());
        } else if (getCreepStatusChillAilment().equals("CHILL")) {
            if (getCreepStatusChillAilmentTimeCounter() <= getCreepStatusChillAilmentTime()) {
                setCreepStatusChillAilmentTimeCounter(getCreepStatusChillAilmentTimeCounter() + 10);
            } else {
                setCreepStatusChillAilmentTime(0);
                setCreepStatusChillAilmentTimeCounter(0);
                setCreepStatusChillAilmentFactor(0);
                setCreepStatusChillAilment("NORMAL");
            }
        } else if (getCreepStatusChillAilment().equals("FREEZE")) {
            if (getCreepStatusChillAilmentTimeCounter() <= getCreepStatusChillAilmentTime()) {
                setCreepStatusChillAilmentTimeCounter(getCreepStatusChillAilmentTimeCounter() + 10);
            } else {
                setCreepMoveSpeed(getCreepMoveSpeedHolder());
                setCreepStatusChillAilmentTime(0);
                setCreepStatusChillAilmentTimeCounter(0);
                setCreepStatusChillAilmentFactor(0);
                setCreepStatusChillAilment("NORMAL");
            }
        }
    }
    
    public void creepStatusPoisonAilment() {
        if (getCreepStatusPoisonAilment().equals("NORMAL")) {
            
        } else if (getCreepStatusPoisonAilment().equals("POISON")) {
            if (getCreepStatusPoisonAilmentTimeCounter() <= getCreepStatusPoisonAilmentTime()) {
                setCreepStatusPoisonAilmentTimeCounter(getCreepStatusPoisonAilmentTimeCounter() + 10);
                if (getCreepStatusPoisonAilmentTimeCounter() == 100 ||getCreepStatusPoisonAilmentTimeCounter() == 200 ||getCreepStatusPoisonAilmentTimeCounter() == 300 ||getCreepStatusPoisonAilmentTimeCounter() == 400 ||getCreepStatusPoisonAilmentTimeCounter() == 500) {
                    setCreepCurrentHp(getCreepCurrentHp() - getCreepStatusPoisonAilmentFactor());
                    candyMagicPanel.addObjectAnimation(getX() + (getCreepImage().getWidth() / 3), getY(), 3, 10, true, getCreepStatusPoisonAilmentFactor());
                }
                setCreepVisibility();
                if (getCreepVisibility() == false) {
                    candyMagicPanel.addObjectAnimation(getX() + (getCreepImage().getWidth() / 3), getY(), 1, 50, true, getCreepGoldBounty());
                }
            } else {
                setCreepStatusPoisonAilmentTime(0);
                setCreepStatusPoisonAilmentTimeCounter(0);
                setCreepStatusPoisonAilmentFactor(0);
                setCreepStatusPoisonAilment("NORMAL");
            }
        }
    }
    
    public void creepMovementAnimation() {
        Rectangle castleRectangle = candyMagicPanel.getCandyCastle().getCastleRectangle();
        Rectangle creepRectangle = getCreepRectangle();
        if (getCreepVisibility() == true) {
            if (creepRectangle.intersects(castleRectangle)) {
                candyMagicPanel.getCandyCastle().setCastleCurrentHp(candyMagicPanel.getCandyCastle().getCastleCurrentHp() - 1);
                setCreepCurrentHp(0);
                setCreepVisibility();
                setCreepCollideOnCastle(true);
            } else {
                if (getCreepSpawnLocation() == 1) {
                    if (getX() <= 275) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1025) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1075) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }  
                } else if (getCreepSpawnLocation() == 2) {
                    if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 3) {
                    if (getX() <= 1075) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1225) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 4) {
                    if (getY() <= 525) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 5) {
                    if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 6) {
                    if (getY() <= 1225) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 7) {
                    if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 8) {
                    if (getY() <= 525) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } 
                } else if (getCreepSpawnLocation() == 9) {
                    if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 10) {
                    if (getX() >= 2275) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 11) {
                    if (getX() >= 1700) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 12) {
                    if (getX() >= 2825) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1125 && getStopY() == false) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 2275) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                        setStopY(true);
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } 
                    else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 13) {
                    if (getX() >= 2275) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 2125 && getStopY() == false) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                        setStopY(true);
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 14) {
                    if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 15) {
                    if (getX() >= 3075) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 2325) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 2275) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } 
                } else if (getCreepSpawnLocation() == 16) {
                    if (getX() >= 2275) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 2125) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 17) {
                    if (getY() >= 2825) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 18) {
                    if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 19) {
                    if (getY() >= 2125) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() >= 1675) {
                        setX(getX() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 20) {
                    if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 21) {
                    if (getY() >= 2825) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 22) {
                    if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 23) {
                    if (getX() <= 1075) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 24) {
                    if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 25) {
                    if (getX() <= 1075) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() >= 1225 && getStopY() == false) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                        setStopY(true);
                    } else if (getY() <= 1675) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    }
                } else if (getCreepSpawnLocation() == 26) {
                    if (getX() <= 475) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getY() <= 2225 && getStopY() == false) {
                        setY(getY() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1075) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                        setStopY(true);
                    } else if (getY() >= 1675) {
                        setY(getY() - (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } else if (getX() <= 1675) {
                        setX(getX() + (getCreepMoveSpeed() - getCreepStatusChillAilmentFactor()));
                    } 
                }
            }
        }
    }
}

