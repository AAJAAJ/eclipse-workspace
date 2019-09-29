/**
 * 
 */
package dom;



/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月30日 上午11:09:50
 */
public class ThreadSub extends Thread{

	private static int num = 100;
	private String name;
	public ThreadSub() {}
	
	public ThreadSub(int num,String name) {
		this.num = num;
		this.name = name;
	}
	
	@Override
	public void run() {
		if(num>0) {
			System.out.println("窗口A卖出一张票,剩余"+(--num)+"张");
		}
	}
	
	
}
