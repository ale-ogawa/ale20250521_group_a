package com.example.webapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webapp.entity.Account;
import com.example.webapp.entity.Group;
import com.example.webapp.form.GroupForm;
import com.example.webapp.helper.GroupHelper;
import com.example.webapp.service.GroupService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/setting/group")
@RequiredArgsConstructor
public class GroupController {
	
	private final GroupService groupService;
	List<Account> accounts;
	List<Group> groups;
	
	@GetMapping
    public String group(Model model, GroupForm form) {
		accounts = groupService.selectAccounts();
		groups = groupService.selectGroups();
		model.addAttribute("accounts", accounts);
		model.addAttribute("groups", groups);
        return "group";
    }
	
	@PostMapping
	public String group(GroupForm form) {
		groupService.changeName(form);
		return "redirect:/setting/group";
	}
	
	@GetMapping("/edit")
	public String edit(Model model, GroupForm form) {
		model.addAttribute("accounts", accounts);
		model.addAttribute("groups", groups);
		return "group_edit";
	}
	
	@PostMapping("/edit")
	public String edit(GroupForm form, @RequestParam(required = false) Integer id) {
		if(id != null) {
			groupService.delete(id);
		}else {
			Group group = GroupHelper.convert(form);
			groupService.insertGroup(group);
		}
		groups = groupService.selectGroups();
		return "redirect:/setting/group/edit";
	}

	@GetMapping("/member")
	public String member(Model model, GroupForm form) {
		model.addAttribute("accounts", accounts);
		model.addAttribute("groups", groups);
		return "group_member";
	}
	
	@PostMapping("/member")
	public String member(GroupForm form) {
		groupService.updateGroup(form);
		accounts = groupService.selectAccounts();
		return "redirect:/setting/group/member";
	}
	
}
