package com.example.webapp.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyTaking {
	private String medicineName;
	private LocalDateTime takingTime;
	private Integer takingId;
	private Integer medicineId;

}
