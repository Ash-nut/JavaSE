package com.wn.methodref;

import java.util.function.Function;

/**
 * 静态方法的引用
 */
public class StaticMethodRefTest {
	public static void main(String[] args) {
		
		//1.把一个字符串转换成int类型
		Function<String, Integer> f1 = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		System.out.println(f1.apply("23"));
		
		//2.使用lambda对匿名内部类简写
		Function<String, Integer> f2 = str -> Integer.parseInt(str);
		System.out.println(f2.apply("12"));
		
		//3.静态的方法引用
		Function<String, Integer> f3 = Integer :: parseInt;
		System.out.println(f3.apply("35"));
		
	}
}
