package cn.helloworld1999;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 没写完
 * 
 * 1.查询所有学生信息
 * 2.添加一条学生信息
 * 3.修改指定学生的年龄
 * 4.删除指定学员的信息
 */
public class Exercises4 {
    static String[] stus = { "wn1001-杨紫-23", "wn1002-杨铁环-28", "wn1003-杨铁盆-22", "wn1004-杜气眼-21" };

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    /**
     * 获取键入的学号
     * 
     * @return String stuNum 学生学号
     */
    static String selectStuNum() {
        System.out.println("输入目标学号：");
        Scanner sc = new Scanner(System.in);
        String stuNum = sc.next();
        return stuNum;
    }

    /**
     * 查找学生
     * 查找学生，并返回在名单中的索引
     * 通过学号和待查名单，打印学号对应的学生信息，并返回信息
     * 
     * @param stus
     * @return int类型 目标字符串在stus[]的索引；如果没有找到则返回 -1
     */
    static int findStuAndGetStuIndex(String[] stus, String stuNum) {
        int index = 0;
        for (; index < stus.length; index++) {
            if (stuNum.equals((stus[index].split("-"))[0])) {
                System.out.println(stus[index]);
                return index;
            }
        }
        System.out.println("查无此人");
        index = -1;
        return index;
    }

    /**
     * 传入待处理名单，打印所有学生信息
     * 
     * @param stus
     */
    static void showStus(String[] stus) {
        for (String stu : stus) {
            System.out.println("学号：" + (stu.split("-"))[0] +
                    " 姓名：" + (stu.split("-"))[1] +
                    " 年龄：" + (stu.split("-"))[2]);
        }
    }

    /**
     * 增加学生
     * 创建新学生，输入待处理名单，输出新名单
     * 
     * @param stus
     * @return
     */
    static String[] creatStu(String[] stus) {
        String[] tempStus = new String[stus.length + 1];
        Scanner sc = new Scanner(System.in);
        System.out.println("新学生学号：");
        String stu = sc.next() + "-";
        System.out.println("新学生姓名：");
        stu += sc.next() + "-";
        System.out.println("新学生年龄：");
        stu += sc.next();
        System.out.println("新学生信息：" + stu);
        tempStus[tempStus.length - 1] = stu;
        for (int i = 0; i <= stus.length - 1; i++) {
            tempStus[i] = stus[i];
        }
        stus = tempStus;
        return stus;
    }

    /**
     * 删除
     * 删除学生，输入待处理名单，目标索引，输出名单
     * 
     * @param stus
     * @param sutNum
     * @return
     */
    static String[] dropStu(String[] stus, int index) {
        stus[index] = stus[stus.length - 1];
        stus = Arrays.copyOf(stus, stus.length - 1);
        return stus;
    }

    /**
     * 修改学生
     * 传入名单， 目标索引；键入修改信息，输出修改后名单
     * 
     * @param stus
     * @param index
     * @return 返回一个 String[] 学生表
     */
    static String[] changeStuAge(String[] stus, int index) {
        Scanner sc = new Scanner(System.in);
        System.out.println("年龄修改为:");
        String age = sc.next();
        String[] stu = stus[index].split("-");
        stu[2] = age;
        String stuTemp = "";
        stuTemp += stu[0] + "-" + stu[1] + "-" + age;
        stus[index] = stuTemp;
        return stus;
    }

    static void menu() {
        System.out.println("1.查询所有学生信息");
        System.out.println("2.添加一条学生信息");
        System.out.println("3.修改指定学生的年龄");
        System.out.println("4.删除指定学员的信息"); // 这是个有问题的方法，要重写的
        System.out.println("5.根据标号查询指定学生信息");
        System.out.println("6.找出年龄在20-25之间所有姓杨的学生");
        System.out.println("7.三个字且带有'铁'关键字的学生");
        System.out.println("8.根据年龄对学生进行排序");
        System.out.println("9.退出");
        Scanner sc = new Scanner(System.in);
        byte key = sc.nextByte();
        switch (key) {
            case 1:
                showStus(stus);
                break;
            case 2:
                stus = creatStu(stus);
                break;
            case 3:
                int index3 = 0;
                index3 = findStuAndGetStuIndex(stus, selectStuNum());
                if (index3 == -1) {
                    System.out.println("查 无 此 人");
                    break;
                }
                stus = changeStuAge(stus, index3);
                break;
            case 4:
                int index4 = 0;
                index4 = findStuAndGetStuIndex(stus, selectStuNum());
                if (index4 == -1) {
                    System.out.println("查 无 此 人");
                    break;
                }
                stus = dropStu(stus, index4);
                break;
            case 5:
                break;
            case 9:
                System.out.println("系 统 退 出");
                System.exit(0);
            default:
                System.out.println("非 法 输 入");
                break;
        }
    }
}
