package decorate;

/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public abstract class AbstractMilkyTeaDecorator extends AbstractMilkyTea{

    protected AbstractMilkyTea abstractMilkyTea;
    public AbstractMilkyTeaDecorator(AbstractMilkyTea abstractMilkyTea){
        this.abstractMilkyTea=abstractMilkyTea;
    }

}
