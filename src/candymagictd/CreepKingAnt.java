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
public class CreepKingAnt extends Creep {
    
    public CreepKingAnt(CandyMagicPanel cmp, int mx, int my, int hp, int ms, boolean inv, boolean detected, int bnty, int sl, BufferedImage creepEggImage) {
        setCandyMagicPanel(cmp);
        setX(mx);
        setY(my);
        setCreepMaxHp(hp);
        setCreepCurrentHp(hp);
        setCreepVisibility();
        setCreepMoveSpeed(ms);
        setCreepMoveSpeedHolder(ms);
        setCreepGoldBounty(bnty);
        setCreepSpawnLocation(sl);
        setCreepStatusChillAilmentTime(0);
        setCreepStatusChillAilmentTimeCounter(0);
        setCreepStatusChillAilmentFactor(0);
        setCreepStatusChillAilment("NORMAL");
        setCreepStatusPoisonAilmentTime(0);
        setCreepStatusPoisonAilmentTimeCounter(0);
        setCreepStatusPoisonAilmentFactor(0);
        setCreepStatusPoisonAilment("NORMAL");
        setCreepCollideOnCastle(false);
        setCreepInvisibility(inv);
        setCreepDetection(detected);
        setCreepImage(creepEggImage);
    }
    
    public void creepMovementStepAnimation() {
        if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("NORMAL") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(132));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("NORMAL") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(138));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(133));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(139));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(134));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(140));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("NORMAL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(135));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("NORMAL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(141));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(136));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(142));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(137));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(143));
            setCreepAnimation(0);
        }
    }
}
