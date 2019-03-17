import java.util.ArrayList;
import java.util.List;

/**
 * @author wujiazhen
 * @date 2019/3/17
 */
public class Player {

    private String name;
    public Player(String name){
        this.name=name;
    }
    private List<Reward> reward=new ArrayList<Reward>();

     public void addReward(Reward reward){
         this.reward.add(reward);
         System.out.println("玩家"+name+"获取奖励"+reward.toString());
     }

     public void completeQuest(int questId){
         System.out.println("玩家"+name+"完成任务"+questId);
     }


}
