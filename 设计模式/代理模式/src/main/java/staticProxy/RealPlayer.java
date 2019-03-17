package staticProxy;

/**
 * 游戏玩家本人
 * @author wujiazhen
 * @date 2019/3/17
 */
public class RealPlayer implements IGamePlayer {
    @Override
    public void playGame() {
        System.out.println("玩游戏");
    }
}
