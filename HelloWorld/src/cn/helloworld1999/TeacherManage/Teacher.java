package cn.helloworld1999.TeacherManage;
/**
 * 讲师类
 */
public class Teacher {
	
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
}