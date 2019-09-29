package cn.yunhe.service.impl;

import java.util.List;

import cn.yunhe.dao.MotifDao;
import cn.yunhe.dao.impl.MotifDaoImpl;
import cn.yunhe.entity.Motif;
import cn.yunhe.service.MotifService;

public class MotifServiceImpl implements MotifService {
	
	MotifDao motifDao = new MotifDaoImpl(); 

	@Override
	public List<Motif> queryMotifList() {
		return motifDao.queryMotifList();
	}

	@Override
	public Motif queryMotifById(int id) {
		return motifDao.queryMotifById(id);
	}

	@Override
	public int setMotifById(int state,int id) {
		return motifDao.setMotifById(state,id);
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
