package cn.helloworld1999.Overload;

public class Student extends Human {

    public Student(){

    }
    public Student(String name,String gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    @Override
    public void eat(){

    }
}