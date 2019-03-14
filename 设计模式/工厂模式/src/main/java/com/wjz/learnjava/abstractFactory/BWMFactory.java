package com.wjz.learnjava.abstractFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class BWMFactory extends AbstractFactory {

    public AbstractCar createYellowCar() {
        return new YellowBWMCar();
    }

    public AbstractCar createRedCar() {
        return new RedBWMCar();
    }
}
