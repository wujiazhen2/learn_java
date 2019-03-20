package template;

/**
 * @author wujiazhen
 * @date 2019/3/20
 */
public class Player {
    public String name;

    public Player(String name) {
        this.name = name;
    }

    public void increHp(int hurt) {
        System.out.println(String.format("玩家%s加了%d血", name, hurt));
    }

    public void decreHp(int hurt) {
        System.out.println(String.format("玩家%s减了%d血", name, hurt));
    }

    public void cast(Skill skill, AbstractSkillEffect abstractSkillEffect) {
        skill.setPlayer(this);
        abstractSkillEffect.cast(skill);
    }
}
