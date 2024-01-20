package com.demo.service;

import java.util.List;

import com.demo.model.Cable;

public interface CableService {

	List<Cable> getCables();

	void addCable(Cable c);

	void deleteByCustId(int custid);

	Cable getCable(int custid);

	void updateCable(Cable s);

	Cable getDataByCustId(int custid);





}
