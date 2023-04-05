package com.msb.strategy;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/31
 * @Description: com.msb.strategy
 * @version: 1.0
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1,T t2);
}
