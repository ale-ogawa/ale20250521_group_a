package com.example.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Scope;
import com.example.webapp.repository.PostMapper;
import com.example.webapp.service.PostService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	
	private final PostMapper postMapper;

	@Override
	public void insertDiary(Diary diary) {
		postMapper.insertDiary(diary);
	}
	
	@Override
	public void insertScope(List<Scope> scopes) {
		postMapper.insertScope(scopes);
	}
	
	@Override
	public void updateDiary(Diary diary) {
		postMapper.updateDiary(diary);
	}
	
	@Override
	public void updateScope(List<Scope> scopes) {
		postMapper.updateScope(scopes);
	}

}
