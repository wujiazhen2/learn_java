使用Spring框架能给我们带来哪些好处？
简化开发
DI: 依赖关系一目了然
IOC：管理好系统中的Bean
万能胶：兼容成熟的框架Hibernate、MyBatis、Quartz、Timer
        Shiro、Data
模块化设计：即插即用，按需分配
自带测试组件：JUnit
Web MVC：过度设计嫌疑、完美分离了Servlet和普通Bean
声明式事务：自然将非功能性代码和功能性代码分离
            提出了事务管理提前声明     
             
             
             
BeanFactory和ApplicationContext有什么区别？
ApplicationContext是BeanFactory子接口
getBean();
1、IOC容器中的Bean监控，生命周期
   PostProcessor
 
   ApplicationEvent
   ContextRefreshedEvent
   ContextStartedEvent
   ContextStoppedEvent
   ContextClosedEvent
   RequestHandleredEvent
 
    
2、支持国际化i18n
3、拓展了统一资源文件读取方式URL
   可以是一个本地URL，也可以是一个网络URL
   ClassPathXmlApplicationContext
   FileSystemXmlApplicationContext
   XmlWebApplicationContext
 
   AnnotationConfigApplicationContext   
    
    
请解释Spring Bean的生命周期
1、InitializingBean和DisposableBean用来回调
2、Aware接口
3、init() destory()
4、@PostContruct 和 @PreDestory注解方式
 
 
Spring Bean各作用域之间的区别？（Socpe）
总共5个范围，对象什么时候创建，什么时候销毁
Spring Bean 命各有长短
规定了有5种寿命
顶层
1、1岁：什么时候用，什么出生，用完就死了 （prototype）
2、100岁：我从容器启动就从石头缝里蹦出来，直到Spring的世界末日才灭亡（singleton）
Web层
3、10岁：request出生的时候就出生，request销毁的时候就销毁（request）
4、20岁：session出生的时候就出生，session销毁的时候就销毁(session)
5、80岁：global-session Context
 
 
Spring中的Bean是线程安全的吗？
是/不是
Spring Bean是有IOC容器来创建，创建的对象是谁写的？
自己写的
BeanDefinition
BeanWarpper   instance   Class.newInstance();    new Object();
 
Map<String,BeanWarpper> 顶多就是做了一次代理，用一个新的类代替了原来的类
 
跟我们写的代码有关系，跟Spring无关
 
 
请问Spring中用到了哪些设计模式？
同学们可以自己梳理
 
 
Spring是怎样处理循环依赖的？
class A{
    B b;
}
 
class B{
    A a;
}
 
用缓存机制来解决循环依赖的问题
BeanWrapper
 
在service层中如何获取到applicationContext？
实现 ApplicationContextAware 接口
 
 
上下文到底是干什么的？为什么叫上下文？
中国，长沙
Tomcat
所处的环境
 
 
Spring事务怎么实现？
1、非功能性代码拆分出来，放到一个TransactionManager里面统一管理，本身就是一个切面
connetion
2、TransactionManager切面，织入到PointCut 
 
 
Spring AOP中对已经被代理过的对象是怎么处理的？
原生对象吗？没有做任何处理
被封装到了BeanWrapper里面，存的是代理对象的引用
 
 
 
