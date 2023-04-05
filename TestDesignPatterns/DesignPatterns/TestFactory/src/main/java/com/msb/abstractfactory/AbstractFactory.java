package com.msb.abstractfactory;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/1
 * @Description: com.msb.abstractfactory
 * @version: 1.0
 */
public abstract class AbstractFactory {
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
    abstract Food createFood();
}
