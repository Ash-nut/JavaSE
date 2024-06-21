package cn.helloworld1999.bean;
import cn.helloworld1999.util.IDUtil;

import java.io.Serializable;

public class Car{
    private String carId;
    private String type;
    private String color;
    private int price;
    private int rentPrice;
    private String id;

    public Car(String carId, String type, String color, int price, int rentPrice) {
        this.carId = carId;
        this.type = type;
        this.color = color;
        this.price = price;
        this.rentPrice = rentPrice;
        this.id = IDUtil.getUUID();
    }
    public String getCarReallyId(){
        return id;
    }
    public void setCarReallyId(String id){
        this.id = id;
    }

    public Car(String carId) {

    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", rentPrice=" + rentPrice +
                ", id='" + id + '\'' +
                '}';
    }

    public int compareTo(Car o2) {
        return this.price - o2.getPrice();
    }
}