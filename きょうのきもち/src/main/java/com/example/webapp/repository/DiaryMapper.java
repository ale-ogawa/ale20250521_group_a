package com.example.webapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.DailyReaction;
import com.example.webapp.entity.DailyTaking;
import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;

@Mapper
public interface DiaryMapper {
	
	List<Scope> findLatestScopes(Integer accountId);
	Diary findToday(LocalDate localDate, Integer accountId);
	List<Scope> findScopes(Integer diaryId);
	List<Group> findGroups(Integer accountId);
	List<DailyTaking> findTodaysTaking(LocalDate localDate, Integer accountId);
	List<Diary> findFeelings(LocalDate firstDay, LocalDate lastDay);
	List<DailyReaction> findReactions(Integer diaryId, Integer accountId);
	boolean findVisible(Integer diaryId, Integer groupId);

}
