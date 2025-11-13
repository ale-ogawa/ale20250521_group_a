package com.example.webapp.service;

import com.example.webapp.entity.Reaction;

public interface ReactionService {

	Reaction findMyReaction(Integer diaryId);
	void insertReaction(Reaction reaction);
	void updateReaction(Reaction reaction);

}
