import java.util.HashMap;
import java.util.Map;

/**
 * 场景：
 * 游戏中每人完成任务都会获取一个相同的奖励。即玩家A 完成 任务1 时，需要创建一个奖励对象 ,将各种奖励put进map中
 * 后面玩家B,C在完成任务1时，也需要同样的操作。如果任务1的奖励多时，每个创建一个奖励对象都十分繁琐。这是通过
 * 使用原型模式，保存一个任务1的任务奖励，通过克隆创建。
 * @author wujiazhen
 * @date 2019/3/17
 */
public class Client {

    private static Map<Integer,Reward> map;
    static {
        map=new HashMap<Integer, Reward>();
        Reward reward1 = new Reward();
        map.put(1, reward1);
        reward1.setRewards(new HashMap<String, Integer>());
        reward1.getRewards().put("屠龙刀",1);
        reward1.getRewards().put("宝石",10);
        reward1.getRewards().put("倚天剑",10);
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Player playerA =new Player("A");
        playerA.completeQuest(1);
        //因为玩家其他操作可能会改变Reward，所以这里的Reward必须深拷贝
        playerA.addReward((Reward) map.get(1).clone());
        Player playerB =new Player("B");
        playerB.completeQuest(2);
        playerB.addReward((Reward) map.get(1).clone());
    }
}
