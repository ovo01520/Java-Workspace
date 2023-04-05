package com.msb.strategy;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.strategy
 * @version: 1.0
 */
public class Dog {
    int food;

    public Dog() {
    }

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
