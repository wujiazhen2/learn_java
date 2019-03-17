package registerSingle;

/**
 * 枚举式注册单例，枚举本身就是最好的单例，反射，反序列等反射都无法破坏其单例。
 * 将单例对象注册到枚举上，通过枚举来获取单例对象
 * @author wujiazhen
 * @date 2019/3/17
 */
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
