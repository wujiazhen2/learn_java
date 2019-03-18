package staticProxy;

import java.util.Calendar;

/**
 * 游戏代练
 * @author wujiazhen
 * @date 2019/3/17
 */
public class Parent implements Persion{

    private Persion son;
    public Parent(Persion son){
        this.son =son;
    }
    public void playGame() {
        if(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>22){
            System.out.println("晚上10点后，父母不让儿子玩游戏");
        }else {
            son.playGame();
        }
    }
}
