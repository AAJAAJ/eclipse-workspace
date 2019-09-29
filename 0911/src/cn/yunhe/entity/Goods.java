package cn.yunhe.entity;

public class Goods {

	private int gid;
	private String name;
	private double price;
	public Goods(int gid, String name, double price) {
		super();
		this.gid = gid;
		this.name = name;
		this.price = price;
	}
	
	public Goods() {}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", name=" + name + ", price=" + price + "]";
	}
	
}
