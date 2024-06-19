package cn.helloworld1999.W2HomeWork;

/**
 * Dog
 */
public class Dog {

    public Dog(){

    }
    public String bark(String str){
        System.out.println(str);
        return str;
    }
    public void bark(){
        System.out.println("无事发生");
    }
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.bark();
        d1.bark("有狗在叫");
    }
}