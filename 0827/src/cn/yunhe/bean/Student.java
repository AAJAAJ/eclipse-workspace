/**
 * 
 */
package cn.yunhe.bean;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月27日 上午10:43:50
 */
public class Student {

	private String name;
	private int age;
	
	public Student() {}
	
	public Student(String name,int age) {
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
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
