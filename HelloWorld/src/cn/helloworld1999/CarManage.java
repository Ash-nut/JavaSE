package cn.helloworld1999;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 起了个chinglish的项目名称（笑）
 * 
 * @author YiXinrui
 */
public class CarManage {
    static Car[] newCars; // 拿来接初始化的 Car[]
    static String[] cars = { "川A55532-轿车-黑色-235000-宝马", "川A55577-SUV-黑色-370000-奔驰", "川A55566-轿车-红色-157000-宝马",
            "苏A55599-SUV-黑色-210000-比亚迪" };

    public static void main(String[] args) {
        newCars = CarManage.initCars();
        while (true) {
            menu();
        }
    }

    /**
     * 初始化车辆信息
     * 
     * @return 一个Car[]
     */
    public static Car[] initCars() {
        Car[] tempCars = new Car[cars.length]; // 这个就是我后续准备用来操作的，然后就不用 String[]cars了
        for (int i = 0; i < cars.length; i++) {
            tempCars[i] = new Car(cars[i].split("-")[0], cars[i].split("-")[1], cars[i].split("-")[2],
                    Integer.parseInt(cars[i].split("-")[3]), cars[i].split("-")[4]);
        }
        return tempCars;
    }

    static public void showCars(Car[] tempCars) {
        System.out.println("-----------车 辆 信 息-----------");
        System.out.println("| 车牌号码 | 类型 | 颜色 | 价格 | 品牌 |");
        for (Car i : tempCars) {
            System.out.println(
                    i.licensePlateNumber + "  " + i.vehicleType + "  " + i.color + "  " + i.price + "  " + i.brand);
        }
    }

    // 尝试一下正则表达式
    static public boolean inputValidityCheck(String temp) {
        boolean flag = false;
        String regx = "[京津冀晋内辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川黔滇藏陕甘青宁新港澳台][A-Z][0-9]{5}";
        flag = temp.matches(regx);
        return flag;
    }

    /**
     * 在现有Car[]里查找是否存在输入的车牌号的实例，存在则返回在Car[]中的位置，不存在则返回 -1
     * 
     * @param tempCars
     * @return 返回的是 int类型
     */
    static public int findCar(Car[] tempCars) {
        int flag = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入待查找的车牌号码：");
        String str = sc.next();
        if (!inputValidityCheck(str)) {
            System.out.println("输入车牌格式错误");
            return -1;
        }
        for (int i = 0; i <= tempCars.length - 1; i++) {
            if (str.equals(tempCars[i].licensePlateNumber)) {
                System.out.println("车牌信息：" + tempCars[i].licensePlateNumber + " 车辆类型：" + tempCars[i].vehicleType
                        + " 车辆颜色：" + tempCars[i].color + " 车辆价格：" + tempCars[i].price + " 车辆品牌:" + tempCars[i].brand);
                return i;
            }
        }
        System.out.println("目标不存在");
        return flag;
    }

    /**
     * 【不重复】则返回【-1】在现有Car[]里查找是否存在输入的车牌号的实例，存在则返回在Car[]中的位置，不重复则返回 -1
     * 就是上面的 findCar的自动版
     * 
     * @param tempCars
     * @return 返回的是 int类型
     */
    static public int selectCar(Car[] tempCars, String str) {
        if (!inputValidityCheck(str)) {
            System.out.println("输入车牌格式错误");
            return -1;
        }
        int flag = -1;
        for (int i = 0; i <= tempCars.length - 1; i++) {
            if (str.equals(tempCars[i].licensePlateNumber)) {
                return i;
            }
        }
        return flag;
    }

