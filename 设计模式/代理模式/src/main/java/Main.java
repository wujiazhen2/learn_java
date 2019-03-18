import CGLIBProxy.CGLibProxy;
import JDKProxy.JdkDynamicProxy;
import staticProxy.Parent;
import staticProxy.Persion;
import staticProxy.Son;

public class Main {

    public static void main(String[] args) {
        Persion son = new Son();
        //静态代理
        Persion parent = new Parent(son);
        parent.playGame();

        //JDK动态代理
        Persion parent1 = new JdkDynamicProxy(son).getProxy();
        parent1.playGame();

        //CGLIB动态代理
        CGLibProxy cgLibProxy = new CGLibProxy(son);
        Persion paretn2  = cgLibProxy.getProxy();
        paretn2.playGame();
    }
}
