import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/3/20
 */
public class Context {

    private IRankStrategy rankStrategy;

    public void setStrategy(IRankStrategy rankStrategy){
        this.rankStrategy=rankStrategy;
    }

    public void rank(List<Player> playerList){
        this.rankStrategy.rank(playerList);
    }
}
