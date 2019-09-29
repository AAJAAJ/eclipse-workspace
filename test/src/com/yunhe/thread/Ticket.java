/**
 * 
 */
package com.yunhe.thread;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月30日 上午11:43:25
 */
public class Ticket implements Runnable {

	private static int count = 100;
	private String name;


	public Ticket() {}
	
	public Ticket(String name) {
		
		this.name = name;
	}

	@Override
	public void run() {
		if (count>0) {
			System.out.println(--count);
		}
	}
	
	
	
}
