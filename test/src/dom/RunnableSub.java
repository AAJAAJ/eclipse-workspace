/**
 * 
 */
package dom;



/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月30日 上午11:14:06
 */
public class RunnableSub  implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
	}

	
}
