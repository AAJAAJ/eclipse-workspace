package cn.yunhe.test;

/**
 * 	多线程在操作时会出现安全问题
 * 	原因:一个线程在进行运算时,另一个线程也参与了运算
 * 	 解决方案:
 * 		一个线程在运算时,不允许其他线程参与
 * 		把公共的代码锁起来
 *  同步锁---synchronized
 *  在使用同步锁时需要提供一个唯一的锁---锁在程序中通常指的是一个对象
 *  
 *  线程中提供的方法
 *  优先级
 *  礼让
 *  守护线程
 *  中断
 * 线程的生命周期
 * 同步锁在单例模式中的使用(单例模式需要讲解)
 * 死锁的产生原理--了解
 * 垃圾回收机制
 */
public class TicketTest {

	public static void main(String[] args) {
		
		/*
		 * //创建两个窗口 Ticket t1 = new Ticket("窗口A"); Ticket t2 = new Ticket("窗口B"); //创建线程
		 * Thread thread1 = new Thread(t1); Thread thread2 = new Thread(t2); //开启线程
		 * thread1.start(); thread2.start();
		 */
		
		Ticket t1 = new Ticket();
		Thread thread1 = new Thread(t1,"窗口A");
		Thread thread2 = new Thread(t1,"窗口B");
		thread1.start();
		thread2.start();
	}
}
