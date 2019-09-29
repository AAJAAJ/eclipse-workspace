package cn.yunhe.controller;

import java.util.ArrayList;
import java.util.List;

import cn.yunhe.bean.Person;
import cn.yunhe.bean.Student;
import cn.yunhe.bean.Teacher;
import cn.yunhe.constant.URLConstant;
import cn.yunhe.test.Result;

/**
 * 学生类控制层
 * 
 * 需求:获取学生信息列表并打印出来
 */
public class StudentController {

	/**
	 * 查询学生信息列表是要返回数据和状态
	 * @return
	 */
	public Result<?> queryStus(){
		Result<Student> result = new Result<Student>();
		//假设该集合是要返回的数据
		List<Student> data = new ArrayList<>();
		data.add(new Student("张三",20,123465));
		data.add(new Student("张三",21,123467));
		data.add(new Student("张三",22,123468));
		
		//封装返回值数据
		return Result.success(data);
	}
	
	/**
	 * 添加学生
	 * @return
	 */
	public Result<?> addStu(){
		//模拟从前台获取到的数据
		Student stu = new Student("李四",22,7895446);
		//此处调用SQL语句添加数据,返回结果为1代表成功,0代表失败
		int result = 1;
		Result<Student> stuResult = new Result<Student>();
		stuResult.setCode(200);
		stuResult.setMsg("success");
		String url = URLConstant.BASE_URL+"/info/queryStus";
		return stuResult;
	}
	
	public static void main(String[] args) {
		//调用查询数据的方法
		/*
		 * Result<?> result = new StudentController().queryStus(); List<Student> stuList
		 * = (List<Student>) result.getData(); for(Student stu : stuList) {
		 * System.out.println(stu); }
		 */
		
		/*
		 * //调用添加数据的方法 Result<?> result = new StudentController().addStu();
		 * System.out.println(result.getCode()+"--"+result.getMsg());
		 */
		
		/*
		 * final Student stu1 = new Student(); Student stu2 = new Student();
		 * stu1.setName("张三");
		 */
		//final修饰对象,地址不可变,内容可变
		//stu1 = stu2;
		
		final String str = "bcd";
		
		Student stu = new Student();
		stu.eat();
		Teacher tea = new Teacher();
		tea.eat();
		
		eatMethod(stu);
	}
	
	public static void eatMethod(Person person) {
		person.eat();
	}
}
