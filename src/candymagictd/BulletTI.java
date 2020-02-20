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
public class BulletTI extends Bullet {
    
    public BulletTI(CandyMagicPanel cmp, int bx, int by, int bdmg, int btype, int blvl, boolean vb, BufferedImage bImg, CreepEgg ce, CreepBigEgg cbe, CreepRageEgg cre, CreepBlackAnt cba, CreepRedAnt cra, CreepRat cr, CreepButterfly cb, CreepBee cbb, CreepBoxerAnt crba, CreepSpearmanAnt csa, CreepSwordsmanAnt crsa, CreepKingAnt cka, String owner) {
        setX(bx);
        setY(by);
        setBulletDamage(bdmg);
        setBulletType(btype);
        setBulletLevel(blvl);
        setBulletSpeed(1);
        setBulletVisibilty(vb);
        setBulletImage(bImg);
        setCandyMagicPanel(cmp);
        setCreepEggTarget(ce);
        setCreepBigEggTarget(cbe);
        setCreepRageEggTarget(cre);
        setCreepBlackAntTarget(cba);
        setCreepRedAntTarget(cra);
        setCreepRatTarget(cr);
        setCreepButterflyTarget(cb);
        setCreepBeeTarget(cbb);
        setCreepBoxerAntTarget(crba);
        setCreepSpearmanAntTarget(csa);
        setCreepSwordsmanAntTarget(crsa);
        setCreepKingAntTarget(cka);
        setBulletOwner(owner);
    }
}
