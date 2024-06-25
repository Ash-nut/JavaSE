package com.wn.methodref;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 对象方法的引用
 *
 */
public class ObjectMethodRefTest {
	
	public static void main(String[] args) {
		
		//把指定参数输出在控制台
		
		Consumer<String> c1  = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		c1.accept("aaa");
		
		//2.使用lambda优化
		Consumer<String> c2  = str -> System.out.println(str);
		c2.accept("ccc");
		
		//3.对象方法的引用
		PrintStream ps = System.out;
		Consumer<String> c3  = ps :: println;
		c3.accept("ddd");
		
		
		//实例化用户对象
		User user = new User("wn1200", "王珊珊", 23);
		
		//供给型接口
		Supplier<String> s1 = new Supplier<String>() {
			@Override
			public String get() {
				return user.getUname();
			}
		};
		System.out.println(s1.get());
		
		//对象方法的引用
		Supplier<String> s2 = user :: getUname;
		System.out.println(s2.get());
	}
	
	
}
