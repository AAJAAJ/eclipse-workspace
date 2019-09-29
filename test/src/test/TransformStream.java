/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月28日 下午3:48:19
 */
public class TransformStream {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);
		
		String result = null;
		
		while ((result=br.readLine())!=null) {
			System.out.println(result);
			if(result.equals("end")) {
				return;
			}
		}
		
	}
}
