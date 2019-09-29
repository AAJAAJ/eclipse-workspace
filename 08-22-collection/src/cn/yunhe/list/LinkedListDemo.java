package cn.yunhe.list;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LinkedListDemo {

	@Test
	public void addMethod() {
		LinkedList list = new LinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		
		System.out.println(list);
		
		list.addLast("a");
		list.addLast("b");
		list.addLast("c");
		
		System.out.println(list);
		
//		System.out.println(list.peek());
//		System.out.println(list.poll());
		
		list.push("d");
		System.out.println(list);
	}
}
