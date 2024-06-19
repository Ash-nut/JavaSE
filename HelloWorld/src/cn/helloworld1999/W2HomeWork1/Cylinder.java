package cn.helloworld1999.W2HomeWork1;

public class Cylinder extends Circle {
    public double height;
    public Cylinder(double r,double h){
        this.radius = r;
        this.height = h;
    }
    public double getHeight(){
        return this.height;
    }
    public double getVol(){
        return getArea()*getHeight();
    }
    public void dispVol(){
        System.out.println(getVol());
    }
}
