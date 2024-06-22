package main.Database;
import main.bean.Phone;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Phone> phonesList;
    static {
        phonesList = new ArrayList<Phone>();
        phonesList.add(new Phone("20230112200501","vivo S16",2699,900,"2023-01-01","vivo"));
        phonesList.add(new Phone("20230112200502","华为P40 pro",6499,1000,"2022-12-12","华为"));
        phonesList.add(new Phone("20230112200503","华为Mate 50",5999,800,"2022-12-30","华为"));
        phonesList.add(new Phone("20230112200504","小米13 Pro",6299,2000,"2022-12-18","小米"));
        phonesList.add(new Phone("20230112200505","iphone14 pro",8899,3000,"2022-12-10","Apple"));
        phonesList.add(new Phone("20230112200506","三星 S22",8099,3100,"022-11-11","三星"));
    }
    private Database(){
    }
    public static List<Phone> getPhonesList() {
        return phonesList;
    }
}
