package cn.helloworld1999.W2HomeWork;

public class TwoConstructor {
    public TwoConstructor( TwoConstructor temp){
        new TwoConstructor();
        System.out.println("有参构造器 ");
    }
    public TwoConstructor(){
        System.out.println("无参构造器");
    }
    public static void main(String[] args) {
        new TwoConstructor(new TwoConstructor());
    }
}
