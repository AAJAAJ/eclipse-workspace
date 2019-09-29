package cn.yunhe.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import cn.yunhe.bean.Person;

/**
 * Set
 * 	不可重复,无序的
 * 问题:
 * 	1 如何保证元素不重复
 *  2 无序的形式是啥
 *  
 * 注意点;
 * 	只能有一个null元素
 *  元素是否重复是通过equals方法进行比较
 * 方法:
 * 	
 */
public class Setdemo {

	@Test
	public void addMethod() {
		Set set = new HashSet();
		set.add("abc");
		set.add("sad");
		set.add("qwe");
		set.add("fdgtr");
		set.add("qwe");
		
		System.out.println(set);
		
		List list = new ArrayList();
		list.add("abc");
		list.add("sad");
		list.add("qwe");
		list.add("fdgtr");
		
		System.out.println(list);
		
	}
	
	/**
	 * 假设:
	 * 	1 姓名相同就为同一个对象
	 *  2 姓名和年龄是相同的,name就判定为同一个对象
	 *  
	 *  equals做对比
	 */
	@Test
	public void objMethod() {
		Person person1 = new Person("张三",12);
		Person person2 = new Person("张三",14);
		Person person3 = new Person("张三",13);
		Person person4 = new Person("张三",12);
		
		/*
		 * List list = new ArrayList(); list.add(person1); list.add(person2);
		 * list.add(person3); list.add(person4);
		 * 
		 * System.out.println(list);
		 */
		
		Set set = new HashSet();
		set.add(person1);
		set.add(person2);
		set.add(person3);
		set.add(person4);
		System.out.println(set);
	}
}
