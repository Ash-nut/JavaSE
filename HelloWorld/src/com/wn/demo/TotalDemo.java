package com.wn.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TotalDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isLoop = true;
		String[] cars = { "川A55532-轿车-黑色-235000-宝马",
				"川A55577-SUV-黑色-370000-奔驰",
				"川A55566-轿车-红色-157000-宝马",
				"苏A55599-SUV-黑色-210000-比亚迪" };
		while (isLoop) {
			System.out.println("========汽车信息系统=======");
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
			System.out.println("请输入您的操作：");
			int num = sc.nextInt();
			switch (num) {
				case 1:
					// 1、查询所有汽车信息
					System.out.println("车牌号\t汽车类型\t颜色\t价格\t品牌");
					for (String str : cars) {
						String[] split = str.split("-");
						for (String spl : split) {
							System.out.print(spl + "\t");
						}
						System.out.println();
					}
					break;
				case 2:
					// 2、添加一条车辆信息
					System.out.println("您需要添加的车牌号为：");
					String cCode = sc.next();
					// 定义一个默认值
					int index = -1;
					// 遍历
					for (int i = 0; i < cars.length; i++) {
						String car = cars[i];
						String[] spl = car.split("-");
						if (spl[0].equals(cCode)) {
							index = i;
							break;
						}
					}
					// 是否存在
					if (index == -1) {
						System.out.println("请输入您的汽车类型:");
						String stype = sc.next();
						System.out.println("请输入您的汽车颜色:");
						String color = sc.next();
						System.out.println("请输入您的汽车价格:");
						int price = sc.nextInt();
						System.out.println("请输入您的汽车品牌:");
						String bank = sc.next();
						// 扩容
						cars = Arrays.copyOf(cars, cars.length + 1);
						// 遍历
						String ca = cCode + "-" + stype + "-" + color + "-" + price + "-" + bank;
						cars[cars.length - 1] = ca;
						System.out.println("添加成功!");
					} else {
						System.out.println("该车牌号已存在，添加失败！");
					}
					break;
				case 3:
					// 3、根据车牌号修改车辆部分信息(类型、颜色、价格、品牌)
					System.out.println("您需要修改的车牌号为：");
					String cCode1 = sc.next();
					// 定义一个默认值
					int index1 = -1;
					// 遍历
					for (int i = 0; i < cars.length; i++) {
						String car = cars[i];
						String[] spl = car.split("-");
						if (spl[0].equals(cCode1)) {
							index1 = i;
							break;
						}
					}
					// 是否存在
					if (index1 != -1) {
						boolean flag = true;
						while (flag) {
							System.out.println("请选择需要修改的类别：1.类型 2.颜色 3.价格 4.品牌 5.退出");
							int num1 = sc.nextInt();
							switch (num1) {
								case 1:
									String oldCar = cars[index1];
									System.out.println("请输入您的汽车类型修改为:");
									String stype = sc.next();
									String[] car = oldCar.split("-");
									String ca = cCode1 + "-" + stype + "-" + car[2] + "-" + car[3] + "-" + car[4];
									cars[index1] = ca;
									System.out.println("修改成功!");
									break;
								case 2:
									String oldCar1 = cars[index1];
									System.out.println("请输入您的汽车颜色修改为:");
									String color = sc.next();
									String[] car1 = oldCar1.split("-");
									String ca1 = cCode1 + "-" + car1[1] + "-" + color + "-" + car1[3] + "-" + car1[4];
									cars[index1] = ca1;
									System.out.println("修改成功!");
									break;
								case 3:
									String oldCar2 = cars[index1];
									System.out.println("请输入您的汽车价格修改为:");
									int price = sc.nextInt();
									String[] car01 = oldCar2.split("-");
									String ca01 = cCode1 + "\t" + car01[1] + "\t" + car01[2] + "\t" + price + "\t"
											+ car01[4];
									cars[index1] = ca01;
									System.out.println("修改成功!");
									break;
								case 4:
									String oldCar3 = cars[index1];
									System.out.println("请输入您的汽车品牌修改为:");
									String bank = sc.next();
									String[] car02 = oldCar3.split("-");
									String ca02 = cCode1 + "\t" + car02[1] + "\t" + car02[2] + "\t" + car02[3] + "\t"
											+ bank;
									cars[index1] = ca02;
									System.out.println("修改成功!");
									break;
								case 5:
									System.out.println("退出成功");
									flag = false;
									break;
								default:
									System.out.println("您输入的操作有误！请重新输入");
									break;
							}
						}
						break;
					} else {
						System.out.println("该车牌号不存在，修改失败！");
					}
					break;
				case 4:
					// 4、根据车牌号删除车辆信息
					System.out.println("您需要删除的车牌号为：");
					String cCode2 = sc.next();
					// 定义一个默认值
					int index2 = -1;
					// 遍历
					for (int i = 0; i < cars.length; i++) {
						String car = cars[i];
						String[] spl = car.split("-");
						if (spl[0].equals(cCode2)) {
							index2 = i;
							break;
						}
					}
					// 是否存在
					if (index2 != -1) {
						String old = cars[index2];
						// 往删除的下标挪动
						System.arraycopy(cars, index2 + 1, cars, index2, cars.length - index2 - 1);
						// 缩容
						cars = Arrays.copyOf(cars, cars.length - 1);

						System.out.println("删除" + old.split("-")[4] + "成功!");
					} else {
						System.out.println("该车牌号不存在，删除失败！");
					}
					break;
				case 5:
					// 5、根据车牌号查询车辆信息
					System.out.println("您需要查询的车牌号为：");
					String cCode3 = sc.next();
					// 定义一个默认值
					int index3 = -1;
					// 遍历
					for (int i = 0; i < cars.length; i++) {
						String car = cars[i];
						String[] spl = car.split("-");
						if (spl[0].equals(cCode3)) {
							index3 = i;
							break;
						}
					}
					// 是否存在
					if (index3 != -1) {
						System.out.println(cars[index3]);
					} else {
						System.out.println("该车牌号不存在，查询失败！");
					}
					break;
				case 6:
					// 6、查询出所有四川牌照的轿车信息
					for (String car : cars) {
						String[] spl = car.split("-");
						if (spl[0].charAt(0) == '川') {
							System.out.println(Arrays.toString(spl));
						}
					}
					break;
				case 7:
					// 7、查找价格在20万 - 40万之间的宝马汽车
					for (String car : cars) {
						String[] split = car.split("-");
						int money = Integer.parseInt(split[3]);
						if (money >= 200000 && money <= 400000) {
							System.out.println(Arrays.toString(split));
						}
					}
					break;
				case 8:
					// 8、根据车辆价格对所有车辆进行升序排序
					for (int i = 0; i < cars.length - 1; i++) {
						for (int j = 0; j < cars.length - i - 1; j++) {
							String car1 = cars[j];
							String car2 = cars[j + 1];
							// 分割
							String[] ca1 = car1.split("-");
							String[] ca2 = car2.split("-");
							// 价格
							int money1 = Integer.parseInt(ca1[3]);
							int money2 = Integer.parseInt(ca2[3]);
							// 比较
							if (money1 > money2) {
								String temp = cars[j];
								cars[j] = cars[j + 1];
								cars[j + 1] = temp;
							}
						}
					}
					// 遍历
					System.out.println("================================");
					System.out.println("车牌号\t汽车类型\t颜色\t价格\t品牌");
					for (String car : cars) {
						String[] split = car.split("-");
						for (String str : split) {
							System.out.print(str + "\t");
						}
						System.out.println();
					}
					System.out.println("================================");
					break;
				case 9:
					// 9、统计不同类型的车辆总数
					// 先定义一个空数组
					String[] car = new String[0];
					// String stype = "";
					for (int i = 0; i < cars.length; i++) {
						boolean exit = false;
						String[] split = cars[i].split("-");
						for (String s : car) {
							if (split[1].equals(s)) {
								// stype = split[1];
								exit = true;
								break;
							}
						}
						if (!exit) {
							car = Arrays.copyOf(car, car.length + 1);
							car[car.length - 1] = split[1];
						}
					}
					System.out.println("不同类型总有：" + car.length);
					break;
				case 10:
					System.out.println("退出成功！");
					isLoop = false;
					break;
			}

		}
	}
}
