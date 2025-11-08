package com.example.webapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.DailyReaction;
import com.example.webapp.entity.DailyScope;
import com.example.webapp.entity.DailyTaking;
import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Reaction;
import com.example.webapp.entity.Scope;
import com.example.webapp.form.PostForm;
import com.example.webapp.form.ReactionForm;
import com.example.webapp.helper.PostHelper;
import com.example.webapp.helper.ReactionHelper;
import com.example.webapp.service.DiaryService;
import com.example.webapp.service.PostService;
import com.example.webapp.service.ReactionService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
	
	private final DiaryService diaryService;
	private final PostService postService;
	private final ReactionService reactionService;
	
	LocalDate localDate;
	boolean isTodaysNewPost;
	boolean isTodaysNewReaction;
	Diary diary;
	Reaction reaction;
	List<Scope> scopes;
	List<Group> groups;
	List<DailyReaction> dailyReactions;
	List<DailyScope> dailyScopes;
	List<DailyTaking> dailyTakings;
	
	@GetMapping
	public String home(Model model, PostForm form) {
		localDate = LocalDate.now();
		dailyReactions = new ArrayList<>();
		
		//その日の投稿内容を取得
		diary = diaryService.findToday(localDate);
		
		//その日の初投稿の場合
		if(diary == null) {
			isTodaysNewPost = true;
			//今日の日付だけセット
			diary = new Diary();
			diary.setDate(localDate);
			//直近の公開設定を取得
			scopes = diaryService.findLatestScopes();
		}
		//その日投稿済みの場合
		else {
			isTodaysNewPost = false;
			//scopesテーブルから、日記IDが一致するレコードを取得
			scopes = diaryService.findScopes(diary.getId());
			//フォロワー全員のリアクションを取得
			dailyReactions = diaryService.findReactions(diary.getId());
		}
		
		//フォロワー自身のリアクションを取得
		reaction = reactionService.findMyReaction(diary.getId());
		if(reaction == null) {
			isTodaysNewReaction = true;
			reaction = new Reaction();
		}else {
			isTodaysNewReaction = false;
		}
		
		//groupsテーブルから、作成者IDが一致するグループのリストを取得
		groups = diaryService.findGroups();
		//groupsとscopesから、公開設定オブジェクトを作成
		dailyScopes = diaryService.makeDailyScopes(groups, scopes);
		
		//その日の服薬情報を取得
		dailyTakings = diaryService.findTodaysTaking(localDate) ;
		
		model.addAttribute("diary", diary);
		model.addAttribute("reaction", reaction);
		model.addAttribute("dailyReactions", dailyReactions);
		model.addAttribute("dailyScopes", dailyScopes);
		model.addAttribute("dailyTakings", dailyTakings);
		model.addAttribute("isPatient", LoginAccount.attribute);
		
		return "home";
	}
	
	@GetMapping("post")
	public String post(Model model, PostForm form) {
		model.addAttribute("diary", diary);
		model.addAttribute("dailyReactions", dailyReactions);
		model.addAttribute("dailyScopes", dailyScopes);
		model.addAttribute("dailyTakings", dailyTakings);
		return "post";
		
	}
	
	@PostMapping("post")
	public String post(PostForm form) {
		//diariesテーブルに格納する情報をセット
		Diary diary = PostHelper.convert(form, localDate);
		
		if(isTodaysNewPost) {
			//diariesテーブルにレコードを登録
			postService.insertDiary(diary);
			//scopesテーブルにレコードを登録
			scopes = PostHelper.convertToScope(form, groups, diary.getId());
			postService.insertScope(scopes);
			
			isTodaysNewPost = false;
		}else {
			//diariesテーブルのレコードを更新
			postService.updateDiary(diary);
			//scopesテーブルのレコードを更新
			scopes = PostHelper.convertToScope(form, groups, diary.getId());
			postService.updateScope(scopes);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("reaction")
	public String reaction(Model model, ReactionForm form) {
		model.addAttribute("diary", diary);
		model.addAttribute("dailyTakings", dailyTakings);
		model.addAttribute("reaction", reaction);
		return "reaction";
	}
	
	@PostMapping("reaction")
	public String reaction(ReactionForm form) {
		if(isTodaysNewReaction) {
			Reaction reaction = ReactionHelper.convert(form, diary.getId());
			reactionService.insertReaction(reaction);
			
			isTodaysNewReaction = false;
		}else {
			Reaction reaction = ReactionHelper.convert(form, diary.getId());
			reactionService.updateReaction(reaction);
		}
		return "redirect:/";
	}
	
}
