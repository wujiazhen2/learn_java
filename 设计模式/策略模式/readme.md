# 策略模式

策略模式是定义一系列算法，并将每个算法封装成独立的,可以互相替换类，根据环境需求的不同选择使用不同的算法处理。

类图:
![策略模式](https://github.com/wujiazhen2/learn_java/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F/img/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F.png?raw=true)


>策略模式常常和委派模式结合使用，通过将策略根据特点注册到委派类中，由委派类路由决定调用什么算法。

