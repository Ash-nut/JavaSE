package cn.helloworld1999.W2HomeWork;

public class Person {
    private String name;
    private int age;
    public Person(){

    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    public void display(){
        System.out.println(this.toString());
    }
}
