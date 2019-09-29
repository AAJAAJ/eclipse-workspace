package cn.yunhe.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws IOException {
		String oldname = "D:/bb.txt";
		String newName = new Date().getTime()+"";
		File file = new File(oldname+newName);
		if(!file.exists()) {
			file.createNewFile();
		}
	}
}
