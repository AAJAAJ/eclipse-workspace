package cn.yunhe.bean;

public class Person {
	
	public Person() {
		System.out.println("父类构造器");
		eat();
	}
	
	public void eat() {
		System.out.println("吃....");
	}
}
