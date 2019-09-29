/**
 * 
 */
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月28日 下午1:58:59
 */
public class IOStream {
	
	@Test
	public void write(){
		OutputStream os = null;
		try {
			os = new FileOutputStream("e:Streamtest.txt");
			
				os.write(98);
				os.write("王傲".getBytes());
				
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void read() throws IOException {
		InputStream in = new FileInputStream("e:/file.txt");
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		
	}
	
	@Test
	public void read2() throws IOException {
		InputStream in = new FileInputStream("e:/file.txt");
		byte[] hcq = new byte[2];
		while(in.read(hcq)!=1) {
			System.out.println(new String(hcq,"gbk"));
		}
		in.close();
	}
	
	
	@Test
	public void read3() throws IOException {
		InputStream in = new FileInputStream("e:/file.txt");
		byte[] hcq = new byte[4];
		
		in.read(hcq,0,4);
		
		System.out.println(new String(hcq,"gbk"));
	
		in.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
