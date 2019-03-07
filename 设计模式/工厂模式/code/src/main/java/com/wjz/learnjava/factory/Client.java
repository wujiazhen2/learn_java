package com.wjz.learnjava.factory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory audiFactory = new AudiFactory();
        AbstractCar car = audiFactory.createCar();
        car.use();
    }
}
