# 委派模式
委派模式不属于GOF23种设计模式之一,但再Spring被广泛使用。委派模式就是通过任务进行路由分发，委派合适的人处理合适的事。例如团队leader根据
员工的特点来分发任务。


## leader和员工的例子

员工接口
```java
public interface IEmpolyee {

     void doWork();
}
```

leader类,在leader初始化是告诉leader员工的特长。
```java
public class Leader {

    private  Map<String,IEmpolyee> empolyees=new HashMap<String, IEmpolyee>();

    public Leader(){
        empolyees.put("需求",new EmpolyeeA());
        empolyees.put("程序",new EmpolyeeB());
    }

    public void doWork(String word){
        empolyees.get(word).doWork();
    }

}
```

leader做程序任务时,就会委派员工B来做程序任务。
```java
public class Client {

    public static void main(String[] args){
        Leader leader = new Leader();
        leader.doWork("程序");
    }
}
```

## Spring中的委派模式

Spring委派模式使用广泛。Springmvc中的DispatchServlet就是委派模式的实现，通过不同的请求路径委派任务给相应的处理方法。还有Spring对xml标签进行解析时,使用的BeanDefinitionParserDelegate类。

类图:
![BeanDefinitionParserDelegate](https://github.com/wujiazhen2/learn_java/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%BC%8F/img/BeanDefinitionParserDelegate.png?raw=true)

通过标签的命名空间,委派合适的NamespaceHandler进行分析标签。


## 总结
委派模式就是一种路由分发。将处理逻辑注册到委派者上，委派者根据需求选择合适的处理逻辑完成任务。
