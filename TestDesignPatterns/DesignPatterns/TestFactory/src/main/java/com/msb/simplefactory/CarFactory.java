package com.msb.simplefactory;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.simplefactory
 * @version: 1.0
 */
public class CarFactory {
    public Moveable create(){
        return new Car();
    }
}
