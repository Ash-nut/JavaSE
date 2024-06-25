package main.dao;

import main.Database.Database;
import main.bean.Phone;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class newPhoneDao {
    static public Stream<Phone> phonesListStream = Database.getPhonesList().stream();//现在我完成了第一步的 列表 转 Stream流

    /**
     * sorted 需要在类里实现 compareTo()
     */
    static public void showMaxThreePhone() {
        //phonesListStream.sorted((t1,t2)-> (int) (t2.getPrice()-t1.getPrice())).limit(3).forEach(System.out::println);
        Database.getPhonesList().stream().sorted((t1, t2) -> (int) (t2.getPrice() - t1.getPrice())).limit(3).forEach(System.out::println);
    }

    static public void showQuestionSix() {
        Database.getPhonesList().stream().filter(phone -> phone.getChangeDate().startsWith("2022-12"))
                .sorted(Comparator.comparingInt(Phone::getQuantityInStock)).forEach(System.out::println);
    }

    static public void showQuestionSeven() {
        Double ave = Database.getPhonesList().stream().filter(phone -> phone.getBrand().equals("华为")).collect(Collectors.averagingDouble(Phone::getPrice));
        System.out.println("平均值为：" + ave);
    }

    public static void showNotHW() {
        Double aveNoHW = Database.getPhonesList().stream().filter(phone -> !phone.getBrand().equals("华为")).collect(Collectors.averagingDouble(Phone::getPrice));
        System.out.println("非华为平均值为：" + aveNoHW);
    }

    public static void showNoHWMax() {
        System.out.println(Database.getPhonesList().stream().filter(phone -> !phone.getBrand().equals("华为")).sorted((s1, s2) -> (int) (s1.getPrice() - s2.getPrice())).limit(1).collect(Collectors.toList()));
    }

    public static void coooool() {
        List<String> brandList = Database.getPhonesList().stream().map(Phone::getBrand).distinct().toList();
        System.out.println(brandList);
    }

    public static void test() {
        Map<String, List<Phone>> fMap = Database.getPhonesList().stream().collect(Collectors.groupingBy(Phone::getBrand));
        System.out.println(fMap);
        System.out.println(fMap.keySet());
        for (List<Phone> i : fMap.values()) {
            System.out.println(i.size());
        }
        Map<String,Integer> brandAndNum = new java.util.HashMap<>(Map.of());
        for (Map.Entry<String, List<Phone>> entry : fMap.entrySet()) {
            brandAndNum.put(entry.getKey(),entry.getValue().size());
        }
        System.out.println(brandAndNum);
    }
    public static void getMax(){
        System.out.println(Database.getPhonesList().stream().collect(Collectors.maxBy((s1, s2) -> (int) (s1.getPrice() - s2.getPrice()))).get().getPrice());
    }
    public static void main(String[] args) {
        //showMaxThreePhone();
        //showQuestionSix();
        //showQuestionSeven();
        //showNotHW();
        //showNoHWMax();
        //coooool();
        //test();
        getMax();
    }
}
