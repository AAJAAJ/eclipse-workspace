/**
 * 
 */
package cn.yunhe.server;

import java.util.List;

import cn.yunhe.entity.Subject;

/**
 * @author 魏无羡 
 *2019年9月11日
 */
public interface SubjectServer {
	//查询所有主题
	List<Subject> selectlList();
	//查询单个主题
	Subject selectSubject(int id);
	//添加主题
	int addSubject(String title);
	//禁用主题
	int noSubject(int state,int id);
	//删除主题
	int delSubject(int id);
	//获取帖子总条数
		int sumPage();
		//查询一页的主题
		List<Subject> selectPage(int pageCount,int pageIndex );
}
