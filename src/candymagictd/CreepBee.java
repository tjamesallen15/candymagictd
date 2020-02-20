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
public class CreepBee extends Creep {
    
    public CreepBee(CandyMagicPanel cmp, int mx, int my, int hp, int ms, boolean inv, boolean detected, int bnty, int sl, BufferedImage creepEggImage) {
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
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(84));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("NORMAL") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(90));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(85));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(91));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(86));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("NORMAL")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(92));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("NORMAL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(87));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("NORMAL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(93));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(88));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("CHILL") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(94));
            setCreepAnimation(0);
        } else if (getCreepAnimation() == 0 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(89));
            setCreepAnimation(1);
        } else if (getCreepAnimation() == 1 && getCreepStatusChillAilment().equals("FREEZE") && getCreepStatusPoisonAilment().equals("POISON")) {
            setCreepImage((BufferedImage) candyMagicPanel.getCreepImageList().get(95));
            setCreepAnimation(0);
        }
    }
}
