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
	//新闻id
	private int nid;
	
	private String title;
	
	private String content;
	
	private Date time;
	
	private int mid;
	
	public News() {}
	
	public News(int nid, String title, String content, Date time, int mid) {
		super();
		this.nid = nid;
		this.title = title;
		this.content = content;
		this.time = time;
		this.mid = mid;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date sendtime) {
		this.time = sendtime;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", content=" + content + ", sendtime=" + time + ", mid="
				+ mid + "]";
	}
	
	
}
