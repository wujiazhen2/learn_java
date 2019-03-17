import java.util.HashMap;
import java.util.Map;
/**
 * @author wujiazhen
 * @date 2019/3/17
 */
public class Reward  {
    /**
     * 奖励物品：数量
     */
    private Map<String,Integer> rewards;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Reward reward = new Reward();
        if(!this.rewards.isEmpty()){
            reward.rewards=new HashMap<String, Integer>();
            reward.rewards.putAll(this.rewards);
        }
        return reward;
    }

    public Map<String, Integer> getRewards() {
        return rewards;
    }

    public void setRewards(Map<String, Integer> rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for (Map.Entry<String,Integer> entry:this.rewards.entrySet()){
            stringBuilder.append(entry.getKey()).append(entry.getValue()).append("个\n");
        }
        return stringBuilder.toString();
    }
}
