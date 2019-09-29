package cn.yunhe.set;

import java.util.TreeSet;

import org.junit.Test;

import cn.yunhe.bean.Hero;
import cn.yunhe.bean.Hero2;
import cn.yunhe.utils.CompareBySpeed;

/**
 * TreeSet
 * 	不重复 排序
 * 默认提供的排序规则:自然排序法---数字和字符串
 * 自定义排序规则---自定义对象
 * 比较形式:
 * 	内部实现Comparable接口,重写compareTo(Object obj)
 *  外部定义比较器,给到集合对象
 *  重写compare(Object obj1,Object obj2)
 *  
 *  作业
 *  集合中存放字符串元素,按照字符串的长度进行排序
 */
public class TreeSetDemo {

	@Test
	public void compareMehod() {
		TreeSet set = new TreeSet();
		set.add("abdc");
		set.add("bcda");
		set.add("abcd");
		
		System.out.println(set);
	}
	
	@Test
	public void compareMehod2() {
		TreeSet set = new TreeSet();
		set.add(new Hero("q",70));
		set.add(new Hero("w",50));
		set.add(new Hero("e",60));
		
		System.out.println(set);
	}
	
	@Test
	public void compareMehod3() {
		TreeSet set = new TreeSet(new CompareBySpeed());
		set.add(new Hero2("q",70));
		set.add(new Hero2("w",50));
		set.add(new Hero2("e",60));
		
		System.out.println(set);
	}
}
