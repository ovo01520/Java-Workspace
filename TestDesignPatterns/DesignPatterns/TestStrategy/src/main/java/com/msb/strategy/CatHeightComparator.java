package com.msb.strategy;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.strategy
 * @version: 1.0
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        if (t1.height < t2.height)
            return -1;
        else if (t1.height > t2.height)
            return 1;
        else
            return 0;
    }
}
