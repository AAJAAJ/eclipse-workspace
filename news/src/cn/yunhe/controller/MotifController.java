package cn.yunhe.controller;

import java.util.List;

import cn.yunhe.entity.Motif;
import cn.yunhe.service.MotifService;
import cn.yunhe.service.impl.MotifServiceImpl;

public class MotifController {

	MotifService motifService = new MotifServiceImpl();
	
	public List<Motif> queryMotifList() {
		return motifService.queryMotifList();
	}

	public Motif queryMotifById(int id) {
		return motifService.queryMotifById(id);
	}
	public int setMotifById(int state,int id) {
		return motifService.setMotifById(state,id);
	}
	public int delMotifById(int id) {
		return motifService.delMotifById(id);
	}

	public int addMotif(Motif motif) {
		return motifService.addMotif(motif);
	}
	
}
