/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月22日 上午11:53:39
 */
public class day0822 {
	
	public List add() {
		List list = new ArrayList();
		list.add("first position");
		list.add("last position");
		list.add(2, "center position");
		list.add("first position");
		System.out.println(list);
		return list;
	}
	@Test
	public void remove() {
		List list = add();
		
		System.out.println("移除前的集合:"+list);
		
		list.remove(0);
		
		System.out.println("移除后的集合:"+list);
		
		System.out.println("获取指定位置上的元素:"+list.get(1));
	}
	@Test
	public void getIndex() {
		List list = add();
		
		System.out.println("正向查找:"+list.indexOf("first position"));
		
		System.out.println("反向查找:"+list.lastIndexOf("first position"));
	}
	
	@Test
	public void iterator() {
		//集合
		List list = add();
		//获取迭代对象
		ListIterator listIt = list.listIterator();
		//遍历
		while(listIt.hasNext()) {
			Object obj = listIt.next();
			if(obj.equals("center position")) {
				listIt.add("fourth positioin");
				//listIt.set("second position");
				//listIt.remove();
			}
		}
		System.out.println(list);
	}
	@Test
	public void iterator2() {
		//集合
		List list = add();
		//获取迭代对象
		ListIterator listIt = list.listIterator();
		
		System.out.println(listIt.next());
		System.out.println(listIt.next());
		System.out.println(listIt.next());
		System.out.println(listIt.next());
		System.out.println(listIt.previous());
		System.out.println(listIt.previous());
		System.out.println(listIt.previous());
		System.out.println(listIt.previous());
	}
	@Test
	public void retain() {
		//集合
		List list = add();
		List newList = new ArrayList();
		newList.add("center position");
		newList.add("last position");
		
		list.retainAll(newList);
		
		System.out.println(list);
	}
	@Test
	public void subList() {
		List list = add();
		List newList = list.subList(0, 3);
		System.out.println(newList);
	}
	
	@Test
	public void nullMethod() {
		List list = add();
		list.add(null);
		list.add(null);
		list.set(1, null);
		list.remove(null);
		list.remove(null);
		System.out.println(list);
	}
	
	
	
	
	
	
	
	
	
	
	
}
