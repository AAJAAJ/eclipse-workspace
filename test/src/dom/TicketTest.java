/**
 * 
 */
package dom;


/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月30日 上午11:16:30
 */
public class TicketTest {

	public static void main(String[] args) {
		
		
//		//创建两个窗口 
//		Ticket t1 = new Ticket("窗口A");
//		Ticket t2 = new Ticket("窗口B"); 
//		//创建线程
//		Thread thread1 = new Thread(t1); 
//		Thread thread2 = new Thread(t2); 
//		//开启线程
//		thread1.start(); 
//		thread2.start();
		
		
		Ticket t1 = new Ticket();
		Thread thread1 = new Thread(t1,"窗口A");
		Thread thread2 = new Thread(t1,"窗口B");
		thread1.start();
		thread2.start();
		new Thread(t1,"窗口C").start();
		new Thread(t1,"窗口D").start();
		new Thread(t1,"窗口E").start();
		new Thread(t1,"窗口F").start();
		new Thread(t1,"窗口G").start();
		new Thread(t1,"窗口H").start();
		
		
	}
}
