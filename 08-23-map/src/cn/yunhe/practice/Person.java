package cn.yunhe.practice;

public class Person {

	private String name;
	private int age;
	public Person() {}
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public int hashCode() {
		System.out.println("-----hashCode-----");
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("-----equals-----");
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
