package cn.yunhe.bean;

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

	//hash冲突---相同的概率较高
	@Override
	public int hashCode() {
		
		return this.name.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {//Object obj = new Person();
		Person person = (Person)obj;
		/*
		 * boolean result = this.name.equals(person.name); if(result) { int ageResult =
		 * this.age - person.age; if(ageResult == 0) { return true; } } return false;
		 */
		//return this.name.equals(person.name)==true?(this.age - person.age==0?true:false):false;
		
		int result = this.age - person.age;
		return result==0?this.name.equals(person.name):false;
		
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
