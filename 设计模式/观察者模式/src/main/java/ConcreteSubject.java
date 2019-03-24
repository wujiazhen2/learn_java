/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public class ConcreteSubject extends Subject {
    private String name;

    public ConcreteSubject(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
