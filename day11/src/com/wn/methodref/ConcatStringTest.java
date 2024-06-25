package com.wn.methodref;

import java.util.function.Function;

/**
 * 拼接字符串
 */
public class ConcatStringTest {
	public static void main(String[] args) {
		
		String str = "aa";//str.concat("bb") 拼接字符串方法
		
		//对象方法的引用
		new Function<String, String>() {
			@Override
			public String apply(String s) {
				return str.concat(s);
			}
		};
		
		//对象方法的引用
		Function<String, String> f = str :: concat;
		System.out.println(f.apply("bb"));
	}
}
