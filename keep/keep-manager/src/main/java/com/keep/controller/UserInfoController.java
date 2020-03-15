package com.keep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keep.pojo.UserInfo;
import com.keep.service.UserInfoService;
import com.keep.vo.InfoVo;
import com.keep.vo.ResultJson;

@Controller
@RequestMapping("user")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	//默认会自动传递两个参数：?page=1&limit=30
	@RequestMapping("findUserInfoTable")
	@ResponseBody
	public InfoVo findUserInfoTable(Integer page,Integer limit) {
		System.out.println(page+":"+limit);
		InfoVo list=userInfoService.findUserInfoTable(page,limit);
		return list;
	}
	@RequestMapping("doLogin")
	public String doLogin(String username,String password) {
		System.out.println(username);
		return "index";
	}
	@RequestMapping("update")
	public String updateUser(UserInfo user) {
		 userInfoService.updateUser(user);
		return "redirect:/table"; 
	}
	@RequestMapping("delete")
	@ResponseBody
	public ResultJson deleteUser(Integer id) {
		System.out.println(id);
		userInfoService.deleteUser(id);
		return ResultJson.success();
	}
}
