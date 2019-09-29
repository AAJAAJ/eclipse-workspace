/**
 * 
 */
package pet;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年8月19日 下午3:04:34
 */
import java.sql.*;


class DBConnection{
	    
//	    驱动类名
	    String driver="com.mysql.jdbc.Driver";
//	    URL格式,最后为数据库名
	    String url="jdbc:mysql://10.50.5.188:3306/pet";
	    String user="root";
	    String password="123456";
	    Connection  coon=null;
	    public DBConnection(){
	        try{
//	            加载驱动程序
	            Class.forName(driver);
	            coon=(Connection)DriverManager.getConnection(url,user,password);
	            if(!coon.isClosed()){
	                System.out.println("成功连接数据库！");
	            } 
	        }catch (Exception e){
	                e.printStackTrace();
	            }
	    }
	    public void close(){
	        try{
	            this.coon.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
//	    增加数据
	    public void add(String name){

	        String sql="insert into petdata(name) values('"+name+"')";
	        
	        try{
	            PreparedStatement preStmt=(PreparedStatement)this.coon.prepareStatement(sql);
	            preStmt.executeUpdate();
	            System.out.println("插入数据成功！");
	            preStmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
//	    查询
	    public void select(){
	        String sql="select * from petdata";//查询usrInfo表中的信息
	        
	        try{
	            Statement stmt=(Statement)this.coon.createStatement();
	            ResultSet rs=(ResultSet)stmt.executeQuery(sql);//得到的是结果的集合
	            System.out.println("--------------------------------");
	            System.out.println("id"+"\t"+"姓名"+"\t"+"性别"+"\t"+"级别"+"\t"+"经验");
	            System.out.println("--------------------------------");
	            while(rs.next()){
	            	int id=rs.getInt("id");
	                String name=rs.getString("name");
	                int lv=rs.getInt("lv");
	                String gender=rs.getString("gender");
	                int ex=rs.getInt("experience");
	                System.out.println(id+"\t"+name+"\t"+gender+"\t"+lv+"\t"+ex);
	            }
	            stmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
//	    更改数据
	    
	    public void update(String name,int id){
	        String sql="update petdata set name=? where id=?";
	        try{
	            PreparedStatement prestmt = (PreparedStatement)this.coon.prepareStatement(sql);
	            prestmt.setString(1,name);
	            prestmt.setInt(2, id);
	            prestmt.executeUpdate();
	            
	            System.out.println("更改数据成功！");
	            prestmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
//	    删除数据
	    public void del(String name){
	        String sql="delete from petdata where name=?";
	        try{
	            PreparedStatement prestmt=(PreparedStatement)this.coon.prepareStatement(sql);
	            prestmt.setString(1, name);
	            prestmt.executeUpdate();
	            System.out.println("删除数据成功！");
	            prestmt.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	}

