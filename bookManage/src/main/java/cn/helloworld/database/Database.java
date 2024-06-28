package cn.helloworld.database;

import cn.helloworld.bean.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static final File BASE_PATH = new File(
            "D:\\DevelopData\\JavaSE\\JavaSE\\bookManage\\src\\main\\java\\cn\\helloworld\\database\\database.bookBase.txt");

    static private List<Book> bookList = new ArrayList<Book>();

    public static List<Book> getBookList() {
        return bookList;
    }
    private Database(){}

    public static void setBookList(List<Book> bookList) {
        Database.bookList = bookList;
    }

    static {
        try {
            Database.bookList = loadDataFormDatabase(BASE_PATH);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            saveDataInDatabase(BASE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 这个动作是把初始化数据转为 bookList
     * @return bookList
     */
    public static List<Book> resetDatabase() {
        String[] books = {"xs2023001-盘龙-我吃番茄-玄幻-1600",
                "xs2023002-雪鹰领主-我吃番茄-玄幻-1800",
                "xs2023003-莽荒纪-我吃番茄-玄幻-3231",
                "xs2023004-沧元图-我吃番茄-玄幻-1002",
                "xs2023005-大主宰-烂土豆-玄幻-1314",
                "xs2023006-元尊-烂土豆-科幻-520",
                "xs2023007-Java开发哪些事-杨大神-都市-9999"};
        for (String bookStr : books) {
            String[] bookInf = bookStr.split("-");
            bookList.add(new Book(bookInf[0], bookInf[1], bookInf[2], bookInf[3], Integer.parseInt(bookInf[4])));
        }
        return bookList;
    }

    /**
     * 硬盘到内存
     * @param BASE_PATH file 持久化存储的文件
     * @return 返回的是给 Dao 的 List<Book>
     * @throws IOException 没什么影响的，如果真的出异常了就直接初始化 持久化文件
     */
//    public static List<Book> loadDataFormDatabase(File BASE_PATH) throws IOException {
//        ObjectInputStream ois = null;
//        //读出硬盘内容，转为内存中的 bookList
//        try {
//            ois = new ObjectInputStream(new FileInputStream(BASE_PATH));
//            bookList = (List<Book>) ois.readObject();
//            System.out.println("读取成功");
//            return bookList;
//        }
//        //没读成功，可能是各种各样的问题，但是我的处理方式是从固定的初始数据转换到对象列表，并且创建包含初始数据的文件
//         catch (Exception e) {
//            System.out.println("读取失败，自动初始化");
//            resetDatabase();    //初始化
//            saveDataInDatabase(BASE_PATH);   //写入
//            return bookList;    //返回
//        } finally {
//            if (ois != null) {
//                ois.close();
//            }
//        }
//    }

    //TODO 回头问一下 为啥上面的不对
    public static List<Book> loadDataFormDatabase(File BASE_PATH) throws IOException {
        if (!BASE_PATH.exists()) {
            //System.out.println("调试信息1：数据库文件不存在，自动初始化");
            return resetDatabase(); // 初始化并返回新的 bookList
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BASE_PATH))) {
            bookList = (List<Book>) ois.readObject();
            //System.out.println("调试信息2：读取成功");
            return bookList;
        } catch (Exception e) {
            //System.out.println("调试信息3：读取失败：" + e.getMessage());
            throw new IOException("调试信息4：无法从数据库文件中读取数据", e);
        }
    }


    /**
     * 内存到硬盘
     * @param BASE_PATH File 持久化存储的文件
     * @throws IOException 希望不要出现这种异常，按理来说也不会出现
     */
    public static void saveDataInDatabase(File BASE_PATH) throws IOException {
        ObjectOutputStream oos = null;
        //尝试写入
        try {
            oos = new ObjectOutputStream(new FileOutputStream(BASE_PATH));
                oos.writeObject(bookList);
        }catch (Exception e){
        }
        finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
