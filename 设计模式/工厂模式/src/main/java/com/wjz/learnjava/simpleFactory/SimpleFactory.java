package com.wjz.learnjava.simpleFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class SimpleFactory {

    public AbstractCar createCar(String type) {
        if ("BWM".equals(type)) {
            return new BWMCar();
        } else if ("AUDI".equals(type)) {
            return new AudiCar();
        } else {
            throw new RuntimeException("不会造这种类型的车");
        }
    }
}
