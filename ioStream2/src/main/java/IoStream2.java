import java.io.*;

public class IoStream2 {
    public static void test1() {
        FileReader fR = null;
        FileWriter fW = null;
        try{
            fR = new FileReader("D:\\DevelopData\\JavaSE\\JavaSE\\ioStream2\\src\\main\\java\\测试.txt");
            fW = new FileWriter("D:\\DevelopData\\JavaSE\\JavaSE\\ioStream2\\src\\main\\java\\测试1.txt");
            int c;
            while ((c = fR.read()) != -1){
                fW.write(c);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fW != null){
                    fW.close();
                }
                if(fR != null){
                    fR.close();
                }
            }catch(IOException e){}
        }
    }

    public static void test2() throws IOException {
        FileInputStream fIS = null;
        FileOutputStream fOS = null;
        fIS = new FileInputStream("D:\\DevelopData\\JavaSE\\JavaSE\\ioStream2\\src\\main\\java\\Default.jpg");
        fOS = new FileOutputStream("D:\\DevelopData\\JavaSE\\JavaSE\\ioStream2\\src\\main\\java\\Default1.jpg");
        byte[] bs = new byte[1024];
        while (fIS.read(bs)!=-1){
            fOS.write(bs);
        }
        fOS.close();
        fIS.close();
    }

    public static void main(String[] args) throws IOException {
        test2();
    }
}
