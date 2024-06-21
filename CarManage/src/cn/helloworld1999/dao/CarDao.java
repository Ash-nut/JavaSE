package cn.helloworld1999.dao;
import cn.helloworld1999.Database.Database;
import cn.helloworld1999.bean.Car;

import java.util.*;

public class CarDao {
    private CarDao(){

    }

    static public String showCars(){
        return Database.getCars().toString();
    }

    static public void createCar(String carId, String type, String color, int price, int rentPrice) {
            Car tempCar = new Car(carId, type, color, price, rentPrice);
            Database.getCars().add(tempCar);
        }


    static public String updateCar(String carId,byte key,String str) {
        int index = findInputCarIndexInCars(carId);
        switch (key) {
            case 1:
                Database.getCars().get(index).setColor(str);
                break;
            case 2:
                Database.getCars().get(index).setType(str);
                break;
            case 3:
                Database.getCars().get(index).setRentPrice(Integer.parseInt(str));
                break;
            }
        return "修改完毕";
    }

    static public boolean deleteCar(String carId) {
        if (findInputCarIndexInCars(carId)!=-1){
            Database.getCars().remove(findInputCarIndexInCars(carId));
            return true;
        }
        return false;
    }
    static public int findInputCarIndexInCars(String carId) {
        int i;
        for (i = 0; i < Database.getCars().size(); i++) {
            if (carId.equals(Database.getCars().get(i).getCarId())) return i;
        }
        return -1;
    }
    static public int findInputCarID(String id) {
        int i;
        for (i = 0; i < Database.getCars().size(); i++) {
            if (id.equals(Database.getCars().get(i).getCarReallyId())) return i;
        }
        return -1;
    }
    static public List<Car>findCarPriceMoreThanThat(String carIdStartWith,int price){
        List<Car> tempCars = new ArrayList<>();
        for (Car i : Database.getCars()) {
            if (i.getCarId().startsWith(carIdStartWith)&&i.getPrice()>price) {
                tempCars.add(i);
            }
        }
        return tempCars;
    }
    static public List<Car>getPriceMaxCar(){
        List<Car> BlackCars = new ArrayList<>();
       for (Car i : Database.getCars()) {
           if (i.getColor().equals("黑色")) {
               BlackCars.add(i);
           }
       }
       List<Car> tempCars = new ArrayList<>();
       int maxPrice = 0;
       for (Car i : BlackCars) {
           maxPrice = Math.max(maxPrice, i.getPrice());
       }
       List<Car> BlackCarsMaxPrice = new ArrayList<>();
       for (Car i : BlackCars) {
           if (i.getPrice() == maxPrice) {
               BlackCarsMaxPrice.add(i);
           }
       }
       return BlackCarsMaxPrice;
    }
    static public String getAllCarsPriceAverage(){
        double average = 0;
        int sum = 0;
        for (Car i : Database.getCars()) {
            sum += i.getPrice();
        }
        average = (double) sum /Database.getCars().size();
        return Double.toString(average);
    }
    static public List<Car>ascendingSort(){
        List<Car> tempCars = new ArrayList<>();
        for (Car i: Database.getCars()) {
            if (!i.getCarId().startsWith("川A")){
                tempCars.add(i);
            }
        }
        //@TODO 这个排序要特别注意，因为刚刚做这个东西卡住了，还有要注意在 Car 中实现的 CompareTO
        tempCars.sort(new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.compareTo(o2);
            }
        });
        return tempCars;
    }

    public static List<Car> getSuvAndBlackAndMoreThan(){
        List<Car> tempCars = new ArrayList<>();
        for (Car i : Database.getCars()) {
            if (i.getRentPrice()>=600&&i.getColor().equals("黑色")&&i.getType().equals("SUV")){
                tempCars.add(i);
            }
        }
        return tempCars;
    }
    public static List<Car> getCarMoreThan(){
        List<Car> tempCars = new ArrayList<>();
        for (Car i : Database.getCars()) {
            if (i.getPrice()>=20000&&i.getCarId().startsWith("川A")){
                tempCars.add(i);
            }
        }
        return tempCars;
    }
    public static boolean deleteCarWithCarId(String carId) {
        int index = findInputCarIndexInCars(carId);
        if (index != -1) {
            Database.getCars().remove(index);
            return true;
        }
        return false;
    }
    public static boolean deleteCarWithCarReallyId(String id) {
        int index = findInputCarID(id);
        if (index != -1) {
            Database.getCars().remove(index);
            return true;
        }
        return false;
    }
}
