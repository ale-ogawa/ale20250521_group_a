package com.example.webapp.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Diary;
import com.example.webapp.form.CalendarForm;
import com.example.webapp.service.AccountService;
import com.example.webapp.service.DiaryService;
import com.example.webapp.utility.DateContainer;
import com.example.webapp.utility.ImagesPath;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CallendarController {
	
	private final DiaryService diaryService;
	private final AccountService accountService;
	int year;
	int month;
	YearMonth yearMonth;
	boolean isSelected;
	
	@GetMapping
    public String calendar(Model model, CalendarForm form) {
		if(isSelected) {
			isSelected = false;
		}else {
			yearMonth = YearMonth.from(LocalDate.now());
		}
		
		form.setYear(yearMonth.getYear());
		form.setMonth(yearMonth.getMonthValue());
		model.addAttribute("calendarForm", form);
		
        List<Diary> diaries = diaryService.findFeelings(yearMonth);
        model.addAttribute("diaries", diaries);
        Account account;
        if(LoginAccount.attribute) {
        	account = accountService.getNickname(LoginAccount.id);
        }else {
        	account = accountService.getNickname(LoginAccount.followId);
        }
        model.addAttribute("nickname", account.getNickname());
        model.addAttribute("images", ImagesPath.images);
        
        return "calendar";
    }
	
	@PostMapping
	public String calendar(CalendarForm form) {
        year = form.getYear();
        month = form.getMonth();
        yearMonth = YearMonth.of(year, month);
        isSelected = true;
        System.out.println(yearMonth);
		return "redirect:/calendar";
	}
	
	@PostMapping("/toHome")
	public String calendarToHome(CalendarForm form) {
		DateContainer.calendarFlag = true;
		DateContainer.date = form.getDate();
		System.out.println(DateContainer.date);
		return "redirect:/";
	}

}
