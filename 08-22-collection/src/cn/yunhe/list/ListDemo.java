package cn.yunhe.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/**
 * Junit关联步骤
 * 	项目右键--->build Path--->libraries--->add libraries--->Junit---<Junit 4--->finish
 *  方法前面@Test,光标在方法名上右键,runas-->junit test
 * 
 * Junit使用限制
 * 	1 方法不能为静态的
 *  2 方法不能有参数
 *  3 方法不能带返回值
 *  
 * Collection
 * 	List
 * 		可重复,有序
 * 		问题:
 * 			1 有序是哪种排序方式
 * 			2 不同的子类有什么特点?使用时如何选择?
 *  方法:
 *  	添加:
 *  		add(int index,Object obj)
 *  	移除:
 *  		remove(int index)
 *  	获取指定位置的元素:
 *  		get(int index)
 *  	获取指定元素对应的下标
 *  		indexOf(Object obj) lastIndexof(Object obj)
 *  	迭代
 *  		listIterator()
 *  	元素筛选
 *  		retainAll(Collection coll)
 *  	修改
 *  		set(int index,Object obj)	
 *  	截取
 *  		subList(int fromIndex,int endindex)
 *  常用的子类
 *  	ArrayList
 *  		优点:查询快
 *  		缺点:增删慢
 *  	LinkedList
 *  		优点:增删快
 *  		缺点:查询慢
 *  
 *  不知道怎么选择集合时,就直接使用ArrayList.原因:开发过程中最多的操作是查询
 *  
 *  Set
 *  	不可重复,无序
 *  	问题:
 *  		1 如何保证元素不重复
 *  		2 不同的子类有什么特点?使用时如何选择?
 */
public class ListDemo {

	
	public List addMethod() {
		List list = new ArrayList();
		
		list.add("first position");
		list.add("last position");
		list.add(2, "center position");
		list.add("first position");
		
		return list;
	}
	
	@Test
	public void removeMethod() {
		List list = addMethod();
		
		System.out.println("移除前的集合:"+list);
		
		list.remove(2);
		
		System.out.println("移除后的集合:"+list);
		
		System.out.println("获取指定位置上的元素:"+list.get(0));
	}
	
	@Test
	public void getIndexMethod() {
		List list = addMethod();
		
		System.out.println("正向查找:"+list.indexOf("first position"));
		
		System.out.println("反向查找:"+list.lastIndexOf("first position"));
	}
	
	@Test
	public void iteratorMethod() {
		//集合
		List list = addMethod();
		//获取迭代对象
		ListIterator listIt = list.listIterator();
		//遍历
		while(listIt.hasNext()) {
			Object obj = listIt.next();
			if(obj.equals("center position")) {
				//listIt.add("fourth positioin");
				//listIt.set("second position");
				listIt.remove();
			}
		}
		System.out.println(list);
	}
	
	@Test
	public void iteratorMethod2() {
		//集合
		List list = addMethod();
		//获取迭代对象
		ListIterator listIt = list.listIterator();
		
		System.out.println(listIt.next());//first positio
		System.out.println(listIt.next());//last position
		System.out.println(listIt.next());//center position
		System.out.println(listIt.previous());//
		System.out.println(listIt.previous());
	}
	
	@Test
	public void retainMethod() {
		//集合
		List list = addMethod();
		List newList = new ArrayList();
		newList.add("second position");
		newList.add("first position");
		
		list.retainAll(newList);
		
		System.out.println(list);
	}
	
	@Test
	public void subListMethod() {
		List list = addMethod();
		List newList = list.subList(1, list.size());
		System.out.println(newList);
	}
	
	@Test
	public void nullMethod() {
		List list = addMethod();
		list.add(null);
		list.add(null);
		System.out.println(list);
	}
}













