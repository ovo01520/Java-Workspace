package com.msb.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2022/3/29-7:02
 * @Description: BooksManagementSystem
 * @Version: 1.0
 */
public class BookDemo {
    static class BookInfo{
        int id;
        String name;
        double price;

        @Override
        public String toString() {
            return id + "\t" +name + "\t" +price;
        }

        public BookInfo(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    static class UnamePasswd{
        String administor;
        String passwd;

        public UnamePasswd(String administor, String passwd) {
            this.administor = administor;
            this.passwd = passwd;
        }
    }
    static List<BookInfo> list = new ArrayList<>();
    static {
        list.add(new BookInfo(1,"水浒传",46.50));
        list.add(new BookInfo(2,"三国演义",61.25));
        list.add(new BookInfo(3,"西游记",98.00));
        list.add(new BookInfo(4,"红楼梦",51.25));
    }

    //这是main方法，程序的入口
    public static void main(String[] args) {
        System.out.println("****************欢迎使用图书管理系统****************");
        System.out.println("\t\t\t作者：李晓龙\t 时间：2022.03.28");
        //开始图书管理系统
        startManager();
    }

    private static void startManager() {
        //展示菜单
        user();
        //进行功能选择
        choose();
    }

    private static void choose() {
        System.out.print("请选择你要执行的功能编号：");
        Scanner sc = new Scanner(System.in);
        int chooseInfo = sc.nextInt();
        System.out.println("你选择的功能是：" + chooseInfo);
        switch (chooseInfo){
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                System.out.println("已经退出系统，欢迎下次使用！");
                return;
        }
    }

    private static void chooseMenu() {
        System.out.print("请选择你要执行的功能编号：");
        Scanner sc = new Scanner(System.in);
        int chooseInfo = sc.nextInt();
        System.out.println("你选择的功能是：" + chooseInfo);
        switch (chooseInfo){
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                showBook();
                break;
            case 4:
                System.out.println("已经退出系统，欢迎下次使用！");
                return;
        }
    }

    private static void register() {
        List<UnamePasswd> li = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要注册的用户名：");
        String name = sc.nextLine();
        System.out.print("请输入你的密码：");
        String passwd = sc.nextLine();
        System.out.print("请再次输入你的密码：");
        String passwd2 = sc.nextLine();
        //针对注册的密码的正确性重新校验
        if (passwd.equals(passwd2)){
            System.out.println("恭喜你，注册成功！");
            li.add(new UnamePasswd(name,passwd2));
            login();
        }else{
            System.out.println("两次密码不匹配，请重新注册！");
            register();
        }
    }

    private static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的用户名：");
        String name = sc.nextLine();
        System.out.print("请输入你的密码：");
        String passwd = sc.nextLine();
        UnamePasswd unamePasswd = new UnamePasswd(name,passwd);
        //针对用户名和密码的正确性重新校验
        if (unamePasswd.administor == name && unamePasswd.passwd == passwd){
            System.out.println("登录成功！");
            showMenu();
            chooseMenu();
        }else{
            System.out.println("用户名或者密码错误，请重新输入！");
        }
    }

    private static void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入您要还书的编号：");
        int num = sc.nextInt();
        System.out.println("请输入您要还书的书名：");
        String name1 = sc.next();
        System.out.println("请输入您要还书的价格：");
        Double price = sc.nextDouble();
        list.add(new BookInfo(num,name1,price));
        chooseMenu();
    }

    private static void borrowBook() {
        System.out.println("请输入您要借书的编号：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (i+1 == num){
                list.remove(i);
            }
        }
        chooseMenu();
    }

    private static void showBook() {
        System.out.println("*****************展示所有的书籍信息*****************");
        //打印表头
        System.out.println("编号\t\t书名\t\t价格");
        //显示书籍
        for (BookInfo bi : list){
            System.out.println(bi);
        }
        chooseMenu();
    }

    private static void user() {
        System.out.println("***************************************************");
        System.out.println("1.注册");
        System.out.println("2.登录");
        System.out.println("3.退出");
        System.out.println("***************************************************");
    }

    private static void showMenu() {
        System.out.println("***************************************************");
        System.out.println("1.借阅书籍");
        System.out.println("2.归还书书籍");
        System.out.println("3.查看书籍");
        System.out.println("4.退出");
        System.out.println("***************************************************");
    }
}
