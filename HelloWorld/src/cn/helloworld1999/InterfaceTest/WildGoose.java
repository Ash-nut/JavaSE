package cn.helloworld1999.InterfaceTest;

public class WildGoose extends Bird implements FlyingAnimalInterface{

    @Override
    public void fly() {

        throw new UnsupportedOperationException("Unimplemented method 'fly'");
    }

    @Override
    public void rawEgg() {

        throw new UnsupportedOperationException("Unimplemented method 'rawEgg'");
    }
    
}
