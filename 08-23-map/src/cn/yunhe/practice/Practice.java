package cn.yunhe.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

//集合中存放字符串元素,按照字符串的长度进行排序
public class Practice {

	@Test
	public void strSort() {
		TreeSet set = new TreeSet(new CompareByLength());
		
		set.add("jsdippe");
		set.add("ads");
		set.add("wqewq");
		set.add("abs");
		
		System.out.println(set);
	}
	
	@Test
	public void test() {
		ArrayList list = new ArrayList();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		list.add("lisi");
		list.add("zhangsan");
		
		System.out.println("去重复前的集合:"+list);
		
		ArrayList newlist = new ArrayList();
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			
			Object obj = it.next();
			if(!newlist.contains(obj)) {
				
				newlist.add(obj);
				
			}
		}
		System.out.println("排序前:"+newlist);
		
		Collections.sort(newlist, new CompareByLength());
		System.out.println("排序后:"+newlist);
	}
}
