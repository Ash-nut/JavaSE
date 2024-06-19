package cn.helloworld1999.W2HomeWork;

public class Rectangle {
    private double width;
    private double height;
    
    public Rectangle(){

    }

    public Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }

    public double rectangularPerimeter(){
        double perimeter = 2*(this.width+this.height);
        System.out.println("该矩形周长为：" + perimeter);
        return perimeter;
    }

    public double rectangularArea(){
        double area = this.height*this.width;
        System.out.println("该矩形面积为：" + area);
        return area;
    }
}
