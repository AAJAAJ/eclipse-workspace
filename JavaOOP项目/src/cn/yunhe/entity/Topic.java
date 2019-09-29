package cn.yunhe.entity;

import java.util.Date;

/**
 * 主贴实体类
 */
public class Topic {

	private int tid;
	
	private String title;
	
	private String context;
	
	private Date ttime;
	
	private int uid;
	
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
