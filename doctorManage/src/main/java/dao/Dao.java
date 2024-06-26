package dao;

import bean.Doctor;
import database.Database;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dao {
    /**
     * 第一问
     * @return 医生列表
     */
    public static List<Doctor> showAllDoctor(){
        return Database.getDoctors().stream().toList();
    }

    /**
     * 检索输入的id是否重复
     * @param InputDoctorId 输入的id
     * @return 返回存在否，存在true 反之 false
     */
    public static boolean doctorInDatabase(String InputDoctorId){
        for (Doctor doctor : Database.getDoctors()){
            if (doctor.getId().equals(InputDoctorId)){
                return true;
            }
        }
        return false;
    }

    /**
     * 第二问
     * @param Doctor 输入的对象
     * @return  返回添加是否成功的字符串
     */
    public static String addDoctor(Doctor Doctor){
        if (!doctorInDatabase(Doctor.getId())){
            Database.getDoctors().add(Doctor);
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * 第3问 通过ID 修改职称、年龄
     * @param InputId   ID
     * @param InputJobTitle 职称
     * @param InputAge  年龄
     */
    public static String updateDoctor(String InputId,String InputJobTitle,int InputAge){
        if (doctorInDatabase(InputId)){
            for (Doctor doctor : Database.getDoctors()){
                if (doctor.getId().equals(InputId)){
                    doctor.setJobTitle(InputJobTitle);
                    doctor.setAge(InputAge);
                    return "修改成功";
                }
            }
        }
        return "修改失败";
    }

    /**
     * 第4问
     * @param InputId 待删除ID
     * @return 删除成功
     */
    public static String deleteDoctor(String InputId){
        List<Doctor> newDoctorList = Database.getDoctors().stream().filter(d -> !d.getId().equals(InputId)).toList();
        Database.setDoctors(newDoctorList);
        return "删除完毕";
    }

    /**
     * 第5问
     * @return 符合名字有 杨 的列表
     */
    public static List<Doctor> showYangInName(){
        return Database.getDoctors().stream().filter(d-> d.getName().contains("杨")).toList();
    }

    /**
     * 第6问 返回主治医师平均年龄
     * @return  平均年龄
     */
    public static double showAverageAgeOfAttendingPhysicians(){
        return Database.getDoctors().stream().collect(Collectors.averagingDouble(Doctor::getAge));
    }

    /**
     * 第7问
     * @return 映射，部门数量，部门列表
     */
    public static Map<Integer, List<String>> showDepartmentInHospital(){
        Map<Integer,List<String>> dMap = new java.util.HashMap<>(Map.of());
        List<String> dList = Database.getDoctors().stream().map(Doctor::getDepartment).distinct().toList();
        dMap.put(dList.size(),dList);
        return dMap;
    }

    /**
     * 第8问
     * @param InputId 输入ID
     * @return 输出 String 医生信息
     */
    public static List<Doctor> showDoctorWithId(String InputId){
        return  Database.getDoctors().stream().filter(d->d.getId().equals(InputId)).toList();
    }

    /**
     * 第9问
     * @return 女医生列表
     */
    public static List<Doctor> showWomenDoctor(){
        return  Database.getDoctors().stream().filter(d->d.getGender().equals("女")).sorted((d1,d2)->d1.getAge()-d2.getAge()).toList();
    }

    /**
     * 第10问 不同性别医生及其信息
     * @return Map<性别，List该性别人员>
     */
    public static Map<String,List<Doctor>> showDoctorWithGender(){
        Map<String,List<Doctor>> dMap = new java.util.HashMap<>(Map.of());
        dMap.put("男",Database.getDoctors().stream().filter(d->d.getGender().equals("男")).toList());
        dMap.put("女",Database.getDoctors().stream().filter(d->d.getGender().equals("女")).toList());
        return dMap;
    }
}
