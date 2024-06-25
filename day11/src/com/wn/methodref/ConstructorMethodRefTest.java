package com.wn.methodref;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 构造方法的引用
 */
public class ConstructorMethodRefTest {
	
	public static void main(String[] args) {
		//创建User类对象
		//供给型接口
		Supplier<User> sup1 = new Supplier<User>() {
			@Override
			public User get() {
				return new User();
			}
		};
//		System.out.println(sup1.get());
		
		//lambda简写
		Supplier<User> sup2 = () -> new User();
//		System.out.println(sup2.get());
		
		//构造方法的简写
		Supplier<User> sup3 = User :: new;
//		System.out.println(sup3.get());
		
		BiFunction<String, Integer,User> bf1 = new BiFunction<String, Integer,User>() {
			@Override
			public User apply(String t, Integer u) {
				return new User(t,u);
			}
		};
		System.out.println(bf1.apply("菲菲", 23));
		
		//lambda表达式
		BiFunction<String, Integer,User> bf2 =(uname,age) -> new User(uname,age);
		System.out.println(bf2.apply("莎莎", 24));
		
		//构造方法的引用
		BiFunction<String, Integer,User> bf3 = User :: new;
		System.out.println(bf3.apply("冰冰", 25));
	}
}
