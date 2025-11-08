package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Scope;

@Mapper
public interface PostMapper {
	
	void insertDiary(Diary diary);
	void insertScope(List<Scope> scopes);
	void updateDiary(Diary diary);
	void updateScope(List<Scope> scopes);

}
