package com.msb.abstractfactory;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/1
 * @Description: com.msb.abstractfactory
 * @version: 1.0
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    @Override
    Food createFood() {
        return new Bread();
    }
}
