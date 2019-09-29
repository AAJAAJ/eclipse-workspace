package com.yunhe.inner;

public class Outer {
	int num = 1;
	final class Inner {
		int num = 2;
		public void say() {
			System.out.println(num);
		}
	}
}
