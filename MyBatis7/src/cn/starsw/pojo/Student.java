package cn.starsw.pojo;

public class Student {

	private int id1;
	private String name1;
	private int age1;
	private  int tid;
	
	@Override
	public String toString() {
		return "Student [id1=" + id1 + ", name1=" + name1 + ", age1=" + age1 + ", tid=" + tid + ", teacher=" 
				+ "]";
	}
	public int getId() {
		return id1;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public void setId(int id) {
		this.id1 = id;
	}
	public String getName() {
		return name1;
	}
	public void setName(String name) {
		this.name1 = name;
	}
	public int getAge() {
		return age1;
	}
	public void setAge(int age) {
		this.age1 = age;
	}
	
	
	
	
	
}
