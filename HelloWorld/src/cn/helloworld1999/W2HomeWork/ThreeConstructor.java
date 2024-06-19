package cn.helloworld1999.W2HomeWork;

/**
 * ThreeConstructo
 */
public class ThreeConstructor {

    public ThreeConstructor(int a,int b){
        System.out.print("两int中较大的为:");
        System.out.println(Math.max(a, b));
    }
    public ThreeConstructor(double a,double b,double c){
        System.out.print("三double的乘积为:");
        System.out.println(a*b*c);
    }
    public ThreeConstructor(String strA,String strB){
        System.out.print("两String对比结果为:");
        System.out.println(strA.equals(strB));
    }

    public static void main(String[] args) {
        new ThreeConstructor(10,20);
        new ThreeConstructor(9, 9, 6);
        new ThreeConstructor("No amount of coffee", "No amount of crying");
    }
}