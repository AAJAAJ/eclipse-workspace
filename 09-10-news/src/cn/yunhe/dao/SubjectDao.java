/**
 * 
 */
package cn.yunhe.dao;
/**
 * @author 魏无羡 
 *2019年9月11日
 *	主题管理
 */

import java.util.List;

import cn.yunhe.entity.Subject;

public interface SubjectDao {
	//查询所有主题
	List<Subject> selectlList();
	//查询单个主题
	Subject selectSubject(int id);
	//添加主题
	int addSubject(String title);
	//修改主题状态
	int noSubject(int state,int id);
	//删除主题
	int delSbuject(int id);
	//获取帖子总条数
	int sumPage();
	//查询一页的主题
	List<Subject> selectPage(int pageCount,int pageIndex );
	
}
