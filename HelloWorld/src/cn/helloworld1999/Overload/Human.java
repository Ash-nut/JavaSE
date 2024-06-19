package cn.helloworld1999.Overload;

public class Human{
    String name;
    String gender;
    int age;

    public void eat(){
        System.out.println(name + "吃");
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", gender=" + gender + ", age=" + age + "]";
    }
}