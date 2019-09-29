package cn.yunhe.dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import cn.yunhe.bean.Student;

/**
 * 1 先将jar包导进来
 * 2 指定xml文件的路径
 * 3 解析文件获取对应的document对象
 * 4 获取节点集合
 * 5 遍历获取子节点
 * 6 获取对应的键值对
 * 7 获取指定值的地址
 * 8 反射获取对象
 * 
 * dom解析通过节点名称进行解析
 * dom4j通过节点结构进行解析
 */
public class DomParse {

	@Test
	public void parseBy4J() throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//xml路径
		String path = "src/Student.xml";
		//获取解析对象
		SAXReader reader = new SAXReader();
		//解析对应的xml文件
		Document document = reader.read(new File(path));
		//获取根节点
		Element element = document.getRootElement();
		//获取子节点
		List<Element> elementList = element.elements();
		//遍历子节点
		for(Element el : elementList) {
			//获取属性集合
			List<Attribute> attList = el.attributes();
			for(Attribute att : attList) {
				String key = att.getName();
				String val = att.getValue();
				System.out.println(key+"--"+val);
				if("cn.yunhe.bean.Student".equals(val)) {
					Class<Student> cls = (Class<Student>) Class.forName(val);
					Student stu = cls.newInstance();
					System.out.println(stu.getName()+"--"+stu.getAge());
				}
			}
		}
	}
}
