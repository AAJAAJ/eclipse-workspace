package com.yunhe.inner;

public class DuoTai {

	public static void main(String[] args) {
		
		Sub sub = new Sub();
		sub.run();
		sub.show();
		
		A a = new Sub();
		a.run();
		
	}
}

interface A{
	void run();
}

abstract class B implements A{
	abstract void show();
}

class Sub extends B{

	@Override
	public void run() {
		
	}

	@Override
	void show() {
		
	}
	
}
