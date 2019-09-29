/**
 * 
 */
package cn.yunhe.entity;

import java.util.Date;

/**
 * @author 魏无羡 
 *2019年9月10日
 *	新闻主题实体类
 */
public class Subject {
	private int sid;
	private String title;
	private Date settimeDate;
	private String state;
	public Subject() {}
	/**
	 * @param sid
	 * @param title
	 * @param settimeDate
	 * @param state
	 */
	public Subject(int sid, String title, Date settimeDate, String state) {
		super();
		this.sid = sid;
		this.title = title;
		this.settimeDate = settimeDate;
		this.state = state;
	}
	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the settimeDate
	 */
	public Date getSettimeDate() {
		return settimeDate;
	}
	/**
	 * @param settimeDate the settimeDate to set
	 */
	public void setSettimeDate(Date settimeDate) {
		this.settimeDate = settimeDate;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Subject [sid=" + sid + ", title=" + title + ", settimeDate=" + settimeDate + ", state=" + state + "]";
	}
	
	
	
}
