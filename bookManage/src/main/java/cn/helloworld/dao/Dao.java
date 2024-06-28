package cn.helloworld.dao;

import cn.helloworld.bean.Book;
import cn.helloworld.database.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dao {
    /**
     * 检索是否 ID 重复
     *
     * @param bookId 传入ID
     * @return 结果，存在 true 反之 false
     */
    public static boolean findBookView(String bookId) {
        return Database.getBookList().stream().anyMatch(book -> book.getBookNum().equals(bookId));
    }

    /**
     * 第一问 查询所有书籍信息
     */
    public static List<Book> showBookFromBooklist() {
        return Database.getBookList().stream().toList();
    }

    /**
     * 第二问
     *
     * @param book 添加对象
     * @return 打印提示
     */
    public static String addBook(Book book) {
        Database.getBookList().add(book);
        return "添加成功";
    }

    /**
     * 第三问
     *
     * @return 打印提示
     */
    public static String updateQ3() {
        Database.getBookList().stream().filter(book -> book.getAuthorName().equals("我吃番茄"))
                .forEach(book -> book.setKindOfBook("东方玄幻"));
        return "修改成功";
    }

    public static String deleteBook(String bookId) {
        Database.getBookList().removeIf(book -> book.getBookNum().equals(bookId));
        return "删除成功";
    }

    /**
     * 第五问
     * 虽然我也觉得平均读者人数是个 double 很奇怪，但就那么办吧
     *
     * @return 读者人数
     */
    public static Double showQ5() {
        return Database.getBookList().stream().filter(book -> book.getAuthorName().equals("我吃番茄")).collect(Collectors.averagingInt(Book::getReader));
    }

    /**
     * 第六问
     *
     * @return Map 书目种类，List 该种类的作者
     */
    public static Map<String, List<String>> showAuthorNameWithKindOfBook() {
        List<String> bookType = Database.getBookList().stream().map(d -> d.getKindOfBook()).distinct().toList();
        Map<String, List<String>> baMap = new HashMap<>();
        for (String str : bookType) {
            baMap.put(str, Database.getBookList().stream().filter(d -> d.getKindOfBook().equals(str)).
                    map(d -> d.getAuthorName()).distinct().toList());
        }
        return baMap;
    }

    /**
     * 第七问
     *
     * @return Book对象
     */
    public static Book getMaxInXH() {
        return Database.getBookList().stream().filter(d -> d.getKindOfBook().equals("玄幻")).
                sorted((s1, s2) -> s2.getReader() - s1.getReader()).toList().get(0);
    }

    /**
     * 第8问
     *
     * @return Book对象
     */
    public static Book showTow() {
        return Database.getBookList().stream().sorted((s1, s2) -> s2.getReader() - s1.getReader()).toList().get(1);
    }

    /**
     * 第9问
     *
     * @return 返回时的是一个Map 类型， List 类型书
     */
    public static Map<String, List<Book>> showReaderAndType() {
        Map<String, List<Book>> sraMap = Database.getBookList().stream()
                .collect(Collectors.groupingBy(Book::getKindOfBook));
        return sraMap;
    }

    /**
     * 第10问
     * 这里有个非常重要的事情！ 用 stream 得到的 List 是不让操作的
     * @return  返回的是拍好的 Book 列表
     */
    public static List<Book> bubbleSort() {
        List<Book> wc = Database.getBookList().stream().filter(b -> b.getAuthorName().equals("我吃番茄")).toList();
        List<Book> wcBooks= new ArrayList<>(wc);
        Book temp;
        for (int i = 0; i < wcBooks.size(); i++) {
            for (int j = 0; j < wcBooks.size()-1 - i; j++) {
                temp = wcBooks.get(j);
                if (wcBooks.get(j).getReader() < wcBooks.get(j + 1).getReader()) {
                    wcBooks.set(j, wcBooks.get(j + 1));
                    wcBooks.set(j + 1, temp);
                }
            }
        }
        return wcBooks;
    }
    public static String save() throws IOException {
        Database.saveDataInDatabase(Database.BASE_PATH);
        //Database.loadDataFormDatabase(Database.BASE_PATH);
        return "保存成功";
    }
}
