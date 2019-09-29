package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Order;

public interface IOrderDao {

	/**
	 * 查询所有的订单信息
	 * @return
	 */
	List<Order> queryOrderInfos();
}
