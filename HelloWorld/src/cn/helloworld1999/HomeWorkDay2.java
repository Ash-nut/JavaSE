package cn.helloworld1999;

import java.util.Scanner;

public class HomeWorkDay2 {
	public static void main(String[] args) {
		
	}
	static void guiShow(byte i) {
		switch(i) {
		case 0:
			System.out.println("**************************");
			System.out.println("*                        *");
			System.out.println("*   1.登 录                *");
			System.out.println("*                        *");
			System.out.println("*   2.退 出                *");
			System.out.println("*                        *");
			System.out.println("**************************");
			break;
		case 1:
			System.out.println("**************************");
			System.out.println("*                        *");
			System.out.println("*   1.存 钱                *");
			System.out.println("*                        *");
			System.out.println("*   2.取 钱                *");
			System.out.println("*                        *");
			System.out.println("*   3.退 出                *");
			System.out.println("*                        *");
			System.out.println("**************************");
			break;
			default:
				System.out.println(" 4 0 4 ！！！");
		}
	}
	static void guiInput() {
		Scanner sc = new Scanner(System.in);
	}
}
