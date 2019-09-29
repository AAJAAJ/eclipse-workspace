package cn.yunhe.thread;

/**
 *	进程:
 *		正在运行的一个程序
 *	线程:
 *		进程中的某个执行单元
 *
 *	关系:
 *		一个进程中可以有多个线程
 *		一个线程只存在于某个进程中
 *	线程---Thread
 *	创建线程的两种形式:
 *	方式一:	创建一个类继承Thread类,并重写run方法
 *			run中的任务就是线程要执行任务
 *		问题:为什么要继承Thread类并重写run方法
 *		原因:需要实现特定任务
 *	方式二:
 *		创建一个类实现Runnable接口并重写run方法,关联Thread类开启线程
 *
 *	子类 thread和runnable中都有run方法,为什么执行的是子类中自定义的任务?
 *		因为Thread的run方法中对传进来的任务进行了判断,如果有任务,就执行传递过来的任务,没有就结束
 *		
 *	注意:
 *		默认情况下,线程并没有先后顺序---随机的
 *		如果优先级不同,也不存在先后顺序,优先级的不同只是标注在某个时间点线程的执行次数不同
 */
public class ThreadTest {

	public static void main(String[] args) {
		/*
		 * ThreadSub ts = new ThreadSub(); ts.start();
		 * 
		 * ThreadSub ts2 = new ThreadSub(); ts2.start();
		 */
		
		RunnableSub rs = new RunnableSub();
		Thread thread = new Thread(rs);
		thread.start();
	}
}
