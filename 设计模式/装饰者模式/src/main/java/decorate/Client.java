package decorate;

/**
 * @author wujiazhen
 * @Date 2019/3/21
 */
public class Client {

    public  static  void main(String[] args){
        AbstractMilkyTea milkyTea= new MilkyTea();
        //加珍珠
        milkyTea = new PearlDecorator(milkyTea);
        //加椰果
        milkyTea = new CoconutDecorator(milkyTea);

        System.out.println(milkyTea);
    }

}
