package cn.yunhe.entity;

/**
 * 版块实体类
 */
public class Block {

	/**
	 * 版块ID
	 */
	private int bid;
	/**
	 * 版块名称
	 */
	private String bname;
	
	public Block() {}
	
	public Block(int bid, String bname) {
		super();
		this.bid = bid;
		this.bname = bname;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Override
	public String toString() {
		return "Block [bid=" + bid + ", bname=" + bname + "]";
	}
}
