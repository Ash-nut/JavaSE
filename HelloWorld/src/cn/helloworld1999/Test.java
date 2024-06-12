package cn.helloworld1999;
import java.util.Scanner;

public class Test {
	static int a = 1,b = 2,c = 3,d =4,e =5;
	static int arr[]= {a,b,c,d,e}; 
	public static void main(String[]args) {
//		Test.min();
//		Test.max();
//		Test.getNumMax();
		Test.getSeason();
	}
	public static void min() {
		System.out.println("min = " + (a > b? b:a));
	}
	public static void max() {
		int max = 0;
		for(byte i = 0;i != 5;i++) {
			max = max >=arr[i]?max:arr[i];
		}
		System.out.println("max = " + max);
	}
	public static void getNumMax() {
		int arrSc[] = {0,0,0,0,0};
		System.out.println("连续输入五个int类型数值：");
		for(byte i = 0;i != 5;i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("现在是输入的第 " + (i+1) +"个数值");
			arrSc[i] = sc.nextInt();
		}
		int max = 0;
		for(byte i = 0;i != 5;i++) {
			max = max >=arrSc[i]?max:arrSc[i];
		}
		System.out.println("max = " + max);
	}
	public static void getSeason() {
		int mon = 0;
		System.out.println("输入月份：");
		Scanner sc = new Scanner(System.in);
		mon = sc.nextInt();
		String season = (mon==12||mon==1||mon==2)?"春"
				:(mon==3||mon==4||mon==5)?"夏"
						:(mon==6||mon==7||mon==8)?"秋"
								:(mon==9||mon==10||mon==11)?"冬":"input inlegal";
		System.out.println(mon + " 月是 " + season + " 季");
	}
}
