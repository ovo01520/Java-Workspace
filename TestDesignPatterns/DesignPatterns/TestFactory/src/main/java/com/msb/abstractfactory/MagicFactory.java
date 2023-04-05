package com.msb.abstractfactory;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/1
 * @Description: com.msb.abstractfactory
 * @version: 1.0
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Food createFood() {
        return new MushRoom();
    }
}
