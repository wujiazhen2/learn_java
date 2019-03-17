package lazy;

/**
 * 懒汉式
 * 在第一次调用获取单例对象方法的时候才会创建对象。
 * 由于多个线程存在共享资源（单例对象），存在线程安全问题。
 * @author wujiazhen
 * @date 2019/3/13
 */
public class LazySigleton {
    private static LazySigleton sigleton;

    private LazySigleton(){}

    public static LazySigleton getSigleton(){
        //典型的check-then-act,有可能多个线程执行到语句2
        if(sigleton==null){   //  1
             sigleton=new LazySigleton();  //2
        }
        return sigleton;
    }
}
