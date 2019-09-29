/**
 * 
 */
package test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月28日 下午2:35:57
 */
public class IOCharTest {

	@Test
	public void write() throws IOException {
		Writer writer = new FileWriter(new File("e:/writer.txt"));
		writer.write("王傲是傻批");
		writer.close();
	}
	
	@Test
	public void read() throws IOException {
		Reader reader = new FileReader(new File("e:/writer.txt"));
		char[] cbuf = new char[100];
		while(reader.read(cbuf)!=-1) {
			System.out.println(cbuf);
		}
		reader.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
