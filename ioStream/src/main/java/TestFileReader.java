import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 结论，这个结果非常神奇，在面对单行大文件时（百万元素及以上）FileReader远高于BufferedReader的速度，
 * 即使两者在极限情况（文件元素四千万，缓冲区大小四千万，FileReader还是更快）
 *
 * 造成这种反直觉结果的原因或许受多种因素影响
 */
public class TestFileReader {
    public static void main(String[] args) throws IOException {
        List<Long> lSR = new ArrayList<>();
        List<Long> hSR = new ArrayList<>();
        for (int i = 0; i < filePath.length; i++) {
            lSR.add(lowSpeedRead(filePath[i]));
        }
        System.out.println("-------------------分割线");
        for (int i = 0; i < filePath.length; i++) {
            hSR.add(highSpeedRead(filePath[i]));
        }
    }

    public static long lowSpeedRead(String filePath) throws IOException {
        FileReader fR = new FileReader(filePath);
        FileWriter fW = new FileWriter(filePath.split("\\.")[0]+"l.txt");

        char[] buf = new char[1024]; // 增加缓冲区大小
        int len;

        long startTime = System.nanoTime(); // 移动计时开始位置

        while ((len = fR.read(buf)) != -1) { // 修正读取逻辑
            fW.write(buf, 0, len);
        }


        fW.close();
        fR.close();
        long endTime = System.nanoTime(); // 移动计时结束位置
        //System.out.println("FileRead耗时 " + (endTime - startTime) + " 纳秒,即千分之" + (endTime - startTime) / 100000 + " 毫秒");
        System.out.println(endTime-startTime);
        return endTime-startTime;
    }

    public static long highSpeedRead(String filePath) throws IOException {
        BufferedReader bR = new BufferedReader(new FileReader(filePath));
        BufferedWriter bW = new BufferedWriter(new FileWriter(filePath.split("\\.")[0]+"h.txt"));

        String str;

        long startTime = System.nanoTime(); // 移动计时开始位置

        while ((str = bR.readLine()) != null) { // 修正读取逻辑
            bW.write(str);
        }


        bW.close();
        bR.close();
        long endTime = System.nanoTime(); // 移动计时结束位置
        //System.out.println("bufferRead 耗时 " + (endTime - startTime) + " 纳秒,即千分之" + (endTime - startTime) / 100000 + " 毫秒");
        System.out.println(endTime-startTime);
        return endTime-startTime;
    }

    public static String[] filePath = {
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\1.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\10.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\100.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\1000.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\10000.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\100000.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\1000000.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\10000000.txt",
            "D:\\DevelopData\\JavaSE\\JavaSE\\ioStream\\src\\main\\java\\40000000.txt"
    };

}
