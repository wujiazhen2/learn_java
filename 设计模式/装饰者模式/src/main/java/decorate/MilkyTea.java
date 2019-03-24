package decorate;

/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public class MilkyTea extends AbstractMilkyTea {

    public String name() {
        return "奶茶";
    }

    public int price() {
        return 5;
    }
}
