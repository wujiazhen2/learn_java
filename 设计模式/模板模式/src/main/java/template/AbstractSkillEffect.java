package template;

/**
 * 处理技能效果
 *
 * @author wujiazhen
 * @date 2019/3/20
 */
public abstract class AbstractSkillEffect {
    /**
     * 一个技能释放的主要流程
     * 1.计算技能cd
     * 2.技能消耗
     * 3.选择技能目标
     * 4.计算技能伤害
     * 5.扣除技能伤害
     *
     * @param skill
     */
    public void cast(Skill skill) {
        if (!cd(skill)) {
            return;
        }
        consumer(skill);
        Player player = selectTarget(skill);
        int hurt = countHurt(skill);
        hurt(player, hurt);
    }

    protected abstract void hurt(Player player, int hurt);

    protected int countHurt(Skill skill) {
        return skill.hurt;
    }

    ;

    protected abstract Player selectTarget(Skill skill);

    protected void consumer(Skill skill) {
        System.out.println("消耗mp");
    }

    ;

    protected boolean cd(Skill skill) {
        return true;
    }


}
