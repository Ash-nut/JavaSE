package cn.helloworld1999;
import java.util.function.*;
public class LambdaTest {
    int x = 0;
    public static void main(String[] args) {
        
        // MyInterface my = () -> System.out.println("随便试试");
        // my.Sout();
        // MyInterface myShow = ()->{System.out.println("第二个实现");};
        // myShow.Sout();
        // my.Sout();
        // MyInterface.test();
        
        // Function<String, Integer> f = str -> Integer.parseInt(str);
        // System.out.println(f.apply("23"));

        // BiFunction<String,Integer,String> b =  (str,i) -> str + i;
        // System.out.println(b.apply("s", 123)); 

        Predicate<LambdaTest> t = la -> la.x==0;
        System.out.println(t.test(new LambdaTest()));

        MyFunInterface<String,String,String,String[]> suStr = String[] :: 
    }
}
 