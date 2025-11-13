package com.example.webapp.form;

import java.time.LocalDate;
import java.util.List;

import com.example.webapp.entity.Group;

import lombok.Data;

@Data
public class HomeForm {
	//日記ID
	private Integer id;
	//気分
	private Integer feeling;
	//本文
	private String text;
	//日付
	private LocalDate date;
	//グループ
	private List<Group> groups;
	//公開
	private List<Integer> groupIds;
}
