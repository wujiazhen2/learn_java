# 单例模式
单例模式就是保证再一个应用中该类只存在一个对象。
1.常用于在一个应用中起全局作业的对象,例如web中的 ServletConfig,ServletContext等全局对象都需要保证单例。
2.用于不存在状态的状态的对象，减少内存开销，不需要建立多个对象。如平常web开发中的 Controller,Service..

## 单例的写法

### 饿汉式

```java
public class HungrySingleton {
    private static final HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getSingleton(){
        return singleton;
    }
}
```
优点：
1. 在类加载时就初始化,所以不存在线程安全问题,执行效率高
缺点：
2. 过早初始化，不管用没用到都占用空间

### 懒汉式


#### 存在安全线程的懒汉式
在第一次调用获取单例对象方法的时候才会创建对象。由于多个线程存在共享资源（单例对象），所以下面写法存在线程安全问题。
```java
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
```


#### 懒汉式-DCL  double check lock
通过双重检查锁的方式来解决线程安全问题。

 ```java
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
```

双重检查是为了提高执行效率，除了第一次调用{@link lazy.LazyDclSigleton#getSigleton }方法时会进去锁区域，后面siglenton已经实例化的情况下调用{@link lazy.LazyDclSigleton#getSigleton }不会再进去获取锁。
这里的双重检查仍然存在问题:

 sigleton=new LazyDclSigleton() 实例化对象过程并不是原子性的，可以分为以下三步。
```
 menory=allocate();    //1.分配内存
 ctorInstance(menory); //2.初始化
 sigleton=menory;      //3.赋值给instance
```

 intra-thread semantics（线程内语义）允许那些在单线程内，不会改变单线程程序执行结果的重排序。重排序后的顺序：
```
 menory=allocate();    //1.分配内存
 sigleton=menory;      //2.赋值给instance
 ctorInstance(menory); //3.初始化
```
 当执行的第二句时，线程B调用{@link lazy.LazyDclSigleton#getSigleton }。判断sigleton!=null,返回sigleton对象。这时线程B拿到的就是一个未初始化的对象。



正确的dcl 懒汉式写法：

上面的dcl写法的问题是重排序引起的 ，通过volatile关键字禁止重排序即可
volatile关键字的语义
1. 保证可见性
2. 禁止重排序

```java
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

```

#### 静态内部类懒汉式

 通过内部类方式，静态内部类只有在使用的时候才会执行类加载过程。
 类加载过程中，java会通过锁来保证只执行一次类加载。所以不存在线程安全问题。
 
```java
 
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
```


### 注册式单例
注册式单例是将对象注册在容器中，获取从容器中获取特点类型的对象都是单例的。实现的容器有枚举方式和map容器方式。
> 只能保证对象从容器获取式单例的，不保证其他方式获取对象的单例
#### 枚举注册单例

枚举式注册单例，枚举本身就是最好的单例，反射，反序列等反射都无法破坏其单例。
将单例对象注册到枚举上，通过枚举来获取单例对象
```java
public enum  EnumSingle {
    INSTANCE;
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
```

#### 容器注册单例
将对象实例注册到map中，每次通过相同类名拿到的对象都是同一个。
Spring中的单例bean就是通过这种方式实现。

```java

public class ContainerSingle {

    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getInstance(String className){
        if(ioc.containsKey(className)){
            return ioc.get(className);
        }
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
```

### 防止破坏单例
破坏单例的方式就要从对象创建的方式说起，java中创建对象的方法有
1.new 
2.反射
3.反序列化
4.克隆


我们懒汉式和饿汉式中都是通过私有化构造函数的方式来阻止了 new方式破坏单例。如果通过反射的方式可以强制访问构造函数
所以私有化构造函数的方式无法阻止放射。

通过在构造函数中判断是否单例，不是则抛出异常，阻止反射方式强制创建对象。
```
  private LazyInnerClassLoadSigleton(){
        //处理反射破坏单例的情况
        if(InstanceHolder.instance!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
  }
```

反序列化和克隆的方式创建对象是不会通过构造函数的，所以上面方法无法预防。
解决反序列化导致破坏单例的情况:

通过在单例类中添加readResolve方法。
```
    private Object readResolve(){
        return InstanceHolder.instance;
    }
```
{@link ObjectInputStream#readObject() }中会判断对象是否存在readResolve方法,存在则用readResolve返回的对象替换反序列化的对象
所以其实反序列还是会创建了另一个对象。这个处理方案只是保证拿到手的对象都是同一个

克隆方式通过重写clone方法可以解决

