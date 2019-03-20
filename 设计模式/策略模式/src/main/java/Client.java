import java.util.ArrayList;
import java.util.List;

/**
 * @author wujiazhen
 * @Date 2019/3/20
 */
public class Client {


    public  static  void main(String[] args){
        /**
         * 游戏中存在很多排行榜。通过玩家的等级或vip进行排行
         * 这里通过将玩家的等级和vip这两种排行方法封装成2中策列。
         * 通过排行榜的类型选择合适的策略进行排行。
         */
        List<Player> objects = new ArrayList<>();
        objects.add(new Player("A",1,11));
        objects.add(new Player("B",11,2));
        objects.add(new Player("C",10,13));

        Context context = new Context();
        context.setStrategy(new LevelRankStrategy());
        context.rank(objects);

        context.setStrategy(new VipRankStrategy());
        context.rank(objects);
    }
}
