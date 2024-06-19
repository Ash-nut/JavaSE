package cn.helloworld1999.TeacherManage;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * 讲师管理
 */
public class TeacherManger {
	
	private static Teacher[] teachers;
	static Scanner scan = new Scanner(System.in);

	
	public static void main(String[] args) {
		boolean isLoop = true;
		while(isLoop) {
			System.out.println("1.查询所有讲师信息?");
			System.out.println("2.添加一条讲师信息?(10分)");
			System.out.println("3.把所有上海员工工资重置为28000元？(10分)");
			System.out.println("4.根据id删除指定讲师?(10分)");
			System.out.println("5.找出工资大于20000的所有高级讲师有哪些?(10分)");
			System.out.println("6.计算所有非高级讲师的平均工资");
			System.out.println("7.找出在成都和杭州工资最高的员工?(10分)");
			System.out.println("8.查找所有姓'杜'的讲师按照工资高低进行排序？(10分)");
			System.out.println("9.找出年龄大于28岁的并且未被删除的讲师有哪些?(10分)");
			System.out.println("10.在成都的高级讲师有多少人?分别有哪些？(10分)");
			System.out.println("11.统计不同城市讲师的总人数及每个城市的讲师详情信息？(10分)");
			System.out.println("请选择功能:");

			int num = scan.nextInt();
			switch (num) {
			case 1 :
				findTeachers();
				break;
			case 2 :
				addTeacher();
				break;
			case 3 :
				updateTeacherByAddr();
				break;
			case 4 :
				delById();
				break;
			case 5 :
				showQuestionFive();
				break;
			case 6 :
				showQuestionSix();
				break;
			case 7 :
				showQuestSeven();
				break;
			case 8 :
				showQuestionEight();
				break;
			case 9 :
				showQuestNine();
				break;
			case 10 :
				showQuestTen();
				break;
			case 11 :
				showQuestEleven();
				break;
			default:
				System.out.println("输入有误，请重新输入....");
				break;
			}
			
		}
	}
	/**
	 * 4.根据id删除指定讲师?(10分)
	 */
	private static void delById() {
		System.out.println("请输入工号:");
		String id = scan.next();
		//判断是否重复
		int index = isExist(id);
		if(index > -1) {
			Teacher oldTeacher = teachers[index];
			//设置isDelete属性置为1
			oldTeacher.setIsDel(1);
			System.out.println("删除成功!");

		}else {
			System.out.println("你输入" + id +"不存在，删除失败!");
		}
		
		
	}
	/**
	 * 3.根据地址修改讲师的工资
	 */
	private static void updateTeacherByAddr() {
		System.out.println("请输入地址:");
		String address  = scan.next();
		//遍历原数组
		for(Teacher t : teachers) {
			//获取当前讲师工作地址
			if(t.getAddress().equals(address)) {
				//修改当前讲师工资为28000
				t.setSal(28000);
			}
		}
		System.out.println("修改成功!");
	}
	/**
	 * 2.添加一条讲师信息?(10分)
	 */
	private static void addTeacher() {
		System.out.println("请输入工号:");
		String id = scan.next();
		//判断是否重复
		int index = isExist(id);
		if(index == -1) {
			System.out.println("请输入姓名:");
			String name = scan.next();
			System.out.println("请输入资历:");
			String seniority = scan.next();
			System.out.println("请输入生日:");
			String birthday = scan.next();
			System.out.println("请输入地址:");
			String addr = scan.next();
			System.out.println("请输入工资:");
			int sal = scan.nextInt();
			
			//把数据封装到实体对象中
			Teacher t = new Teacher(id, name, seniority, birthday, addr, sal, 0);
			
			//扩容
			teachers = Arrays.copyOf(teachers, teachers.length + 1);
			//把数据添加到数组末尾
			teachers[teachers.length - 1] = t;
			System.out.println("添加成功!");
			
		}else {
			System.out.println("你输入" + id +"已存在，添加失败!");
		}
	}
	
