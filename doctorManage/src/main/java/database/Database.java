package database;

import bean.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Doctor> doctors;

    private Database() {
    }

    public static List<Doctor> getDoctors() {
        return doctors;
    }

    public static void setDoctors(List<Doctor> doctors) {
        Database.doctors = doctors;
    }

    static {
        doctors = new ArrayList<>();
        doctors.add(new Doctor("cd200", "高飞", "主任医师", "内科", 31, "男"));
        doctors.add(new Doctor("cd202", "杨蕾", "住院医师", "内科", 24, "女"));
        doctors.add(new Doctor("cd201", "邓杨", "主治医师", "儿科", 30, "男"));
        doctors.add(new Doctor("cd209", "程悦", "主治医师", "妇科", 34, "男"));
        doctors.add(new Doctor("cd208", "朱珠", "主治医师", "外科", 30, "女"));
        doctors.add(new Doctor("cd207", "宋思琪", "主任医师", "脑外科", 32, "女"));
    }
}
