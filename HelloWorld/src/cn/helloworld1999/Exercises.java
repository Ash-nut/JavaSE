package cn.helloworld1999;
/**
 * 1.输入一个整数，判断这个数是否为偶数，如果是则输出yes，否则输出no。

2.编程判断输入的正整数是否既是5又是7的整倍数。若是，则输出yes，否则，输出no。

3.输入2023年的某一个月，输出这个月份的天数。

4.编程实现：输入一个整数，判断它能否被3,5,7整除，并输出一下信息之一？
(1).能同时被3,5,7整除。
(2).能被其中两个数整除(要指出那两个数)？
(3).能被其中一个数整除(要指出哪一个)？
(4).不能被3,5,7任一个整除。
	
6.手动输入一个成绩，打印输出对应的等级。90 - 100 打印A ，80 - 89 打印B，。。。。。0 - 59 打印E

7.手动输入你的工资，打印输出你要缴纳的税，小于等于2500不交税，小于等于5000元交3%，
       小于等于8000交5%的税，小于等于20000交10%的税，20000交20%的税。 

8.手动输入一个三位数的整数，判断这个数是否为水仙花数。
	各位数的3次方之和等于当前数字的本身153 == 111 + 555 + 333 

9.手动输入一个四位数的数，判断这个数是否为四叶玫瑰数。

10.猜拳游戏
	数字1.拳头,2.布,3.剪刀
	手动输入一个1 - 3的数，系统随机一个1 - 3的数字。输出用户的输赢结果。
	(在结果中必须输出用户和系统分别出的是石头、剪刀或者布。)
11.猜数字游戏
	系统随机产生一个1 - 100的数字，用户输入一个1 - 100的数字。
	如果用户和系统随机的数字相等，则输出用户闯关成功！
	如果用户的数字大于系统随机的数字，则输出你输入的数字过大，
	如果用户的数字小于系统随机的数字，则输出你输入的数字过小。
 */
import java.util.Scanner;

public class Exercises {
	public static void main(String[] args) {	
		Exercises.exercise12();
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
		System.out.println(
				temp%(3*5*7) == 0?"能同时被3,5,7整除。"
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
	 * 题目有问题吧?
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
	
	static public void exercise8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入三位整数：");
		int temp = sc.nextInt();
		int hu = temp  / 100;
		int th = (temp - (100 * hu))/10;
		int ge = (temp - (100 * hu) - (10 * th));
		System.out.println(temp < 100?"输入不合法":(temp == (hu*hu*hu) + (th*th*th) + (ge*ge*ge))?"yes":"no");
	}
	
	static public void exercise9() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入四位整数：");
		int temp = sc.nextInt();
		int so = temp / 1000;
		int hu = (temp - 1000 * so) / 100;
		int th = (temp - (1000 * so) - (100 * hu))/10;
		int ge = (temp - (1000 * so) - (100 * hu) - (10 * th));
		System.out.println(temp < 1000?"输入不合法":(temp == (so * so * so) + (hu*hu*hu) + (th*th*th) + (ge*ge*ge))?"yes":"no");
	}
	
	/**
	 * 这道题写的麻烦，上课教的更好，毕竟是用了 || 和 && ，确实这样更简单
	 */
	static public void exercise10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入1-3整数(1 == 石头， 2 == 剪刀， 3 == 布)：");
		int temp = sc.nextInt();
		int ran = (int)(Math.random() * 3 + 1);
		System.out.println(ran);
		// 使 1 == 石头， 2 == 剪刀， 3 == 布。
		System.out.println("系统输出：" + (ran == 1?"石头":ran == 2?"剪刀":"布"));
		System.out.println("你输出：" + (temp == 1?"石头":temp == 2?"剪刀":"布"));
		switch(temp * ran) {
			case 2:
				System.out.println("winer:" + (ran == 1?"玩家":"系统"));
				break;
			case 3:
				System.out.println("winer:" + (ran == 1?"玩家":"系统"));
				break;
			case 6:
				System.out.println("winer:" + (ran == 3?"玩家":"系统"));
				break;
			default:
				System.out.println("平局");
		}
	}
	static public void exercise11() {
		int sum = 0;
		for(int i = 1;i < 100;i +=2) {
			sum += i;
		}
		System.out.println("sum = " + sum);
	}
	static public void exercise12() {
		int i= 0;
			for(;i<100;i++) {
				System.out.print(i%3 == 0?i:" ");
				if(i%3 == 0) {
					System.out.println();
				}
		}
	}
}
