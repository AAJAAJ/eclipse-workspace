/**
 * 
 */
package test;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月31日 下午2:21:51
 */
public class fanshetest implements Runnable{

    private String name;
    private int ticket = 10;
    public fanshetest(String name) {
    	this.name = name;
    }
  public void run(){
    	for(int i=1;i<=10;i++){
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(ticket>0){
    		     System.out.println(name+"卖票:剩余="+--ticket);
    		   }
    	}        
    	}
  
public static void main(String[] args) {
	
	fanshetest demo1 = new fanshetest("线程1");
	
       new Thread(demo1).start();
       new Thread(demo1).start();
       
      
        }
 

}
