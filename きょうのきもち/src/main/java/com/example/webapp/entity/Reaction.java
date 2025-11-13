package com.example.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {
	//リアクションID
	private Integer id;
	//投稿者ID
	private Integer accountId;
	//日記ID
	private Integer diaryId;
	//スタンプ
	private Integer stamp;
	//コメント
	private String comment;

}
