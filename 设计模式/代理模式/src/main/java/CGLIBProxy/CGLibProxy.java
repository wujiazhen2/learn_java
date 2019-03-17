package CGLIBProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wujiazhen
 * @date 2019/3/17
 */
public class CGLibProxy implements MethodInterceptor {

    private Object target;

    public CGLibProxy(Object target){
        this.target=target;
    }

    /**
     * 获取被代理接口实例对象
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    /**
     *
     * @param o 代理类实例
     * @param method 代理类的方法
     * @param objects 目标方法参数
     * @param methodProxy 父类方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理在玩");
        return methodProxy.invoke(this.target,objects);
    }
}
