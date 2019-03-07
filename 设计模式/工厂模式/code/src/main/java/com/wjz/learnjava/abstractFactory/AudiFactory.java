package com.wjz.learnjava.abstractFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class AudiFactory extends AbstractFactory {


    public AbstractMotorbike createMotorbike() {
        return new AudiMotorbike();
    }

    public AbstractCar createCar() {
        return new AudiCar();
    }
}
