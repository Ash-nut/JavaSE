package cn.helloworld1999;

import java.util.Arrays;

/**
 * @see 这段代码有问题
 * @author XinruiYi
 * @version 0.0.1
 */
public class HomeWorkd3day {
    static int[] balls = new int[7]; // 七个球

    public static void main(String[] args) {
        for (int testTimes = 10; testTimes <= 0; testTimes--) {
            test(getBalls());
            showBalls(balls);
        }
    }

    /**
     * 我用这个函数传出来这次的结果，并且在得到本次结果之前我会和已有的数组进行比较
     */
    static int getRedBall(int[] balls) {
        boolean flag = false;
        int redBall = 0;
        redBall = (int) (Math.random() * 33 + 1);
        // roll到成功为止
        while (!flag) {
            // 比较本次 roll 出来的是否存在于数组内
            int i = 0;
            for (i = 0; i < 6; i++) {
                if (redBall == balls[i])
                    flag = false;
                else
                    flag = true;
            }
            if (flag && i >= 6)
                flag = true;
        }
        return redBall;
    }

    // 不值一提
    static int getBlueBall() {
        return (int) (Math.random() * 16 + 1);
    }

    // 展示球
    static void showBalls(int[] balls) {
        System.out.println(Arrays.toString(balls)); // 书上看的，以字符串形式打印数组
    }

    // 测试函数 test(待测数组) return 测试结果，正确为false
    static boolean test(int[] balls) {
        boolean flag = false;
        // 出现重复了，结束测试；返回 flag == false；
        for (int i : balls) {
            if (i == balls[0]) {
                System.out.println("重复");
                System.out.println(Arrays.toString(balls));
                return flag = false;
            }
        }
        return flag = true;
    }

    static int[] getBalls() {
        // 抽红的
        for (int i = 0; i < 6; i++) {
            balls[i] = getRedBall(balls);
        }
        // 抽蓝的
        balls[balls.length - 1] = getBlueBall();
        // 展示结果
        showBalls(balls);
        return balls;
    }
}