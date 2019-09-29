/**
 * 
 */
package com.yunhe.thread;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月30日 上午11:46:42
 */
public class ThreadSub extends Thread {

	public String name;
	public int num = 100;
	@Override
	public void run() {
		if (num>0) {
			System.out.println(--num);
		}
	}

	
}
