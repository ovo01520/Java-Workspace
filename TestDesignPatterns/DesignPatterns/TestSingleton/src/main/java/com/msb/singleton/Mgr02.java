package com.msb.singleton;

/**
 * 跟Mgr01是一个意思
 */
public class Mgr02 {
    public static final Mgr02 INSTANCE;
    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02(){
    }

    public static Mgr02 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    // 这是main方法，程序的入口
    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
