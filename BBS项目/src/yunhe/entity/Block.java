/**
 * 
 */
package yunhe.entity;

/**
 * @author 性感渣渣傲在线打bug 2019年9月2日 上午11:49:16 对应block表的实体类
 */
public class Block {

	/**
	 * 版块ID
	 */
	private int bid;
	/**
	 * 版块名字
	 */
	private String bname;

	public Block() {
	}

	public Block(int bid, String bname) {
		super();
		this.bid = bid;
		this.bname = bname;
	}

	public synchronized int getBid() {
		return bid;
	}

	public synchronized void setBid(int bid) {
		this.bid = bid;
	}

	public synchronized String getBname() {
		return bname;
	}

	public synchronized void setBname(String bname) {
		this.bname = bname;
	}

	@Override
	public String toString() {
		return "Block [bid=" + bid + ", bname=" + bname + "]";
	}

}
