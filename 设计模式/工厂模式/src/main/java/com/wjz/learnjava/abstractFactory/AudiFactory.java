package com.wjz.learnjava.abstractFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class AudiFactory extends AbstractFactory {

    public AbstractCar createYellowCar() {
        return new YellowAudiCar();
    }

    public AbstractCar createRedCar() {
        return new RedAudiCar();
    }
}
