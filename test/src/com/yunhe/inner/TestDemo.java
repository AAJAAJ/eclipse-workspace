package com.yunhe.inner;

public class TestDemo {
	public static void main(String[] args) {
		Outer outer = new Outer();
		/*
		 * Inner innerTest = new Inner(); innerTest.say(); Inner inner = new
		 * Outer.Inner(); outer.name = "0";
		 */
		final String name = "def";
		final StringBuffer sb = new StringBuffer();
		sb.append("bbbb");
		sb.append("aaaa");
		System.out.println(sb);
	}
}