	/**
	 * 判断工号是否重复
	 */
	public static int isExist(String id) {
		for(int i = 0;i < teachers.length;i++) {
			Teacher t = teachers[i];
			if(t.getTid().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * 1.查询所有讲师信息?
	 */
	public static void findTeachers() {
		
		//遍历数组
		System.out.println("工号\t\t\t姓名\t资历\t生日\t\t地址\t工资");
		for(Teacher t : teachers) {
			if(t.getIsDel() == 0) {
				//输入对象中属性值
				System.out.println(t.getTid() + "\t" + t.getTname() + "\t" + t.getSeniority() 
				+ "\t" + t.getBirthday() + "\t" + t.getAddress() + "\t" + t.getSal());
			}
		}
	}
	public static void showQuestionFive(){
		System.out.println("工资大于20000的所有高级讲师:");
		for (Teacher t : teachers) {
			if(t.getSal()>20000&&t.getSeniority().equals("高级讲师")){
				System.out.println(t.getTid() + "\t" + t.getTname() + "\t" + t.getSeniority()
						+ "\t" + t.getBirthday() + "\t" + t.getAddress() + "\t" + t.getSal());
			}
		}
	}
	/**
	 * 计算所有非高级教师的平均工资5
	 */
	public static void showQuestionSix(){
		int tempNum = 0;
		double tempSum = 0;
		for(Teacher t : teachers) {
			if(t.getSeniority()!="高级讲师") {
				tempSum += t.getSal();
				tempNum++;
			}
		}
		if (tempNum!=0){
			System.out.println("所有非高级教师的平均工资为："+tempSum/tempNum);
		}else {
			System.out.println("没有高级教师");
		}
	}
	public static void showQuestSeven(){
		double salaryMaxInCD = 0;
		double salaryMaxInHZ = 0;
		for (Teacher t:teachers){
			if (t.getAddress().equals("成都")){
				salaryMaxInCD = salaryMaxInHZ>t.getSal()?salaryMaxInCD: t.getSal();
			}
			else if(t.getAddress().equals("杭州")){
				salaryMaxInHZ = salaryMaxInHZ>t.getSal()?salaryMaxInCD: t.getSal();
			}
		}
		System.out.println("成都最高工资为："+salaryMaxInCD);
		System.out.println("杭州最高工资为："+salaryMaxInHZ);
	}
	public static void showQuestionEight(){
		Teacher[] teacherArray = new Teacher[0];
		for(Teacher t:teachers){
			if (t.getTname().startsWith("杜")) {
				teacherArray = Arrays.copyOf(teacherArray, teacherArray.length+1);
				teacherArray[teacherArray.length-1] = t;
			}
		}
		// for(int i=0;i<teacherArray.length;i++){
		// 	for(int j = 0;j<teacherArray.length-1-i;j++){
		// 		if (teacherArray[i].getSal()<teacherArray[i+1].getSal()) {
		// 			teacherArray[i] = teacherArray[i+1];
		// 		}
		// 	}
		// }
		Arrays.sort(teacherArray);
		System.out.println("所有姓'杜'的讲师按照工资高低进行排序：");
		System.out.println("工号\t\t\t姓名\t资历\t生日\t\t地址\t工资");
		for(Teacher t : teacherArray) {
			if(t.getIsDel() == 0) {
				//输入对象中属性值
				System.out.println(t.getTid() + "\t" + t.getTname() + "\t" + t.getSeniority()
						+ "\t" + t.getBirthday() + "\t" + t.getAddress() + "\t" + t.getSal());
			}
		}
	}
	public static void showQuestNine(){
		Date date = new Date();		//这个东东是获取现在的时间 print strDate is Tue Jun 18 19:07:36 CST 2024
		int nowTime = Integer.parseInt(date.toString().split(" ")[5]);
		System.out.println("年龄大于28岁的并且未被删除的讲师");
		System.out.println("工号\t\t\t姓名\t资历\t生日\t\t地址\t工资");
		for (Teacher t:teachers){
			if ((nowTime - (Integer.parseInt(t.getBirthday().split("-")[0]))>=28) && (t.getIsDel()==0)){
				System.out.println(t.getTid() + "\t" + t.getTname() + "\t" + t.getSeniority()
						+ "\t" + t.getBirthday() + "\t" + t.getAddress() + "\t" + t.getSal());
			}
		}
	}
	public static void showQuestTen(){
		Teacher[] temp = new Teacher[0];
		for (Teacher t:teachers){
			if (t.getAddress().equals("成都")&&t.getSeniority().equals("高级讲师")) {
				temp = Arrays.copyOf(temp,temp.length+1);
				temp[temp.length-1] = t;
			}
		}
		System.out.println("住在成都的高级教师有 "+temp.length+"人，信息如下：");
		System.out.println("工号\t\t\t姓名\t资历\t生日\t\t地址\t工资");
		for (Teacher t:temp){
			System.out.println(t.getTid() + "\t" + t.getTname() + "\t" + t.getSeniority()
					+ "\t" + t.getBirthday() + "\t" + t.getAddress() + "\t" + t.getSal());
		}
	}
	public static void showQuestEleven(){
		String[] cityArray = new String[0];
		int[] peopleNum = new int[0];
		int c = 0;
		int p = 0;
		for (p = 0;p<teachers.length;p++){
			boolean flag = false;
			for (c = 0;c<cityArray.length;c++){
				if (teachers[p].getAddress().equals(cityArray[c])){
					peopleNum[c]++;
					flag = true;
					System.out.println(flag);
					break;
				}
			}
			if (!flag){
				cityArray = Arrays.copyOf(cityArray, cityArray.length+1);
				cityArray[cityArray.length-1] = teachers[p].getAddress();
				peopleNum = Arrays.copyOf(peopleNum, peopleNum.length+1);
				peopleNum[peopleNum.length-1]++;
			}
		}
		for (int i=0;i<cityArray.length;i++){
			System.out.println("住在 " + cityArray[i] + " 有 "+peopleNum[i]+" 人,信息如下：");
			for (Teacher t:teachers){
				if (t.getAddress().equals(cityArray[i])){
					System.out.println(t.getTid() + "\t" + t.getTname() + "\t" + t.getSeniority()
							+ "\t" + t.getBirthday() + "\t" + t.getAddress() + "\t" + t.getSal());
				}
			}
		}
	}
	/**静态块*/
	static {
		//初始化数据
		Teacher  t1 = new Teacher("1189389726308478977", "吴止境", "高级讲师", "1980-02-18", "成都", 20000, 0);
		Teacher  t2 = new Teacher("1189390295668469762", "杜紫达", "首席讲师", "1982-07-01", "杭州", 32000, 0);
		Teacher  t3 = new Teacher("1189426437876985857", "古辉何", "高级讲师", "1990-08-10", "上海", 26000, 1);
		Teacher  t4 = new Teacher("1192249914833055746", "范统", "中级讲师", "1986-03-30", "成都", 18000, 0);
		Teacher  t5 = new Teacher("1527933834454339586", "沈京兵", "首席讲师", "1988-11-09", "成都", 28000, 0);
		Teacher  t6 = new Teacher("1195337453429129218", "杜子腾", "高级讲师", "1992-10-22", "杭州", 24500, 0);
		Teacher  t7 = new Teacher("1195337453429117258", "杜琦燕", "高级讲师", "1995-10-08", "杭州", 22000, 0);
		Teacher  t8 = new Teacher("1175337453339117339", "安世珠", "高级讲师", "1994-09-16", "上海", 25000, 0);
		
		Teacher[] arr = {t1,t2,t3,t4,t5,t6,t7,t8};
		teachers = arr;
	}

}
