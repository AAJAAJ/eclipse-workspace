/**
 * 
 */
package yunhe.factory;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 上午11:36:41
 * 	菜单工厂
 * 	  用于放每个页面的菜单方法
 */
public class MenuFactory {

	//登录菜单
	public void entryMenu() {
		System.out.println("欢迎来BBS论坛");
		System.out.println("-----菜单-----");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("0.退出");
		System.out.println("--------------");
		System.out.println("请输入数字选择");
	}
	//输入有误
	public void error() {
		System.out.println("输入有误，请重新输入");
	}
	//普通用户菜单
	public void userMenu() {
		System.out.println("-----用户菜单-----");
		System.out.println("1.发帖");
		System.out.println("2.看帖");
		System.out.println("0. 返回登录");
		System.out.println("-------------------");
		System.out.println("请选择所需的功能:");
	}
	//管理员菜单
	public void admiMenu() {
		System.out.println("-----管理员菜单-----");
		System.out.println("1.查看用户列表");
		System.out.println("2.修改用户状态");
		System.out.println("3.查看版块");
		System.out.println("4.添加版块");
		System.out.println("5.查看删除主帖");
		System.out.println("6.查看最活跃用户");
		System.out.println("7.查看版块总贴数");
		System.out.println("8.发帖回帖");
		System.out.println("0.返回登录");
		System.out.println("---------------------");
		System.out.println("请选择所需的功能:");
	}
	//选择版块菜单
	public void selectBlock() {
		
	}
	//看帖选单
	public void lookORreply() {
		System.out.println("---------------");
		System.out.println("1.查看所有回复");
		System.out.println("2.回复帖子");
		System.out.println("0.返回上层");
		System.out.println("--------------");
		System.out.println("请选择所需的功能:");
	}
	//封禁用户选项
	public void alterState() {
		System.out.println("---------------");
		System.out.println("0.解封");
		System.out.println("1.封禁");
		System.out.println("0.返回上层");
		System.out.println("--------------");
		
	}
	//删除主帖菜单
	public void removeTopic() {
		System.out.println("---------------");
		System.out.println("1.删除");
		System.out.println("0.返回");
		System.out.println("--------------");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
