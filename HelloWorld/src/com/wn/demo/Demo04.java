package com.wn.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Demo04 {
	
	static String[] cars = {"川A55532-轿车-黑色-235000-宝马","川A55577-SUV-黑色-370000-奔驰"
			 ,"川A55566-轿车-红色-157000-宝马","苏A55599-SUV-黑色-210000-比亚迪"};
	
	static Scanner scan = new Scanner(System.in);
	/**
	 * 查询所有车辆信息
	 */
	public static void showCars() {
		System.err.println("车牌号\t\t类型\t\t颜色\t\t价格\t\t品牌");
		for(String car : cars) {
			//分割字符串
			String[] split = car.split("-");
			for(String msg : split) {
				System.out.print(msg + "\t\t");
			}
			System.out.println(); //换行
		}
	}
	/**
	 * 2、添加一条车辆信息
	 */
	public static void addCar() {
		System.out.println("请输入车牌号:");
		String carid = scan.next();
		//判断carid是否重复
		int index = isExist(carid);
		if(index > -1) { //表示存在
			System.out.println("你输入" + carid + "已被使用,添加失败!");
		}else { //表示不存在
			System.out.println("请输入车辆类型:");
			String type = scan.next();
			System.out.println("请输入车辆颜色:");
			String color = scan.next();
			System.out.println("请输入车辆价格:");
			String price = scan.next();
			System.out.println("请输入车辆品牌:");
			String brand = scan.next();
			
			//拼接字符串
			String newCar = carid + "-" + type + "-" + color + "-" + price + "-" + brand;
			//对数组进行扩容
			cars = Arrays.copyOf(cars, cars.length + 1);
			//把新数据保存到数组的末尾
			cars[cars.length - 1] = newCar;
			System.out.println("新增车辆信息成功！");
		}
		
	}
	
	/**
	 * 判断caid是否存在，如果存在则返回 所在的下标
	 * @param carid: 判断车牌号
	 * @return int :返回carid在数组中所在下标，如果返回-1表示carid不存在
	 */
	public static int isExist(String carid) {
		for(int i = 0;i < cars.length;i++) {
			String car = cars[i];
			String[] split = car.split("-");
			if(split[0].equals(carid)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 3、根据车牌号修改车辆部分信息(类型、颜色、价格、品牌)
	 */
	public static void updateCarById() {
		System.out.println("请输入车牌号:");
		String carid = scan.next();
		//判断carid是否重复
		int index = isExist(carid);
		if(index > -1) {
			System.out.println("请输入车辆类型:");
			String type = scan.next();
			System.out.println("请输入车辆颜色:");
			String color = scan.next();
			System.out.println("请输入车辆价格:");
			String price = scan.next();
			System.out.println("请输入车辆品牌:");
			String brand = scan.next();
			
			//获取被修改车辆数据
			String oldCar = cars[index];
			//分割字符串
			String[] split = oldCar.split("-");
			//重新拼接字符串
			String updateCar = split[0] +"-" +  type + "-" + color + "-" + price + "-" + brand;
			//把修改过后字符串重新复制到指定索引位置
			cars[index] = updateCar;
			System.out.println("修改成功!");
		}else {
			System.out.println("你输入" + carid + "不存在!修改失败!");
		}
	}
	/**
	 * 4、根据车牌号删除车辆信息
	 */
	public static void delByCarId() {
		System.out.println("请输入车牌号:");
		String carid = scan.next();
		//判断carid是否重复
		int index = isExist(carid);
		if(index > -1) {
			//移动元素
			System.arraycopy(cars, index + 1, cars, index, cars.length - index - 1);
			//对数组进行缩容
			cars = Arrays.copyOf(cars, cars.length - 1);
			System.out.println("删除成功！");
		}else {
			System.out.println("你输入" + carid + "不存在!删除失败!");
		}
	}
	
	public static void main(String[] args) {
		
		boolean isLoop = true;
		while(isLoop) {
			System.out.println("1、查询所有汽车信息");
			System.out.println("2、添加一条车辆信息");
			System.out.println("3、根据车牌号修改车辆部分信息(类型、颜色、价格、品牌)");
			System.out.println("4、根据车牌号删除车辆信息");
			System.out.println("5、根据车牌号查询车辆信息");
			System.out.println("6、查询出所有四川牌照的轿车信息");
			System.out.println("7、查找价格在20万 - 40万之间的宝马汽车");
			System.out.println("8、根据车辆价格对所有车辆进行升序排序");
			System.out.println("9、统计不同类型的车辆总数");
			System.out.println("10、退出");
			System.out.println("请输入你要进行的操作：");
			int num = scan.nextInt();
			switch (num) {
			case 1:
				showCars();
				break;
			case 2:
				addCar();
				break;
			case 3:
				updateCarById();
				break;
			case 4:
				delByCarId();
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				System.out.println("退出成功!");
				isLoop = false;
				break;
			default:
				System.out.println("输入错误，请重新输入....");
				break;
			}

		}
		    
		    
		   

		
		
	}
}
