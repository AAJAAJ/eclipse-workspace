package cn.yunhe.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1 数组转换成集合   Arrays.asList(array);
 * 2 集合去重复,得到新集合
 * 	步骤:
 * 		1 定义集合,带有重复的数据---List---ArrayList
 * 		2 遍历集合,找到重复的元素
 * 			创建一个新集合用于存储不重复的数据---new ArrayList()
 * 			判断新集合中是否包含了当前的元素---contains(Object obj)
 */
public class Practice {

	public static void main(String[] args) {
		/*
		 * int[] arr = {1,2,3,4}; System.out.println(arr.toString());
		 * 
		 * //转换为集合 List list =Arrays.asList(arr,arr);
		 */
		ArrayList arr = new ArrayList();
		arr.add("张三");
		arr.add("李四");
		arr.add("王五");
		arr.add("李四");
		arr.add("张三");
		
		ArrayList newArr = new ArrayList();
		//遍历老集合,获取元素
		Iterator it = arr.iterator();
		while(it.hasNext()) {
			//获取当前元素
			Object obj = it.next();
			//判断元素不存在于新集合中
			if(!newArr.contains(obj)) {
				//将不重复的元素添加到新集合中
				newArr.add(obj);
			}
		}
		System.out.println("老集合:"+arr);
		System.out.println("新集合:"+newArr);
		
	}
}
