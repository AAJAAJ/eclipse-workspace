package cn.yunhe.bean;

public class Student extends Person{

	private String name;
	private int age;
	private long sid;
	
	public Student() {
		super();
		System.out.println("子类构造器");
		this.name = "张三";
		System.out.println(this.name);
	}
	
	public Student(String name,int age,long sid) {
		this.name = name;
		this.age = age;
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
		super.eat();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sid=" + sid + "]";
	}
	
}
