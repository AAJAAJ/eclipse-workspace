/**
 * 
 */
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月28日 下午4:06:50
 */
public class WriterObject {

	@Test
	public void write() throws IOException {
		OutputStream os = new FileOutputStream("E:/obj.txt");
		ObjectOutputStream ois = new ObjectOutputStream(os);
		ois.writeObject(new Person("张三",15));
		
		ois.close();
		os.close();
	}
	
	@Test
	public void read() throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream("E:/obj.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		Person person = (Person)ois.readObject();
		System.out.println(person);
	}
	
	
	
}
