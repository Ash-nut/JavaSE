package com.wn.lambda;

import java.util.function.Supplier;

public class TestSupplier {
	public static void main(String[] args) {
		
		//1.用匿名内部类实现
		Supplier<String> sup1 = new Supplier<String>() {
			//重写方法
			@Override
			public String get() {
				return "aaa";
			}
		};
		//调用方法
//		System.out.println(sup1.get());
		
		//1.用户lambda优化
		Supplier<String> sup2 = () -> "bbb";
		System.out.println(sup2.get());
	}
}
