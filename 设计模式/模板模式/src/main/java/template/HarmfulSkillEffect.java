package template;

/**
 * 减血技能
 *
 * @author wujiazhen
 * @date 2019/3/20
 */
public class HarmfulSkillEffect extends AbstractSkillEffect {

    /**
     * 扣血
     *
     * @param player
     * @param hurt
     */
    protected void hurt(Player player, int hurt) {
        player.decreHp(hurt);
    }

    /**
     * 给对方扣血
     *
     * @param skill
     * @return
     */
    protected Player selectTarget(Skill skill) {
        return skill.getTarget();
    }
}
