package com.example.webapp.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
	private List<Integer> diseaseIds;
	private Integer accountId;
	
}
