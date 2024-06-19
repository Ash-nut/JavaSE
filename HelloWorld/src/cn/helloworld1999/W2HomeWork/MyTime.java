package cn.helloworld1999.W2HomeWork;

import java.util.Scanner;

/**
 * MyTime
 */
public class MyTime {
    public int hour;
    public int minute;
    public int second;

    @Override
    public String toString() {
        return "MyTime: " + hour + ":" + minute + ":" + second ;
    }

    final private void timeRuleBaseAdd(){
        if (this.second >= 60) {
            this.minute += this.second/60 ;
            this.second = this.second%60;
        }
        if (this.minute >= 60) {
            this.hour += this.minute/60;
            this.minute = this.minute%60;
        }
        if (this.hour >= 24) {
            this.hour = this.hour%24;
        }
    }
    final private void timeRuleBaseSub(){
        if (this.second < 0) {
            this.minute -= this.second/-60 ;
            this.second = this.second%-60;
        }
        if (this.minute < 0) {
            this.hour -= this.minute/-60;
            this.minute = this.minute%-60;
        }
        if (this.hour < 0) {
            this.hour = this.hour%-24+24;
        }
    }

    public MyTime(){

    }
    public MyTime(int hour,int minute,int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        if (this.hour>=24||this.minute>=60||this.second>=60) {
            timeRuleBaseAdd();
        }
        if (this.hour<0||this.minute<0||this.second<0) {
            timeRuleBaseSub();
        }
    }
    public void display(){
        System.out.println(this.toString());
    }

    public void addSecond(int sec){
        this.second = sec;
        timeRuleBaseAdd();
    }
    public void addHour(int hou){
        this.hour = hou;
        timeRuleBaseAdd();
    }
    public void addMinute(int min){
        this.minute = min;
        timeRuleBaseAdd();
    }
    public void subSecond(int sec){
        this.second = sec;
        timeRuleBaseSub();
    }
    public void subHour(int hou){
        this.hour = hou;
        timeRuleBaseSub();
    }
    public void subMinute(int min){
        this.minute = min;
        timeRuleBaseSub();
    }
    public static void main(String[] args) {
        MyTime mt1 = new MyTime(0, 0, 0);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("当前存储的时间为：");
            System.out.println(mt1.toString());
            System.out.println("1.增加时");
            System.out.println("2.增加分");
            System.out.println("3.增加秒");
            System.out.println("4.减少时");
            System.out.println("5.减少分");
            System.out.println("6.减少秒");
            System.out.println("其他按键退出");
            int key = sc.nextInt();
            switch (key) {
                case 1:
                    key = sc.nextInt();
                    mt1.addHour(key);
                    break;
                case 2:
                    key = sc.nextInt();
                    mt1.addMinute(key);
                    break;
                case 3:
                    key = sc.nextInt();
                    mt1.addSecond(key);
                    break;
                case 4:
                    key = sc.nextInt();
                    mt1.subHour(key);
                    break;
                case 5:
                    key = sc.nextInt();
                    mt1.subMinute(key);
                    break;
                case 6:
                    key = sc.nextInt();
                    mt1.subSecond(key);
                    break;
                default:
                System.exit(0);
                    break;
            }
            sc.close();
        }
    }
}