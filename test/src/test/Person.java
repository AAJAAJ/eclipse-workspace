/**
 * 
 */
package test;

import java.io.Serializable;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月28日 下午4:58:36
 */
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	
	
	
	public Person() {}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public synchronized String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public synchronized void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public synchronized int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public synchronized void setAge(int age) {
		this.age = age;
	}
	
}
