package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Order;

public interface IOrderDao {

	/**
	 * ��ѯ���еĶ�����Ϣ
	 * @return
	 */
	List<Order> queryOrderInfos();
}
