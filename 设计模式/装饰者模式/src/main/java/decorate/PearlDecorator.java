package decorate;

/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public class PearlDecorator extends AbstractMilkyTeaDecorator {
    public PearlDecorator(AbstractMilkyTea abstractMilkyTea) {
        super(abstractMilkyTea);
    }

    public String name() {
        return "珍珠"+this.abstractMilkyTea.name();
    }

    public int price() {
        return abstractMilkyTea.price()+2;
    }
}
