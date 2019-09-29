package cn.yunhe.entity;

import java.util.Date;
import java.util.List;

public class Order {

	/**
	 * �������
	 */
	private long orderId;
	
	/**
	 * �û�ID
	 */
	private int uid;
	
	/**
	 * ��������ʱ��
	 */
	private Date create_time;
	
	/**
	 * ��Ʒ�б�
	 */
	private List<Goods> goodsList;
	
	public Order() {}

	public Order(long orderId, Date create_time, List<Goods> goodsList) {
		super();
		this.orderId = orderId;
		this.create_time = create_time;
		this.goodsList = goodsList;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
}
