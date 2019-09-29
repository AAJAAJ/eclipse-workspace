package cn.yunhe.map;

import java.util.TreeMap;

import org.junit.Test;

import cn.yunhe.practice.CompareByLength;

public class TreeMapDemo {

	@Test
	public void run() {
		//取大于或等于给定值的最小整数
		System.out.println(Math.ceil(11.5));
		//取小于或等于给定值的最大整数
		System.out.println(Math.floor(-11.5));
	}
	
	@Test
	public void getKeyMethod() {
		TreeMap map = new TreeMap();
		map.put("name", "zhangsan");
		map.put("age", 13);
		map.put("abc", null);
		System.out.println(map);
		
		Object key = map.ceilingKey("zzz");
		System.out.println(key);
	}
	
	@Test
	public void getComparator() {
		TreeMap map = new TreeMap(new CompareByLength());
		System.out.println(map.comparator());
	}
}
