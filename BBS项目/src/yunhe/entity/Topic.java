/**
 * 
 */
package yunhe.entity;

import java.util.Date;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月2日 上午11:49:41
 */
public class Topic {

	/**
	 *主帖ID
	 */
	private int tid;
	/**
	 *主帖标题
	 */
	private String title;
	/**
	 *主帖内容
	 */
	private String context;
	/**
	 *发帖时间
	 */
	private Date ttime;
	/**
	 *发帖人
	 */
	private int uid;
	/**
	 *所属版块
	 */
	private int bid;
	
	
	public Topic() {}

	public Topic(int tid, String title, String context, Date ttime, int uid, int bid) {
		super();
		this.tid = tid;
		this.title = title;
		this.context = context;
		this.ttime = ttime;
		this.uid = uid;
		this.bid = bid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getTtime() {
		return ttime;
	}

	public void setTtime(Date ttime) {
		this.ttime = ttime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Topic [tid=" + tid + ", title=" + title + ", context=" + context + ", ttime=" + ttime + ", uid=" + uid
				+ ", bid=" + bid + "]";
	}
}
