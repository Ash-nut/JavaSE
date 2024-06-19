package cn.helloworld1999.W2HomeWork;

public class Car {
    private int numberOfTires;
    private String vehicleColor;
    private double vehicleWeight;
    
    public Car(int numberOfTires, String vehicleColor, double vehicleWeight) {
        this.numberOfTires = numberOfTires;
        this.vehicleColor = vehicleColor;
        this.vehicleWeight = vehicleWeight;
    }
    public Car(String vehicleColor, double vehicleWeight) {
        this.vehicleColor = vehicleColor;
        this.vehicleWeight = vehicleWeight;
    }
    public Car(double vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }
    @Override
    public String toString() {
        return "Car [numberOfTires=" + numberOfTires + ", vehicleColor=" + vehicleColor + ", vehicleWeight="
                + vehicleWeight + "]";
    }
    public void showCar(){
        System.out.println(this.toString());
    }
}
