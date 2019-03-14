package com.wjz.learnjava.factory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class BWMFactory extends AbstractFactory {
    public AbstractCar createCar() {
        return new BWMCar();
    }
}
