package lazy;

/**
 * 懒汉式-DCL  double check lock
 * 通过双重检查锁的方式来解决线程安全问题。
 * 双重检查是为了提高执行效率，除了第一次调用{@link lazy.LazyDclSigleton#getSigleton }方法时会进去锁区域，后面siglenton已经实例化的情况下调用{@link lazy.LazyDclSigleton#getSigleton }不会再进去获取锁。
 * 这里的双重检查仍然存在问题:
 *  sigleton=new LazyDclSigleton() 实例化对象过程并不是原子性的，可以分为以下三步。
 *
 *  menory=allocate();    //1.分配内存
 *  ctorInstance(menory); //2.初始化
 *  sigleton=menory;      //3.赋值给instance
 *
 *  intra-thread semantics（线程内语义）允许那些在单线程内，不会改变单线程程序执行结果的重排序。重排序后的顺序：
 *
 *  menory=allocate();    //1.分配内存
 *  sigleton=menory;      //2.赋值给instance
 *  ctorInstance(menory); //3.初始化
 *
 *  当执行的第二句时，线程B调用{@link lazy.LazyDclSigleton#getSigleton }。判断sigleton!=null,返回sigleton对象。这时线程B拿到的就是一个未初始化的对象。
 * @author wujiazhen
 * @date 2019/3/13
 */
public class LazyDclSigleton {
    private static LazyDclSigleton sigleton;

    private LazyDclSigleton(){}

    public static LazyDclSigleton getSigleton(){
        if(sigleton==null){
             synchronized (LazyDclSigleton.class){
                 if(sigleton==null){
                     sigleton=new LazyDclSigleton();
                 }
             }
        }
        return sigleton;
    }
}
