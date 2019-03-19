package delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujiazhen
 * @date 2019/3/19
 */
public class Leader {

    private  Map<String,IEmpolyee> empolyees=new HashMap<String, IEmpolyee>();

    public Leader(){
        empolyees.put("需求",new EmpolyeeA());
        empolyees.put("程序",new EmpolyeeB());
    }

    public void doWork(String word){
        empolyees.get(word).doWork();
    }


}
