package com.wn.java8.interfaces;

import java.util.function.Supplier;

public class TestMyInterface {
	public static void main(String[] args) {
		
//		MyInterfaceImpl impl = new MyInterfaceImpl();
//		impl.showInfo();
//		MyInterface.run();
		
		//通过匿名内部类实现
		MyInterface mi = new MyInterface() {
			@Override
			public void fly() {
				System.out.println("---- shouinfo ----");
			}
		};
//		mi.fly();
		//使用lambda表达式优化
		
		MyInterface mi2 = () -> {System.out.println("---- shouinfo2 ----");};
		mi2.fly();
		
		//对方法体进行优化
		MyInterface mi3 = () -> System.out.println("---- shouinfo3 ----");
		mi3.fly();
	}
}
