package lazy;

import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 懒汉式-内部类方式
 * 通过内部类方式，静态内部类只有在使用的时候才会执行类加载过程。
 * 类加载过程中，java会通过锁来保证只执行一次类加载。所以不存在线程安全问题。
 * @author wujiazhen
 * @date 2019/3/13
 */
public class LazyInnerClassLoadSigleton implements Serializable {
    private volatile static LazyInnerClassLoadSigleton sigleton;

    private LazyInnerClassLoadSigleton(){
        //处理反射破坏单例的情况
        if(InstanceHolder.instance!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 解决反序列化导致破坏单例的情况
     * {@link ObjectInputStream#readObject() }中会判断对象是否存在readResolve方法,存在则用readResolve返回的对象替换反序列化的对象
     * 所有其实反序列还是会创建了另一个对象。这个处理方案只是保证拿到手的对象都是同一个
     */
    private Object readResolve(){
        return InstanceHolder.instance;
    }

    public static LazyInnerClassLoadSigleton getSigleton(){
       return InstanceHolder.instance;
    }

    private static class InstanceHolder{
        public final static  LazyInnerClassLoadSigleton  instance= new LazyInnerClassLoadSigleton();
    }
}
