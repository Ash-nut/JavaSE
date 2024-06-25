package main.dao;
import main.bean.Phone;
import main.Database.Database;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneDao {
    // 我不需要这个类的对象实例化，所以我就根本不开放构造方法
    private PhoneDao() {
    }

    /**
     * 留给 dao 用，view不需要知道数据的位置
     *
     * @param id 产品ID
     * @return 产品索引 -1 为产品不存在
     */
    private static int searchTargetDao(String id) {
        for (int i = 0; i < Database.getPhonesList().size(); i++) {
            if (Database.getPhonesList().get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给前端的存在检测
     *
     * @param id 产品ID
     * @return boolean 存在为 true 反之 false
     */
    public static boolean searchTargetView(String id) {
        for (Phone phone : Database.getPhonesList()) {
            if (phone.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return 传数据
     */
    public static List<Phone> showPhoneList() {
        return Database.getPhonesList();
    }

    /**
     * 增
     */
    public static void addPhone(String id,String name,int price,int quantityInStock,String brand) {
        Phone temp = new Phone(id,name,price,quantityInStock,brand);
        Database.getPhonesList().add(temp);
    }

    /**
     * 删
     * @param id id
     * @return 修改结果
     */
    public static boolean deletePhone(String id) {
        int index = searchTargetDao(id);
        for (Phone phone : Database.getPhonesList()) {
            if (index != -1) {
                Database.getPhonesList().remove(index);
                return true;
            }
        }
        return false;
    }

    /**
     * 改
     * @param quantityInStock 库存
     * @param price 售价
     * @param id ID
     * @return 修改是否成功
     */
    public static void updatePhone(int price,int quantityInStock, String id) {
        int index = searchTargetDao(id);
        if (index != -1) {
            Database.getPhonesList().get(index).setPrice(price);
            Database.getPhonesList().get(index).setQuantityInStock(quantityInStock);
        }
    }

    public static void deleteAllIphone() {
        Database.getPhonesList().removeIf(phone -> phone.getBrand().equals("苹果"));
    }

    public static List<Phone> showAllphoneWithPrice() {
        List<Phone> phones = new ArrayList<Phone>();
        Database.getPhonesList().sort(new Comparator<Phone>() {
            public int compare(Phone o1, Phone o2) {
                return o2.comepareToPrice(o1);
            }
        });
        phones.add(Database.getPhonesList().get(0));
        phones.add(Database.getPhonesList().get(1));
        phones.add(Database.getPhonesList().get(2));

        return phones;
    }
    public static List<Phone> showSix(){
        List<Phone> phones = new ArrayList<>();
        Database.getPhonesList().sort(new Comparator<Phone>() {
            public int compare(Phone o1, Phone o2) {
                return o1.comepareToQuantityInStock(o2);
            }
        });
        for (Phone phone : Database.getPhonesList()) {
            if (phone.getBrand().startsWith("2022-12")){
                phones.add(phone);
            }
        }
        return phones;
    }
    public static double getHuaWeiAvgPrice() {
        double sum = 0;
        double temp = 0;
        for (Phone phone : Database.getPhonesList()) {
            if (phone.getBrand().equals("华为")) {
                sum += phone.getPrice();
                temp++;
            }
        }
        return sum / temp;
    }

    public static List<Phone> getMaxPriceAndNotHW(){
        double max = 0;
        List<Phone> phones = new ArrayList<>();
        for (Phone phone : Database.getPhonesList()) {
            if(!phone.getBrand().equals("华为")){
                max = Math.max(max, phone.getPrice());
            }
        }
        for (Phone phone : Database.getPhonesList()) {
            if (phone.getPrice() == max && !phone.getBrand().equals("华为")){
                phones.add(phone);
            }
        }
        return phones;
    }
    public static List<List<Phone>> showAllPhoneWithBrand(){
        List<List<Phone>> phones = new ArrayList<>();
        int j = 0;
        int i = 0;
        for (j = 0; j < Database.getPhonesList().size(); j++) {
            boolean flag = false;
            for (i= 0;i<phones.size();i++) {
                if (phones.get(i).get(0).getBrand().equals(Database.getPhonesList().get(j).getBrand())){
                    phones.get(i).add(Database.getPhonesList().get(j));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                phones.add(new ArrayList<>());
                phones.get(i).add(Database.getPhonesList().get(j));
            }
        }
        return phones;
    }
}

