/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public class ConcreteObserver implements  Observer{
    private String name;
    public ConcreteObserver(String name){
        this.name=name;
    }
    public void update(Subject subject) {
        System.out.println(String.format("observer: %s 观察 subject:%s 执行",name,subject.getName()));
    }
}
