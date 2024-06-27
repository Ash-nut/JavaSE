import java.io.File;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("输入要删除的路径");
        Scanner sc = new Scanner(System.in);
        //System.out.println(delAllFiles(getAllFiles(sc.next())));


    }
    public static boolean delFile(String path) {
        File file = new File(path);
        return file.delete();
    }
    public static File[] getAllFiles(String path) {
        File file = new File(path);
        return file.listFiles();
    }
    public static boolean delAllFiles(File[] listFiles) {
        for (File file: listFiles){
            System.out.println(file);
        }
        for (File file: listFiles) {
            file.delete();
        }
        return listFiles[listFiles.length-1].delete();
    }
    /**
     * 思路，我觉得应该用深度优先的方法，用 temp 一直来拉 listFiles，一直去拿listFiles的第一个元素，层层深入
     * 直到这个最深层没有元素为止，然后我重新给 temp 赋值为 初始的第一次 即 listFiles
     * 直到 listFiles.length == 0 ;
     *
     * 嗯，思路是对的，但是代码写错了；直接去看群里的正确答案吧
     */
    public static void getFileDspDel(String path) {
        File file = new File(path);
        boolean flag = false;
        File tempPath = file;
        while (file.listFiles() != null) {
            while (flag){
                System.out.println("working");
            if (tempPath.listFiles().length == 0) {
                flag = false;
            }else{
                tempPath = tempPath.listFiles()[0];
                tempPath.delete();
                flag = true;
            }
            tempPath = file;
            }
        }
    }
}
