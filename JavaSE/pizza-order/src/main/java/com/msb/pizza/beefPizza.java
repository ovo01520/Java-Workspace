package com.msb.pizza;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/18-18:12
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class beefPizza extends Pizza{
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public beefPizza() {
    }

    public beefPizza(String name, int size, int price, double weight) {
        super(name, size, price);
        this.weight = weight;
    }

    @Override
    public String showPizza() {
        return super.showPizza() + "\n" + "牛肉克数：" + weight + "克";
    }
}
