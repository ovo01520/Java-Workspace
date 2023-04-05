package com.msb.pizza;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/16-13:08
 * @Description: 水果披萨
 * @Version: 1.0
 */
public class FruitsPizza extends Pizza {
    private String burdening;

    public String getBurdening() {
        return burdening;
    }

    public void setBurdening(String burdening) {
        this.burdening = burdening;
    }

    public FruitsPizza() {
    }

    public FruitsPizza(String name, int size, int price, String burdening) {
        super(name, size, price);
        this.burdening = burdening;
    }

    @Override
    public String showPizza() {
        return super.showPizza() + "\n" + "配料水果：" + burdening;
    }
}