    /**
     * 创建一辆新车子
     * 
     * @param tempCars
     * @return
     */
    static public void creatNewCar(Car[] tempCars) {
        Car[] temp = Arrays.copyOf(tempCars, tempCars.length + 1);
        Scanner sc = new Scanner(System.in);
        temp[temp.length - 1] = new Car(null, null, null, 0, null);
        System.out.println("新增车辆的车牌 |号码| 为：");
        String tempNum = sc.next();
        if (selectCar(tempCars, tempNum) == -1) {
            temp[temp.length - 1].licensePlateNumber = tempNum;
            System.out.println("新增车辆的车辆 |类型| 为：");
            temp[temp.length - 1].vehicleType = sc.next();
            System.out.println("新增车辆的车辆 |颜色| 为：");
            temp[temp.length - 1].color = sc.next();
            System.out.println("新增车辆的车辆 |价格| 为：");
            temp[temp.length - 1].price = sc.nextInt();
            System.out.println("新增车辆的车辆 |品牌| 为：");
            temp[temp.length - 1].brand = sc.next();
            System.out.println("创建成功");
            CarManage.newCars = temp;
        } else {
            System.out.println("车牌号输入有误");
        }
    }

    /**
     * 修改车辆信息
     * 
     * @param tempCars
     */
    static public void updataCarData(Car[] temp) {
        Scanner sc = new Scanner(System.in);
        System.out.println("待修改信息的车辆车牌 |号码| 为：");
        String tempNum = sc.next();
        int index = selectCar(temp, tempNum);
        System.out.println("----------------------------");
        System.out.println("1.修改车辆类型");
        System.out.println("2.修改车辆颜色");
        System.out.println("3.修改车辆价格");
        System.out.println("4.修改车辆品牌");
        System.out.println("----------------------------");
        if (index != -1) {
            byte key = sc.nextByte();
            switch (key) {
                case 1:
                    temp[index].setVehicleType();
                    break;
                case 2:
                    temp[index].setColor();
                    break;
                case 3:
                    temp[index].setPrice();
                    break;
                case 4:
                    temp[index].setBrand();
                    break;
                default:
                    System.out.println("非法输入");
                    break;
            }
        } else {
            System.out.println("车牌号输入有误");
        }
    }

    /**
     * 删除车子
     * 
     * @param temp
     */
    static public void dropCar(Car[] temp) {
        Scanner sc = new Scanner(System.in);
        System.out.println("待删除信息的车辆车牌 |号码| 为：");
        String tempNum = sc.next();
        int index = selectCar(temp, tempNum);
        if (index != -1) {
            temp[index] = temp[temp.length - 1];
            CarManage.newCars = Arrays.copyOf(temp, temp.length - 1);
        } else {
            System.out.println("车牌号输入有误");
        }
    }

    static public void showSiChuanNumAndSaloonCars(Car[] tempCars) {
        System.out.println("-----------车 辆 信 息-----------");
        System.out.println("| 车牌号码 | 类型 | 颜色 | 价格 | 品牌 |");
        for (Car i : tempCars) {
            if (i.licensePlateNumber.startsWith("川") && i.vehicleType.equals("轿车")) {
                System.out.println(
                        i.licensePlateNumber + "  " + i.vehicleType + "  " + i.color + "  " + i.price + "  " + i.brand);
            }
        }
    }

    static public void showBMW400kCars(Car[] tempCars) {
        System.out.println("-----------车 辆 信 息-----------");
        System.out.println("| 车牌号码 | 类型 | 颜色 | 价格 | 品牌 |");
        for (Car i : tempCars) {
            if ((i.price > 200000 && i.price < 400000) && i.brand.equals("宝马")) {
                System.out.println(
                        i.licensePlateNumber + "  " + i.vehicleType + "  " + i.color + "  " + i.price + "  " + i.brand);
            }
        }
    }

    static public void bubbleSort(Car[] tempCars) {
        for (int i = 0; i < tempCars.length - 1; i++) {
            for (int j = 0; j < tempCars.length - 1 - i; j++) {
                Car temp = null;
                if (tempCars[j].price > tempCars[j + 1].price) {
                    temp = tempCars[j];
                    tempCars[j] = tempCars[j + 1];
                    tempCars[j + 1] = temp;
                }
            }
        }
    }

