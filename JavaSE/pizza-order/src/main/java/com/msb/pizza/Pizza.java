package com.msb.pizza;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/16-13:02
 * @父类: 披萨类
 * @Version: 1.0
 */
public class Pizza {
    private String name;
    private int size;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String showPizza(){
        return "名称：" + name + "\n" +
                "价格：" + price + "元\n" +
                "大小：" + size + "寸";
    }

    public Pizza() {
    }

    public Pizza(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
}