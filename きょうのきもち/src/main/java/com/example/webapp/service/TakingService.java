package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.Taking;

public interface TakingService {

	void insert(Taking taking);
	
	void insertTaking(Taking taking);
	
	List<Taking> selectTaken(Integer takingId);
	
	List<Taking> selectTakenAll();

}
