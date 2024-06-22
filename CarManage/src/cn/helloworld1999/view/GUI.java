package cn.helloworld1999.view;

import cn.helloworld1999.dao.CarDao;

import java.util.Scanner;

public class GUI {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
        System.out.println("1.查询所有车辆信息");
        System.out.println("2.查询价格高出20000的川A车辆有哪些？");
        System.out.println("3.找出价格最高的黑色车辆信息？");
        System.out.println("4.计算所有车辆的出租的平均价格？");
        System.out.println("5.找出所有非川A车辆根据价格进行升序排序？");
        System.out.println("6.找出所有SUV中的黑色车辆，且出租价格大于600车辆信息？");
        System.out.println("7.新增一条车辆数据");
        System.out.println("8.修改指定车辆的颜色、类型、出租价格");
        System.out.println("9.根据id删除指定车辆信息");
        System.out.println("10。根据车牌删除指定车辆");
            System.out.println("11.退出");
            switch (sc.next()) {
            case "1":
                System.out.println(CarDao.showCars());
                break;
            case "2":
                System.out.println(CarDao.getCarMoreThan());
                break;
            case "3":
                System.out.println(CarDao.getPriceMaxCar());
                break;
            case "4":
                System.out.println(CarDao.getAllCarsPriceAverage());
                break;
            case "5":
                System.out.println(CarDao.ascendingSort());
                break;
            case "6":
                System.out.println(CarDao.getSuvAndBlackAndMoreThan());
                break;
            case "7":
                System.out.println("输入准备新添加的车牌号：");
                String str = sc.next();
                if (CarDao.findInputCarIndexInCars(str) == -1) {
                    System.out.println("该车牌可用");
                    System.out.println("输入车辆类型：");
                    String type = sc.next();
                    System.out.println("输入车辆颜色：");
                    String color = sc.next();
                    System.out.println("输入车辆价格：");
                    int price = sc.nextInt();
                    System.out.println("输入车辆租金：");
                    int rentPrice = sc.nextInt();
                    CarDao.createCar(str, type, color, price, rentPrice);
                }
                System.out.println("创建完毕");
                break;
            case "8":
                System.out.println("输入准备更改的车辆车牌号：");
                String str1 = sc.next();
                if (CarDao.findInputCarIndexInCars(str1) == -1) {
                    System.out.println("该车辆可更改");
                    System.out.println("请选择你要修改的项目：");
                    String key = sc.next();
                    byte keyT = 0;
                    switch (key) {
                        case "1":
                            keyT = 1;
                            break;
                        case "2":
                            keyT = 2;
                            break;
                        case "3":
                            keyT = 3;
                            break;
                        default:
                            System.out.println("非法输入");
                            break;
                    }
                    System.out.println("修改为：");
                    String strTemp = sc.next();
                    CarDao.updateCar(str1, keyT, strTemp);
                }
                break;
            case "9":
                System.out.println("输入准备删除的车辆唯一ID号:");
                String str4 = sc.next();
                if (CarDao.findInputCarID(str4) != -1) {
                    CarDao.deleteCarWithCarReallyId(str4);
                    System.out.println("已删除");
                } else {
                    System.out.println("输入有误或不存在该目标");
                }
                break;
            case "10":
                System.out.println("输入准备删除的车辆车牌号：");
                String str3 = sc.next();
                if (CarDao.findInputCarIndexInCars(str3) != -1) {
                    CarDao.deleteCarWithCarId(str3);
                    System.out.println("已删除");
                } else {
                    System.out.println("输入有误或不存在该目标");
                }
                break;
                case "11":
                    flag = false;//只是为了让while循环不显示警告
                    System.out.println("退出系统");
            }
        }
        System.exit(0);
    }
}
