package com.example.webapp.form;

import java.util.List;

import lombok.Data;

@Data
public class PostForm {
	//本文
	private String text;
	//気分
	private Integer feeling;
	//公開
	private List<Integer> groupIds;
}
