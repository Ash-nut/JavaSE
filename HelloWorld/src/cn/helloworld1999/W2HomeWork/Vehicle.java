package cn.helloworld1999.W2HomeWork;

import java.util.Scanner;

/**
 * Vehicle
 */
public class Vehicle {

    private double speed;
    private double size;

    @Override
    public String toString() {
        return "Vehicle [speed=" + speed + ", size=" + size + "]";
    }

    public Vehicle(){

    }
    public Vehicle(double speed,double size){
        this.speed = speed;
        this.size = size;
    }

    public void move(){
        System.out.println("可能它移动了吧");
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void speedUp(){
        System.out.println("改变的速度为：");
        Scanner sc = new Scanner(System.in);
        double acceleratedSpeed = sc.nextDouble();  //没注意，是直接改变的速度，而不是加速度，凑活用这个名字吧
        this.speed += acceleratedSpeed;      
    }
    public void speedDown(){
        System.out.println("改变的速度为：");
        Scanner sc = new Scanner(System.in);
        double acceleratedSpeed = sc.nextDouble();
        this.speed += acceleratedSpeed;
    }
    public static void main(String[] args){
        Vehicle v = new Vehicle(0.0,0.0);
        System.out.println(v.toString());
        while (true) {
            v.speedUp();
            System.out.println(v.toString());
        }
    }
}