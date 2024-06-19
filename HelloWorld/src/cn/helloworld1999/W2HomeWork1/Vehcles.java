package cn.helloworld1999.W2HomeWork1;

public class Vehcles {
    private String brand;
    private String color;
    public Vehcles(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }
    public Vehcles(){

    }
    public void run(){
        System.out.println("我已经开动了");
    }
    @Override
    public String toString() {
        return "Vehcles [brand=" + brand + ", color=" + color + "]";
    }
    public void showInfo(){
        System.out.println(this.toString());
    }
}
