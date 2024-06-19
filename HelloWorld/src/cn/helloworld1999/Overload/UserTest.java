package cn.helloworld1999.Overload;

public class UserTest {
    public static void main(String[] args) {
        Student s1 = new Student("嘻嘻", "沃尔玛购物袋", 100);
        System.out.println(s1.toString());
        s1.eat();
    }
}
