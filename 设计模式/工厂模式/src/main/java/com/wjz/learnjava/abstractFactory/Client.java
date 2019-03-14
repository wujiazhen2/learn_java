package com.wjz.learnjava.abstractFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory audiFactory = new AudiFactory();
        AbstractCar redCar = audiFactory.createRedCar();
        redCar.use();
        AbstractCar yellowCar = audiFactory.createYellowCar();
        yellowCar.use();
    }
}
