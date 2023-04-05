package com.msb.strategy;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.strategy
 * @version: 1.0
 */
public class Cat {
    double weight;
    double height;

    public Cat() {
    }

    public Cat(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
