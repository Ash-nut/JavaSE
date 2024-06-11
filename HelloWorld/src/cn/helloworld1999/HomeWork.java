package cn.helloworld1999;
/**
 * @author XinruiYi
 * @see 互换两整型的值，i = 10,j = 3;输出：i = 3,j = 10;
 * 这种固定值数值的运算好像是会被编译器进行计算优化的？
 * 好像是直接把答案写到字节码文件中的？
 */
public class HomeWork {
	static int i = 10,j = 3;
	public static void main(String[] args) {
		//启动
		HomeWork.solution();
		HomeWork.solution1();
		HomeWork.solution2();
	}
	static void solution() {
		int k = 0;
		k = i;
		i = j;
		j = k;
		System.out.println("方法一：" + "i = " + i +"; " + "j = " + j);
		resetNum();
	}
	static void solution1() {
		i = i + j; //i=13 j=3
		j = i - j; //i=13 j=10
		i = i - j; //i=3 j=10
		System.out.println("方法二：" + "i = " + i + "; " + "j = " + j);
		resetNum();
	}
	static void solution2() {
		i = i * j; //i=30 j=3
		j = i / j; //i=30 j=10
		i = i / j; //i=3 j=10
		System.out.println("方法三：" + "i = " + i + "; " + "j = " + j);
		resetNum();
	}
	static void resetNum() {
		i = 10;
		j = 3;
	}
}
