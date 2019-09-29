package cn.yunhe.service.impl;

import java.util.List;

import cn.yunhe.dao.IMotifDao;
import cn.yunhe.dao.impl.MotifImpl;
import cn.yunhe.entity.Motif;
import cn.yunhe.service.IMotifService;

public class MotifServiceImpl implements IMotifService {
	
	IMotifDao motifDao = new MotifImpl(); 

	@Override
	public List<Motif> queryMotifList() {
		return motifDao.queryMotifList();
	}

	@Override
	public Motif queryMotifById(int id) {
		return motifDao.queryMotifById(id);
	}

	@Override
	public int delMotifById(int id) {
		return motifDao.delMotifById(id);
	}

	@Override
	public int addMotif(Motif motif) {
		return motifDao.addMotif(motif);
	}

}
