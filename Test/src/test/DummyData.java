package test;

import java.io.Serializable;

public class DummyData implements Serializable{
	
	private static final long serialVersionUID = -7788619177798333712L;
	
	private String fname;
	private String lname;
	private int age;
	private String address;
	
	@Override
	public String toString() {
		return "DummyData [fname=" + fname + ", lname=" + lname + ", age=" + age + ", address=" + address + "]";
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
