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
public class Bullet {

    private int bulletX;
    private int bulletY;
    private int bulletDamage;
    private int bulletType;
    private int bulletHeight;
    private int bulletWidth;
    private int bulletLevel;
    private int bulletSpeed;
    private boolean bulletVisibility;
    private BufferedImage bulletImage;
    private int bulletChance;
    private Random bulletRandom = new Random();
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
    private String bulletOwner;

    public void setX(int bx) {
        bulletX = bx;
    }

    public int getX() {
        return bulletX;
    }

    public void setY(int by) {
        bulletY = by;
    }

    public int getY() {
        return bulletY;
    }

    public void setBulletDamage(int dmg) {
        bulletDamage = dmg;
    }

    public int getBulletDamage() {
        return bulletDamage;
    }

    public void setBulletType(int type) {
        bulletType = type;
    }

    public int getBulletType() {
        return bulletType;
    }

    public void setBulletLevel(int lvl) {
        bulletLevel = lvl;
    }

    public int getBulletLevel() {
        return bulletLevel;
    }

    public void setBulletSpeed(int spd) {
        bulletSpeed = spd;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

    public void setBulletVisibilty(boolean vb) {
        bulletVisibility = vb;
    }

    public boolean getBulletVisibility() {
        return bulletVisibility;
    }

    public void setBulletImage(BufferedImage bulletImg) {
        bulletImage = bulletImg;
        bulletHeight = bulletImage.getHeight();
        bulletWidth = bulletImage.getWidth();
    }

    public BufferedImage getBulletImage() {
        return bulletImage;
    }

    public Rectangle getBulletRectangle() {
        return new Rectangle((int) bulletX, (int) bulletY, bulletWidth, bulletHeight);
    }

    public Random getBulletRandom() {
        return bulletRandom;
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

    public void setBulletOwner(String owner) {
        bulletOwner = owner;
    }

    public String getBulletOwner() {
        return bulletOwner;
    }

    public void bulletTargetHomingAnimation() {
        if (getCreepEggTarget() != null) {
            if (getCreepEggTarget().getCreepVisibility() == true) {
                Rectangle creepEggRectangle = getCreepEggTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepEggTarget().getX();
                int cy = getCreepEggTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepEggRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepEggTarget().setCreepCurrentHp(getCreepEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepEggTarget().setCreepVisibility();
                        if (getCreepEggTarget().getCreepVisibility() == false) {
                            getCreepEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX() + (getCreepEggTarget().getCreepImage().getWidth() / 3), getCreepEggTarget().getY(), 1, 50, true, getCreepEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepEggTarget().setCreepCurrentHp(getCreepEggTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepEggTarget().setCreepVisibility();
                            if (getCreepEggTarget().getCreepVisibility() == false) {
                                getCreepEggTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX() + (getCreepEggTarget().getCreepImage().getWidth() / 3), getCreepEggTarget().getY(), 1, 50, true, getCreepEggTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepEggTarget().setCreepStatusChillAilment("CHILL");
                                getCreepEggTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepEggTarget().setCreepStatusChillAilmentTime(300);
                                getCreepEggTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX(), getCreepEggTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX(), getCreepEggTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepEggTarget().setCreepCurrentHp(getCreepEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepEggTarget().setCreepVisibility();
                        if (getCreepEggTarget().getCreepVisibility() == false) {
                            getCreepEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX() + (getCreepEggTarget().getCreepImage().getWidth() / 3), getCreepEggTarget().getY(), 1, 50, true, getCreepEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepEggTarget().setCreepCurrentHp(getCreepEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepEggTarget().setCreepVisibility();
                        if (getCreepEggTarget().getCreepVisibility() == false) {
                            getCreepEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX() + (getCreepEggTarget().getCreepImage().getWidth() / 3), getCreepEggTarget().getY(), 1, 50, true, getCreepEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepEggTarget().setCreepCurrentHp(getCreepEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepEggTarget().setCreepVisibility();
                        if (getCreepEggTarget().getCreepVisibility() == false) {
                            getCreepEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX() + (getCreepEggTarget().getCreepImage().getWidth() / 3), getCreepEggTarget().getY(), 1, 50, true, getCreepEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepEggTarget().getX(), getCreepEggTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepBigEggTarget() != null) {
            if (getCreepBigEggTarget().getCreepVisibility() == true) {
                Rectangle creepBigEggRectangle = getCreepBigEggTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepBigEggTarget().getX();
                int cy = getCreepBigEggTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepBigEggRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepBigEggTarget().setCreepCurrentHp(getCreepBigEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBigEggTarget().setCreepVisibility();
                        if (getCreepBigEggTarget().getCreepVisibility() == false) {
                            getCreepBigEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX() + (getCreepBigEggTarget().getCreepImage().getWidth() / 3), getCreepBigEggTarget().getY(), 1, 50, true, getCreepBigEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepBigEggTarget().setCreepCurrentHp(getCreepBigEggTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepBigEggTarget().setCreepVisibility();
                            if (getCreepBigEggTarget().getCreepVisibility() == false) {
                                getCreepBigEggTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX() + (getCreepBigEggTarget().getCreepImage().getWidth() / 3), getCreepBigEggTarget().getY(), 1, 50, true, getCreepBigEggTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepBigEggTarget().setCreepStatusChillAilment("CHILL");
                                getCreepBigEggTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepBigEggTarget().setCreepStatusChillAilmentTime(300);
                                getCreepBigEggTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX(), getCreepBigEggTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX(), getCreepBigEggTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepBigEggTarget().setCreepCurrentHp(getCreepBigEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBigEggTarget().setCreepVisibility();
                        if (getCreepBigEggTarget().getCreepVisibility() == false) {
                            getCreepBigEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX() + (getCreepBigEggTarget().getCreepImage().getWidth() / 3), getCreepBigEggTarget().getY(), 1, 50, true, getCreepBigEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepBigEggTarget().setCreepCurrentHp(getCreepBigEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBigEggTarget().setCreepVisibility();
                        if (getCreepBigEggTarget().getCreepVisibility() == false) {
                            getCreepBigEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX() + (getCreepBigEggTarget().getCreepImage().getWidth() / 3), getCreepBigEggTarget().getY(), 1, 50, true, getCreepBigEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepBigEggTarget().setCreepCurrentHp(getCreepBigEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBigEggTarget().setCreepVisibility();
                        if (getCreepBigEggTarget().getCreepVisibility() == false) {
                            getCreepBigEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX() + (getCreepBigEggTarget().getCreepImage().getWidth() / 3), getCreepBigEggTarget().getY(), 1, 50, true, getCreepBigEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBigEggTarget().getX(), getCreepBigEggTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepRageEggTarget() != null) {
            if (getCreepRageEggTarget().getCreepVisibility() == true) {
                Rectangle creepRageEggRectangle = getCreepRageEggTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepRageEggTarget().getX();
                int cy = getCreepRageEggTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepRageEggRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepRageEggTarget().setCreepCurrentHp(getCreepRageEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRageEggTarget().setCreepVisibility();
                        if (getCreepRageEggTarget().getCreepVisibility() == false) {
                            getCreepRageEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX() + (getCreepRageEggTarget().getCreepImage().getWidth() / 3), getCreepRageEggTarget().getY(), 1, 50, true, getCreepRageEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepRageEggTarget().setCreepCurrentHp(getCreepRageEggTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepRageEggTarget().setCreepVisibility();
                            if (getCreepRageEggTarget().getCreepVisibility() == false) {
                                getCreepRageEggTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX() + (getCreepRageEggTarget().getCreepImage().getWidth() / 3), getCreepRageEggTarget().getY(), 1, 50, true, getCreepRageEggTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepRageEggTarget().setCreepStatusChillAilment("CHILL");
                                getCreepRageEggTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepRageEggTarget().setCreepStatusChillAilmentTime(300);
                                getCreepRageEggTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX(), getCreepRageEggTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX(), getCreepRageEggTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepRageEggTarget().setCreepCurrentHp(getCreepRageEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRageEggTarget().setCreepVisibility();
                        if (getCreepRageEggTarget().getCreepVisibility() == false) {
                            getCreepRageEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX() + (getCreepRageEggTarget().getCreepImage().getWidth() / 3), getCreepRageEggTarget().getY(), 1, 50, true, getCreepRageEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepRageEggTarget().setCreepCurrentHp(getCreepRageEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRageEggTarget().setCreepVisibility();
                        if (getCreepRageEggTarget().getCreepVisibility() == false) {
                            getCreepRageEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX() + (getCreepRageEggTarget().getCreepImage().getWidth() / 3), getCreepRageEggTarget().getY(), 1, 50, true, getCreepRageEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepRageEggTarget().setCreepCurrentHp(getCreepRageEggTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRageEggTarget().setCreepVisibility();
                        if (getCreepRageEggTarget().getCreepVisibility() == false) {
                            getCreepRageEggTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX() + (getCreepRageEggTarget().getCreepImage().getWidth() / 3), getCreepRageEggTarget().getY(), 1, 50, true, getCreepRageEggTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepRageEggTarget().getX(), getCreepRageEggTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepBlackAntTarget() != null) {
            if (getCreepBlackAntTarget().getCreepVisibility() == true) {
                Rectangle creepBlackAntRectangle = getCreepBlackAntTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepBlackAntTarget().getX();
                int cy = getCreepBlackAntTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepBlackAntRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepBlackAntTarget().setCreepCurrentHp(getCreepBlackAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBlackAntTarget().setCreepVisibility();
                        if (getCreepBlackAntTarget().getCreepVisibility() == false) {
                            getCreepBlackAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX() + (getCreepBlackAntTarget().getCreepImage().getWidth() / 3), getCreepBlackAntTarget().getY(), 1, 50, true, getCreepBlackAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepBlackAntTarget().setCreepCurrentHp(getCreepBlackAntTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepBlackAntTarget().setCreepVisibility();
                            if (getCreepBlackAntTarget().getCreepVisibility() == false) {
                                getCreepBlackAntTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX() + (getCreepBlackAntTarget().getCreepImage().getWidth() / 3), getCreepBlackAntTarget().getY(), 1, 50, true, getCreepBlackAntTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepBlackAntTarget().setCreepStatusChillAilment("CHILL");
                                getCreepBlackAntTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepBlackAntTarget().setCreepStatusChillAilmentTime(300);
                                getCreepBlackAntTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX(), getCreepBlackAntTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX(), getCreepBlackAntTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepBlackAntTarget().setCreepCurrentHp(getCreepBlackAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBlackAntTarget().setCreepVisibility();
                        if (getCreepBlackAntTarget().getCreepVisibility() == false) {
                            getCreepBlackAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX() + (getCreepBlackAntTarget().getCreepImage().getWidth() / 3), getCreepBlackAntTarget().getY(), 1, 50, true, getCreepBlackAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepBlackAntTarget().setCreepCurrentHp(getCreepBlackAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBlackAntTarget().setCreepVisibility();
                        if (getCreepBlackAntTarget().getCreepVisibility() == false) {
                            getCreepBlackAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX() + (getCreepBlackAntTarget().getCreepImage().getWidth() / 3), getCreepBlackAntTarget().getY(), 1, 50, true, getCreepBlackAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepBlackAntTarget().setCreepCurrentHp(getCreepBlackAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBlackAntTarget().setCreepVisibility();
                        if (getCreepBlackAntTarget().getCreepVisibility() == false) {
                            getCreepBlackAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX() + (getCreepBlackAntTarget().getCreepImage().getWidth() / 3), getCreepBlackAntTarget().getY(), 1, 50, true, getCreepBlackAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBlackAntTarget().getX(), getCreepBlackAntTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepRedAntTarget() != null) {
            if (getCreepRedAntTarget().getCreepVisibility() == true) {
                Rectangle creepRedAntRectangle = getCreepRedAntTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepRedAntTarget().getX();
                int cy = getCreepRedAntTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepRedAntRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepRedAntTarget().setCreepCurrentHp(getCreepRedAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRedAntTarget().setCreepVisibility();
                        if (getCreepRedAntTarget().getCreepVisibility() == false) {
                            getCreepRedAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX() + (getCreepRedAntTarget().getCreepImage().getWidth() / 3), getCreepRedAntTarget().getY(), 1, 50, true, getCreepRedAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepRedAntTarget().setCreepCurrentHp(getCreepRedAntTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepRedAntTarget().setCreepVisibility();
                            if (getCreepRedAntTarget().getCreepVisibility() == false) {
                                getCreepRedAntTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX() + (getCreepRedAntTarget().getCreepImage().getWidth() / 3), getCreepRedAntTarget().getY(), 1, 50, true, getCreepRedAntTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepRedAntTarget().setCreepStatusChillAilment("CHILL");
                                getCreepRedAntTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepRedAntTarget().setCreepStatusChillAilmentTime(300);
                                getCreepRedAntTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX(), getCreepRedAntTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX(), getCreepRedAntTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepRedAntTarget().setCreepCurrentHp(getCreepRedAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRedAntTarget().setCreepVisibility();
                        if (getCreepRedAntTarget().getCreepVisibility() == false) {
                            getCreepRedAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX() + (getCreepRedAntTarget().getCreepImage().getWidth() / 3), getCreepRedAntTarget().getY(), 1, 50, true, getCreepRedAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepRedAntTarget().setCreepCurrentHp(getCreepRedAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRedAntTarget().setCreepVisibility();
                        if (getCreepRedAntTarget().getCreepVisibility() == false) {
                            getCreepRedAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX() + (getCreepRedAntTarget().getCreepImage().getWidth() / 3), getCreepRedAntTarget().getY(), 1, 50, true, getCreepRedAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepRedAntTarget().setCreepCurrentHp(getCreepRedAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRedAntTarget().setCreepVisibility();
                        if (getCreepRedAntTarget().getCreepVisibility() == false) {
                            getCreepRedAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX() + (getCreepRedAntTarget().getCreepImage().getWidth() / 3), getCreepRedAntTarget().getY(), 1, 50, true, getCreepRedAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepRedAntTarget().getX(), getCreepRedAntTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepRatTarget() != null) {
            if (getCreepRatTarget().getCreepVisibility() == true) {
                Rectangle creepRatRectangle = getCreepRatTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepRatTarget().getX();
                int cy = getCreepRatTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepRatRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepRatTarget().setCreepCurrentHp(getCreepRatTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRatTarget().setCreepVisibility();
                        if (getCreepRatTarget().getCreepVisibility() == false) {
                            getCreepRatTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX() + (getCreepRatTarget().getCreepImage().getWidth() / 3), getCreepRatTarget().getY(), 1, 50, true, getCreepRatTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepRatTarget().setCreepCurrentHp(getCreepRatTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepRatTarget().setCreepVisibility();
                            if (getCreepRatTarget().getCreepVisibility() == false) {
                                getCreepRatTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX() + (getCreepRatTarget().getCreepImage().getWidth() / 3), getCreepRatTarget().getY(), 1, 50, true, getCreepRatTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepRatTarget().setCreepStatusChillAilment("CHILL");
                                getCreepRatTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepRatTarget().setCreepStatusChillAilmentTime(300);
                                getCreepRatTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX(), getCreepRatTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX(), getCreepRatTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepRatTarget().setCreepCurrentHp(getCreepRatTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRatTarget().setCreepVisibility();
                        if (getCreepRatTarget().getCreepVisibility() == false) {
                            getCreepRatTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX() + (getCreepRatTarget().getCreepImage().getWidth() / 3), getCreepRatTarget().getY(), 1, 50, true, getCreepRatTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepRatTarget().setCreepCurrentHp(getCreepRatTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRatTarget().setCreepVisibility();
                        if (getCreepRatTarget().getCreepVisibility() == false) {
                            getCreepRatTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX() + (getCreepRatTarget().getCreepImage().getWidth() / 3), getCreepRatTarget().getY(), 1, 50, true, getCreepRatTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepRatTarget().setCreepCurrentHp(getCreepRatTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepRatTarget().setCreepVisibility();
                        if (getCreepRatTarget().getCreepVisibility() == false) {
                            getCreepRatTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX() + (getCreepRatTarget().getCreepImage().getWidth() / 3), getCreepRatTarget().getY(), 1, 50, true, getCreepRatTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepRatTarget().getX(), getCreepRatTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepButterflyTarget() != null) {
            if (getCreepButterflyTarget().getCreepVisibility() == true) {
                Rectangle creepButterflyRectangle = getCreepButterflyTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepButterflyTarget().getX();
                int cy = getCreepButterflyTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepButterflyRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepButterflyTarget().setCreepCurrentHp(getCreepButterflyTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepButterflyTarget().setCreepVisibility();
                        if (getCreepButterflyTarget().getCreepVisibility() == false) {
                            getCreepButterflyTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX() + (getCreepButterflyTarget().getCreepImage().getWidth() / 3), getCreepButterflyTarget().getY(), 1, 50, true, getCreepButterflyTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepButterflyTarget().setCreepCurrentHp(getCreepButterflyTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepButterflyTarget().setCreepVisibility();
                            if (getCreepButterflyTarget().getCreepVisibility() == false) {
                                getCreepButterflyTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX() + (getCreepButterflyTarget().getCreepImage().getWidth() / 3), getCreepButterflyTarget().getY(), 1, 50, true, getCreepButterflyTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepButterflyTarget().setCreepStatusChillAilment("CHILL");
                                getCreepButterflyTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepButterflyTarget().setCreepStatusChillAilmentTime(300);
                                getCreepButterflyTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX(), getCreepButterflyTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX(), getCreepButterflyTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepButterflyTarget().setCreepCurrentHp(getCreepButterflyTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepButterflyTarget().setCreepVisibility();
                        if (getCreepButterflyTarget().getCreepVisibility() == false) {
                            getCreepButterflyTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX() + (getCreepButterflyTarget().getCreepImage().getWidth() / 3), getCreepButterflyTarget().getY(), 1, 50, true, getCreepButterflyTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepButterflyTarget().setCreepCurrentHp(getCreepButterflyTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepButterflyTarget().setCreepVisibility();
                        if (getCreepButterflyTarget().getCreepVisibility() == false) {
                            getCreepButterflyTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX() + (getCreepButterflyTarget().getCreepImage().getWidth() / 3), getCreepButterflyTarget().getY(), 1, 50, true, getCreepButterflyTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepButterflyTarget().setCreepCurrentHp(getCreepButterflyTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepButterflyTarget().setCreepVisibility();
                        if (getCreepButterflyTarget().getCreepVisibility() == false) {
                            getCreepButterflyTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX() + (getCreepButterflyTarget().getCreepImage().getWidth() / 3), getCreepButterflyTarget().getY(), 1, 50, true, getCreepButterflyTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepButterflyTarget().getX(), getCreepButterflyTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepBeeTarget() != null) {
            if (getCreepBeeTarget().getCreepVisibility() == true) {
                Rectangle creepBeeRectangle = getCreepBeeTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepBeeTarget().getX();
                int cy = getCreepBeeTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepBeeRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepBeeTarget().setCreepCurrentHp(getCreepBeeTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBeeTarget().setCreepVisibility();
                        if (getCreepBeeTarget().getCreepVisibility() == false) {
                            getCreepBeeTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX() + (getCreepBeeTarget().getCreepImage().getWidth() / 3), getCreepBeeTarget().getY(), 1, 50, true, getCreepBeeTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepBeeTarget().setCreepCurrentHp(getCreepBeeTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepBeeTarget().setCreepVisibility();
                            if (getCreepBeeTarget().getCreepVisibility() == false) {
                                getCreepBeeTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX() + (getCreepBeeTarget().getCreepImage().getWidth() / 3), getCreepBeeTarget().getY(), 1, 50, true, getCreepBeeTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepBeeTarget().setCreepStatusChillAilment("CHILL");
                                getCreepBeeTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepBeeTarget().setCreepStatusChillAilmentTime(300);
                                getCreepBeeTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX(), getCreepBeeTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX(), getCreepBeeTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepBeeTarget().setCreepCurrentHp(getCreepBeeTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBeeTarget().setCreepVisibility();
                        if (getCreepBeeTarget().getCreepVisibility() == false) {
                            getCreepBeeTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX() + (getCreepBeeTarget().getCreepImage().getWidth() / 3), getCreepBeeTarget().getY(), 1, 50, true, getCreepBeeTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepBeeTarget().setCreepCurrentHp(getCreepBeeTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBeeTarget().setCreepVisibility();
                        if (getCreepBeeTarget().getCreepVisibility() == false) {
                            getCreepBeeTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX() + (getCreepBeeTarget().getCreepImage().getWidth() / 3), getCreepBeeTarget().getY(), 1, 50, true, getCreepBeeTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepBeeTarget().setCreepCurrentHp(getCreepBeeTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBeeTarget().setCreepVisibility();
                        if (getCreepBeeTarget().getCreepVisibility() == false) {
                            getCreepBeeTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX() + (getCreepBeeTarget().getCreepImage().getWidth() / 3), getCreepBeeTarget().getY(), 1, 50, true, getCreepBeeTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBeeTarget().getX(), getCreepBeeTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepBoxerAntTarget() != null) {
            if (getCreepBoxerAntTarget().getCreepVisibility() == true) {
                Rectangle creepBoxerAntRectangle = getCreepBoxerAntTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepBoxerAntTarget().getX();
                int cy = getCreepBoxerAntTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepBoxerAntRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepBoxerAntTarget().setCreepCurrentHp(getCreepBoxerAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBoxerAntTarget().setCreepVisibility();
                        if (getCreepBoxerAntTarget().getCreepVisibility() == false) {
                            getCreepBoxerAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX() + (getCreepBoxerAntTarget().getCreepImage().getWidth() / 3), getCreepBoxerAntTarget().getY(), 1, 50, true, getCreepBoxerAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepBoxerAntTarget().setCreepCurrentHp(getCreepBoxerAntTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepBoxerAntTarget().setCreepVisibility();
                            if (getCreepBoxerAntTarget().getCreepVisibility() == false) {
                                getCreepBoxerAntTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX() + (getCreepBoxerAntTarget().getCreepImage().getWidth() / 3), getCreepBoxerAntTarget().getY(), 1, 50, true, getCreepBoxerAntTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepBoxerAntTarget().setCreepStatusChillAilment("CHILL");
                                getCreepBoxerAntTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepBoxerAntTarget().setCreepStatusChillAilmentTime(300);
                                getCreepBoxerAntTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX(), getCreepBoxerAntTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX(), getCreepBoxerAntTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepBoxerAntTarget().setCreepCurrentHp(getCreepBoxerAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBoxerAntTarget().setCreepVisibility();
                        if (getCreepBoxerAntTarget().getCreepVisibility() == false) {
                            getCreepBoxerAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX() + (getCreepBoxerAntTarget().getCreepImage().getWidth() / 3), getCreepBoxerAntTarget().getY(), 1, 50, true, getCreepBoxerAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepBoxerAntTarget().setCreepCurrentHp(getCreepBoxerAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBoxerAntTarget().setCreepVisibility();
                        if (getCreepBoxerAntTarget().getCreepVisibility() == false) {
                            getCreepBoxerAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX() + (getCreepBoxerAntTarget().getCreepImage().getWidth() / 3), getCreepBoxerAntTarget().getY(), 1, 50, true, getCreepBoxerAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepBoxerAntTarget().setCreepCurrentHp(getCreepBoxerAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepBoxerAntTarget().setCreepVisibility();
                        if (getCreepBoxerAntTarget().getCreepVisibility() == false) {
                            getCreepBoxerAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX() + (getCreepBoxerAntTarget().getCreepImage().getWidth() / 3), getCreepBoxerAntTarget().getY(), 1, 50, true, getCreepBoxerAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepBoxerAntTarget().getX(), getCreepBoxerAntTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepSpearmanAntTarget() != null) {
            if (getCreepSpearmanAntTarget().getCreepVisibility() == true) {
                Rectangle creepSpearmanAntRectangle = getCreepSpearmanAntTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepSpearmanAntTarget().getX();
                int cy = getCreepSpearmanAntTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepSpearmanAntRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepSpearmanAntTarget().setCreepCurrentHp(getCreepSpearmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSpearmanAntTarget().setCreepVisibility();
                        if (getCreepSpearmanAntTarget().getCreepVisibility() == false) {
                            getCreepSpearmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX() + (getCreepSpearmanAntTarget().getCreepImage().getWidth() / 3), getCreepSpearmanAntTarget().getY(), 1, 50, true, getCreepSpearmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepSpearmanAntTarget().setCreepCurrentHp(getCreepSpearmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepSpearmanAntTarget().setCreepVisibility();
                            if (getCreepSpearmanAntTarget().getCreepVisibility() == false) {
                                getCreepSpearmanAntTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX() + (getCreepSpearmanAntTarget().getCreepImage().getWidth() / 3), getCreepSpearmanAntTarget().getY(), 1, 50, true, getCreepSpearmanAntTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepSpearmanAntTarget().setCreepStatusChillAilment("CHILL");
                                getCreepSpearmanAntTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepSpearmanAntTarget().setCreepStatusChillAilmentTime(300);
                                getCreepSpearmanAntTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX(), getCreepSpearmanAntTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX(), getCreepSpearmanAntTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepSpearmanAntTarget().setCreepCurrentHp(getCreepSpearmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSpearmanAntTarget().setCreepVisibility();
                        if (getCreepSpearmanAntTarget().getCreepVisibility() == false) {
                            getCreepSpearmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX() + (getCreepSpearmanAntTarget().getCreepImage().getWidth() / 3), getCreepSpearmanAntTarget().getY(), 1, 50, true, getCreepSpearmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepSpearmanAntTarget().setCreepCurrentHp(getCreepSpearmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSpearmanAntTarget().setCreepVisibility();
                        if (getCreepSpearmanAntTarget().getCreepVisibility() == false) {
                            getCreepSpearmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX() + (getCreepSpearmanAntTarget().getCreepImage().getWidth() / 3), getCreepSpearmanAntTarget().getY(), 1, 50, true, getCreepSpearmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepSpearmanAntTarget().setCreepCurrentHp(getCreepSpearmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSpearmanAntTarget().setCreepVisibility();
                        if (getCreepSpearmanAntTarget().getCreepVisibility() == false) {
                            getCreepSpearmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX() + (getCreepSpearmanAntTarget().getCreepImage().getWidth() / 3), getCreepSpearmanAntTarget().getY(), 1, 50, true, getCreepSpearmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepSpearmanAntTarget().getX(), getCreepSpearmanAntTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepSwordsmanAntTarget() != null) {
            if (getCreepSwordsmanAntTarget().getCreepVisibility() == true) {
                Rectangle creepSwordsmanAntRectangle = getCreepSwordsmanAntTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepSwordsmanAntTarget().getX();
                int cy = getCreepSwordsmanAntTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepSwordsmanAntRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepSwordsmanAntTarget().setCreepCurrentHp(getCreepSwordsmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSwordsmanAntTarget().setCreepVisibility();
                        if (getCreepSwordsmanAntTarget().getCreepVisibility() == false) {
                            getCreepSwordsmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX() + (getCreepSwordsmanAntTarget().getCreepImage().getWidth() / 3), getCreepSwordsmanAntTarget().getY(), 1, 50, true, getCreepSwordsmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepSwordsmanAntTarget().setCreepCurrentHp(getCreepSwordsmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepSwordsmanAntTarget().setCreepVisibility();
                            if (getCreepSwordsmanAntTarget().getCreepVisibility() == false) {
                                getCreepSwordsmanAntTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX() + (getCreepSwordsmanAntTarget().getCreepImage().getWidth() / 3), getCreepSwordsmanAntTarget().getY(), 1, 50, true, getCreepSwordsmanAntTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepSwordsmanAntTarget().setCreepStatusChillAilment("CHILL");
                                getCreepSwordsmanAntTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepSwordsmanAntTarget().setCreepStatusChillAilmentTime(300);
                                getCreepSwordsmanAntTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX(), getCreepSwordsmanAntTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX(), getCreepSwordsmanAntTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepSwordsmanAntTarget().setCreepCurrentHp(getCreepSwordsmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSwordsmanAntTarget().setCreepVisibility();
                        if (getCreepSwordsmanAntTarget().getCreepVisibility() == false) {
                            getCreepSwordsmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX() + (getCreepSwordsmanAntTarget().getCreepImage().getWidth() / 3), getCreepSwordsmanAntTarget().getY(), 1, 50, true, getCreepSwordsmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepSwordsmanAntTarget().setCreepCurrentHp(getCreepSwordsmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSwordsmanAntTarget().setCreepVisibility();
                        if (getCreepSwordsmanAntTarget().getCreepVisibility() == false) {
                            getCreepSwordsmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX() + (getCreepSwordsmanAntTarget().getCreepImage().getWidth() / 3), getCreepSwordsmanAntTarget().getY(), 1, 50, true, getCreepSwordsmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepSwordsmanAntTarget().setCreepCurrentHp(getCreepSwordsmanAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepSwordsmanAntTarget().setCreepVisibility();
                        if (getCreepSwordsmanAntTarget().getCreepVisibility() == false) {
                            getCreepSwordsmanAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX() + (getCreepSwordsmanAntTarget().getCreepImage().getWidth() / 3), getCreepSwordsmanAntTarget().getY(), 1, 50, true, getCreepSwordsmanAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepSwordsmanAntTarget().getX(), getCreepSwordsmanAntTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }

        if (getCreepKingAntTarget() != null) {
            if (getCreepKingAntTarget().getCreepVisibility() == true) {
                Rectangle creepKingAntRectangle = getCreepKingAntTarget().getCreepRectangle();
                Rectangle bulletRectangle = getBulletRectangle();
                int cx = getCreepKingAntTarget().getX();
                int cy = getCreepKingAntTarget().getY();

                if (getX() > cx && getX() != cx) {
                    setX(getX() - getBulletSpeed());
                }
                if (getX() < cx && getX() != cx) {
                    setX(getX() + getBulletSpeed());
                }
                if (getY() > cy && getY() != cy) {
                    setY(getY() - getBulletSpeed());
                }
                if (getY() < cy && getY() != cy) {
                    setY(getY() + getBulletSpeed());
                }
                setBulletSpeed(getBulletSpeed() + 2);
                if (bulletRectangle.intersects(creepKingAntRectangle)) {
                    if (getBulletType() == 1) {
                        getCreepKingAntTarget().setCreepCurrentHp(getCreepKingAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepKingAntTarget().setCreepVisibility();
                        if (getCreepKingAntTarget().getCreepVisibility() == false) {
                            getCreepKingAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX() + (getCreepKingAntTarget().getCreepImage().getWidth() / 3), getCreepKingAntTarget().getY(), 1, 50, true, getCreepKingAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 2) {
                        if (getBulletLevel() == 1) {
                            getCreepKingAntTarget().setCreepCurrentHp(getCreepKingAntTarget().getCreepCurrentHp() - getBulletDamage());
                            getCreepKingAntTarget().setCreepVisibility();
                            if (getCreepKingAntTarget().getCreepVisibility() == false) {
                                getCreepKingAntTarget().setCreepKilledBy(getBulletOwner());
                                if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                    candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX() + (getCreepKingAntTarget().getCreepImage().getWidth() / 3), getCreepKingAntTarget().getY(), 1, 50, true, getCreepKingAntTarget().getCreepGoldBounty());
                                }
                            } else {
                                getCreepKingAntTarget().setCreepStatusChillAilment("CHILL");
                                getCreepKingAntTarget().setCreepStatusChillAilmentFactor(1);
                                getCreepKingAntTarget().setCreepStatusChillAilmentTime(300);
                                getCreepKingAntTarget().setCreepStatusChillAilmentTimeCounter(0);
                            }
                        } else if (getBulletLevel() == 2 || getBulletLevel() == 3) {
                            loadSoundToPlay();
                            candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX(), getCreepKingAntTarget().getY(), 5, 11, true, 1);
                            bulletSplashAnimation();
                        }
                    } else if (getBulletType() == 3) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX(), getCreepKingAntTarget().getY(), 6, 15, true, 1);
                        bulletSplashAnimation();
                    } else if (getBulletType() == 4) {
                        loadSoundToPlay();
                        getCreepKingAntTarget().setCreepCurrentHp(getCreepKingAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepKingAntTarget().setCreepVisibility();
                        if (getCreepKingAntTarget().getCreepVisibility() == false) {
                            getCreepKingAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX() + (getCreepKingAntTarget().getCreepImage().getWidth() / 3), getCreepKingAntTarget().getY(), 1, 50, true, getCreepKingAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 5) {
                        getCreepKingAntTarget().setCreepCurrentHp(getCreepKingAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepKingAntTarget().setCreepVisibility();
                        if (getCreepKingAntTarget().getCreepVisibility() == false) {
                            getCreepKingAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX() + (getCreepKingAntTarget().getCreepImage().getWidth() / 3), getCreepKingAntTarget().getY(), 1, 50, true, getCreepKingAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 6) {
                        getCreepKingAntTarget().setCreepCurrentHp(getCreepKingAntTarget().getCreepCurrentHp() - getBulletDamage());
                        getCreepKingAntTarget().setCreepVisibility();
                        if (getCreepKingAntTarget().getCreepVisibility() == false) {
                            getCreepKingAntTarget().setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX() + (getCreepKingAntTarget().getCreepImage().getWidth() / 3), getCreepKingAntTarget().getY(), 1, 50, true, getCreepKingAntTarget().getCreepGoldBounty());
                            }
                        }
                    } else if (getBulletType() == 7) {
                        loadSoundToPlay();
                        candyMagicPanel.addObjectAnimation(getCreepKingAntTarget().getX(), getCreepKingAntTarget().getY(), 7, 10, true, 1);
                        bulletSplashAnimation();
                    }
                    setBulletVisibilty(false);
                }
            } else {
                setBulletVisibilty(false);
            }
        }
    }

    public void bulletSplashAnimation() {
        if (getBulletType() == 2) {
            if (getBulletLevel() == 2) {
                Rectangle bulletSplash = new Rectangle(getX() - 40, getY() - 40, 100, 100);
                for (int a = 0; a < candyMagicPanel.getCreepEggList().size(); a++) {
                    CreepEgg ce = (CreepEgg) candyMagicPanel.getCreepEggList().get(a);
                    if (ce.getCreepRectangle().intersects(bulletSplash)) {
                        ce.setCreepCurrentHp(ce.getCreepCurrentHp() - getBulletDamage());
                        ce.setCreepVisibility();
                        if (ce.getCreepVisibility() == false) {
                            ce.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(ce.getX() + (ce.getCreepImage().getWidth() / 3), ce.getY(), 1, 50, true, ce.getCreepGoldBounty());
                            }
                        } else {
                            ce.setCreepStatusChillAilment("CHILL");
                            ce.setCreepStatusChillAilmentFactor(2);
                            ce.setCreepStatusChillAilmentTime(400);
                            ce.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBigEggList().size(); a++) {
                    CreepBigEgg cbe = (CreepBigEgg) candyMagicPanel.getCreepBigEggList().get(a);
                    if (cbe.getCreepRectangle().intersects(bulletSplash)) {
                        cbe.setCreepCurrentHp(cbe.getCreepCurrentHp() - getBulletDamage());
                        cbe.setCreepVisibility();
                        if (cbe.getCreepVisibility() == false) {
                            cbe.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cbe.getX() + (cbe.getCreepImage().getWidth() / 3), cbe.getY(), 1, 50, true, cbe.getCreepGoldBounty());
                            }
                        } else {
                            cbe.setCreepStatusChillAilment("CHILL");
                            cbe.setCreepStatusChillAilmentFactor(2);
                            cbe.setCreepStatusChillAilmentTime(400);
                            cbe.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepRageEggList().size(); a++) {
                    CreepRageEgg cre = (CreepRageEgg) candyMagicPanel.getCreepRageEggList().get(a);
                    if (cre.getCreepRectangle().intersects(bulletSplash)) {
                        cre.setCreepCurrentHp(cre.getCreepCurrentHp() - getBulletDamage());
                        cre.setCreepVisibility();
                        if (cre.getCreepVisibility() == false) {
                            cre.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cre.getX() + (cre.getCreepImage().getWidth() / 3), cre.getY(), 1, 50, true, cre.getCreepGoldBounty());
                            }
                        } else {
                            cre.setCreepStatusChillAilment("CHILL");
                            cre.setCreepStatusChillAilmentFactor(2);
                            cre.setCreepStatusChillAilmentTime(400);
                            cre.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBlackAntList().size(); a++) {
                    CreepBlackAnt cba = (CreepBlackAnt) candyMagicPanel.getCreepBlackAntList().get(a);
                    if (cba.getCreepRectangle().intersects(bulletSplash)) {
                        cba.setCreepCurrentHp(cba.getCreepCurrentHp() - getBulletDamage());
                        cba.setCreepVisibility();
                        if (cba.getCreepVisibility() == false) {
                            cba.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cba.getX() + (cba.getCreepImage().getWidth() / 3), cba.getY(), 1, 50, true, cba.getCreepGoldBounty());
                            }
                        } else {
                            cba.setCreepStatusChillAilment("CHILL");
                            cba.setCreepStatusChillAilmentFactor(2);
                            cba.setCreepStatusChillAilmentTime(400);
                            cba.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepRedAntList().size(); a++) {
                    CreepRedAnt cra = (CreepRedAnt) candyMagicPanel.getCreepRedAntList().get(a);
                    if (cra.getCreepRectangle().intersects(bulletSplash)) {
                        cra.setCreepCurrentHp(cra.getCreepCurrentHp() - getBulletDamage());
                        cra.setCreepVisibility();
                        if (cra.getCreepVisibility() == false) {
                            cra.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cra.getX() + (cra.getCreepImage().getWidth() / 3), cra.getY(), 1, 50, true, cra.getCreepGoldBounty());
                            }
                        } else {
                            cra.setCreepStatusChillAilment("CHILL");
                            cra.setCreepStatusChillAilmentFactor(2);
                            cra.setCreepStatusChillAilmentTime(400);
                            cra.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepRatList().size(); a++) {
                    CreepRat cr = (CreepRat) candyMagicPanel.getCreepRatList().get(a);
                    if (cr.getCreepRectangle().intersects(bulletSplash)) {
                        cr.setCreepCurrentHp(cr.getCreepCurrentHp() - getBulletDamage());
                        cr.setCreepVisibility();
                        if (cr.getCreepVisibility() == false) {
                            cr.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cr.getX() + (cr.getCreepImage().getWidth() / 3), cr.getY(), 1, 50, true, cr.getCreepGoldBounty());
                            }
                        } else {
                            cr.setCreepStatusChillAilment("CHILL");
                            cr.setCreepStatusChillAilmentFactor(2);
                            cr.setCreepStatusChillAilmentTime(400);
                            cr.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepButterflyList().size(); a++) {
                    CreepButterfly cb = (CreepButterfly) candyMagicPanel.getCreepButterflyList().get(a);
                    if (cb.getCreepRectangle().intersects(bulletSplash)) {
                        cb.setCreepCurrentHp(cb.getCreepCurrentHp() - getBulletDamage());
                        cb.setCreepVisibility();
                        if (cb.getCreepVisibility() == false) {
                            cb.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cb.getX() + (cb.getCreepImage().getWidth() / 3), cb.getY(), 1, 50, true, cb.getCreepGoldBounty());
                            }
                        } else {
                            cb.setCreepStatusChillAilment("CHILL");
                            cb.setCreepStatusChillAilmentFactor(2);
                            cb.setCreepStatusChillAilmentTime(400);
                            cb.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBeeList().size(); a++) {
                    CreepBee cbb = (CreepBee) candyMagicPanel.getCreepBeeList().get(a);
                    if (cbb.getCreepRectangle().intersects(bulletSplash)) {
                        cbb.setCreepCurrentHp(cbb.getCreepCurrentHp() - getBulletDamage());
                        cbb.setCreepVisibility();
                        if (cbb.getCreepVisibility() == false) {
                            cbb.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cbb.getX() + (cbb.getCreepImage().getWidth() / 3), cbb.getY(), 1, 50, true, cbb.getCreepGoldBounty());
                            }
                        } else {
                            cbb.setCreepStatusChillAilment("CHILL");
                            cbb.setCreepStatusChillAilmentFactor(2);
                            cbb.setCreepStatusChillAilmentTime(400);
                            cbb.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBoxerAntList().size(); a++) {
                    CreepBoxerAnt crba = (CreepBoxerAnt) candyMagicPanel.getCreepBoxerAntList().get(a);
                    if (crba.getCreepRectangle().intersects(bulletSplash)) {
                        crba.setCreepCurrentHp(crba.getCreepCurrentHp() - getBulletDamage());
                        crba.setCreepVisibility();
                        if (crba.getCreepVisibility() == false) {
                            crba.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(crba.getX() + (crba.getCreepImage().getWidth() / 3), crba.getY(), 1, 50, true, crba.getCreepGoldBounty());
                            }
                        } else {
                            crba.setCreepStatusChillAilment("CHILL");
                            crba.setCreepStatusChillAilmentFactor(2);
                            crba.setCreepStatusChillAilmentTime(400);
                            crba.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepSpearmanAntList().size(); a++) {
                    CreepSpearmanAnt csa = (CreepSpearmanAnt) candyMagicPanel.getCreepSpearmanAntList().get(a);
                    if (csa.getCreepRectangle().intersects(bulletSplash)) {
                        csa.setCreepCurrentHp(csa.getCreepCurrentHp() - getBulletDamage());
                        csa.setCreepVisibility();
                        if (csa.getCreepVisibility() == false) {
                            csa.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(csa.getX() + (csa.getCreepImage().getWidth() / 3), csa.getY(), 1, 50, true, csa.getCreepGoldBounty());
                            }
                        } else {
                            csa.setCreepStatusChillAilment("CHILL");
                            csa.setCreepStatusChillAilmentFactor(2);
                            csa.setCreepStatusChillAilmentTime(400);
                            csa.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepSwordsmanAntList().size(); a++) {
                    CreepSwordsmanAnt crsa = (CreepSwordsmanAnt) candyMagicPanel.getCreepSwordsmanAntList().get(a);
                    if (crsa.getCreepRectangle().intersects(bulletSplash)) {
                        crsa.setCreepCurrentHp(crsa.getCreepCurrentHp() - getBulletDamage());
                        crsa.setCreepVisibility();
                        if (crsa.getCreepVisibility() == false) {
                            crsa.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(crsa.getX() + (crsa.getCreepImage().getWidth() / 3), crsa.getY(), 1, 50, true, crsa.getCreepGoldBounty());
                            }
                        } else {
                            crsa.setCreepStatusChillAilment("CHILL");
                            crsa.setCreepStatusChillAilmentFactor(2);
                            crsa.setCreepStatusChillAilmentTime(400);
                            crsa.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepKingAntList().size(); a++) {
                    CreepKingAnt cka = (CreepKingAnt) candyMagicPanel.getCreepKingAntList().get(a);
                    if (cka.getCreepRectangle().intersects(bulletSplash)) {
                        cka.setCreepCurrentHp(cka.getCreepCurrentHp() - getBulletDamage());
                        cka.setCreepVisibility();
                        if (cka.getCreepVisibility() == false) {
                            cka.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cka.getX() + (cka.getCreepImage().getWidth() / 3), cka.getY(), 1, 50, true, cka.getCreepGoldBounty());
                            }
                        } else {
                            cka.setCreepStatusChillAilment("CHILL");
                            cka.setCreepStatusChillAilmentFactor(2);
                            cka.setCreepStatusChillAilmentTime(400);
                            cka.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }
            } else if (getBulletLevel() == 3) {
                Rectangle bulletSplash = new Rectangle(getX() - 40, getY() - 40, 100, 100);
                for (int a = 0; a < candyMagicPanel.getCreepEggList().size(); a++) {
                    CreepEgg ce = (CreepEgg) candyMagicPanel.getCreepEggList().get(a);
                    if (ce.getCreepRectangle().intersects(bulletSplash)) {
                        ce.setCreepCurrentHp(ce.getCreepCurrentHp() - getBulletDamage());
                        ce.setCreepVisibility();
                        if (ce.getCreepVisibility() == false) {
                            ce.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(ce.getX() + (ce.getCreepImage().getWidth() / 3), ce.getY(), 1, 50, true, ce.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                ce.setCreepStatusChillAilment("FREEZE");
                                ce.setCreepMoveSpeed(0);
                                ce.setCreepStatusChillAilmentFactor(0);
                            } else {
                                ce.setCreepMoveSpeed(ce.getCreepMoveSpeedHolder());
                                ce.setCreepStatusChillAilment("CHILL");
                                ce.setCreepStatusChillAilmentFactor(3);
                            }
                            ce.setCreepStatusChillAilmentTime(500);
                            ce.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBigEggList().size(); a++) {
                    CreepBigEgg cbe = (CreepBigEgg) candyMagicPanel.getCreepBigEggList().get(a);
                    if (cbe.getCreepRectangle().intersects(bulletSplash)) {
                        cbe.setCreepCurrentHp(cbe.getCreepCurrentHp() - getBulletDamage());
                        cbe.setCreepVisibility();
                        if (cbe.getCreepVisibility() == false) {
                            cbe.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cbe.getX() + (cbe.getCreepImage().getWidth() / 3), cbe.getY(), 1, 50, true, cbe.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cbe.setCreepStatusChillAilment("FREEZE");
                                cbe.setCreepMoveSpeed(0);
                                cbe.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cbe.setCreepMoveSpeed(cbe.getCreepMoveSpeedHolder());
                                cbe.setCreepStatusChillAilment("CHILL");
                                cbe.setCreepStatusChillAilmentFactor(3);
                            }
                            cbe.setCreepStatusChillAilmentTime(500);
                            cbe.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepRageEggList().size(); a++) {
                    CreepRageEgg cre = (CreepRageEgg) candyMagicPanel.getCreepRageEggList().get(a);
                    if (cre.getCreepRectangle().intersects(bulletSplash)) {
                        cre.setCreepCurrentHp(cre.getCreepCurrentHp() - getBulletDamage());
                        cre.setCreepVisibility();
                        if (cre.getCreepVisibility() == false) {
                            cre.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cre.getX() + (cre.getCreepImage().getWidth() / 3), cre.getY(), 1, 50, true, cre.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cre.setCreepStatusChillAilment("FREEZE");
                                cre.setCreepMoveSpeed(0);
                                cre.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cre.setCreepMoveSpeed(cre.getCreepMoveSpeedHolder());
                                cre.setCreepStatusChillAilment("CHILL");
                                cre.setCreepStatusChillAilmentFactor(3);
                            }
                            cre.setCreepStatusChillAilmentTime(500);
                            cre.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBlackAntList().size(); a++) {
                    CreepBlackAnt cba = (CreepBlackAnt) candyMagicPanel.getCreepBlackAntList().get(a);
                    if (cba.getCreepRectangle().intersects(bulletSplash)) {
                        cba.setCreepCurrentHp(cba.getCreepCurrentHp() - getBulletDamage());
                        cba.setCreepVisibility();
                        if (cba.getCreepVisibility() == false) {
                            cba.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cba.getX() + (cba.getCreepImage().getWidth() / 3), cba.getY(), 1, 50, true, cba.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cba.setCreepStatusChillAilment("FREEZE");
                                cba.setCreepMoveSpeed(0);
                                cba.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cba.setCreepMoveSpeed(cba.getCreepMoveSpeedHolder());
                                cba.setCreepStatusChillAilment("CHILL");
                                cba.setCreepStatusChillAilmentFactor(3);
                            }
                            cba.setCreepStatusChillAilmentTime(500);
                            cba.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepRedAntList().size(); a++) {
                    CreepRedAnt cra = (CreepRedAnt) candyMagicPanel.getCreepRedAntList().get(a);
                    if (cra.getCreepRectangle().intersects(bulletSplash)) {
                        cra.setCreepCurrentHp(cra.getCreepCurrentHp() - getBulletDamage());
                        cra.setCreepVisibility();
                        if (cra.getCreepVisibility() == false) {
                            cra.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cra.getX() + (cra.getCreepImage().getWidth() / 3), cra.getY(), 1, 50, true, cra.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cra.setCreepStatusChillAilment("FREEZE");
                                cra.setCreepMoveSpeed(0);
                                cra.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cra.setCreepMoveSpeed(cra.getCreepMoveSpeedHolder());
                                cra.setCreepStatusChillAilment("CHILL");
                                cra.setCreepStatusChillAilmentFactor(3);
                            }
                            cra.setCreepStatusChillAilmentTime(500);
                            cra.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepRatList().size(); a++) {
                    CreepRat cr = (CreepRat) candyMagicPanel.getCreepRatList().get(a);
                    if (cr.getCreepRectangle().intersects(bulletSplash)) {
                        cr.setCreepCurrentHp(cr.getCreepCurrentHp() - getBulletDamage());
                        cr.setCreepVisibility();
                        if (cr.getCreepVisibility() == false) {
                            cr.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cr.getX() + (cr.getCreepImage().getWidth() / 3), cr.getY(), 1, 50, true, cr.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cr.setCreepStatusChillAilment("FREEZE");
                                cr.setCreepMoveSpeed(0);
                                cr.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cr.setCreepMoveSpeed(cr.getCreepMoveSpeedHolder());
                                cr.setCreepStatusChillAilment("CHILL");
                                cr.setCreepStatusChillAilmentFactor(3);
                            }
                            cr.setCreepStatusChillAilmentTime(500);
                            cr.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepButterflyList().size(); a++) {
                    CreepButterfly cb = (CreepButterfly) candyMagicPanel.getCreepButterflyList().get(a);
                    if (cb.getCreepRectangle().intersects(bulletSplash)) {
                        cb.setCreepCurrentHp(cb.getCreepCurrentHp() - getBulletDamage());
                        cb.setCreepVisibility();
                        if (cb.getCreepVisibility() == false) {
                            cb.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cb.getX() + (cb.getCreepImage().getWidth() / 3), cb.getY(), 1, 50, true, cb.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cb.setCreepStatusChillAilment("FREEZE");
                                cb.setCreepMoveSpeed(0);
                                cb.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cb.setCreepMoveSpeed(cb.getCreepMoveSpeedHolder());
                                cb.setCreepStatusChillAilment("CHILL");
                                cb.setCreepStatusChillAilmentFactor(3);
                            }
                            cb.setCreepStatusChillAilmentTime(500);
                            cb.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBeeList().size(); a++) {
                    CreepBee cbb = (CreepBee) candyMagicPanel.getCreepBeeList().get(a);
                    if (cbb.getCreepRectangle().intersects(bulletSplash)) {
                        cbb.setCreepCurrentHp(cbb.getCreepCurrentHp() - getBulletDamage());
                        cbb.setCreepVisibility();
                        if (cbb.getCreepVisibility() == false) {
                            cbb.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cbb.getX() + (cbb.getCreepImage().getWidth() / 3), cbb.getY(), 1, 50, true, cbb.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cbb.setCreepStatusChillAilment("FREEZE");
                                cbb.setCreepMoveSpeed(0);
                                cbb.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cbb.setCreepMoveSpeed(cbb.getCreepMoveSpeedHolder());
                                cbb.setCreepStatusChillAilment("CHILL");
                                cbb.setCreepStatusChillAilmentFactor(3);
                            }
                            cbb.setCreepStatusChillAilmentTime(500);
                            cbb.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepBoxerAntList().size(); a++) {
                    CreepBoxerAnt crba = (CreepBoxerAnt) candyMagicPanel.getCreepBoxerAntList().get(a);
                    if (crba.getCreepRectangle().intersects(bulletSplash)) {
                        crba.setCreepCurrentHp(crba.getCreepCurrentHp() - getBulletDamage());
                        crba.setCreepVisibility();
                        if (crba.getCreepVisibility() == false) {
                            crba.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(crba.getX() + (crba.getCreepImage().getWidth() / 3), crba.getY(), 1, 50, true, crba.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                crba.setCreepStatusChillAilment("FREEZE");
                                crba.setCreepMoveSpeed(0);
                                crba.setCreepStatusChillAilmentFactor(0);
                            } else {
                                crba.setCreepMoveSpeed(crba.getCreepMoveSpeedHolder());
                                crba.setCreepStatusChillAilment("CHILL");
                                crba.setCreepStatusChillAilmentFactor(3);
                            }
                            crba.setCreepStatusChillAilmentTime(500);
                            crba.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepSpearmanAntList().size(); a++) {
                    CreepSpearmanAnt csa = (CreepSpearmanAnt) candyMagicPanel.getCreepSpearmanAntList().get(a);
                    if (csa.getCreepRectangle().intersects(bulletSplash)) {
                        csa.setCreepCurrentHp(csa.getCreepCurrentHp() - getBulletDamage());
                        csa.setCreepVisibility();
                        if (csa.getCreepVisibility() == false) {
                            csa.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(csa.getX() + (csa.getCreepImage().getWidth() / 3), csa.getY(), 1, 50, true, csa.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                csa.setCreepStatusChillAilment("FREEZE");
                                csa.setCreepMoveSpeed(0);
                                csa.setCreepStatusChillAilmentFactor(0);
                            } else {
                                csa.setCreepMoveSpeed(csa.getCreepMoveSpeedHolder());
                                csa.setCreepStatusChillAilment("CHILL");
                                csa.setCreepStatusChillAilmentFactor(3);
                            }
                            csa.setCreepStatusChillAilmentTime(500);
                            csa.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepSwordsmanAntList().size(); a++) {
                    CreepSwordsmanAnt crsa = (CreepSwordsmanAnt) candyMagicPanel.getCreepSwordsmanAntList().get(a);
                    if (crsa.getCreepRectangle().intersects(bulletSplash)) {
                        crsa.setCreepCurrentHp(crsa.getCreepCurrentHp() - getBulletDamage());
                        crsa.setCreepVisibility();
                        if (crsa.getCreepVisibility() == false) {
                            crsa.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(crsa.getX() + (crsa.getCreepImage().getWidth() / 3), crsa.getY(), 1, 50, true, crsa.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                crsa.setCreepStatusChillAilment("FREEZE");
                                crsa.setCreepMoveSpeed(0);
                                crsa.setCreepStatusChillAilmentFactor(0);
                            } else {
                                crsa.setCreepMoveSpeed(crsa.getCreepMoveSpeedHolder());
                                crsa.setCreepStatusChillAilment("CHILL");
                                crsa.setCreepStatusChillAilmentFactor(3);
                            }
                            crsa.setCreepStatusChillAilmentTime(500);
                            crsa.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }

                for (int a = 0; a < candyMagicPanel.getCreepKingAntList().size(); a++) {
                    CreepKingAnt cka = (CreepKingAnt) candyMagicPanel.getCreepKingAntList().get(a);
                    if (cka.getCreepRectangle().intersects(bulletSplash)) {
                        cka.setCreepCurrentHp(cka.getCreepCurrentHp() - getBulletDamage());
                        cka.setCreepVisibility();
                        if (cka.getCreepVisibility() == false) {
                            cka.setCreepKilledBy(getBulletOwner());
                            if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                                candyMagicPanel.addObjectAnimation(cka.getX() + (cka.getCreepImage().getWidth() / 3), cka.getY(), 1, 50, true, cka.getCreepGoldBounty());
                            }
                        } else {
                            bulletChance = getBulletRandom().nextInt(100);
                            if (bulletChance >= 90) {
                                cka.setCreepStatusChillAilment("FREEZE");
                                cka.setCreepMoveSpeed(0);
                                cka.setCreepStatusChillAilmentFactor(0);
                            } else {
                                cka.setCreepMoveSpeed(cka.getCreepMoveSpeedHolder());
                                cka.setCreepStatusChillAilment("CHILL");
                                cka.setCreepStatusChillAilmentFactor(3);
                            }
                            cka.setCreepStatusChillAilmentTime(500);
                            cka.setCreepStatusChillAilmentTimeCounter(0);
                        }
                    }
                }
            }
        } else if (getBulletType() == 3) {
            Rectangle bulletSplash = new Rectangle(getX() - 40, getY() - 40, 100, 100);
            for (int a = 0; a < candyMagicPanel.getCreepEggList().size(); a++) {
                CreepEgg ce = (CreepEgg) candyMagicPanel.getCreepEggList().get(a);
                if (ce.getCreepRectangle().intersects(bulletSplash)) {
                    ce.setCreepCurrentHp(ce.getCreepCurrentHp() - getBulletDamage());
                    ce.setCreepVisibility();
                    if (ce.getCreepVisibility() == false) {
                        ce.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(ce.getX() + (ce.getCreepImage().getWidth() / 3), ce.getY(), 1, 50, true, ce.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBigEggList().size(); a++) {
                CreepBigEgg cbe = (CreepBigEgg) candyMagicPanel.getCreepBigEggList().get(a);
                if (cbe.getCreepRectangle().intersects(bulletSplash)) {
                    cbe.setCreepCurrentHp(cbe.getCreepCurrentHp() - getBulletDamage());
                    cbe.setCreepVisibility();
                    if (cbe.getCreepVisibility() == false) {
                        cbe.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cbe.getX() + (cbe.getCreepImage().getWidth() / 3), cbe.getY(), 1, 50, true, cbe.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRageEggList().size(); a++) {
                CreepRageEgg cre = (CreepRageEgg) candyMagicPanel.getCreepRageEggList().get(a);
                if (cre.getCreepRectangle().intersects(bulletSplash)) {
                    cre.setCreepCurrentHp(cre.getCreepCurrentHp() - getBulletDamage());
                    cre.setCreepVisibility();
                    if (cre.getCreepVisibility() == false) {
                        cre.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cre.getX() + (cre.getCreepImage().getWidth() / 3), cre.getY(), 1, 50, true, cre.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBlackAntList().size(); a++) {
                CreepBlackAnt cba = (CreepBlackAnt) candyMagicPanel.getCreepBlackAntList().get(a);
                if (cba.getCreepRectangle().intersects(bulletSplash)) {
                    cba.setCreepCurrentHp(cba.getCreepCurrentHp() - getBulletDamage());
                    cba.setCreepVisibility();
                    if (cba.getCreepVisibility() == false) {
                        cba.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cba.getX() + (cba.getCreepImage().getWidth() / 3), cba.getY(), 1, 50, true, cba.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRedAntList().size(); a++) {
                CreepRedAnt cra = (CreepRedAnt) candyMagicPanel.getCreepRedAntList().get(a);
                if (cra.getCreepRectangle().intersects(bulletSplash)) {
                    cra.setCreepCurrentHp(cra.getCreepCurrentHp() - getBulletDamage());
                    cra.setCreepVisibility();
                    if (cra.getCreepVisibility() == false) {
                        cra.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cra.getX() + (cra.getCreepImage().getWidth() / 3), cra.getY(), 1, 50, true, cra.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRatList().size(); a++) {
                CreepRat cr = (CreepRat) candyMagicPanel.getCreepRatList().get(a);
                if (cr.getCreepRectangle().intersects(bulletSplash)) {
                    cr.setCreepCurrentHp(cr.getCreepCurrentHp() - getBulletDamage());
                    cr.setCreepVisibility();
                    if (cr.getCreepVisibility() == false) {
                        cr.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cr.getX() + (cr.getCreepImage().getWidth() / 3), cr.getY(), 1, 50, true, cr.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepButterflyList().size(); a++) {
                CreepButterfly cb = (CreepButterfly) candyMagicPanel.getCreepButterflyList().get(a);
                if (cb.getCreepRectangle().intersects(bulletSplash)) {
                    cb.setCreepCurrentHp(cb.getCreepCurrentHp() - getBulletDamage());
                    cb.setCreepVisibility();
                    if (cb.getCreepVisibility() == false) {
                        cb.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cb.getX() + (cb.getCreepImage().getWidth() / 3), cb.getY(), 1, 50, true, cb.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBeeList().size(); a++) {
                CreepBee cbb = (CreepBee) candyMagicPanel.getCreepBeeList().get(a);
                if (cbb.getCreepRectangle().intersects(bulletSplash)) {
                    cbb.setCreepCurrentHp(cbb.getCreepCurrentHp() - getBulletDamage());
                    cbb.setCreepVisibility();
                    if (cbb.getCreepVisibility() == false) {
                        cbb.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cbb.getX() + (cbb.getCreepImage().getWidth() / 3), cbb.getY(), 1, 50, true, cbb.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBoxerAntList().size(); a++) {
                CreepBoxerAnt crba = (CreepBoxerAnt) candyMagicPanel.getCreepBoxerAntList().get(a);
                if (crba.getCreepRectangle().intersects(bulletSplash)) {
                    crba.setCreepCurrentHp(crba.getCreepCurrentHp() - getBulletDamage());
                    crba.setCreepVisibility();
                    if (crba.getCreepVisibility() == false) {
                        crba.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(crba.getX() + (crba.getCreepImage().getWidth() / 3), crba.getY(), 1, 50, true, crba.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepSpearmanAntList().size(); a++) {
                CreepSpearmanAnt crsa = (CreepSpearmanAnt) candyMagicPanel.getCreepSpearmanAntList().get(a);
                if (crsa.getCreepRectangle().intersects(bulletSplash)) {
                    crsa.setCreepCurrentHp(crsa.getCreepCurrentHp() - getBulletDamage());
                    crsa.setCreepVisibility();
                    if (crsa.getCreepVisibility() == false) {
                        crsa.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(crsa.getX() + (crsa.getCreepImage().getWidth() / 3), crsa.getY(), 1, 50, true, crsa.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepSwordsmanAntList().size(); a++) {
                CreepSwordsmanAnt crsa = (CreepSwordsmanAnt) candyMagicPanel.getCreepSwordsmanAntList().get(a);
                if (crsa.getCreepRectangle().intersects(bulletSplash)) {
                    crsa.setCreepCurrentHp(crsa.getCreepCurrentHp() - getBulletDamage());
                    crsa.setCreepVisibility();
                    if (crsa.getCreepVisibility() == false) {
                        crsa.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(crsa.getX() + (crsa.getCreepImage().getWidth() / 3), crsa.getY(), 1, 50, true, crsa.getCreepGoldBounty());
                        }
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepKingAntList().size(); a++) {
                CreepKingAnt cka = (CreepKingAnt) candyMagicPanel.getCreepKingAntList().get(a);
                if (cka.getCreepRectangle().intersects(bulletSplash)) {
                    cka.setCreepCurrentHp(cka.getCreepCurrentHp() - getBulletDamage());
                    cka.setCreepVisibility();
                    if (cka.getCreepVisibility() == false) {
                        cka.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cka.getX() + (cka.getCreepImage().getWidth() / 3), cka.getY(), 1, 50, true, cka.getCreepGoldBounty());
                        }
                    }
                }
            }
        } else if (getBulletType() == 7) {
            Rectangle bulletSplash = new Rectangle(getX() - 40, getY() - 40, 100, 100);
            for (int a = 0; a < candyMagicPanel.getCreepEggList().size(); a++) {
                CreepEgg ce = (CreepEgg) candyMagicPanel.getCreepEggList().get(a);
                if (ce.getCreepRectangle().intersects(bulletSplash)) {
                    ce.setCreepCurrentHp(ce.getCreepCurrentHp() - getBulletDamage());
                    ce.setCreepVisibility();
                    if (ce.getCreepVisibility() == false) {
                        ce.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(ce.getX() + (ce.getCreepImage().getWidth() / 3), ce.getY(), 1, 50, true, ce.getCreepGoldBounty());
                        }
                    } else {
                        ce.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            ce.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            ce.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            ce.setCreepStatusPoisonAilmentFactor(70);
                        }
                        ce.setCreepStatusPoisonAilmentTime(500);
                        ce.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBigEggList().size(); a++) {
                CreepBigEgg cbe = (CreepBigEgg) candyMagicPanel.getCreepBigEggList().get(a);
                if (cbe.getCreepRectangle().intersects(bulletSplash)) {
                    cbe.setCreepCurrentHp(cbe.getCreepCurrentHp() - getBulletDamage());
                    cbe.setCreepVisibility();
                    if (cbe.getCreepVisibility() == false) {
                        cbe.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cbe.getX() + (cbe.getCreepImage().getWidth() / 3), cbe.getY(), 1, 50, true, cbe.getCreepGoldBounty());
                        }
                    } else {
                        cbe.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cbe.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cbe.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cbe.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cbe.setCreepStatusPoisonAilmentTime(500);
                        cbe.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRageEggList().size(); a++) {
                CreepRageEgg cre = (CreepRageEgg) candyMagicPanel.getCreepRageEggList().get(a);
                if (cre.getCreepRectangle().intersects(bulletSplash)) {
                    cre.setCreepCurrentHp(cre.getCreepCurrentHp() - getBulletDamage());
                    cre.setCreepVisibility();
                    if (cre.getCreepVisibility() == false) {
                        cre.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cre.getX() + (cre.getCreepImage().getWidth() / 3), cre.getY(), 1, 50, true, cre.getCreepGoldBounty());
                        }
                    } else {
                        cre.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cre.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cre.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cre.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cre.setCreepStatusPoisonAilmentTime(500);
                        cre.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBlackAntList().size(); a++) {
                CreepBlackAnt cba = (CreepBlackAnt) candyMagicPanel.getCreepBlackAntList().get(a);
                if (cba.getCreepRectangle().intersects(bulletSplash)) {
                    cba.setCreepCurrentHp(cba.getCreepCurrentHp() - getBulletDamage());
                    cba.setCreepVisibility();
                    if (cba.getCreepVisibility() == false) {
                        cba.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cba.getX() + (cba.getCreepImage().getWidth() / 3), cba.getY(), 1, 50, true, cba.getCreepGoldBounty());
                        }
                    } else {
                        cba.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cba.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cba.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cba.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cba.setCreepStatusPoisonAilmentTime(500);
                        cba.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRedAntList().size(); a++) {
                CreepRedAnt cra = (CreepRedAnt) candyMagicPanel.getCreepRedAntList().get(a);
                if (cra.getCreepRectangle().intersects(bulletSplash)) {
                    cra.setCreepCurrentHp(cra.getCreepCurrentHp() - getBulletDamage());
                    cra.setCreepVisibility();
                    if (cra.getCreepVisibility() == false) {
                        cra.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cra.getX() + (cra.getCreepImage().getWidth() / 3), cra.getY(), 1, 50, true, cra.getCreepGoldBounty());
                        }
                    } else {
                        cra.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cra.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cra.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cra.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cra.setCreepStatusPoisonAilmentTime(500);
                        cra.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepRatList().size(); a++) {
                CreepRat cr = (CreepRat) candyMagicPanel.getCreepRatList().get(a);
                if (cr.getCreepRectangle().intersects(bulletSplash)) {
                    cr.setCreepCurrentHp(cr.getCreepCurrentHp() - getBulletDamage());
                    cr.setCreepVisibility();
                    if (cr.getCreepVisibility() == false) {
                        cr.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cr.getX() + (cr.getCreepImage().getWidth() / 3), cr.getY(), 1, 50, true, cr.getCreepGoldBounty());
                        }
                    } else {
                        cr.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cr.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cr.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cr.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cr.setCreepStatusPoisonAilmentTime(500);
                        cr.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepButterflyList().size(); a++) {
                CreepButterfly cb = (CreepButterfly) candyMagicPanel.getCreepButterflyList().get(a);
                if (cb.getCreepRectangle().intersects(bulletSplash)) {
                    cb.setCreepCurrentHp(cb.getCreepCurrentHp() - getBulletDamage());
                    cb.setCreepVisibility();
                    if (cb.getCreepVisibility() == false) {
                        cb.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cb.getX() + (cb.getCreepImage().getWidth() / 3), cb.getY(), 1, 50, true, cb.getCreepGoldBounty());
                        }
                    } else {
                        cb.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cb.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cb.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cb.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cb.setCreepStatusPoisonAilmentTime(500);
                        cb.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBeeList().size(); a++) {
                CreepBee cbb = (CreepBee) candyMagicPanel.getCreepBeeList().get(a);
                if (cbb.getCreepRectangle().intersects(bulletSplash)) {
                    cbb.setCreepCurrentHp(cbb.getCreepCurrentHp() - getBulletDamage());
                    cbb.setCreepVisibility();
                    if (cbb.getCreepVisibility() == false) {
                        cbb.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cbb.getX() + (cbb.getCreepImage().getWidth() / 3), cbb.getY(), 1, 50, true, cbb.getCreepGoldBounty());
                        }
                    } else {
                        cbb.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cbb.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cbb.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cbb.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cbb.setCreepStatusPoisonAilmentTime(500);
                        cbb.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepBoxerAntList().size(); a++) {
                CreepBoxerAnt crba = (CreepBoxerAnt) candyMagicPanel.getCreepBoxerAntList().get(a);
                if (crba.getCreepRectangle().intersects(bulletSplash)) {
                    crba.setCreepCurrentHp(crba.getCreepCurrentHp() - getBulletDamage());
                    crba.setCreepVisibility();
                    if (crba.getCreepVisibility() == false) {
                        crba.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(crba.getX() + (crba.getCreepImage().getWidth() / 3), crba.getY(), 1, 50, true, crba.getCreepGoldBounty());
                        }
                    } else {
                        crba.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            crba.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            crba.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            crba.setCreepStatusPoisonAilmentFactor(70);
                        }
                        crba.setCreepStatusPoisonAilmentTime(500);
                        crba.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepSpearmanAntList().size(); a++) {
                CreepSpearmanAnt csa = (CreepSpearmanAnt) candyMagicPanel.getCreepSpearmanAntList().get(a);
                if (csa.getCreepRectangle().intersects(bulletSplash)) {
                    csa.setCreepCurrentHp(csa.getCreepCurrentHp() - getBulletDamage());
                    csa.setCreepVisibility();
                    if (csa.getCreepVisibility() == false) {
                        csa.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(csa.getX() + (csa.getCreepImage().getWidth() / 3), csa.getY(), 1, 50, true, csa.getCreepGoldBounty());
                        }
                    } else {
                        csa.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            csa.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            csa.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            csa.setCreepStatusPoisonAilmentFactor(70);
                        }
                        csa.setCreepStatusPoisonAilmentTime(500);
                        csa.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepSwordsmanAntList().size(); a++) {
                CreepSwordsmanAnt crsa = (CreepSwordsmanAnt) candyMagicPanel.getCreepSwordsmanAntList().get(a);
                if (crsa.getCreepRectangle().intersects(bulletSplash)) {
                    crsa.setCreepCurrentHp(crsa.getCreepCurrentHp() - getBulletDamage());
                    crsa.setCreepVisibility();
                    if (crsa.getCreepVisibility() == false) {
                        crsa.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(crsa.getX() + (crsa.getCreepImage().getWidth() / 3), crsa.getY(), 1, 50, true, crsa.getCreepGoldBounty());
                        }
                    } else {
                        crsa.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            crsa.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            crsa.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            crsa.setCreepStatusPoisonAilmentFactor(70);
                        }
                        crsa.setCreepStatusPoisonAilmentTime(500);
                        crsa.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }

            for (int a = 0; a < candyMagicPanel.getCreepKingAntList().size(); a++) {
                CreepKingAnt cka = (CreepKingAnt) candyMagicPanel.getCreepKingAntList().get(a);
                if (cka.getCreepRectangle().intersects(bulletSplash)) {
                    cka.setCreepCurrentHp(cka.getCreepCurrentHp() - getBulletDamage());
                    cka.setCreepVisibility();
                    if (cka.getCreepVisibility() == false) {
                        cka.setCreepKilledBy(getBulletOwner());
                        if (candyMagicPanel.playerName.equals(getBulletOwner())) {
                            candyMagicPanel.addObjectAnimation(cka.getX() + (cka.getCreepImage().getWidth() / 3), cka.getY(), 1, 50, true, cka.getCreepGoldBounty());
                        }
                    } else {
                        cka.setCreepStatusPoisonAilment("POISON");
                        if (getBulletLevel() == 1) {
                            cka.setCreepStatusPoisonAilmentFactor(20);
                        } else if (getBulletLevel() == 2) {
                            cka.setCreepStatusPoisonAilmentFactor(40);
                        } else if (getBulletLevel() == 3) {
                            cka.setCreepStatusPoisonAilmentFactor(70);
                        }
                        cka.setCreepStatusPoisonAilmentTime(500);
                        cka.setCreepStatusPoisonAilmentTimeCounter(0);
                    }
                }
            }
        }
    }

    public void loadSoundToPlay() {
        if (getX() >= candyMagicPanel.camX && getX() <= (candyMagicPanel.camX + candyMagicPanel.screenWidth)) {
            if (getY() >= candyMagicPanel.camY && getY() <= (candyMagicPanel.camY + candyMagicPanel.screenHeight)) {
                if (getBulletType() == 2) {
                    candyMagicPanel.onPlaySoundClip(4);
                } else if (getBulletType() == 3) {
                    candyMagicPanel.onPlaySoundClip(6);
                } else if (getBulletType() == 4) {
                    candyMagicPanel.onPlaySoundClip(8);
                } else if (getBulletType() == 7) {
                    candyMagicPanel.onPlaySoundClip(12);
                }
            }
        }
    }
}
