/**
 * 
 */
package cn.yunhe.entity;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月11日 下午12:12:34
 */
public class User {

	private int id;
	private String name;
	private String pwd;

	public User() {}

	/**
	 * @param id
	 * @param name
	 * @param pwd
	 */
	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	/**
	 * @return the id
	 */
	public synchronized int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public synchronized void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public synchronized String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public synchronized void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pwd
	 */
	public synchronized String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public synchronized void setPwd(String pwd) {
		this.pwd = pwd;
	}	
	
	

}
