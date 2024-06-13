package cn.helloworld1999;

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        // exercise1();
        exercise2();

    }

    public static boolean exercise1(int temp) {
        if (temp == 1) {
            return false;
        }
        for (int i = temp - 1; i >= 1; i--) {
            if ((temp % i == 0) && (i != 1)) {
                return false;
            }
        }
        return true;
    }

    public static void exercise2() {
        for (int loop = 1; loop < 101; loop++) {
            if (exercise1(loop)) {
                System.out.println(loop);
            } else {
                continue;
            }
        }
    }
}
