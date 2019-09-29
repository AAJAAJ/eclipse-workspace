package pet;

import java.util.Scanner;

public class test {
	    public static void main(String args[]){
	        Scanner in=new Scanner(System.in);
	        DBConnection db=new DBConnection();
	        
//	        插入数据
//	        System.out.println("输入姓名");
//	        String name=in.next();        
//	        db.add(name);
	        
//	        查询数据
	        db.select();
	        
//	        修改数据
	        System.out.println("输入id");
	        int id = in.nextInt();
	        System.out.println("改为");
	        String name=in.next();
	        db.update(name,id);
	        
	        db.select();
//	        删除数据
	        System.out.println("输入姓名删除");
	        String name2=in.next();
	        db.del(name2);
	        db.select();
	        db.close();
	    }

}
