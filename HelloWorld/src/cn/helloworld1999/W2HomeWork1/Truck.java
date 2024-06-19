package cn.helloworld1999.W2HomeWork1;

public class Truck extends Vehcles {
    private float load;
    public Truck(String brand,String color,float load){
        this.brand = brand;
        this.color = color;
        this.load = load;
    }
    @Override
    public String toString() {
        return "Truck [brand=" + brand + ", load=" + load + ", color=" + color + "]";
    }
    public void showTruck(){
        System.out.println(toString());
    }
}
