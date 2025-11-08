package com.example.webapp.helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;
import com.example.webapp.form.PostForm;
import com.example.webapp.utility.LoginAccount;

public class PostHelper {
	
	public static Diary convert(PostForm form, LocalDate localDate) {
		Diary diary = new Diary();
		diary.setFeeling(form.getFeeling());
		diary.setText(form.getText());
		diary.setDate(localDate);
		diary.setAccountId(LoginAccount.id);
		return diary;
	}
	
	public static List<Scope> convertToScope(PostForm form, List<Group> groups, Integer diaryId){
		List<Scope> scopes = new ArrayList<>();
		for(Group group: groups) {
			Scope scope = new Scope();
			scope.setDiaryId(diaryId);
			scope.setGroupId(group.getId());
			scope.setSetting(form.getGroupIds().contains(group.getId()));
			scopes.add(scope);
		}
		return scopes;
	}

}
