package cn.helloworld1999.W2HomeWork1;

public class Circle {
    public double radius = 0;
    public Circle(){

    }
    public Circle(double r){
        this.radius = r;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
    void disp(){
        System.out.println(getRadius()+getPerimeter()+getArea());
    }
}
