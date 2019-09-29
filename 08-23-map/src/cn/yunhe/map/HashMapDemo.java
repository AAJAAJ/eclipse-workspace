package cn.yunhe.map;

import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Test;

import cn.yunhe.bean.Person;

public class HashMapDemo {

	@Test
	public void saveObjectMethod() {
		HashMap map = new HashMap();
		map.put("JavaProgrammer", new Person("张三",23));
		map.put("UIProgrammer", new Person("小玲",21));
		map.put("H5Programmer", new Person("小黄",22));
		
		map.put(new Person("张三",23), "JavaProgrammer");
		map.put(new Person("小玲",21), "UIProgrammer");
		map.put(new Person("小黄",22), "H5Programmer");
		
		System.out.println(map);
	}
	
	@Test
	public void saveObjectByTreeMap() {
		TreeMap map = new TreeMap();
		/*
		 * map.put("JavaProgrammer", new Person("张三",23)); map.put("UIProgrammer", new
		 * Person("小玲",21)); map.put("H5Programmer", new Person("小黄",22));
		 */
		
		map.put(new Person("bac",23), "JavaProgrammer");
		map.put(new Person("abc",21), "UIProgrammer");
		map.put(new Person("cba",22), "H5Programmer");
		map.put(new Person("cba",20), "PHPProgrammer");
		map.put(new Person("abc",21), "UIProgrammer");
		
		System.out.println(map.size());
		System.out.println(map);
	}
}
