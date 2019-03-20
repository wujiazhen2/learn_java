package template;

/**
 * 加血技能
 *
 * @author wujiazhen
 * @date 2019/3/20
 */
public class HelpfulSkillEffect extends AbstractSkillEffect {

    /**
     * 有益的技能是加血
     *
     * @param player
     * @param hurt
     */
    protected void hurt(Player player, int hurt) {
        player.increHp(hurt);
    }

    /**
     * 加血加给自己
     *
     * @param skill
     * @return
     */
    protected Player selectTarget(Skill skill) {
        return skill.getPlayer();
    }
}
