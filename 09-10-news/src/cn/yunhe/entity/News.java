/**
 * 
 */
package cn.yunhe.entity;
/**
 * @author 魏无羡 
 *2019年9月10日
 *	新闻实体类
 */

import java.sql.Date;

public class News {
	private int nid;
	private String title;
	private String content;
	private Date sendtime;
	private int sid;
	public News() {}
	public News(int nid, String title, String content, Date sendtime, int sid) {
		super();
		this.nid = nid;
		this.title = title;
		this.content = content;
		this.sendtime = sendtime;
		this.sid = sid;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", content=" + content + ", sendtime=" + sendtime + ", sid="
				+ sid + "]";
	}
	
	
}
