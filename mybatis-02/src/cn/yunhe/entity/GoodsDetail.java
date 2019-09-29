package cn.yunhe.entity;

import java.util.Date;

public class GoodsDetail {
	/**
	 * 商品ID
	 */
	private long goodsId;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品价格
	 */
	private double price;
	
	/**
	 * 商品数量
	 */
	private int count;
	
	/**
	 * 生产日期
	 */
	private Date create_time;
	
	/**
	 * 过期时间
	 */
	private Date expire_time;
	
	public GoodsDetail() {}

	public GoodsDetail(long goodsId, String goodsName, double price, int count, Date create_time, Date expire_time) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
		this.count = count;
		this.create_time = create_time;
		this.expire_time = expire_time;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Date expire_time) {
		this.expire_time = expire_time;
	}

	@Override
	public String toString() {
		return "GoodsDetail [goodsId=" + goodsId + ", goodsName=" + goodsName + ", price=" + price + ", count=" + count
				+ ", create_time=" + create_time + ", expire_time=" + expire_time + "]";
	}
	
}
