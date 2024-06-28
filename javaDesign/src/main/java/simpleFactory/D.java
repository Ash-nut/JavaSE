package simpleFactory;

public class D extends Animal {
    public D() {}

    public void only(){
        System.out.println("子类特有的方法");
    }
    @Override
    String eat() {
        return "";
    }

    @Override
    String walk() {
        return "";
    }
}
