package cn.helloworld1999.W2HomeWork1;

public class Car extends Vehcles {
    private int seats;

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", seats=" + seats + ", color=" + color + "]";
    }

    public void showCar(){
        System.out.println(this.toString());
    } 
}
