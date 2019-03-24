import java.util.HashSet;
import java.util.Set;

/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public abstract class Subject  {

    private Set<Observer> observers=new HashSet<Observer>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void deAttach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
    public abstract String getName();
}
