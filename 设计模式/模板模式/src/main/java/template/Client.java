package template;

/**
 * @author wujiazhen
 * @date 2019/3/20
 */
public class Client {

    public static void main(String[] args) {
        /**
         * 简单一个例子。描述一个技能释放的流程
         *  1.计算技能cd
         *  2.技能消耗
         *  3.选择技能目标
         *  4.计算技能伤害
         *  5.扣除技能伤害
         *
         *  然后存在两种技能，一个扣血的技能，给技能目标扣血，一种加血的技能给释放技能的玩家加血;
         */
        //技能目标玩家B，伤害50
        Skill skill = new Skill(50, new Player("B"));
        Player player = new Player("A");
        //玩家A释放加血技能，给自己加血
        player.cast(skill, new HelpfulSkillEffect());
        //玩家A释放伤害技能，给玩家B扣血
        player.cast(skill, new HarmfulSkillEffect());
    }
}
