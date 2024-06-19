package cn.helloworld1999.W2HomeWork;

public class DoubleMethod {

    public DoubleMethod(){

    }

    public void methodOne(){
        this.methodTwo();
        methodTwo();
    }

    public void methodTwo(){
        System.out.println("有啥区别么？");
    }
    public static void main(String[] args) {
        new DoubleMethod().methodOne();
    }
}
