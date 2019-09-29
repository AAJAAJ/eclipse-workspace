/**
 * 
 */
package cn.yunhe.control;
/**
 * @author 魏无羡 
 *2019年9月11日
 */

import java.util.List;

import cn.yunhe.entity.Subject;
import cn.yunhe.server.SubjectServer;
import cn.yunhe.server.imp.SubjectServerImp;

public class SubjectControl {
	SubjectServer ss = new SubjectServerImp();
	/**
	 * 	查询所有主题
	 */
	public List<Subject> selectList(){
		return ss.selectlList();
	}
	/**
	 * 	查询一个主题
	 */
	public Subject selectSubject(int id) {
		return ss.selectSubject(id);
	}
	/**
	 * 	添加主题
	 */
	public int addSubject(String title) {
		return ss.addSubject(title);
	}
	/**
	 * 	修改主题状态
	 */
	public int noSubject(int state,int id) {
		return ss.noSubject(state,id);
	}
	/**	
	 * 	修改主题名
	 */
	public int delSubject(int id) {
		return ss.delSubject( id);
	}
	/**
	 * 	获取主题总数
	 */
	public int sumPage() {
		return ss.sumPage();
	}
	/**
	 * 	分页查询
	 */
	public List<Subject> selectPage(int pageCount, int pageIndex) {
		return ss.selectPage(pageCount, pageIndex);
	}
}
