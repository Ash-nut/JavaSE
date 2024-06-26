package view;

import bean.Doctor;
import dao.Dao;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class view {
    public static void main(String[] args) {
        while (true){
            menu();
        }
    }

    public static void menu() {
        System.out.println("1、查询所有医生信息(10分)");
        System.out.println("2、录入一条医生数据(10分)");
        System.out.println("3、根据工作证号修改指定医生职称和年龄信息(10分)");
        System.out.println("4、根据工作证号删除指定医生信息(10分)");
        System.out.println("5、查询姓名中包含   杨  的医生信息(10分)");
        System.out.println("6、所有主治医生的平均年龄是多少?(10分)");
        System.out.println("7、统计现在医院有多少个科室？分别是哪些科室(10分)");
        System.out.println("8、根据工作证号查询指定医生信息(10分)");
        System.out.println("9、查询所有女性的医生，再根据医生的年龄进行降序排序(10分)");
        System.out.println("10、统计不同性别医生总人数同时显示出不同性别具体医生信息？(10分)");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        switch (key) {
            case 1:
                System.out.println("医生信息如下：");
                System.out.println(Dao.showAllDoctor());
                break;
            case 2:
                System.out.println("依次输入： 工作证号  | 姓名  | 职称   | 所属科室名 | 年龄  | 性别  ");
                System.out.println(Dao.addDoctor(new Doctor(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next())));
                break;
            case 3:
                System.out.println("依次输入：待修改的医生id | 新职称 | 新年龄");
                System.out.println(Dao.updateDoctor(sc.next(), sc.next(), sc.nextInt()));
                break;
            case 4:
                System.out.println("请输入准备删除的医生的id");
                System.out.println(Dao.deleteDoctor(sc.next()));
                break;
            case 5:
                System.out.println("名字内含有“杨”的列表如下：");
                System.out.println(Dao.showYangInName());
                break;
            case 6:
                System.out.println("主治医师的平均年龄如下：");
                System.out.println(Dao.showAverageAgeOfAttendingPhysicians());
                break;
            case 7:
                System.out.println("科室数量及详情如下：");
                System.out.println(Dao.showDepartmentInHospital());
                break;
            case 8:
                System.out.println("目标医生的信息为：");
                System.out.println(Dao.showDoctorWithId(sc.next()).toString());
                break;
            case 9:
                System.out.println("女医生信息如下：");
                System.out.println(Dao.showWomenDoctor());
                break;
                case 10:
                    System.out.println("男女医生信息如下：");
                    for (Map.Entry<String, List<Doctor>>ent:Dao.showDoctorWithGender().entrySet()) {
                        System.out.println("性别为 "+ent.getKey()+ " 的医生有 "+ent.getValue().size()+" 人，信息如下：");
                        System.out.println(ent.getValue());
                    }
                    break;
            default:
                System.out.println("非法输入");
                break;
        }
    }
}
