# 简单工厂模式

简单工厂模式定义一个简单的工厂来创建其他类的实例，被创建的实例通常都具有共同的父类。当需要什么对象，通过工厂类的创建方法传入
对应的类型就可以获取想要的对象。

组成
1. 工厂
2. 抽象产品
3. 具体产品

```java
public class SimpleFactory {

    public AbstractCar createCar(String type) {
        if ("BWM".equals(type)) {
            return new BWMCar();
        } else if ("AUDI".equals(type)) {
            return new AudiCar();
        } else {
            throw new RuntimeException("不会造这种类型的车");
        }
    }
}
```

!(简单工厂模式)[https://github.com/wujiazhen2/learn_java/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.png?raw=true]


优点：
1.客户端获得产品只需要传入产品的类型，而不需要知道具体的创建细节


缺点: 
1. 简单方法负责的职责过重
2. 违法了开闭原则。但增加新类型是需要修改createCar的逻辑。
3. 产品多或者产品创建逻辑复杂时，创建产品的类会变的非常臃肿。


# 工厂模式

工厂方法对简单工厂方法进行了优化。工厂方法由4个角色组成
1. 抽象工厂
2. 具体工厂
3. 抽象产品
4. 具体产品

!(工厂模式)[https://github.com/wujiazhen2/learn_java/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.png?raw=true]

优点:
1.每个具体的工厂创建一样具体的产品，职责分离。当增加具体产品时，通过添加一个具体的工厂来扩展，无需修改原来代码，符合开闭原则。

缺点:
1. 一个产品对应一个工厂对象，系统类的数量增多。

# 抽象工厂模式

抽象工厂相对工厂模式多产品族和产品等级的的概念。就像现实的工厂不是只能生产一样产品。工厂可以生产的所有产品就是一个产品族。而这些不同的产品就代表着不同的产品等级，产品等级可以理解为产品种类。
例如宝马生产汽车，摩托车。汽车和摩托车就是一个产品族，汽车和摩托车就分别可以理解为这个产品族中不同的产品等级。宝马的工厂可以生产宝马汽车和宝马摩托车。工厂模式其实就是产品等级只有一个的抽象工厂。

!(抽象工厂)[https://github.com/wujiazhen2/learn_java/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F/%E6%8A%BD%E8%B1%A1%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.png?raw=true]


缺点：
抽象工厂如果要扩展产品等级会非常麻烦，需要为所有的工厂添加接口。