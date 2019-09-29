package cn.yunhe.utils;

import java.util.Comparator;

import cn.yunhe.bean.Hero2;

public class CompareBySpeed implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Hero2 hero3 = (Hero2)o1;
		Hero2 hero4 = (Hero2)o2;
		return hero3.getSpeed() - hero4.getSpeed();
	}

}
