package cn.helloworld1999;
import java.util.function.Supplier;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


// Supplier 的方法是 get() //供应商 //无输入，有输出
// Function 的方法是 Apply()    //就是函数，有输入 有输出
// Consumer 的方法是 Accept()  //消费者 有输入，无输出
// Predicate 的方法是 Apply()   //有输入，固定输出类型 boolean



public class MethodLambda {
    public static void main(String[] args) {
        User user = new User("哈哈", "12345");
        Supplier<String> u1 = user::getUserID;
        System.out.println(u1.get());

        String str1 = "Nothing";
        String str2 = "~";

        Function<String,String> f1 = str1 :: concat;
        System.out.println(f1.apply(str2));
        
        BiFunction<String,String,User> u21 = (userName,userID) -> new User();
        BiFunction<String,String,User> u22 = User :: new;

        /**
         * 重中之重，先弄清楚你要用的方法是不是 static
         */
        Function<String,String> str34 = String :: toUpperCase;
        System.out.println(str34.apply("hahahahahaha"));


    }
}
