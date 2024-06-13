package cn.helloworld1999;

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        exercise2();
    }

    public static void exercise1() {
        System.out.println("输入一个正整数，以判断是否为质数：");
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        for (int i = temp - 1; i >= 1; i--) {
            if ((temp % i == 0) && (i != 1)) {
                System.out.println(temp + "不是一个质数");
                return;
            }
        }
        System.out.println(temp + "是一个质数");
    }

    public static void exercise2() {
        // 从100倒数
        for (int loop = 1; loop <= 100; loop++) {
            // 判断每一个数字是否是质数
            boolean flag = false;
            for (int i = loop; i >= 0; i--) {
                if ((loop % i == 0) && (i != 1)) {
                    System.out.println(i + "不是质数");
                    break;
                }
            }
            System.out.println(loop);
        }
    }
}
