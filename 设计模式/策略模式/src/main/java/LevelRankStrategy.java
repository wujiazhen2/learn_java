import java.util.Comparator;
import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/3/20
 */
public class LevelRankStrategy implements IRankStrategy {
    public void rank(List<Player> playerList) {
        System.out.println("===================等级排行榜==============================");
        playerList.sort(Comparator.comparingInt(Player::getLevel).reversed());
        int i=1;
        for (Player player : playerList) {
            System.out.println(String.format("%s 第%d名，等级%d",player.getName(),i++,player.getLevel()));
        }
        System.out.println("===================等级排行榜==============================");

    }
}
