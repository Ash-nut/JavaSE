package main.view;

import main.bean.Phone;
import main.dao.PhoneDao;

import java.util.List;
import java.util.Scanner;

import static main.dao.newPhoneDao.showMaxThreePhone;

public class PhoneManageGUI {
    public static void Gui() {
        String id;
        int price;
        String name;
        int quantityInStock;
        String brand;
        System.out.println("1.查询所有商品信息？(10分)");
        System.out.println("2.添加一条商品信息？(10分)");
        System.out.println("3.根据商品编号修改指定商品价格和库存？(10分)");
        System.out.println("4.删除所有的苹果手机?(10分)");
        System.out.println("5.查询价格最高的前三个商品信息？(10分)");
        System.out.println("6.查询2022-12录入的商品按照库存进行升序排序？(10分)");
        System.out.println("7.计算出所有华为旗下商品的平均价格?(10分)");
        System.out.println("8.查询出所有非华为旗下的所有商品中价格最高的商品信息?(10分)");
        System.out.println("9.根据品牌进行分组,显示每个品牌的总数量以及每个品牌下具体的商品信息？(20分)");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                System.out.println(PhoneDao.showPhoneList().toString());
                break;
            case 2:
                System.out.println("输入id");
                id = sc.next();
                if (!PhoneDao.searchTargetView(id)) {
                    System.out.println("可以使用这个id");
                    System.out.println("输入名称：");
                    name = sc.next();
                    System.out.println("输入价格：");
                    price = sc.nextInt();
                    System.out.println("输入库存：");
                    quantityInStock = sc.nextInt();
                    System.out.println("输入品牌：");
                    brand = sc.next();
                    PhoneDao.addPhone(id, name, price, quantityInStock, brand);
                    System.out.println("完成创建");
                    break;
                } else {
                    System.out.println("该id已存在");
                }
                break;
            case 3:
                System.out.println("输入id");
                id = sc.next();
                if (!PhoneDao.searchTargetView(id)) {
                    System.out.println("修改售价为：");
                    price = sc.nextInt();
                    System.out.println("修改库存为：");
                    quantityInStock = sc.nextInt();
                    PhoneDao.updatePhone(price,quantityInStock,id);
                    System.out.println("修改成功");
                    break;
                }else {
                    System.out.println("目标不存在");
                }
                break;
            case 4:
                PhoneDao.deleteAllIphone();
                System.out.println("已删除所有的苹果手机");
                break;
            case 5:
                System.out.println("售价前三的商品信息：");
                showMaxThreePhone();
                //System.out.println(PhoneDao.showAllphoneWithPrice());
                break;
                case 6:
                    System.out.println(PhoneDao.showSix());
                    break;
                case 7:
                    System.out.println(PhoneDao.getHuaWeiAvgPrice());
                    break;
                    case 8:
                        System.out.println(PhoneDao.getMaxPriceAndNotHW());
                        break;
                        case 9:
                            for (List<Phone> brandList:PhoneDao.showAllPhoneWithBrand()){
                                System.out.println(brandList.get(0).getBrand()+" 手机有 "+brandList.size()+" 种");
                                for (Phone phone:brandList) {
                                    System.out.println(phone.toString());
                                }
                            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            Gui();
        }
    }
}
