package lazy;

/**
 * 懒汉式-内部类方式
 * 通过内部类方式，静态内部类只有在使用的时候才会执行类加载过程。
 * 类加载过程中，java会通过锁来保证只执行一次类加载。所以不存在线程安全问题。
 * @author wujiazhen
 * @date 2019/3/13
 */
public class LazyInnerClassLoadSigleton {
    private volatile static LazyInnerClassLoadSigleton sigleton;

    private LazyInnerClassLoadSigleton(){}

    public static LazyInnerClassLoadSigleton getSigleton(){
       return InstanceHolder.instance;
    }

    private static class InstanceHolder{
        public final static  LazyInnerClassLoadSigleton  instance= new LazyInnerClassLoadSigleton();
    }
}
