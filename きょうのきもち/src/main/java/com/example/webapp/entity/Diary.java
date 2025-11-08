package com.example.webapp.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
	//日記ID
	private Integer id;
	//投稿者ID
	private Integer accountId;
	//気分
	private Integer feeling;
	//本文
	private String text;
	//日付
	private LocalDate date;

}
