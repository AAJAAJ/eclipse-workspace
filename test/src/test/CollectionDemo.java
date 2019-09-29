package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {

	public static void main(String[] args) {
		
//		collMethodAdd();
//		removeMethod();
//		compareMethod();
//		iteratorMethod();
//		iteratorMethod2();
		toArrayMethod();
		
		/*
		 * int i = 1; while(i<5) { System.out.println(i); i++; }
		 * 
		 * for(int j=1;j<5;j++) { System.out.println(j); } int j=1; for(;j<5;) {
		 * System.out.println(j); j++; }
		 */
		
	}
	
	/**
	 * Collection添加方法
	 */
	public static Collection collMethodAdd() {
		//创建集合对象
		Collection coll = new ArrayList();
		
		//添加单个数据
		coll.add(1);
		coll.add(2);
		coll.add("a");
		
		
		//添加集合
		Collection coll2 = new ArrayList();
		coll2.add("hello");
		coll2.add("zhengkeyuan");
		
		coll.addAll(coll2);
		return coll;
	}
	
	/**
	 * 移除方法
	 */
	public static void removeMethod() {
		//调用添加数据的方法
		Collection coll = collMethodAdd();
		
		System.out.println("集合大小:"+coll.size()+"原有的元素:"+coll);
		
		//移除单个元素
		//boolean result = coll.remove(-1);
		//System.out.println("删除结果:"+result);
		
		//移除指定集合的交集
		/*
		 * Collection newColl = new ArrayList(); newColl.add("a"); newColl.add(1);
		 * newColl.add(3); newColl.add("ke");
		 * 
		 * coll.removeAll(newColl);
		 */
		
		//清空集合
		coll.clear();
		
		System.out.println("集合大小:"+coll.size()+"移除后的元素;"+coll);
	}
	
	/**
	 * 元素判断是否存在
	 */
	public static void compareMethod() {
		//调用添加数据的方法
		Collection coll = collMethodAdd();
		
		//System.out.println(coll.contains("he"));
		
		Collection newColl = new ArrayList();
		newColl.add("hello");
		newColl.add("a");
		newColl.add("bcd");
		
		//System.out.println(coll.containsAll(newColl));
		coll.clear();
		if(coll.isEmpty()) {
			System.out.println("集合为空,请添加数据");
		}else {
			System.out.println(coll);
		}
	}
	
	/**
	 * 迭代器--循环--遍历
	 */
	public static void iteratorMethod() {
		//调用添加数据的方法
		Collection coll = collMethodAdd();
		//获取迭代器对象
		//Iterator it = coll.iterator();
		/*
		 * System.out.println(it.next()); System.out.println(it.next());
		 * System.out.println(it.next()); System.out.println(it.next());
		 * System.out.println(it.next()); System.out.println(it.next());
		 */
		
		 //while(it.hasNext()) { System.out.println(it.next()); }
		for(Iterator it = coll.iterator();it.hasNext();) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 迭代器遍历中的问题
	 */
	public static void iteratorMethod2() {
		//调用添加数据的方法
		Collection coll = collMethodAdd();
		//获取迭代器对象
		Iterator it = coll.iterator();
		//需求;如果当前元素为2,那么在后面添加一个元素为3
		while(it.hasNext()) { 
			//判断当前的数据类型是否是数字--instanceof
			if(it.next() instanceof Integer) {
				int result = (int)it.next();
				if(result == 2) {
					//ConcurrentModificationException 并发操作异常
					coll.add(3);
				}
			}
		}
		System.out.println("最新集合:"+coll);
	}
	
	/**
	 * 集合转换为数组
	 */
	public static void toArrayMethod() {
		//调用添加数据的方法
		Collection coll = collMethodAdd();
		
		Object[] objArr = coll.toArray();
		//此循环的主要作用是下标的使用
		
		  for(int i=0;i<objArr.length;i++) { 
			  Object obj = objArr[i];
			  System.out.println(obj); 
		  }
		
		for(Object obj : objArr) {
			System.out.println(obj);
		}
	}
	//作业1 指定一个集合,去除集合中的重复元素,并打印结果
	//作业2数组是否可以转换为集合?如果可以,怎么转换?
}
