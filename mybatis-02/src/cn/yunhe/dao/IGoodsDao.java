package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.Goods;

public interface IGoodsDao {

	/**
	 * �����������Ʒ��Ϣ���в�ѯ
	 * 	��Ʒ���� ��Ʒ�ļ۸� ��ƷID������
	 */
	List<Goods> queryGoods(Goods goods) ;
}
