package com.keep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keep.pojo.Classes;
import com.keep.pojo.Material;
import com.keep.pojo.UserInfo;

@Controller
public class pageController {
	@RequestMapping("{mudle}")
	public String mudle(@PathVariable String mudle) {
		return mudle;
	}
	@RequestMapping("update")
	public String UserUpdate(UserInfo user,Model model) {
		model.addAttribute("user", user);
		return "update";
	}
	@RequestMapping("machine_update")
	public String MachineUpdate(Material material,Model model) {
		model.addAttribute("material", material);
		return "machine_update";
	}
	@RequestMapping("classes_update")
	public String ClassesUpdate(Classes classes,Model model) {
		model.addAttribute("classes", classes);
		return "classes_update";
	}
}
