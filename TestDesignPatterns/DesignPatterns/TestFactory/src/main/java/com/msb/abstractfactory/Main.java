package com.msb.abstractfactory;

import org.junit.Test;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/1
 * @Description: com.msb.abstractfactory
 * @version: 1.0
 */
public class Main {
    @Test
    public void TestModernFactory(){
        AbstractFactory factory = new ModernFactory();
        Vehicle car = factory.createVehicle();
        car.go();
        Food bread = factory.createFood();
        bread.printName();
        Weapon ak47 = factory.createWeapon();
        ak47.shoot();
    }

    @Test
    public void TestMagicFactory(){
        AbstractFactory factory = new MagicFactory();
        Vehicle broom = factory.createVehicle();
        broom.go();
        Food mushRoom = factory.createFood();
        mushRoom.printName();
        Weapon magicStick = factory.createWeapon();
        magicStick.shoot();
    }
}
