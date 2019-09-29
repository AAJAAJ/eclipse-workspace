package com.yunhe.inner;

public class Test {
	public static void main(String[] args) {
		
		Phone phone = new Phone();
		phone.name = "华为";
		phone.play();
		
	}
}


class Phone{
	String name;
	double price;
	
	public void call() {}
	
	public void play() {
		System.out.println("鸿蒙系统玩游戏可能会输");
	}
	
}
