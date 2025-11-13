package com.example.webapp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Reaction;

@Mapper
public interface ReactionMapper {
	
	Reaction findMyReaction(Integer diaryId, Integer accountId);

	void insertReaction(Reaction reaction);

	void updateReaction(Reaction reaction);

}
