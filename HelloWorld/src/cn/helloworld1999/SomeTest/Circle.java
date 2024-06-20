package cn.helloworld1999.SomeTest;

/**
 * Circle
 */
public class Circle extends Shape implements InnerShapeInterface,InnerShapeInterfaceCopy {
    private double r;
    private double area;

    @Override
    public double area(String str) {
        this.area = this.r*2*Math.PI;
        return area;
    }

    public void area(){

    }
    public static void main(String[] args) {
        System.out.println(InnerShapeInterface.str);
    }
}