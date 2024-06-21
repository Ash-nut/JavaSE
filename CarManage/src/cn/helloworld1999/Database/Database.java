package cn.helloworld1999.Database;


import cn.helloworld1999.bean.Car;

import java.util.ArrayList;
import java.util.List;

public class Database {

    static private List<Car>cars;
	static {Car c1 = new Car("川A77777", "小轿车", "白色", 180000, 800);
		Car c2 = new Car("川A77779", "SUV", "黑色", 366780, 850);
		Car c3 = new Car("川A77778", "SUV", "黑色", 280000, 600);
		Car c4 = new Car("川A77771", "小轿车", "红色", 140000, 500);
		Car c5 = new Car("川B12345", "SUV", "紫色", 220000, 650);
		Car c6 = new Car("川C67823", "小轿车", "黑色", 155000, 550);
		Car c7 = new Car("川B88991", "跑车", "白色", 1200000, 1500);
		cars = new ArrayList<>();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		cars.add(c5);
		cars.add(c6);
		cars.add(c7);}

    public Database() {

    }
	public static List<Car> getCars() {
		return Database.cars;
	}

}
