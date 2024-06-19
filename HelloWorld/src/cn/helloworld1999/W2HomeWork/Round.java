package cn.helloworld1999.W2HomeWork;

public class Round {

    static final double pi = Math.PI;
    private double r;

    public Round(double r){
        this.r = r;
    }
    public double roundArea(){
        double area = r*r*pi;
        return area;
    }
}