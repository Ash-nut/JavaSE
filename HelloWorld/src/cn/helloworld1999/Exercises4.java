package cn.helloworld1999;

import java.util.Scanner;

/**
 * 1.查询所有学生信息
 * 2.添加一条学生信息
 * 3.修改指定学生的年龄
 * 4.删除指定学员的信息
 */
public class Exercises4 {
    static String[] stus = { "wn1001-杨紫-23", "wn1002-杨铁环-28", "wn1003-杨铁盆-22", "wn1004-杜气眼-21" };

    public static void main(String[] args) {
        System.out.println(findStuAndGetStuIndex(stus));
    }

    // 不仅用来打印，还要用来返回位置；即返回 目标在 stus[] 的索引
    static int findStuAndGetStuIndex(String[] stus) {
        System.out.println("输入目标学号：");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        int index = 0;
        for (; index < stus.length; index++) {
            if (temp.equals((stus[index].split("-"))[0])) {
                System.out.println(stus[index]);
                return index;
            }
        }
        System.out.println("查无此人");
        index = -1;
        return index;
    }
}
