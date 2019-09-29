package cn.yunhe.entity;

import java.util.Date;
import java.util.List;

/**
 * 一个订单中可以包含多个商品  一对多的关系
 */
public class Order {

	private long oid;
	private Date createTime;
	private List<Goods> goodsList;
	
	public Order() {}

	public Order(long oid, Date createTime, List<Goods> goodsList) {
		super();
		this.oid = oid;
		this.createTime = createTime;
		this.goodsList = goodsList;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
}
