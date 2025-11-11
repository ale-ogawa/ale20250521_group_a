package com.example.webapp.service.impl;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.DailyReaction;
import com.example.webapp.entity.DailyScope;
import com.example.webapp.entity.DailyTaking;
import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;
import com.example.webapp.repository.DiaryMapper;
import com.example.webapp.service.DiaryService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
	
	private final DiaryMapper diaryMapper;
	
	@Override
	public List<Scope> findLatestScopes() {
		return diaryMapper.findLatestScopes(LoginAccount.id);
	}
	
	@Override
	public Diary findToday(LocalDate localDate) {
		if(LoginAccount.attribute) {
			return diaryMapper.findToday(localDate, LoginAccount.id);
		}else {
			return diaryMapper.findToday(localDate, LoginAccount.followId);
		}
	}
	
	@Override
	public List<Scope> findScopes(Integer diaryId) {
		return diaryMapper.findScopes(diaryId);
	}
	
	@Override
	public List<Group> findGroups() {
		return diaryMapper.findGroups(LoginAccount.id);
	}
	
	@Override
	public List<DailyScope> makeDailyScopes(List<Group> groups, List<Scope> scopes) {
		List<DailyScope> dailyScopes = new ArrayList<>();
		for(int i = 0; i < groups.size(); i++) {
			DailyScope dailyScope = new DailyScope();
			dailyScope.setGroupId(groups.get(i).getId());
			dailyScope.setGroupName(groups.get(i).getName());
			dailyScope.setSetting(scopes.get(i).isSetting());
			dailyScopes.add(dailyScope);
		}
		return dailyScopes;
	}
	
	@Override
	public List<DailyTaking> findTodaysTaking(LocalDate localDate) {
		return diaryMapper.findTodaysTaking(localDate, LoginAccount.id);
	}
	
	@Override
	public List<Diary> findFeelings(YearMonth yearMonth) {
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();
		return diaryMapper.findFeelings(firstDay, lastDay);
	}

	@Override
	public List<DailyReaction> findReactions(Integer diaryId) {
		return diaryMapper.findReactions(diaryId, LoginAccount.id);
	}
	

}
