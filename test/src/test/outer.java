/**
 * 
 */
package test;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月20日 上午10:53:02
 */
public class outer {

	public class inner {
		public void innerFun(){
			System.out.println("内部类的方法");
			
		}
	}
	

	public static void outerfun() {
		// TODO Auto-generated method stub
		System.out.println("方法");
		 class innerfuninnerclass {
		
			public void innerfuninnerclassfun() {
				System.out.println("方法中内部类中的方法");

			}
		}
	}
	
	
	
}
