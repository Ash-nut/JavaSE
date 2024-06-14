package com.wn.demo;

import java.util.Arrays;

public class Demo01 {
	// 随机一注双色球
	public static void main(String[] args) {
		// 1.定义int类型动态数组，长度为7
		int[] ball = new int[7];

		// 2.随机一个蓝球
		int blue = (int) (Math.random() * 16 + 1);
		// 放进数组的最后一个位置
		ball[ball.length - 1] = blue;

		// 3.通过循环随机6个红球
		for (int i = 0; i < ball.length - 1;) {
			// 随机一个红球
			int red = (int) (Math.random() * 33 + 1);
			// 默认当前red在数组中不存在
			boolean flag = false;
			// 循环判断当前red是否在数组中已出现
			for (int j = 0; j < i; j++) {
				if (ball[j] == red) {
					flag = true;// 已存在
					break;
				}
			}
			if (!flag) { // 表示red在数组中不存在，把red保存到数组的对应位置
				ball[i] = red;
				i++;
			}
		}

		System.out.println(Arrays.toString(ball));
	}
}
