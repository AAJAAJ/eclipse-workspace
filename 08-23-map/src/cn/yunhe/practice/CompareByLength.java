package cn.yunhe.practice;

import java.util.Comparator;

public class CompareByLength implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String str1 = (String)o1;
		String str2 = (String)o2;
		int len = str1.length()-str2.length();
		if(len == 0) {
			int result = str1.compareTo(str2);
			return result;
		}
		return len;
	}

}
