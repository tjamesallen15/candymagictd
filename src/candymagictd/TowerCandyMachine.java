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
public class TowerCandyMachine extends Tower {
    
     public TowerCandyMachine(CandyMagicPanel cmp, int tx, int ty, BufferedImage tImg, String owner) {
        setX(tx);
        setY(ty);
        setTowerType(4);
        setTowerLevel(1);
        setTowerMaxTarget(1);
        setTowerMaxTargetCounter(0);
        setTowerUpgradeCost(500);
        setTowerDamage(30);
        setTowerAttackSpeed(200);
        setTowerAttackSpeedCounter(0);
        setTowerAttackBleedFactor(0);
        setTowerRangeDeductor(175);
        setTowerRangeWidth(400);
        setTowerRangeHeight(400);
        setTowerStatus(true);
        setTowerVisibility();
        setTowerShootingStatus(false);
        setTowerClicked(false);
        setTowerImage(tImg);
        setCandyMagicPanel(cmp);
        setTowerOwner(owner);
    }
}
