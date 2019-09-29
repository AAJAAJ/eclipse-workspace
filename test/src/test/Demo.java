/**
 * 
 */
package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月20日 下午4:53:23
 */
public class Demo {
	  public static void main(String args[]){
		  Logger logger = null;
	          Logger logger1 = logger.getLogger("Demo");
	          PropertyConfigurator.configure("./src/log4j.propertis");
	          logger1.debug("异常");
	     }
	}
