package hungry;

/**
 * 饿汉式-单例模式
 * 在类加载时就初始化,所以不存在线程安全问题,执行效率高
 * 但是过早初始化，不管用没用到都占用空间
 * @author wujiazhen
 * @date 2019/3/13
 */
public class HungrySingleton {
    private static final HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getSingleton(){
        return singleton;
    }
}
