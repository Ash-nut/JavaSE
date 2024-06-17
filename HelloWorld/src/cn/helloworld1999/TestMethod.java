package cn.helloworld1999;
import java.util.Scanner;
import java.util.Arrays;

public class TestMethod {
    public static void main(String[] args) {
        // int[] i = {0,1,2,3,4,5,6,7,8,9};
        // System.out.println(Arrays.toString(method4_1(i, 1, 10)));
        method7(7);
    }

    public static int method1(int[] temp){
        int sum = 0;
        for(int i:temp){
            sum +=i;
        }
        return sum;
    }
    public static double method1_1(int[] temp){
        double sum = 0;
        for(int i:temp){
            sum +=i;
        }
        return sum;
    }
    public static int method2(int[] temp){
        int max = temp[0];
        for(int i:temp){
            max = max>=i?max:i;
        }
        return 0;
    }
    public static String[] method3(String tempString){
        String[] str = new String[0];
        Scanner sc = new Scanner(System.in);
        System.out.println("是否进行输入？");
        System.out.println("1.输入");
        System.out.println("任意键结束");
        byte key = sc.nextByte();
        switch (key) {
            case 1:
                if (str.length == 0) {
                    str = Arrays.copyOf(str,str.length+1);
                    String strInput = sc.next();
                    str[str.length-1] = strInput;
                }
                break;
            default:
            System.out.println("输入有误");
                break;
        }
        return str;
    }
    /**
     * 不太对吧？？？如果这样好使的话，那为啥还要那么多基本类型的函数重载呢？？？
     * 确实不对，传基本类型会报错
     * 这个【Object】东西是所有类的爹，but，他不是基本类型的爹
     * @param tempInput
     * @param tempStart
     * @param tempEnd
     * @return
     */
    public static Object method4(Object[] tempInput,int tempStart,int tempEnd){
        Object [] obTemp = new Object[tempEnd-tempStart];
        for(int i = 0;i<tempEnd-tempStart;i++){
            obTemp[i] = tempInput[tempStart+i];
        }
        return obTemp;
    }
    public static int[] method4_1(int[] tempInput,int tempStart,int tempEnd){
        int[] obTemp = new int[tempEnd-tempStart];
        for(int i = 0;i<tempEnd-tempStart;i++){
            obTemp[i] = tempInput[tempStart+i];
        }
        return obTemp;
    }
    public static String method5(int[] temp){
        String str = "";
        for(int i:temp){
            str += Integer.toString(i);
        }
        return str;
    }
    public static int method6(String[]strArray,String str){
        int index = -1;
        for(int i = 0;i<strArray.length;i++){
            if (str.equals(strArray[i])) return index = i;
        }
        return index;
    }
    public static void method7(int temp){
        for(int i =1;i<=temp;i++)
        {
            if (temp%i==0&&i!=1&&i!=temp) {
                System.out.println( temp + " 不是质数");
                return;
            }
        }
        System.out.println(temp + " 是质数");
        return;
    }
}
