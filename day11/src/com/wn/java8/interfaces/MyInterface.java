package com.wn.java8.interfaces;
/**
 * 定义默认方法
 */
@FunctionalInterface  //检查当前接口是否为函数式接口
public interface MyInterface {
	/**
	 * 定义static修饰的方法
	 * 	调用：  接口名.方法名()
	 */
	static void run() {
		System.out.println(" myInterface  run() -----");
	}
	/**
	 * 自定义default修饰方法,在接口可以定义多个
	 *	必须声明方法体
	 *	接口中默认方法接口不能直接使用，而是给其实现类使用
	 */
	default void showInfo() {
		System.out.println(" ----- show Info  ------");
	}
	
	default int showinfo(int i) {
		return i;
	}
	
	void fly(); //抽象方法
}
