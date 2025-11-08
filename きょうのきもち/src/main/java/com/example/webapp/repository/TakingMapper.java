package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Taking;

@Mapper
public interface TakingMapper {
	
	void insert(Taking taking);
	void insertTaking(Taking taking);
	List<Taking> selectTaken(Integer takingId);

}
