package cn.yunhe.test;

public class Ticket implements Runnable{

	private static int count = 100;
	private String name;
	//static Object obj = new Object();
	
	public Ticket() {}
	
	public Ticket(String name) {
		this.name = name;
	}
	
	public Ticket(int count,String name) {
		this.count = count;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			//将公共的业务代码锁起来
			synchronized(this) {
				if(count>0) {
					//模拟信息传递间隔
					try {
						//假设线程A先进来,在睡眠的过程中线程B也进来了
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"卖出了一张票,剩余"+(--count)+"张");
				}else {
					return;
				}
			}
		}
	}

	
}
