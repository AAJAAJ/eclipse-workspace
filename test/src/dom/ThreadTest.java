/**
 * 
 */
package dom;


/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月30日 上午11:13:04
 */
public class ThreadTest {

	public static void main(String[] args) {
		
		 ThreadSub ts = new ThreadSub(); 
		 ts.start();
		  
		 ThreadSub ts2 = new ThreadSub();
		 ts2.start();
		 
		RunnableSub rs = new RunnableSub();
		Thread thread = new Thread(rs);
		thread.start();
	}
}
