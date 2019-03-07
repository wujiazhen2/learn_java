package com.wjz.learnjava.abstractFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class BWMFactory extends AbstractFactory {

    public AbstractMotorbike createMotorbike() {
        return new BWMMotorbike();
    }

    public AbstractCar createCar() {
        return new BWMCar();
    }
}
