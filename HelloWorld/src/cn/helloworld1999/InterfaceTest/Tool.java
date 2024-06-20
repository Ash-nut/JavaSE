package cn.helloworld1999.InterfaceTest;

public class Tool  {
    public static Insect getNewInsect(String str){
        if (str.equals("Bee")) {
            return new Bee();
        }
        if (str.equals("Ant")) {
            return new Ant();
        }
    return null;
    }
}
