package cn.yunhe.entity;

import java.util.Date;

/**
 * 回帖实体类
 */
public class Reply {

	/**
	 * 回帖ID
	 */
	private int rid;
	/**
	 * 回帖标题
	 */
	private String title;
	/**
	 * 回帖内容
	 */
	private String context;
	/**
	 * 回帖时间
	 */
	private Date rtime;
	/**
	 * 主贴ID
	 */
	private int tid;
	/**
	 * 回帖人ID
	 */
	private int uid;
	
	public Reply() {}
	
	public Reply(int rid, String title, String context, Date rtime, int tid, int uid) {
		super();
		this.rid = rid;
		this.title = title;
		this.context = context;
		this.rtime = rtime;
		this.tid = tid;
		this.uid = uid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public Date getRtime() {
		return rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", title=" + title + ", context=" + context + ", rtime=" + rtime + ", tid=" + tid
				+ ", uid=" + uid + "]";
	}
	
}
