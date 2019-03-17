package staticProxy;

/**
 * 游戏代练
 * @author wujiazhen
 * @date 2019/3/17
 */
public class GameProxy implements IGamePlayer{

    private IGamePlayer gamePlayer;
    public GameProxy(IGamePlayer gamePlayer){
        this.gamePlayer=gamePlayer;
    }
    @Override
    public void playGame() {
        System.out.println("代练");
        gamePlayer.playGame();
    }
}
