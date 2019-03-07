package com.wjz.learnjava.simpleFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class SimpleFactory {

    public <T extends  AbstractCar> T createCar(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
