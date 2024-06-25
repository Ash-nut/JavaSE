package com.wn.lambda;

import java.util.function.Function;

public class TestFunction {
	public static void main(String[] args) {
		
//		使用Function接口实现把字符串转换成int类型
		//1.匿名内部类实现
		Function<String,Integer> f1 = new Function<String,Integer>() {
			@Override
			public Integer apply(String str) {
				return Integer.parseInt(str);
			}
		};
		//调用方法
//		Integer i = f1.apply("12");
//		System.out.println(i);
		
		//2.使用lambda简化
		Function<String,Integer> f2 = str -> Integer.parseInt(str);
		System.out.println(f2.apply("23"));
	}
}
