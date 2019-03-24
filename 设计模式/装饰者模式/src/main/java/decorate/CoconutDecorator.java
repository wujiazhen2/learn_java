package decorate;

/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public class CoconutDecorator extends AbstractMilkyTeaDecorator {
    public CoconutDecorator(AbstractMilkyTea abstractMilkyTea) {
        super(abstractMilkyTea);
    }

    public String name() {
        return "椰果"+abstractMilkyTea.name();
    }

    public int price() {
        return 1+abstractMilkyTea.price();
    }
}
