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
 * 常见的数据传输方式
 * json于xml的区别:
 * 	数据体积方面，JSON相对XML来讲，数据的体积小，传递的速度更快些
	数据交互方面，JSON与JavaScript的交互更加方便，更容易解析处理，更好地进行数据交互
	数据描述方面，JSON对数据的描述性比XML较差
	传输速度方面，JSON的速度要远远快于XML
	
	需求:解析xml文件,获取Student的实例对象
	思路:
		1 解析xml文件,找到bean标签
		2 找到class属性
		3 获取class属性对应的值
		4 反射
		5 获取实例对象
	
	流程:
		1 创建生成DOM解析器的工厂对象
		2 通过工厂对象创建解析DOM文件的文档实例API
		3 通过文档实例解析指定的xml文件获取对应文件的DOM对象
		4 使用DOM对象获取xml中的指定节点
		5 通过获取的节点集合查找指定节点的键值对
		6 获取对应的键或值
		7 通过获取到的class路径值进行反射获取对应的实体类对象
		8 使用实体类对象进行数据操作
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
