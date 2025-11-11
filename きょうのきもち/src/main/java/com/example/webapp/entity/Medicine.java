package com.example.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
	private Integer id;
	private String name;
	private String effect;
	private String quantity;
	private String type;
	private String sideEffect;

}
