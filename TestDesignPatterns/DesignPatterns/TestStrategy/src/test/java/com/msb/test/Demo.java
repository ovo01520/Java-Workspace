package com.msb.test;

import com.msb.strategy.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.test
 * @version: 1.0
 */
public class Demo {
    @Test
    public void catWeight(){
        Cat[] c = {new Cat(1,5),new Cat(2,3),new Cat(4,7)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(c,new CatWeightComparator());
        System.out.println(Arrays.toString(c));
    }

    @Test
    public void catHeight(){
        Cat[] c = {new Cat(1,5),new Cat(2,3),new Cat(4,7)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(c,new CatHeightComparator());
        System.out.println(Arrays.toString(c));
    }

    @Test
    public void dogFood(){
        Dog[] d = {new Dog(4),new Dog(2),new Dog(1),new Dog(10)};
        Sorter<Dog> sorter = new Sorter<>();
        sorter.sort(d,new DogFoodComparator());
        System.out.println(Arrays.toString(d));
    }
}
