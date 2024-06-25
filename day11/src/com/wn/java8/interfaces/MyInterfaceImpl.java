package com.wn.java8.interfaces;

public class MyInterfaceImpl implements MyInterface{

	@Override
	public void fly() {
		System.out.println("---- fly --- ");
	}
	
	
	@Override
	public void showInfo() {
		System.out.println("----重写父接口中default方法 ---- ");
	}
	
}
