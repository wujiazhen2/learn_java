package registerSingle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 讲对象实例注册到map中，每次通过相同类名拿到的对象都是同一个。
 * Spring中的单例bean就是通过这种方式实现。
 *
 * @author wujiazhen
 * @date 2019/3/17
 */
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
