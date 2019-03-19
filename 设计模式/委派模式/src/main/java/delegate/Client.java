package delegate;

/**
 * @author wujiazhen
 * @date 2019/3/19
 */
public class Client {

    public static void main(String[] args){
        Leader leader = new Leader();
        leader.doWork("程序");
    }
}
