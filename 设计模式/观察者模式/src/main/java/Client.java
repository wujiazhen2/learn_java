/**
 * @author wujiazhen
 * @date 2019/3/24
 */
public class Client {

    public static void main(String[] args){
        Subject subject1=new ConcreteSubject("subject1");

        ConcreteObserver observer1 = new ConcreteObserver("observer1");
        ConcreteObserver observer2 = new ConcreteObserver("observer2");
        subject1.attach(observer1);
        subject1.attach(observer2);
        subject1.notifyObservers();
    }
}
