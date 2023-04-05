package com.msb.singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化
 */
public enum Mgr08 {
    INSTANCE;

    public void m(){
    }

    // 这是main方法，程序的入口
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
