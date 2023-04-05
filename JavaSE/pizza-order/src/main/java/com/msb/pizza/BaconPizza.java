package com.msb.pizza;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/16-13:12
 * @Description: 培根披萨
 * @Version: 1.0
 */
public class BaconPizza extends Pizza{
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BaconPizza() {
    }

    public BaconPizza(String name, int size, int price, double weight) {
        super(name, size, price);
        this.weight = weight;
    }

    @Override
    public String showPizza() {
        return super.showPizza() + "\n" + "培根克数：" + weight + "克";
    }
}