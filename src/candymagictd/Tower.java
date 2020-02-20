/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package candymagictd;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author JamesAllen
 */
public class Tower {

    private int towerX;
    private int towerY;
    private int towerType;
    private int towerLevel;
    private int towerMaxTarget;
    private int towerMaxTargetCounter;
    private int towerUpgradeCost;
    private int towerDamage;
    private int towerAttackSpeed;
    private int towerAttackSpeedCounter;
    private int towerAttackBleedFactor;
    private int towerRangeWidth;
    private int towerRangeHeight;
    private int towerRangeDeductor;
    private double deltaX;
    private double deltaY;
    private double angle;
    private boolean towerStatus;
    private boolean towerVisibility;
    private boolean towerShootingStatus;
    private boolean towerClicked;
    private int towerCriticalChance;
    private Random towerRandom = new Random();
    private BufferedImage towerImage;
    public CandyMagicPanel candyMagicPanel;
    private CreepEgg creepEggTarget;
    private CreepBigEgg creepBigEggTarget;
    private CreepRageEgg creepRageEggTarget;
    private CreepBlackAnt creepBlackAntTarget;
    private CreepRedAnt creepRedAntTarget;
    private CreepRat creepRatTarget;
    private CreepButterfly creepButterflyTarget;
    private CreepBee creepBeeTarget;
    private CreepBoxerAnt creepBoxerAntTarget;
    private CreepSpearmanAnt creepSpearmanAntTarget;
    private CreepSwordsmanAnt creepSwordsmanAntTarget;
    private CreepKingAnt creepKingAntTarget;
    private String towerOwner;
    
    public void setX(int tx) {
        towerX = tx;
    }

    public int getX() {
        return towerX;
    }

    public void setY(int ty) {
        towerY = ty;
    }

    public int getY() {
        return towerY;
    }

    public void setTowerType(int type) {
        towerType = type;
    }

    public int getTowerType() {
        return towerType;
    }

    public void setTowerLevel(int lv) {
        towerLevel = lv;
    }

    public int getTowerLevel() {
        return towerLevel;
    }

    public void setTowerMaxTarget(int target) {
        towerMaxTarget = target;
    }

    public int getTowerMaxTarget() {
        return towerMaxTarget;
    }

    public void setTowerMaxTargetCounter(int target) {
        towerMaxTargetCounter = target;
    }

    public int getTowerMaxTargetCounter() {
        return towerMaxTargetCounter;
    }

    public void setTowerUpgradeCost(int cost) {
        towerUpgradeCost = cost;
    }

    public int getTowerUpgradeCost() {
        return towerUpgradeCost;
    }

    public void setTowerDamage(int dmg) {
        towerDamage = dmg;
    }

    public int getTowerDamage() {
        return towerDamage;
    }

    public void setTowerAttackSpeed(int spd) {
        towerAttackSpeed = spd;
    }

    public int getTowerAttackSpeed() {
        return towerAttackSpeed;
    }

    public void setTowerAttackSpeedCounter(int ct) {
        towerAttackSpeedCounter = ct;
    }

    public int getTowerAttackSpeedCounter() {
        return towerAttackSpeedCounter;
    }

    public void setTowerAttackBleedFactor(int tabf) {
        towerAttackBleedFactor = tabf;
    }

    public int getTowerAttackBleedFactor() {
        return towerAttackBleedFactor;
    }

    public void setTowerRangeWidth(int trw) {
        towerRangeWidth = trw;
    }

    public int getTowerRangeWidth() {
        return towerRangeWidth;
    }

    public void setTowerRangeHeight(int trh) {
        towerRangeHeight = trh;
    }

    public int getTowerRangeHeight() {
        return towerRangeHeight;
    }

    public void setTowerRangeDeductor(int trd) {
        towerRangeDeductor = trd;
    }

    public int getTowerRangeDeductor() {
        return towerRangeDeductor;
    }

    public void setDeltaX(double x) {
        deltaX = x;
    }
    
    public double getDeltaX() {
        return deltaX;
    }
    
    public void setDeltaY(double y) {
        deltaY = y;
    }
    
    public double getDeltaY() {
        return deltaY;
    }
    
