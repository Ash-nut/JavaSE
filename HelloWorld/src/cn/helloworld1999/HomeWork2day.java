package cn.helloworld1999;

import java.util.Scanner;

public class HomeWork2day {
    public static String account = "admin";
    public static String pin = "000000";
    public static double balance = 0d;
    public static boolean landingStatus = false;

    public static void main(String[] args) {
        while (true) {
            showGUI(landingStatus);
        }
    }

    public static byte getKeyBoardGUI() {
        Scanner sc = new Scanner(System.in);
        return sc.nextByte();
    }

    public static boolean getKeyBoardAccount() {
        System.out.println("请输入账号：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        return str.equals(account);
    }

    public static boolean getKeyBoardPin() {
        System.out.println("请输入密码：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        return str.equals(pin);
    }

    public static void login() {
        System.out.println("分别输入账户名及密码");
        for (byte i = 3; i > 0; i--) {
            if (!getKeyBoardAccount() || !getKeyBoardPin()) {
                System.out.println("账号或密码错误，还有 " + i + " 次机会");
            } else {
                landingStatus = true;
                break;
            }
        }
        if (!landingStatus) {
            System.out.println("超过最大尝试次数，系统已退出");
            System.exit(0);
        }
    }

    public static void showGUI(boolean login) {
        if (!login) {
            System.out.println("这是登录页面");
            System.out.println("1. 登录");
            System.out.println("2. 退出系统");
            switch (getKeyBoardGUI()) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("系统退出");
                    System.exit(0);
                default:
                    System.out.println("非法输入");
                    break;
            }
        } else {
            System.out.println("1. 存钱");
            System.out.println("2. 取钱");
            System.out.println("3. 退出登录");
            switch (getKeyBoardGUI()) {
                case 1:
                    System.out.println("请输入存入数额：");
                    Scanner sc = new Scanner(System.in);
                    double db = sc.nextDouble();
                    if(db >= 0) {
                    	balance += db;
                       	System.out.println("余额： " + balance);                    }
                    else{
                    	System.out.println("数值非法");
                    }
                    break;
                case 2:
                    System.out.println("请输入取出数额：");
                    Scanner sc1 = new Scanner(System.in);
                    double db1 = sc1.nextDouble();
                    if(balance - db1>=0 && db1 >= 0) {
                    	balance -= db1;
                    	System.out.println("余额： " + balance);
                    }
                    else{
                    	System.out.println("数值非法");
                    }
                    break;
                case 3:
                    System.out.println("账号已退出登录");
                    landingStatus = false;
                    break;
                default:
                    System.out.println("非法输入");
                    break;
            }
        }
    }
}
