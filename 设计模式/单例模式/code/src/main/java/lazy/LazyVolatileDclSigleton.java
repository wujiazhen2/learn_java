package lazy;

/**
 * 懒汉式-DCL  double check lock
 * dcl的问题是重排序引起的 ，通过volatile关键字禁止重排序即可
 * volatile关键字的语义
 * 1. 保证可见性
 * 2. 禁止重排序
 * @author wujiazhen
 * @date 2019/3/13
 */
public class LazyVolatileDclSigleton {
    private volatile static LazyVolatileDclSigleton sigleton;

    private LazyVolatileDclSigleton(){}

    public static LazyVolatileDclSigleton getSigleton(){
        if(sigleton==null){
             synchronized (LazyVolatileDclSigleton.class){
                 if(sigleton==null){
                     sigleton=new LazyVolatileDclSigleton();
                 }
             }
        }
        return sigleton;
    }
}
