package cn.helloworld1999.userManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 有一个问题，关于 Scanner 的，如果创建了监听，但是却不关闭，那么会警告；
 * 但是如果设置了开和关，那么又会因为开关的太快导致程序崩溃了。
 * 如果设置成静态变量，那么又会出现输入中文会出错的情况，所以这得怎么办？？？
 */
public class UserManagement {
    static public String[] customers = {"2023122214-杜琦彦-男-8888-12/22","2023122215-范建-男-10000-12/21","2023122216-范桃花-女-12000-12/20","2023122217-范醉-男-11500-12/20"};
    static public List<User> userList = new ArrayList<>();
    static private Scanner sc = new Scanner(System.in);

    static public void initUserList(){
        for(String str:customers){
            userList.add(new User(str.split("-")[0], str.split("-")[1], str.split("-")[2],Double.parseDouble(str.split("-")[3]), str.split("-")[4]));
        }
    }

    static public void menu(){
        System.out.println("1.查询所有客户信息");
        System.out.println("2.添加一条客户信息");
        System.out.println("3.根据编号修改指定客户姓名和生日");
        System.out.println("4.根据编号删除指定客户");
        System.out.println("5.退出");
        byte key = sc.nextByte();
        switch (key) {
            case 1:
                showUserInformaction();
                break;
            case 2:
                addOneUser();
                break;
            case 3:
                setUserNameAndBitrthday();
                break;
            case 4:
                dropUser();
                break;
            case 5:
                System.exit(0);
                break;
            default:
            System.out.println("非法输入");
                break;
        }
    }

    static public void showUserInformaction(){
        for(User u:userList){
            System.out.println(u.toString());
        }
    }

    static public void addOneUser(){
        System.out.println("编号：");
        String userNum = sc.next();
        int flag = selectUserIndexFormList(userNum);
        if (flag != -1) {
            System.out.println("编号已存在，检查后重新输入");
            return;
        }
        System.out.println("姓名：");
        String userName = sc.next();
        System.out.println("性别：");
        String userGender = sc.next();
        System.out.println("余额：");
        double userBalance = sc.nextDouble();
        System.out.println("生日：");
        String userBirthday = sc.next();
        userList.add(new User(userNum,userName, userGender, userBalance, userBirthday));
    }

    static public int selectUserIndexFormList(String userNum){
        int index = -1;
        for(int i = 0;i<userList.size();i++){
            if (userList.get(i).getUserNum().equals(userNum)) {
                System.out.println("目标存在");
                return i;
            }
        }
        return index;
    }
    static public void setUserNameAndBitrthday(){
        System.out.println("输入待修改的目标id:");
        String userNum = sc.next();
        int index = selectUserIndexFormList(userNum);
        if (index != -1) {
            System.out.println("修改姓名为：");
            String userName = sc.next();
            userList.get(index).setUserName(userName);
            System.out.println("修改生日为：");
            String userBirthday = sc.next();
            userList.get(index).setUserBirthday(userBirthday);
            System.out.println("修改成功");
        }else{
            System.out.println("目标不存在");
            return;
        }
    }
    static public void dropUser(){
        System.out.println("待删除用户id为:");
        String userNum = sc.next();
        int index = selectUserIndexFormList(userNum);
        if (index == -1) {
            System.out.println("输入有误或不存在该用户");
        }else{
            userList.remove(index);
            System.out.println("删除完成");
        }
    }
    public static void main(String[] args) {
        initUserList();
        while (true) {
            menu();
        }
    }
}
