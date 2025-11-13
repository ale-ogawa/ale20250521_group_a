package com.example.webapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Reaction;
import com.example.webapp.repository.ReactionMapper;
import com.example.webapp.service.ReactionService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {
	
	private final ReactionMapper reactionMapper;

	@Override
	public Reaction findMyReaction(Integer diaryId) {
		return reactionMapper.findMyReaction(diaryId, LoginAccount.id);
	}

	@Override
	public void insertReaction(Reaction reaction) {
		reactionMapper.insertReaction(reaction);
	}

	@Override
	public void updateReaction(Reaction reaction) {
		reactionMapper.updateReaction(reaction);
	}

}
