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
public class TowerCherryBolt extends Tower {
    
    public TowerCherryBolt(CandyMagicPanel cmp, int tx, int ty, BufferedImage tImg, String owner) {
        setX(tx);
        setY(ty);
        setTowerType(3);
        setTowerLevel(1);
        setTowerMaxTarget(1);
        setTowerMaxTargetCounter(0);
        setTowerUpgradeCost(500);
        setTowerDamage(100);
        setTowerAttackSpeed(400);
        setTowerAttackSpeedCounter(0);
        setTowerAttackBleedFactor(0);
        setTowerRangeDeductor(75);
        setTowerRangeWidth(200);
        setTowerRangeHeight(200);
        setTowerStatus(true);
        setTowerVisibility();
        setTowerShootingStatus(false);
        setTowerClicked(false);
        setTowerImage(tImg);
        setCandyMagicPanel(cmp);
        setTowerOwner(owner);
    }
}
