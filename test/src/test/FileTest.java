/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月28日 上午10:09:34
 */
public class FileTest {
	@Test
	public void createFile() throws IOException {
		File file = new File("e:/file.txt");
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
	}
	@Test
	public void readWrite() {
		File file = new File("e:/file.txt");
		System.out.println("可读"+file.canRead());
		System.out.println("可写"+file.canWrite());
	}
	
	@Test
	public void getPath() {
		File file = new File("e:/file.txt");
		System.out.println(file.getAbsolutePath());
		
		System.out.println(file.getPath());
		
		System.out.println(file.getName());
		
		System.out.println(file.length());
		
	}
	
	@Test
	public void printFiles() {
		File file = new File("c:");
		String[] files = file.list();
		for(String str : files) {
			System.out.println(str);
		}
	}

	@Test
	public void printFiles2() {
		File file = new File("C:");
		//获取指定根目录下的所有文件
		File[] files = file.listFiles();
		for(File f : files) {
			System.out.println(f);
		}
	}
	
	public void print(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					print(f.getPath());
				}else {
					System.out.println(f.getPath());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String path = "E:";
		new FileTest().print(path);
	}
	
	@Test
	public void createDirectory() throws IOException {
		File file = new File("E:/test/test2/test3");
		//创建单级目录
		//file.mkdir();
		//创建多级目录
		file.mkdirs();
	}
	
}
