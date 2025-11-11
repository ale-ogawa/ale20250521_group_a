package com.example.webapp.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CalendarForm {
	private Integer year;
	private Integer month;
	private LocalDate date;
}
