package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月21日 下午3:20:08
 */
public class day0821 {

	public static void main(String[] args) {
		Homework1_1();
//		Homework1();
//		Homework2();
	}
	
	public static Collection add() {

		Collection coll = new ArrayList();
		coll.add("c");
		coll.add("3");
		coll.add("a");
		coll.add("a");
		coll.add("c");
		coll.add(3);
		coll.add("a");
		coll.add("bre");
		coll.add("a");
		System.out.println(coll);
		return coll;
	}
	
	//作业1 指定一个集合,去除集合中的重复元素,并打印结果
	public static void Homework1() {

		Collection coll = add();
		
		//定义一个数组用来记录重复的元素
		String[] chongfu = new String[coll.size()];
		//用来记录通过判断的j，使重复的元素相同下标只写入一次
		int k = 999;
		//for循环的i
		int i = 0;
		//定义数组下标
		int index = 0;
		//迭代器循环，仿双层for循环
		for (Iterator it = coll.iterator();it.hasNext();) {
			//内层for循环的j
			int j = 0;
			//获取每一个元素，强转string形好比较
			String a = it.next().toString();
			//内层for循环
			for (Iterator it1 = coll.iterator();it1.hasNext();) {
				//内循环获取每一个元素，强转string，用来与每个元素作比较
				String b = it1.next().toString();
				if (j > i && a.equals(b)) {
					System.out.println(i+"下标  "+a+" 与"+j+"下标  "+b+" 重复          上次记录的下标"+k);
					//如果多个重复，不重复加入相同下标
					if (k != i) {
						chongfu[index] = b;
					}
					k = i;
					index++;
				}
				j++;
			}
			i++;
		}
		System.out.println("删除重复……");
		for (int j = 0; j < chongfu.length; j++) {
			String a = chongfu[j];
			coll.remove(a);
		}
		System.out.println(coll);
	}
	
	//作业2数组是否可以转换为集合?如果可以,怎么转换?
	public static void Homework2(Object[] arr) {
		
		Collection coll1 = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			coll1.add(arr[i]);
		}
		System.out.println("数组转集合");
		System.out.println("转换后集合"+coll1);
	}
	public static void Homework1_1() {
		Collection coll = add();
		Object[] objArr = coll.toArray();
//		System.out.print("原数组为:");
//        for(Object a:objArr){
//            System.out.print(","+a);
//        }
		for (int i = 0; i < objArr.length; i++) {
			for (int j = i+1; j < objArr.length; j++) {
				if (objArr[i] == objArr[j]) {
					System.out.println(i+"下标"+objArr[i]+"与"+j+"下标"+objArr[j]+"重复");
					
				}
			}
		}
		for (int i = 0; i < objArr.length; i++) {
			System.out.println(objArr[i]);
		}
		

		
		
		
		
		
	}
    public static Object[] delete(int index, Object array[]) {
        //数组的删除其实就是覆盖前一位
    	Object[] arrNew = new Object[array.length - 1];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        System.arraycopy(array, 0, arrNew, 0, arrNew.length);
        return arrNew;
    }
	
}
