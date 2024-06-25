package com.wn.java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 创建Stream对象的方式
 *
 */
public class CreateStreamObjectTest {
	public static void main(String[] args) {
		String[] arr = {"11","33","77","88","99"};
		//1.通过数组的工具类创建
		Stream<String> stream1 = Arrays.stream(arr);
		System.out.println(stream1);
		
		//2通过list集合创建
		List<String> list = Arrays.asList("aa","bb","dd");
		Stream<String> stream2 = list.stream();
		System.out.println(stream2);
		
		//3.通过Stream类中of()方法创建
		Stream<List<String>> stream3 = Stream.of(list);
		System.out.println(stream2);
		
	}
}
