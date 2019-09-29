/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月28日 下午2:46:57
 */
public class BufferedIIOTest {

	@Test
	public void read() throws IOException {
		FileReader fr = new FileReader("e:/writer.txt");
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("e:/writerCopy.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String result = null;
		
		while((result=br.readLine())!=null) {
			bw.write(result);
		}
		
		br.close();
		fr.close();
		bw.close();
		fw.close();
		
	}
	
	
	
	
	
	
	
	
	
	
}
