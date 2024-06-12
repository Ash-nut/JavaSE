package cn.helloworld1999;

import java.util.Scanner;

public class Exercises {
	public static void main(String[] args) {	
		Exercises.exercise4();
	}
	static public void exercise1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入任意整数，判断奇偶数：");
		int temp = sc.nextInt();
		System.out.println(temp%2==1?"no":"yes");
	}
	static public void exercise2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入任意整数，判断奇偶数：");
		int temp = sc.nextInt();
		System.out.println(temp%(7*5)!=0?"no":"yes");
	}
	//不知道怎么get每个月的天数，不做了
	static public void exercise3() {
	}
	static public void exercise4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入任意整数，判断能否被3、5、7整除：");
		int temp = sc.nextInt();
		System.out.println(temp%(3*5*7) == 0?"能同时被3,5,7整除。"
				:temp%(3*5) == 0?"能被3、5整除"
						:temp%(3*7) == 0?"能被3、7整除"
								:temp%(5*7) == 0?"能被5、7整除"
									:temp%3 == 0?"只能被5、7整除"
										:temp%5 == 0?"只能被5整除"
											:temp%7 == 0?"只能被7整除"
												:"不能被3,5,7任一个整除。");
	}
	/**
	 *  没有第五题
	 */
	//没意思，不做了
	static public void exercise6() {
	}
	
	/**
	 * 题目有问题吧
	 */
	static public void exercise7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入工资，求税：");
		double taxBase = sc.nextDouble();
		double taxBaracketZero = taxBase - 2500;
		double taxBaracketOne = (taxBase - 5000)*0.03;
		double taxBaracketTwo = (taxBase - 8000)*0.05;
		double taxBaracketThree = (taxBase - 20000)*0.1;
		double taxBaracketFour = (taxBase - 20000)*0.1;
		
		
		System.out.println(taxBase%2==1?"no":"yes");
	}
	
}
