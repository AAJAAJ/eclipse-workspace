/**
 * 
 */
package cn.yunhe.xml;

import java.lang.reflect.Constructor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.yunhe.bean.Student;
/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月27日 上午10:45:57
 */
public class DomParse {
	@Test
	public void parseByDom() throws Exception {
		//DocumentBuilderFactory创建生成DOM解析器的工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//找到对应的xml文件
		String path = "src/Student.xml";
		////获取Document对象--解析xml文件
		Document document = builder.parse(path);
		//获取bean节点
		NodeList nodeList = document.getElementsByTagName("bean");
		//遍历节点集合
		for(int i=0;i<nodeList.getLength();i++) {
			//获取节点对应的node对象
			Node node = nodeList.item(i);
			//获取键值对集合
			NamedNodeMap map = node.getAttributes();
			//获取class属性对应的键值对
			Node namedNode = map.getNamedItem("class");
			//获取class属性对应的值
			String val = namedNode.getNodeValue();
			System.out.println(val);
			if("cn.yunhe.bean.Student".equals(val)) {
				//通过路径进行反射
				Class<Student> cls = (Class<Student>) Class.forName(val);
				Constructor<Student> con = cls.getConstructor(String.class,int.class);
				Student stu = con.newInstance("张三",14);
				System.out.println(stu.getName());
			}
		}
	}
}
