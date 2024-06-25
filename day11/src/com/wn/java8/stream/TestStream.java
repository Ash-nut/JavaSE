package com.wn.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TestStream implements TestSortAndDistinct {
	public static void main(String[] args) {
		
		//统计在成都的员工人数
		long count = initData().stream().filter(t -> t.getAddress().equals("成都")).count();
//		System.out.println(count);
		//找出讲师最高工资是多少?
//		Integer maxSal = initData().stream().map(Teacher ::  getSal).max((o1,o2) -> o1.compareTo(o2)).get();
		Integer maxSal = initData().stream().map(Teacher ::  getSal).max(Integer :: compareTo).get();
//		System.out.println(maxSal);
		
		//计算所有在成都的讲师工资总和
//		Integer sum = initData().stream().filter(t -> t.getAddress().equals("成都"))
//				  .map(Teacher :: getSal).reduce(Integer :: sum).get();
//		System.out.println(sum);
		
		//求和
//		Integer max = initData().stream().filter(t -> t.getAddress().equals("成都")).map(Teacher :: getSal)
//			.reduce(0, Integer :: sum);
//		System.out.println(max);
		
		//计算杭州讲师平均工资
//		Double avgSal = initData().stream().filter(t -> t.getAddress().equals("杭州"))
//				.collect(Collectors.averagingInt(Teacher :: getSal));
//		System.out.println(avgSal);
		
		//根据讲师工作地址进行分组
//		Map<String, List<Teacher>> map = initData().stream().collect(Collectors.groupingBy(Teacher :: getAddress));
//		//遍历集合
//		Set<String> keys = map.keySet();
//		for(String addr : keys) {
//			List<Teacher> list  = map.get(addr);
//			
//			System.out.println(addr + "的讲师有" + list.size()  + "人。详情如下:");
//			for(Teacher t : list) {
//				System.out.println("---->" + t);
//			}
//		}
		
		//Stream转换成指定的结合
//		List<Teacher> list = initData().stream().filter(t -> t.getAddress().equals("杭州")).collect(Collectors.toList());
//		for(Teacher t : list) {
//			System.out.println(t);
//		}
		
		//查询有哪些工作地址
		List<String> list = initData().stream().map(Teacher :: getAddress).distinct().collect(Collectors.toList());
		for(String city : list) {
			System.out.println(city);
		}
	}
	/**
	 * 排序和去重
	 */
	public static void testSortAndDistinct() {
		//获取所有讲师工资
//		initData().stream().map(Teacher :: getSal).forEach(System.out::println);
		//过滤 filter()
//		initData().stream().filter(tea -> tea.getAddress().equals("成都") )
//						   .filter(t -> t.getSal() >= 20000)
//						   .forEach(System.out::println);
		
		//查询所有的工作地点 (对地址进行去重)  distinct()
//		initData().stream().map(Teacher :: getAddress).distinct().forEach(System.out::println);
		
		//显示数据源中前3条数据
//		initData().stream().limit(3).forEach(System.out::println);
		
		//显示第3 - 5的讲师数据
//		initData().stream().skip(2).limit(3).forEach(System.out::println);
		
		//根据讲师工资进行降序排序
//		initData().stream().sorted((t1,t2) -> t2.getSal() - t1.getSal()).forEach(System.out::println);;
		
		//排序第二种方式
		initData().stream().sorted(Comparator.comparing(Teacher :: getBirthday)).forEach(System.out::println);;
	}

	/**
	 * 映射 map方法
	 */
	public static void TestMap() {
		//1.对集合中数据进行过滤
		//映射  (把集合中数据转换)  map(Function f)
		List<String> list = Arrays.asList("11","33","77","88","99");
		//获取Stream对象
		Stream<String> stream = list.stream();
		//对数据进行映射
//		Stream<Integer> stream2 = stream.map(new Function<String, Integer>() {
//			@Override
//			public Integer apply(String s) {
//				return Integer.parseInt(s);
//			}
//		});
		
		//lambda优化
//		Stream<Integer> stream2 = stream.map(s ->  Integer.parseInt(s));
		
		//方法的引用
		Stream<Integer> stream2 = stream.map(Integer :: parseInt);
		//遍历元素
//		stream2.forEach(System.out::println);
		//Stream支持链式操作
		list.stream().map(Integer::parseInt).forEach(System.out::println);
	}
	
	/**
	 * 初始化讲师数据
	 */
	public static List<Teacher> initData() {
		//实例化讲师对象
		Teacher  t1 = new Teacher("1189389726308478977", "吴止境", "高级讲师", "1980-02-18", "成都", 20000, 0);
		Teacher  t2 = new Teacher("1189390295668469762", "杜紫达", "首席讲师", "1982-07-01", "杭州", 32000, 0);
		Teacher  t3 = new Teacher("1189426437876985857", "古辉何", "高级讲师", "1990-08-10", "上海", 26000, 1);
		Teacher  t4 = new Teacher("1192249914833055746", "范统", "中级讲师", "1986-03-30", "成都", 18000, 0);
		Teacher  t5 = new Teacher("1527933834454339586", "沈京兵", "首席讲师", "1988-11-09", "成都", 28000, 0);
		Teacher  t6 = new Teacher("1195337453429129218", "杜子腾", "高级讲师", "1992-10-22", "杭州", 24500, 0);
		Teacher  t7 = new Teacher("1195337453429117258", "杜琦燕", "高级讲师", "2005-10-08", "杭州", 22000, 0);
		Teacher  t8 = new Teacher("1175337453339117339", "安世珠", "高级讲师", "1994-09-16", "上海", 25000, 0);
		
		
		List<Teacher> list = new ArrayList<>();
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.add(t6);
		list.add(t7);
		list.add(t8);
		return list;
	}
}
