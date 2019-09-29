/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @author 性感渣渣傲在线打bug 2019年8月22日 下午7:19:57
 */
public class Day0822_2 {

	public Set addSet() {
		Set set = new HashSet();
		set.add("wangao");
		set.add("杨航");
		set.add("machong");
		set.add("杨航");
		set.add("马冲");
		set.add("machong");
		set.add("yanghang");
		System.out.println("无序集合" + set);
		return set;
	}
	@Test
	public void sortMethod() {
		Set set = addSet();
		
		
		 Set<String> sortSet = new TreeSet(new Comparator<String>() {
	            @Override
	            public int compare(String o1, String o2) {
	            	int len1 = o1.length();
					int len2 = o2.length();
					
					int result = len1 - len2;
					return result;
	            }
	        });
	        sortSet.addAll(set);
	        System.out.println("排序后"+sortSet);
		
	}

	
	
}
