package com.msb.strategy;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.strategy
 * @version: 1.0
 */
public class DogFoodComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog t1, Dog t2) {
        if (t1.food < t2.food)
            return -1;
        else if (t1.food > t2.food)
            return 1;
        else
            return 0;
    }
}
