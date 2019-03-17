import CGLIBProxy.CGLibProxy;
import JDKProxy.JdkDynamicProxy;
import staticProxy.GameProxy;
import staticProxy.IGamePlayer;
import staticProxy.RealPlayer;

public class Main {

    public static void main(String[] args) {
        RealPlayer realPlayerA = new RealPlayer();
        //静态代理
        GameProxy gameProxy = new GameProxy(realPlayerA);
        gameProxy.playGame();

        //JDK动态代理
        IGamePlayer gameProxy1 = new JdkDynamicProxy(realPlayerA).getProxy();
        gameProxy1.playGame();

        //CGLIB动态代理
        CGLibProxy cgLibProxy = new CGLibProxy(realPlayerA);
        IGamePlayer gameProxy2  = cgLibProxy.getProxy();
        gameProxy2.playGame();
    }
}
