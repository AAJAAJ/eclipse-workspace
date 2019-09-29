/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;




/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月22日 下午5:18:19
 *  作业:
 * 	给定一个带有重复数据的集合
 *  需求:添加元素时要保证元素不重复(包含对象),去重后的数据就行排序
 *  要求:使用ArrayList集合实现
 */


public class Dat0822Test {
	public static void main(String[] args) {
		sortMethod();
	}
	
	public static List addMethod() {
		List list = new ArrayList();
		list.add("wangao");
		list.add("杨航");
		list.add("machong");
		list.add("杨航");
		list.add("马冲");
		list.add("machong");
		list.add("yanghang");

		
		
		
		System.out.println("去重前集合:"+list);
		List newList = new ArrayList();
		
		for (ListIterator it = list.listIterator();it.hasNext();) {
			
			Object obj = it.next();
			
			if (!newList.contains(obj)) {
				newList.add(obj);
			}
		}
		
		return newList;
	}
	
	@Test
	public static void sortMethod() {
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
	
	
	
	
	
	
}
