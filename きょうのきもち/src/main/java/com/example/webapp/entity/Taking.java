package com.example.webapp.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taking {
	private Integer id;
	private Integer accountId;
	private LocalDateTime time;
	private String name;
	private Integer takingId;
	private Integer medicineId;

}
