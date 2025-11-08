package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Scope;

public interface PostService {

	void insertDiary(Diary diary);
	void insertScope(List<Scope> scopes);
	void updateDiary(Diary diary);
	void updateScope(List<Scope> scopes);

}
