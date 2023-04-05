package com.msb.simplefactory;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.factory
 * @version: 1.0
 */
public class Demo {
    // 这是main方法，程序的入口
    public static void main(String[] args) {
        // Moveable m = new Car();
        // Moveable m = new Plane();
        // Moveable m = new VehicleFactory().createCar();
        // Moveable m = new VehicleFactory().createPlane();
        // Moveable m = new CarFactory().create();
        Moveable m = new PlaneFactory().create();
        m.go();
    }
}
