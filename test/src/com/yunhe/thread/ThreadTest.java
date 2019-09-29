/**
 * 
 */
package com.yunhe.thread;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月30日 上午11:48:59
 */
public class ThreadTest {

	public static void main(String[] args) {
		Ticket ticket = new Ticket("售票a");
		Thread t1 = new Thread(ticket);
		t1.start();
		
	}
}
