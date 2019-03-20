/**
 * @author wujiazhen
 * @date 2019/3/20
 */
public class Client {

    public static void main(String[] args){
        /**
         * 场景:项目中存在一个buff，现在需求需要有一个和buff效果一样的技能。玩家通过释放技能使改buff生效。而我玩家的技能释放方法接受的是技能
         * 参数。这时使用适配器模式,使buff可以适配skill
         */
        Player player=new Player();
        player.cast(new SkillAdapter());
    }
}
