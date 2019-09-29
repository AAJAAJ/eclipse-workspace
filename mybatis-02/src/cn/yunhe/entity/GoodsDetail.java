package cn.yunhe.entity;

import java.util.Date;

public class GoodsDetail {
	/**
	 * ��ƷID
	 */
	private long goodsId;
	
	/**
	 * ��Ʒ����
	 */
	private String goodsName;
	
	/**
	 * ��Ʒ�۸�
	 */
	private double price;
	
	/**
	 * ��Ʒ����
	 */
	private int count;
	
	/**
	 * ��������
	 */
	private Date create_time;
	
	/**
	 * ����ʱ��
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
