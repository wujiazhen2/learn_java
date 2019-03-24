package decorate;

/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public  abstract class AbstractMilkyTea {
    public abstract String name();
    public abstract int price();

    @Override
    public String toString() {
        return String.format("name:%s,price:%d",name(),price());
    }
}
