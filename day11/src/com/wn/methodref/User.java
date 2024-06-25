package com.wn.methodref;
/**
 * 用户类
 */
public class User {
	
	private String uid;
	private String uname;
	private int age;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", age=" + age + "]";
	}
	public User(String uid, String uname, int age) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.age = age;
	}
	public User() {
		super();
	}
	public User(String uname, int age) {
		this.uname = uname;
		this.age = age;
	}
}
