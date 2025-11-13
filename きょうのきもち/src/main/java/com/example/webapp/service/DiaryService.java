package com.example.webapp.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import com.example.webapp.entity.DailyReaction;
import com.example.webapp.entity.DailyScope;
import com.example.webapp.entity.DailyTaking;
import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;

public interface DiaryService {

	List<Scope> findLatestScopes();
	Diary findToday(LocalDate localDate);
	List<Scope> findScopes(Integer diaryId);
	List<Group> findGroups();
	List<DailyScope> makeDailyScopes(List<Group> groups, List<Scope> scopes);
	List<DailyTaking> findTodaysTaking(LocalDate localDate);
	List<Diary> findFeelings(YearMonth yearMonth);
	List<DailyReaction> findReactions(Integer id);
	boolean findVisible(Integer diaryId, Integer groupId);

}
