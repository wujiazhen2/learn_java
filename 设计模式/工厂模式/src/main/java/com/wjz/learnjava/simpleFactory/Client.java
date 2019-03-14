package com.wjz.learnjava.simpleFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class Client {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        AbstractCar bwm = simpleFactory.createCar("BWM");
        bwm.use();
    }
}