    static public void menu() {
        System.out.println("--------------------------------------------------");
        System.out.println("1、查询所有汽车信息\n" + //
                "\n" + //
                "2、添加一条车辆信息\n" + //
                "\n" + //
                "3、根据车牌号修改车辆部分信息(类型、颜色、价格、品牌)\n" + //
                "\n" + //
                "4、根据车牌号删除车辆信息\n" + //
                "\n" + //
                "5、根据车牌号查询车辆信息\n" + //
                "\n" + //
                "6、查询出所有四川牌照的轿车信息\n" + //
                "\n" + //
                "7、查找价格在20万 - 40万之间的宝马汽车\n" + //
                "\n" + //
                "8、根据车辆价格对所有车辆进行升序排序\n" + //
                "\n" + //
                "9、统计不同类型的车辆总数");
        System.out.println("--------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        byte key = sc.nextByte();
        switch (key) {
            case 1:
                showCars(newCars);
                break;
            case 2:
                creatNewCar(newCars);
                break;
            case 3:
                updataCarData(newCars);
                break;
            case 4:
                dropCar(newCars);
                break;
            case 5:
                findCar(newCars);
                break;
            case 6:
                showSiChuanNumAndSaloonCars(newCars);
                break;
            case 7:
                showBMW400kCars(newCars);
                break;
            case 8:
                bubbleSort(newCars);
                break;
            case 9:
                Car.showTypeAndNum(newCars);
                break;
            default:
                System.out.println("非法输入");
                break;
        }
    }

}

/**
 * 没什么想法，把这个单纯当结构体来用
 */
class Car {
    static String[] staticVehicleTypes = null; // 车辆类型及数量,先创建，留着。
    String licensePlateNumber = null; // 车牌号
    String vehicleType = null; // 车辆类型
    String color = null; // 颜色
    int price = 0; // 价格
    String brand = null; // 品牌

    // 构造函数
    Car(String licensePlateNumber, String vehicleType, String color, int price, String brand) {
        this.licensePlateNumber = licensePlateNumber;
        this.vehicleType = vehicleType;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public void setVehicleType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("车辆类型修改为：");
        vehicleType = sc.next();
    }

    public void setColor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("车辆颜色修改为：");
        color = sc.next();
    }

    public void setPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("车辆价格修改为：");
        price = sc.nextInt();
    }

    public void setBrand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("车辆价格修改为：");
        brand = sc.next();
    }

    /**
     * 我预期的效果是可以生成一个局部变量的 String[], 数组内容为：{车辆类型1，车辆类型1的数量，车辆类型2，车辆类型2的数量，……}
     * 
     * @param tempCars
     */
    static public void showTypeAndNum(Car[] tempCars) {
        String[] carTypes = new String[0];
        for (int i = 0; i <= tempCars.length - 1; i++) {
            boolean flag = false;
            int index = -1;
            // 这个 j 的游标我让它指向奇数位，也就是我设定的存放类型的地方；也就是说这个循环我用它来【遍历现有的车辆类型】的表。
            for (int j = 0; j <= carTypes.length - 1; j += 2) {
                if (tempCars[i].vehicleType.equals(carTypes[j])) {
                    index = j;
                    flag = true;
                }
            }
            if (flag && index != -1) {
                // 如果他们这次相等，那么我就要让 carTypes[j+1] 的地方 +1，也就是给这种类型的数量+1
                // 这里我需要先把 carTypes[j+1] 先转换成 int,以便进行 +1；再转回 String 存入
                int temp = Integer.parseInt(carTypes[index + 1]) + 1;
                carTypes[index + 1] = Integer.toString(temp);
            } else {
                // 这说明没有查到这种类型，那我要给 carType[] 进行扩列，加两位。
                carTypes = Arrays.copyOf(carTypes, carTypes.length + 2);// 扩列
                carTypes[carTypes.length - 2] = tempCars[i].vehicleType; // 添加新的车辆类型
                // 这里我直接给一个 String 的 "1" 是因为这种情况根本不用进行计算；因为这里代表着这个车辆类型第一次出现
                carTypes[carTypes.length - 1] = "1";
            }
            System.out.println("车辆类型" + "  " + "车辆数量");
            for (int x = 0; x <= carTypes.length - 1; x += 2) {
                System.out.println(carTypes[x] + "  " + carTypes[x + 1]);
            }
        }
    }
}