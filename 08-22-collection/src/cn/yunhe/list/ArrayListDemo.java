package cn.yunhe.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 作业:
 * 	给定一个带有重复数据的集合
 *  需求:添加元素时要保证元素不重复(包含对象),去重后的数据就行排序
 *  要求:使用ArrayList集合实现
 */
public class ArrayListDemo {

	
	public List addMethod() {
		List list = new ArrayList();
		
		list.add("first position");
		list.add("last position");
		list.add(2, "center position");
		list.add("first position");
		
		return list;
	}
	
	public void quChong() {
		List list = addMethod();
		List newList = new ArrayList();
		
		
		
		
	}
	
	@Test
	public void sortMethod() {
		List list = addMethod();
		System.out.println("排序前的集合:"+list);
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//按字符串长度排序
				int len1 = o1.length();
				int len2 = o2.length();
				
				int result = len1 - len2;
				return result;
			}
		});
		System.out.println("排序后的集合:"+list);
	}
	
	@Test
	public void test() {
		String s1 = "a";
		String s2 = "b";
		
		System.out.println(s1.compareTo(s2));;
	}
	
	
	
	
}
