package com.wn.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestBiFunction {
	public static void main(String[] args) {
		
		//1.把String类型和Integer类型的参数拼接，返回String类型
		//使用BiFunction接口实现
		BiFunction<String, Integer, String> bf1 = new BiFunction<String, Integer, String>() {
			@Override
			public String apply(String s, Integer i) {
				return s + i;
			}
		};
		//调用方法
//		System.out.println(bf1.apply("a = ", 23));
		
		//2，使用lambda表达式优化
		BiFunction<String, Integer, String> bf2 = (str, num) -> str + num;
		System.out.println(bf2.apply("b = ", 88));
	}
}
