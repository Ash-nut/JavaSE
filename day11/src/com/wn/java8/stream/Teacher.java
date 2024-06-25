package com.wn.java8.stream;
/**
 * 讲师类
 */
public class Teacher implements Comparable<Teacher>{
	
	/**工号*/
	private String tid;
	/**姓名*/
	private String tname;
	/**资历*/
	private String seniority;
	/**生日*/
	private String birthday;
	/**地址*/
	private String address;
	/**工资*/
	private int sal;
	/**是否删除*/
	private int isDel;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSeniority() {
		return seniority;
	}
	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public Teacher(String tid, String tname, String seniority, String birthday, String address, int sal, int isDel) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.seniority = seniority;
		this.birthday = birthday;
		this.address = address;
		this.sal = sal;
		this.isDel = isDel;
	}
	/**
	 * 重写toString方法
	 */
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", seniority=" + seniority + ", birthday=" + birthday
				+ ", address=" + address + ", sal=" + sal + ", isDel=" + isDel + "]";
	}
	/**
	 * 元素之间比较的方法
	 */
	@Override
	public int compareTo(Teacher t) {
		return t.getSal() - this.getSal();
	}
	
}
