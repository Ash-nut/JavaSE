package com.wn.methodref;

import java.util.function.BiFunction;

/**
 * 演示实例方法的引用
 */
public class InstanceMethodRefTest {
	public static void main(String[] args) {
		
		//拼接字符串
		//匿名内部类实现
		BiFunction<String,String, String> bf = new BiFunction<String,String, String>() {
			@Override
			public String apply(String s1, String s2) {
				return s1.concat(s2);
			}
		};
		System.out.println(bf.apply("a", "b"));
		
		//lambda表达式
		BiFunction<String,String, String> bf2 = (str1,str2) -> str1.concat(str2);
		System.out.println(bf2.apply("c", "d"));
		
		//实例方法 引用
		BiFunction<String,String, String> bf3 = String :: concat;
		System.out.println(bf2.apply("e", "f"));
	}
}
