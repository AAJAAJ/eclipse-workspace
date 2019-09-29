/**
 * 
 */
package cn.yunhe.entity;

/**
 * @author 性感渣渣傲在线打bug
 * 2019年9月25日 下午5:28:15
 */
public class Product {
	private int proid;
	private String proname;
	private String proprice;
	private String proaddress;

/**
 * 
 */
public Product() {
	// TODO Auto-generated constructor stub
}

/**
 * @param proid
 * @param proname
 * @param proprice
 * @param proaddress
 */
public Product(int proid, String proname, String proprice, String proaddress) {
	super();
	this.proid = proid;
	this.proname = proname;
	this.proprice = proprice;
	this.proaddress = proaddress;
}

/**
 * @return the proid
 */
public synchronized int getProid() {
	return proid;
}

/**
 * @param proid the proid to set
 */
public synchronized void setProid(int proid) {
	this.proid = proid;
}

/**
 * @return the proname
 */
public synchronized String getProname() {
	return proname;
}

/**
 * @param proname the proname to set
 */
public synchronized void setProname(String proname) {
	this.proname = proname;
}

/**
 * @return the proprice
 */
public synchronized String getProprice() {
	return proprice;
}

/**
 * @param proprice the proprice to set
 */
public synchronized void setProprice(String proprice) {
	this.proprice = proprice;
}

/**
 * @return the proaddress
 */
public synchronized String getProaddress() {
	return proaddress;
}

/**
 * @param proaddress the proaddress to set
 */
public synchronized void setProaddress(String proaddress) {
	this.proaddress = proaddress;
}

@Override
public String toString() {
	return "Product [proid=" + proid + ", proname=" + proname + ", proprice=" + proprice + ", proaddress=" + proaddress
			+ "]";
}

}
