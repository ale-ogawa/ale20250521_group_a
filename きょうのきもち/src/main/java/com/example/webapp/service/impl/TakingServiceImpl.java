package com.example.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Taking;
import com.example.webapp.repository.TakingMapper;
import com.example.webapp.service.TakingService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TakingServiceImpl implements TakingService {
	
	private final TakingMapper takingMapper;

	@Override
	public void insert(Taking taking) {
		takingMapper.insert(taking);
	}

	@Override
	public void insertTaking(Taking taking) {
		takingMapper.insertTaking(taking);
	}

	@Override
	public List<Taking> selectTaken(Integer takingId) {
		return takingMapper.selectTaken(takingId);
	}


}
