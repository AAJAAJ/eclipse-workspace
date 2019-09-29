package cn.yunhe.bean;

public class Person implements Comparable{

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
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		Person person = (Person)o;
		int nameResult = this.name.compareTo(person.name);
		
		return nameResult==0?(this.age-person.age):nameResult;
	}
}
