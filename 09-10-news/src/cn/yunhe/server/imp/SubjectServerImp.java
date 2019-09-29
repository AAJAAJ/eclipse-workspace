/**
 * 
 */
package cn.yunhe.server.imp;

import java.util.List;

import cn.yunhe.dao.SubjectDao;
import cn.yunhe.dao.imp.SubjectDaoImp;
import cn.yunhe.entity.Subject;
import cn.yunhe.server.SubjectServer;

/**
 * @author 魏无羡 
 *2019年9月11日
 */
public class SubjectServerImp implements SubjectServer {
	SubjectDao sd = new SubjectDaoImp();
	/**
	 * 	查询所有主题
	 */
	@Override
	public List<Subject> selectlList() {
		return sd.selectlList();
	}
	/**
	 * 	查询一个主题
	 */
	@Override
	public Subject selectSubject(int id) {
		return sd.selectSubject(id);
	}
	/**
	 * 	添加主题
	 */
	@Override
	public int addSubject(String title) {
		return sd.addSubject(title);
	}
	/**
	 * 	删除主题
	 */
	@Override
	public int noSubject(int state,int id) {
		return sd.noSubject(state,id);
	}
	/**
	 * 	修改主题名
	 */
	@Override
	public int delSubject(int id) {
		return sd.delSbuject( id);
	}
	/**
	 * 	获取主题总数
	 */
	@Override
	public int sumPage() {
		return sd.sumPage();
	}
	/**
	 * 	分页查询
	 */
	@Override
	public List<Subject> selectPage(int pageCount, int pageIndex) {
		return sd.selectPage(pageCount, pageIndex);
	}
}