    public void setAngle(double agl) {
        angle = agl;
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void setTowerVisibility() {
        if (towerStatus == true) {
            towerVisibility = true;
        } else {
            towerVisibility = false;
        }
    }

    public boolean getTowerVisibility() {
        return towerVisibility;
    }

    public void setTowerStatus(boolean stat) {
        towerStatus = stat;
    }

    public boolean getTowerStatus() {
        return towerStatus;
    }

    public void setTowerShootingStatus(boolean st) {
        towerShootingStatus = st;
    }

    public boolean getTowerShootingStatus() {
        return towerShootingStatus;
    }

    public void setTowerClicked(boolean click) {
        towerClicked = click;
    }

    public boolean getTowerClicked() {
        return towerClicked;
    }

    public void setTowerImage(BufferedImage towerImg) {
        towerImage = towerImg;
    }

    public BufferedImage getTowerImage() {
        return towerImage;
    }

    public Rectangle getTowerRange() {
        return new Rectangle(getX() - getTowerRangeDeductor(), getY() - getTowerRangeDeductor(), getTowerRangeWidth(), getTowerRangeHeight());
    }

    public void setCandyMagicPanel(CandyMagicPanel cmp) {
        candyMagicPanel = cmp;
    }

    public void setCreepEggTarget(CreepEgg ce) {
        creepEggTarget = ce;
    }

    public CreepEgg getCreepEggTarget() {
        return creepEggTarget;
    }
        
    public void setCreepBigEggTarget(CreepBigEgg cbe) {
        creepBigEggTarget = cbe;
    }

    public CreepBigEgg getCreepBigEggTarget() {
        return creepBigEggTarget;
    }
    
    public void setCreepRageEggTarget(CreepRageEgg cre) {
        creepRageEggTarget = cre;
    }

    public CreepRageEgg getCreepRageEggTarget() {
        return creepRageEggTarget;
    }
    
    public void setCreepBlackAntTarget(CreepBlackAnt cba) {
        creepBlackAntTarget = cba;
    }

    public CreepBlackAnt getCreepBlackAntTarget() {
        return creepBlackAntTarget;
    }
    
    public void setCreepRedAntTarget(CreepRedAnt cra) {
        creepRedAntTarget = cra;
    }

    public CreepRedAnt getCreepRedAntTarget() {
        return creepRedAntTarget;
    }
    
    public void setCreepRatTarget(CreepRat cr) {
        creepRatTarget = cr;
    }

    public CreepRat getCreepRatTarget() {
        return creepRatTarget;
    }
    
    public void setCreepButterflyTarget(CreepButterfly cb) {
        creepButterflyTarget = cb;
    }

    public CreepButterfly getCreepButterflyTarget() {
        return creepButterflyTarget;
    }
    
    public void setCreepBeeTarget(CreepBee cbb) {
        creepBeeTarget = cbb;
    }

    public CreepBee getCreepBeeTarget() {
        return creepBeeTarget;
    }
    
    public void setCreepBoxerAntTarget(CreepBoxerAnt cba) {
        creepBoxerAntTarget = cba;
    }

    public CreepBoxerAnt getCreepBoxerAntTarget() {
        return creepBoxerAntTarget;
    }
    
    public void setCreepSpearmanAntTarget(CreepSpearmanAnt csa) {
        creepSpearmanAntTarget = csa;
    }

    public CreepSpearmanAnt getCreepSpearmanAntTarget() {
        return creepSpearmanAntTarget;
    }
    
    public void setCreepSwordsmanAntTarget(CreepSwordsmanAnt csa) {
        creepSwordsmanAntTarget = csa;
    }

    public CreepSwordsmanAnt getCreepSwordsmanAntTarget() {
        return creepSwordsmanAntTarget;
    }
    
    public void setCreepKingAntTarget(CreepKingAnt cka) {
        creepKingAntTarget = cka;
    }

    public CreepKingAnt getCreepKingAntTarget() {
        return creepKingAntTarget;
    }
    
    public void setTowerOwner(String owner) {
        towerOwner = owner;
    }
    
    public String getTowerOwner() {
        return towerOwner;
    }

    public void towerSingleEnemyDetection() {
        if (getTowerShootingStatus() == false) {
            Rectangle towerRange = getTowerRange();

            for (int a = 0; a < candyMagicPanel.getCreepEggList().size(); a++) {
                CreepEgg ce = (CreepEgg) candyMagicPanel.getCreepEggList().get(a);
                Rectangle creepEggRectangle = ce.getCreepRectangle();
                if (creepEggRectangle.intersects(towerRange) && ce.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepEggTarget(ce);
                    break;
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBigEggList().size(); a++) {
                CreepBigEgg cbe = (CreepBigEgg) candyMagicPanel.getCreepBigEggList().get(a);
                Rectangle creepBigEggRectangle = cbe.getCreepRectangle();
                if (creepBigEggRectangle.intersects(towerRange) && cbe.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepBigEggTarget(cbe);
                    break;
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRageEggList().size(); a++) {
                CreepRageEgg cre = (CreepRageEgg) candyMagicPanel.getCreepRageEggList().get(a);
                Rectangle creepRageEggRectangle = cre.getCreepRectangle();
                if (creepRageEggRectangle.intersects(towerRange) && cre.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepRageEggTarget(cre);
                    break;
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBlackAntList().size(); a++) {
                CreepBlackAnt cba = (CreepBlackAnt) candyMagicPanel.getCreepBlackAntList().get(a);
                Rectangle creepBlackAntRectangle = cba.getCreepRectangle();
                if (creepBlackAntRectangle.intersects(towerRange) && cba.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepBlackAntTarget(cba);
                    break;
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRedAntList().size(); a++) {
                CreepRedAnt cra = (CreepRedAnt) candyMagicPanel.getCreepRedAntList().get(a);
                Rectangle creepRedAntRectangle = cra.getCreepRectangle();
                if (creepRedAntRectangle.intersects(towerRange) && cra.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepRedAntTarget(cra);
                    break;
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRatList().size(); a++) {
                CreepRat cr = (CreepRat) candyMagicPanel.getCreepRatList().get(a);
                Rectangle creepRatRectangle = cr.getCreepRectangle();
                if (creepRatRectangle.intersects(towerRange) && cr.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepRatTarget(cr);
                    break;
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepButterflyList().size(); a++) {
                CreepButterfly cb = (CreepButterfly) candyMagicPanel.getCreepButterflyList().get(a);
                Rectangle creepButterflyRectangle = cb.getCreepRectangle();
                if (creepButterflyRectangle.intersects(towerRange) && cb.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepButterflyTarget(cb);
                    break;
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBeeList().size(); a++) {
                CreepBee cbb = (CreepBee) candyMagicPanel.getCreepBeeList().get(a);
                Rectangle creepBeeRectangle = cbb.getCreepRectangle();
                if (creepBeeRectangle.intersects(towerRange) && cbb.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepBeeTarget(cbb);
                    break;
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepBoxerAntList().size(); a++) {
                CreepBoxerAnt crba = (CreepBoxerAnt) candyMagicPanel.getCreepBoxerAntList().get(a);
                Rectangle creepBoxerAntRectangle = crba.getCreepRectangle();
                if (creepBoxerAntRectangle.intersects(towerRange) && crba.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepBoxerAntTarget(crba);
                    break;
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepSpearmanAntList().size(); a++) {
                CreepSpearmanAnt csa = (CreepSpearmanAnt) candyMagicPanel.getCreepSpearmanAntList().get(a);
                Rectangle creepSpearmanAntRectangle = csa.getCreepRectangle();
                if (creepSpearmanAntRectangle.intersects(towerRange) && csa.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepSpearmanAntTarget(csa);
                    break;
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepSwordsmanAntList().size(); a++) {
                CreepSwordsmanAnt crsa = (CreepSwordsmanAnt) candyMagicPanel.getCreepSwordsmanAntList().get(a);
                Rectangle creepSwordsmanAntRectangle = crsa.getCreepRectangle();
                if (creepSwordsmanAntRectangle.intersects(towerRange) && crsa.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepSwordsmanAntTarget(crsa);
                    break;
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepKingAntList().size(); a++) {
                CreepKingAnt cka = (CreepKingAnt) candyMagicPanel.getCreepKingAntList().get(a);
                Rectangle creepKingAntRectangle = cka.getCreepRectangle();
                if (creepKingAntRectangle.intersects(towerRange) && cka.getCreepVisibility() == true) {
                    setTowerShootingStatus(true);
                    setTowerAttackSpeedCounter(0);
                    setCreepKingAntTarget(cka);
                    break;
                }
            }
        }
    }

    public void towerAddBullet() {
        Rectangle towerRange = getTowerRange();
        if (getTowerShootingStatus() == true) {
            if (getCreepEggTarget() != null) {
                Rectangle creepEggRectangle = getCreepEggTarget().getCreepRectangle();
                if (creepEggRectangle.intersects(towerRange) && getCreepEggTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepEggTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepEggTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, getCreepEggTarget(), null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepEggTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepBigEggTarget() != null) {
                Rectangle creepEggRectangle = getCreepBigEggTarget().getCreepRectangle();
                if (creepEggRectangle.intersects(towerRange) && getCreepBigEggTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepBigEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepBigEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepBigEggTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepBigEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepBigEggTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepBigEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, getCreepBigEggTarget(), null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepBigEggTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepRageEggTarget() != null) {
                Rectangle creepEggRectangle = getCreepRageEggTarget().getCreepRectangle();
                if (creepEggRectangle.intersects(towerRange) && getCreepRageEggTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepRageEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepRageEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepRageEggTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepRageEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepRageEggTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepRageEggTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, getCreepRageEggTarget(), null, null, null, null, null, null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepRageEggTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepBlackAntTarget() != null) {
                Rectangle creepBlackAntRectangle = getCreepBlackAntTarget().getCreepRectangle();
                if (creepBlackAntRectangle.intersects(towerRange) && getCreepBlackAntTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepBlackAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepBlackAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepBlackAntTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepBlackAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepBlackAntTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepBlackAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, getCreepBlackAntTarget(), null, null, null, null, null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepBlackAntTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepRedAntTarget() != null) {
                Rectangle creepRedAntRectangle = getCreepRedAntTarget().getCreepRectangle();
                if (creepRedAntRectangle.intersects(towerRange) && getCreepRedAntTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepRedAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepRedAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepRedAntTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepRedAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepRedAntTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepRedAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, getCreepRedAntTarget(), null, null, null, null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepRedAntTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepRatTarget() != null) {
                Rectangle creepRatRectangle = getCreepRatTarget().getCreepRectangle();
                if (creepRatRectangle.intersects(towerRange) && getCreepRatTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepRatTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepRatTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepRatTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepRatTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepRatTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepRatTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, null, getCreepRatTarget(), null, null, null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepRatTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepButterflyTarget() != null) {
                Rectangle creepButterflyRectangle = getCreepButterflyTarget().getCreepRectangle();
                if (creepButterflyRectangle.intersects(towerRange) && getCreepButterflyTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepButterflyTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepButterflyTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepButterflyTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepButterflyTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepButterflyTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepButterflyTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, null, null, getCreepButterflyTarget(), null, null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepButterflyTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepBeeTarget() != null) {
                Rectangle creepBeeRectangle = getCreepBeeTarget().getCreepRectangle();
                if (creepBeeRectangle.intersects(towerRange) && getCreepBeeTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepBeeTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepBeeTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepBeeTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepBeeTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepBeeTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepBeeTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, null, null, null, getCreepBeeTarget(), null, null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepBeeTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepBoxerAntTarget() != null) {
                Rectangle creepBoxerAntRectangle = getCreepBoxerAntTarget().getCreepRectangle();
                if (creepBoxerAntRectangle.intersects(towerRange) && getCreepBoxerAntTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepBoxerAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepBoxerAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepBoxerAntTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepBoxerAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepBoxerAntTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepBoxerAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, null, null, null, null, getCreepBoxerAntTarget(), null, null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepBoxerAntTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepSpearmanAntTarget() != null) {
                Rectangle creepSpearmanAntRectangle = getCreepSpearmanAntTarget().getCreepRectangle();
                if (creepSpearmanAntRectangle.intersects(towerRange) && getCreepSpearmanAntTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepSpearmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepSpearmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepSpearmanAntTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepSpearmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepSpearmanAntTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepSpearmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, null, null, null, null, null, getCreepSpearmanAntTarget(), null, null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepSpearmanAntTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepSwordsmanAntTarget() != null) {
                Rectangle creepSwordsmanAntRectangle = getCreepSwordsmanAntTarget().getCreepRectangle();
                if (creepSwordsmanAntRectangle.intersects(towerRange) && getCreepSwordsmanAntTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, null, null, null, null, null, null, getCreepSwordsmanAntTarget(), null, getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepSwordsmanAntTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            } else if (getCreepKingAntTarget() != null) {
                Rectangle creepKingAntRectangle = getCreepKingAntTarget().getCreepRectangle();
                if (creepKingAntRectangle.intersects(towerRange) && getCreepKingAntTarget().getCreepVisibility() == true) {
                    if (getTowerType() == 1 && getCreepKingAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 1, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                        if (getTowerLevel() == 1 && getTowerAttackSpeed() >= 100) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 2 && getTowerAttackSpeed() >= 60) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        } else if (getTowerLevel() == 3 && getTowerAttackSpeed() >= 20) {
                            setTowerAttackSpeed(getTowerAttackSpeed() - 20);
                        }
                    } else if (getTowerType() == 2 && getCreepKingAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), (getY() - 15 + (getTowerImage().getHeight() / 2)), getTowerDamage(), 2, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                    } else if (getTowerType() == 3 && getCreepKingAntTarget().getCreepDetection() == true) {
                        towerCherryBoltDirectionAnimation();
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() - 15 + (getTowerImage().getWidth() / 2)), getY(), getTowerDamage(), 3, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                    } else if (getTowerType() == 4 && getCreepKingAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 2)), (getY() + (getTowerImage().getHeight() / 2)), getTowerDamage() + getTowerAttackBleedFactor(), 4, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                        if (getTowerLevel() == 1) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 30);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 40);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackBleedFactor(getTowerAttackBleedFactor() + 70);
                        }
                    } else if (getTowerType() == 6 && getCreepKingAntTarget().getCreepDetection() == true) {
                        towerCriticalChance = towerRandom.nextInt(100);
                        if (towerCriticalChance >= 75) {
                            if (getTowerLevel() == 1) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 40, 6, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 1);
                            } else if (getTowerLevel() == 2) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 50, 6, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 2);
                            } else if (getTowerLevel() == 3) {
                                candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage() * 60, 6, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                                candyMagicPanel.addObjectAnimation((getX() + getTowerImage().getWidth() / 3), getY(), 2, 50, true, 3);
                            }
                        } else {
                            candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 4)), (getY() + (getTowerImage().getHeight() / 4)), getTowerDamage(), 6, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                        }
                    } else if (getTowerType() == 7 && getCreepKingAntTarget().getCreepDetection() == true) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), (getX() + (getTowerImage().getWidth() / 3)), getY(), getTowerDamage(), 7, true, null, null, null, null, null, null, null, null, null, null, null, getCreepKingAntTarget(), getTowerOwner());
                    }
                } else {
                    setTowerAttackBleedFactor(0);
                    setTowerShootingStatus(false);
                    setCreepKingAntTarget(null);
                    if (getTowerType() == 1) {
                        if (getTowerLevel() == 1) {
                            setTowerAttackSpeed(300);
                        } else if (getTowerLevel() == 2) {
                            setTowerAttackSpeed(200);
                        } else if (getTowerLevel() == 3) {
                            setTowerAttackSpeed(100);
                        }
                    }
                }
            }
        }//
    }
    
    public void towerMultipleEnemyDetection() {
        Rectangle towerRange = getTowerRange();
        if (getTowerType() == 5) {
            for (int a = 0; a < candyMagicPanel.getCreepEggList().size(); a++) {
                CreepEgg ce = (CreepEgg) candyMagicPanel.getCreepEggList().get(a);
                if (ce.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, ce, null, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (ce.getCreepInvisibility() == true) {
                        ce.setCreepDetection(true);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBigEggList().size(); a++) {
                CreepBigEgg cbe = (CreepBigEgg) candyMagicPanel.getCreepBigEggList().get(a);
                if (cbe.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, cbe, null, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cbe.getCreepInvisibility() == true) {
                        cbe.setCreepDetection(true);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRageEggList().size(); a++) {
                CreepRageEgg cre = (CreepRageEgg) candyMagicPanel.getCreepRageEggList().get(a);
                if (cre.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, cre, null, null, null, null, null, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cre.getCreepInvisibility() == true) {
                        cre.setCreepDetection(true);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBlackAntList().size(); a++) {
                CreepBlackAnt cba = (CreepBlackAnt) candyMagicPanel.getCreepBlackAntList().get(a);
                if (cba.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, cba, null, null, null, null, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cba.getCreepInvisibility() == true) {
                        cba.setCreepDetection(true);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRedAntList().size(); a++) {
                CreepRedAnt cra = (CreepRedAnt) candyMagicPanel.getCreepRedAntList().get(a);
                if (cra.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, cra, null, null, null, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cra.getCreepInvisibility() == true) {
                        cra.setCreepDetection(true);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRatList().size(); a++) {
                CreepRat cr = (CreepRat) candyMagicPanel.getCreepRatList().get(a);
                if (cr.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, null, cr, null, null, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cr.getCreepInvisibility() == true) {
                        cr.setCreepDetection(true);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepButterflyList().size(); a++) {
                CreepButterfly cb = (CreepButterfly) candyMagicPanel.getCreepButterflyList().get(a);
                if (cb.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, null, null, cb, null, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cb.getCreepInvisibility() == true) {
                        cb.setCreepDetection(true);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBeeList().size(); a++) {
                CreepBee cbb = (CreepBee) candyMagicPanel.getCreepBeeList().get(a);
                if (cbb.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, null, null, null, cbb, null, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cbb.getCreepInvisibility() == true) {
                        cbb.setCreepDetection(true);
                    }
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepBoxerAntList().size(); a++) {
                CreepBoxerAnt crba = (CreepBoxerAnt) candyMagicPanel.getCreepBoxerAntList().get(a);
                if (crba.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, null, null, null, null, crba, null, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (crba.getCreepInvisibility() == true) {
                        crba.setCreepDetection(true);
                    }
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepSpearmanAntList().size(); a++) {
                CreepSpearmanAnt csa = (CreepSpearmanAnt) candyMagicPanel.getCreepSpearmanAntList().get(a);
                if (csa.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, null, null, null, null, null, csa, null, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (csa.getCreepInvisibility() == true) {
                        csa.setCreepDetection(true);
                    }
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepSwordsmanAntList().size(); a++) {
                CreepSwordsmanAnt crsa = (CreepSwordsmanAnt) candyMagicPanel.getCreepSwordsmanAntList().get(a);
                if (crsa.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, null, null, null, null, null, null, crsa, null, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (crsa.getCreepInvisibility() == true) {
                        crsa.setCreepDetection(true);
                    }
                }
            }
            
            for (int a = 0; a < candyMagicPanel.getCreepKingAntList().size(); a++) {
                CreepKingAnt cka = (CreepKingAnt) candyMagicPanel.getCreepKingAntList().get(a);
                if (cka.getCreepRectangle().intersects(towerRange)) {
                    if (getTowerMaxTargetCounter() < getTowerMaxTarget()) {
                        candyMagicPanel.addBullet(getTowerType(), getTowerLevel(), getX() + getTowerImage().getWidth() / 2, getY() + getTowerImage().getHeight() / 2, getTowerDamage(), 5, true, null, null, null, null, null, null, null, null, null, null, null, cka, getTowerOwner());
                        setTowerMaxTargetCounter(getTowerMaxTargetCounter() + 1);
                    }

                    if (cka.getCreepInvisibility() == true) {
                        cka.setCreepDetection(true);
                    }
                }
            }
        }
    }

    public void towerChangeDirection() {
        if (getCreepEggTarget() != null) {
            if (getCreepEggTarget().getCreepDetection() == true) {
                deltaX = (getCreepEggTarget().getX() + (getCreepEggTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepEggTarget().getY() + (getCreepEggTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBigEggTarget() != null) {
            if (getCreepBigEggTarget().getCreepDetection() == true) {
                deltaX = (getCreepBigEggTarget().getX() + (getCreepBigEggTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBigEggTarget().getY() + (getCreepBigEggTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepRageEggTarget() != null) {
            if (getCreepRageEggTarget().getCreepDetection() == true) {
                deltaX = (getCreepRageEggTarget().getX() + (getCreepRageEggTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepRageEggTarget().getY() + (getCreepRageEggTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBlackAntTarget() != null) {
            if (getCreepBlackAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepBlackAntTarget().getX() + (getCreepBlackAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBlackAntTarget().getY() + (getCreepBlackAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepRedAntTarget() != null) {
            if (getCreepRedAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepRedAntTarget().getX() + (getCreepRedAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepRedAntTarget().getY() + (getCreepRedAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepRatTarget() != null) {
            if (getCreepRatTarget().getCreepDetection() == true) {
                deltaX = (getCreepRatTarget().getX() + (getCreepRatTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepRatTarget().getY() + (getCreepRatTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepButterflyTarget() != null) {
            if (getCreepButterflyTarget().getCreepDetection() == true) {
                deltaX = (getCreepButterflyTarget().getX() + (getCreepButterflyTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepButterflyTarget().getY() + (getCreepButterflyTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBeeTarget() != null) {
            if (getCreepBeeTarget().getCreepDetection() == true) {
                deltaX = (getCreepBeeTarget().getX() + (getCreepBeeTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBeeTarget().getY() + (getCreepBeeTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBoxerAntTarget() != null) {
            if (getCreepBoxerAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepBoxerAntTarget().getX() + (getCreepBoxerAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBoxerAntTarget().getY() + (getCreepBoxerAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepSpearmanAntTarget() != null) {
            if (getCreepSpearmanAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepSpearmanAntTarget().getX() + (getCreepSpearmanAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepSpearmanAntTarget().getY() + (getCreepSpearmanAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepSwordsmanAntTarget() != null) {
            if (getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepSwordsmanAntTarget().getX() + (getCreepSwordsmanAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepSwordsmanAntTarget().getY() + (getCreepSwordsmanAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepKingAntTarget() != null) {
            if (getCreepKingAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepKingAntTarget().getX() + (getCreepKingAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepKingAntTarget().getY() + (getCreepKingAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        }

        if (getTowerType() == 1) {
            if (getTowerLevel() == 1) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(0));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(1));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(2));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(3));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(4));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(4));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(5));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(6));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(7));
                }
            } else if (getTowerLevel() == 2) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(8));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(9));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(10));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(11));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(12));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(12));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(13));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(14));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(15));
                }
            } else if (getTowerLevel() == 3) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(16));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(17));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(18));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(19));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(20));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(20));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(21));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(22));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerIceDropImageList().get(23));
                }
            }
        } else if (getTowerType() == 3) {
            if (getTowerLevel() == 1) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(0));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(0));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(0));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(2));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(2));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(4));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(4));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(6));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(6));
                }
            } else if (getTowerLevel() == 2) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(8));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(8));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(8));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(10));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(10));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(12));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(12));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(14));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(14));
                }
            } else if (getTowerLevel() == 3) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(16));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(16));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(16));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(18));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(18));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(20));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(20));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(22));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(22));
                }
            }
        } else if (getTowerType() == 6) {
            if (getTowerLevel() == 1) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(0));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(1));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(2));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(3));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(4));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(4));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(5));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(6));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(7));
                }
            } else if (getTowerLevel() == 2) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(8));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(9));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(10));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(11));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(12));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(12));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(13));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(14));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(15));
                }
            } else if (getTowerLevel() == 3) {
                if (getAngle() > -5 && getAngle() < 5) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(16));
                } else if (getAngle() > 5 && getAngle() < 60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(17));
                } else if (getAngle() > 60 && getAngle() < 90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(18));
                } else if (getAngle() > 90 && getAngle() < 175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(19));
                } else if (getAngle() > 175 && getAngle() < 180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(20));
                } else if (getAngle() < -175 && getAngle() > -180) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(20));
                } else if (getAngle() < -90 && getAngle() > -175) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(21));
                } else if (getAngle() < -60 && getAngle() > -90) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(22));
                } else if (getAngle() < -5 && getAngle() > -60) {
                    setTowerImage((BufferedImage) candyMagicPanel.getTowerSingleIceDropImageList().get(23));
                }
            }
        }
    }

    public void towerCherryBoltDirectionAnimation() {
        if (getCreepEggTarget() != null) {
            if (getCreepEggTarget().getCreepDetection() == true) {
                deltaX = (getCreepEggTarget().getX() + (getCreepEggTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepEggTarget().getY() + (getCreepEggTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBigEggTarget() != null) {
            if (getCreepBigEggTarget().getCreepDetection() == true) {
                deltaX = (getCreepBigEggTarget().getX() + (getCreepBigEggTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBigEggTarget().getY() + (getCreepBigEggTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepRageEggTarget() != null) {
            if (getCreepRageEggTarget().getCreepDetection() == true) {
                deltaX = (getCreepRageEggTarget().getX() + (getCreepRageEggTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepRageEggTarget().getY() + (getCreepRageEggTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBlackAntTarget() != null) {
            if (getCreepBlackAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepBlackAntTarget().getX() + (getCreepBlackAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBlackAntTarget().getY() + (getCreepBlackAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepRedAntTarget() != null) {
            if (getCreepRedAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepRedAntTarget().getX() + (getCreepRedAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepRedAntTarget().getY() + (getCreepRedAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepRatTarget() != null) {
            if (getCreepRatTarget().getCreepDetection() == true) {
                deltaX = (getCreepRatTarget().getX() + (getCreepRatTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepRatTarget().getY() + (getCreepRatTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepButterflyTarget() != null) {
            if (getCreepButterflyTarget().getCreepDetection() == true) {
                deltaX = (getCreepButterflyTarget().getX() + (getCreepButterflyTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepButterflyTarget().getY() + (getCreepButterflyTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBeeTarget() != null) {
            if (getCreepBeeTarget().getCreepDetection() == true) {
                deltaX = (getCreepBeeTarget().getX() + (getCreepBeeTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBeeTarget().getY() + (getCreepBeeTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepBoxerAntTarget() != null) {
            if (getCreepBoxerAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepBoxerAntTarget().getX() + (getCreepBoxerAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepBoxerAntTarget().getY() + (getCreepBoxerAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepSpearmanAntTarget() != null) {
            if (getCreepSpearmanAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepSpearmanAntTarget().getX() + (getCreepSpearmanAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepSpearmanAntTarget().getY() + (getCreepSpearmanAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepSwordsmanAntTarget() != null) {
            if (getCreepSwordsmanAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepSwordsmanAntTarget().getX() + (getCreepSwordsmanAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepSwordsmanAntTarget().getY() + (getCreepSwordsmanAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        } else if (getCreepKingAntTarget() != null) {
            if (getCreepKingAntTarget().getCreepDetection() == true) {
                deltaX = (getCreepKingAntTarget().getX() + (getCreepKingAntTarget().getCreepImage().getWidth() / 2)) - getX();
                deltaY = (-1 * (getCreepKingAntTarget().getY() + (getCreepKingAntTarget().getCreepImage().getHeight() / 2)) - (-1 * (getY())));
                angle = Math.atan2(deltaX, deltaY) * (180 / Math.PI);
            }
        }
        

        if (getTowerLevel() == 1) {
            if (getAngle() > -5 && getAngle() < 5) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(1));
            } else if (getAngle() > 5 && getAngle() < 60) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(1));
            } else if (getAngle() > 60 && getAngle() < 90) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(1));
            } else if (getAngle() > 90 && getAngle() < 175) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(3));
            } else if (getAngle() > 175 && getAngle() < 180) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(3));
            } else if (getAngle() < -175 && getAngle() > -180) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(5));
            } else if (getAngle() < -90 && getAngle() > -175) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(5));
            } else if (getAngle() < -60 && getAngle() > -90) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(7));
            } else if (getAngle() < -5 && getAngle() > -60) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(7));
            }
        } else if (getTowerLevel() == 2) {
            if (getAngle() > -5 && getAngle() < 5) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(9));
            } else if (getAngle() > 5 && getAngle() < 60) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(9));
            } else if (getAngle() > 60 && getAngle() < 90) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(9));
            } else if (getAngle() > 90 && getAngle() < 175) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(11));
            } else if (getAngle() > 175 && getAngle() < 180) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(11));
            } else if (getAngle() < -175 && getAngle() > -180) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(13));
            } else if (getAngle() < -90 && getAngle() > -175) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(13));
            } else if (getAngle() < -60 && getAngle() > -90) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(15));
            } else if (getAngle() < -5 && getAngle() > -60) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(15));
            }
        } else if (getTowerLevel() == 3) {
            if (getAngle() > -5 && getAngle() < 5) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(17));
            } else if (getAngle() > 5 && getAngle() < 60) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(17));
            } else if (getAngle() > 60 && getAngle() < 90) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(17));
            } else if (getAngle() > 90 && getAngle() < 175) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(19));
            } else if (getAngle() > 175 && getAngle() < 180) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(19));
            } else if (getAngle() < -175 && getAngle() > -180) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(21));
            } else if (getAngle() < -90 && getAngle() > -175) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(21));
            } else if (getAngle() < -60 && getAngle() > -90) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(23));
            } else if (getAngle() < -5 && getAngle() > -60) {
                setTowerImage((BufferedImage) candyMagicPanel.getTowerCherryBoltImageList().get(23));
            }
        }
    }
}
