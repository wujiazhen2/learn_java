import java.util.Comparator;
import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/3/20
 */
public class VipRankStrategy implements IRankStrategy {

    public void rank(List<Player> playerList) {
        System.out.println("===================vip排行榜==============================");
        playerList.sort(Comparator.comparingInt(Player::getVip).reversed());
        int i=1;
        for (Player player : playerList) {
            System.out.println(String.format("%s 第%d名，vip%d",player.getName(),i++,player.getVip()));
        }
        System.out.println("===================vip排行榜==============================");
    }
}
