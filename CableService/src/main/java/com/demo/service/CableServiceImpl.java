package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CableDao;
import com.demo.model.Cable;

@Service
public class CableServiceImpl implements CableService {
	
	
	@Autowired
	private CableDao cdao;

	@Override
	public List<Cable> getCables() {
		
		return cdao.findAll();
	}

	@Override
	public void addCable(Cable c) {
		cdao.save(c);
		
	}

	@Override
	public void deleteByCustId(int custid) {
		cdao.deleteById(custid);
		
	}

	@Override
	public Cable getCable(int custid) {
		
		return cdao.getById(custid);
	}

	@Override
	public void updateCable(Cable s) {
		Cable ns =cdao.getById(s.getCustid());
		ns.setBasepack(s.getBasepack());
		ns.setOptionpack(s.getOptionpack());
	
		
		cdao.save(ns);
		
	}

	@Override
	public Cable getDataByCustId(int custid) {
		
		return cdao.getById(custid);
	}



}
