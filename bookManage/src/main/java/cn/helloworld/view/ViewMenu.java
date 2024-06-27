package cn.helloworld.view;

import cn.helloworld.bean.Book;
import cn.helloworld.dao.Dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ViewMenu {
    private static boolean flag = false;

    static public void showMenu() throws IOException {
        System.out.println("1、查询所有书籍信息");
        System.out.println("2、添加一册书籍信息");
        System.out.println("3、把 作者 我吃番茄 的所有书籍  修改为  东方玄幻");
        System.out.println("4、删除指定 编号的书籍信息？");
        System.out.println("5、我吃番茄 所有书籍的平均阅读人数是多少？");
        System.out.println("6、根据 书籍类型 找出对应的作者有哪些？");
        System.out.println("7、找出 玄幻类型 的阅读量最高的书籍信息");
        System.out.println("8、找出 阅读量 排名在 第二 的书籍信息？");
        System.out.println("9、统计不同类型的书籍数量 及 书籍详情？");
        System.out.println("10、找出 作者为   我吃番茄 的书籍，进行冒泡排序");
        if (!flag){System.out.println("11、自动保存 | 已关闭");
        } else {
            System.out.println("11、自动保存 | 已开启");
        }
        System.out.println("12、保存并退出");
        System.out.println("其他任意非功能按键，放弃保存并退出");

        if (flag)Dao.save();
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                System.out.println(Dao.showBookFromBooklist());
                break;
            case 2:
                System.out.println("请输入书籍ID：");
                String id = sc.next();
                if (!Dao.findBookView(id)) {
                    System.out.println("请依次输入： 小说名 | 作者 | 类型 | 阅读人数");
                    System.out.println(Dao.addBook(new Book(id, sc.next(), sc.next(), sc.next(), sc.nextInt())));
                }
                break;
            case 3:
                System.out.println(Dao.updateQ3());
                break;
            case 4:
                System.out.println("请输入要删除的书籍名称：");
                id = sc.next();
                if (Dao.findBookView(id)) {
                    System.out.println(Dao.deleteBook(id));
                } else {
                    System.out.println("不存在该书");
                }
                break;
            case 5:
                System.out.println("我吃番茄 所有书籍的平均阅读人数是: " + Dao.showQ5() + " 人");
                break;
            case 6:
                for (Map.Entry<String, List<String>> entry : Dao.showAuthorNameWithKindOfBook().entrySet()) {
                    System.out.println(entry.getKey() + " 类型的作者有：");
                    System.out.println(entry.getValue().toString());
                }
                break;
            case 7:
                System.out.println("阅读量最高的玄幻类型书是：");
                System.out.println(Dao.getMaxInXH());
                break;
            case 8:
                System.out.println("阅读量第二的书籍信息为：");
                System.out.println(Dao.showTow().toString());
                break;
            case 9:
                Map<String, List<Book>> slMap = Dao.showReaderAndType();
                for (Map.Entry<String, List<Book>> entry : slMap.entrySet()) {
                    System.out.println(entry.getKey() + " 类型的书有 " + entry.getValue().size() + " 本，详情如下：");
                    System.out.println(entry.getValue().toString());
                }
                break;
            case 10:
                System.out.println(Dao.bubbleSort());
                break;
            case 11:
                flag = !flag;
                break;
            case 12:
                System.out.println(Dao.save());
                System.exit(0);
                break;
            default:
                System.out.println("已退出");
                System.exit(0);
                break;
        }
    }
}
