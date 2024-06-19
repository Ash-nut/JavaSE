package cn.helloworld1999.W2HomeWork;

import java.util.Scanner;

public class NumGamePlayGame {
    public static void main(String[] args) {
        int num = new NumGame().v;
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int temp = 0;
        while (!flag) {
            temp = sc.nextInt();
            if (temp == num) {
                System.out.println("对了");
            }else if(temp > num){
                System.out.println("大了");
            }else{
                System.out.println("小了");
            }
        }
        sc.close();
    }
}
