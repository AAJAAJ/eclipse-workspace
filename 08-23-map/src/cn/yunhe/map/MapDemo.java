package cn.yunhe.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * Map 双列集合<K,V>
 * 1 键不能重复
 * 2 每个键对应一个值
 * 
 * 常用子类:
 * 	HashMap  基于哈希表结构
 * 		允许null值和null键,是不同步的
 * 	TreeMap		基于红黑树结构
 * 		键不能为null,值可以为null
 * 方法:
 * 	添加:
 * 		put(Object K,Object V) putAll(Map<K,V>  map)
 * 	移除:
 * 		remove(Object key)
 * 	获取:
 * 		get(Object key)
 * 	判断:
 * 		containsKey(Object key) containsValue(Object value)
 * 	遍历:
 * 		values()	keySet()	entrySet()
 *  map集合本身并不提供遍历的方式
 */
public class MapDemo {

	public Map putMethod() {
		Map map = new HashMap();
		map.put("name", "张三");
		map.put("age", 12);
		map.put("name", "李四");
		
		System.out.println(map);
		
		Map newMap = new HashMap();
		newMap.put("idCard", "2464864545366");
		newMap.put("age", 13);
		
		map.putAll(newMap);
		
		return map;
	}
	
	@Test
	public void removeMethod() {
		Map map = new HashMap();
		map.put("name", "张三");
		map.put("age", 12);
		map.put("name", "李四");
		
		System.out.println(map);
		
		Map newMap = new HashMap();
		newMap.put("idCard", "2464864545366");
		newMap.put("age", 13);
		
		map.putAll(newMap);
		
		System.out.println(map);
		
		//移除key为age的数据
		map.remove("age");
		
		System.out.println(map);
		System.out.println(map.size());
	}
	
	@Test
	public void getMethod() {
		Map map = putMethod();
		System.out.println(map.get("name"));
	}
	
	@Test
	public void containsMethod() {
		Map map = putMethod();
		System.out.println(map.containsKey("names"));
	}
	
	@Test
	public void eachMethod() {
		Map map = putMethod();
		/*
		 * //拿到map集合中的值的集合 Collection coll = map.values(); //获取迭代器对象 Iterator it =
		 * coll.iterator(); //遍历 while(it.hasNext()) { System.out.println(it.next()); }
		 */
		
		/*
		 * Set set = map.keySet(); Iterator it = set.iterator(); while(it.hasNext()){
		 * Object key = it.next(); System.out.println(map.get(key)); }
		 */
		
		Set<Map.Entry> set = map.entrySet();
		Iterator<Entry> it = set.iterator();
		while(it.hasNext()) {
			//entry对象中包含了获取key,获取value及修改value的方法
			Entry entry = it.next();
			//获取key
			Object key = entry.getKey();
			//获取value
			Object val = entry.getValue();
			
			System.out.println("key:"+key+",value:"+val);
			
			if("name".equals(key)) {
				entry.setValue("张三");
			}
		}
		System.out.println(map.get("name"));
	}
}
