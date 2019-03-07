package com.wjz.learnjava.simpleFactory;

import com.wjz.learnjava.factory.AbstractFactory;

/**
 * @author wujiazhen
 * @Date 2019/3/7
 */
public class Client {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        AbstractCar bwm= simpleFactory.createCar(BWMCar.class);
        bwm.use();
    }
}
