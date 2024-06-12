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
		HomeWork.solution();
		HomeWork.solution1();
		HomeWork.solution2();
		HomeWork.solution3();
		HomeWork.solution4();
	}
	/**
	 * 众所周知的基本款
	 */
	static void solution() {
		int k = 0;
		k = i;
		i = j;
		j = k;
		System.out.println("方法一：" + "i = " + i +"; " + "j = " + j);
		resetNum();
	}
	/**
	 * 麻烦的方法
	 */
	static void solution1() {
		i = i + j; //i=13 j=3
		j = i - j; //i=13 j=10
		i = i - j; //i=3 j=10
		System.out.println("方法二：" + "i = " + i + "; " + "j = " + j);
		resetNum();
	}
	/**
	 * 麻烦的方法 +1
	 */
	static void solution2() {
		i = i * j; //i=30 j=3
		j = i / j; //i=30 j=10
		i = i / j; //i=3 j=10
		System.out.println("方法三：" + "i = " + i + "; " + "j = " + j);
		resetNum();
	}
	/**
	 * 这个纯粹是来搞笑的，hahaha；虽然我也不知道这么做有什么意义
	 */
	static void solution3() {
		int [] arr = {i,j};
		for(byte temp = 0; arr[0]!=j; temp++) {
			if(i == arr[temp]) {
				j = arr[temp];
				i = temp==1?arr[0]:arr[1];
			}
		}
		System.out.println("方法四：" + "i = " + i + "; " + "j = " + j);
		resetNum();
	}
	/**
	 * 这个也是来搞笑的
	 */
	static void solution4() {
		i = i == 10?3:10;
		j = j == 3?10:3;
		System.out.println("方法五：" + "i = " + i + "; " + "j = " + j);
		resetNum();
	}
	/**
	 * 这个值得一提，因为我最开始写完第一个方法再写第二个方法的时候发现忘重新赋值了
	 */
	static void resetNum() {
		i = 10;
		j = 3;
	}
}
