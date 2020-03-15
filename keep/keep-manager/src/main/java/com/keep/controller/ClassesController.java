package com.keep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keep.pojo.Classes;
import com.keep.service.ClassesService;
import com.keep.vo.InfoVo;
import com.keep.vo.ResultJson;

@Controller
@RequestMapping("classes")
public class ClassesController {
	
	@Autowired
	private ClassesService classesService;
	@RequestMapping("getClassesTableInfo")
	@ResponseBody
	public InfoVo getClasses(Integer page,Integer limit) {
		return classesService.getClassesTableInfo(page,limit);
	}
	@RequestMapping("update")
	public String classesUpdate(Classes classes) {
		classesService.classesUpdate(classes);
		return "redirect:/classes";
	}
	@RequestMapping("delete")
	@ResponseBody
	public ResultJson classesDelete(Integer id) {
		classesService.classesDelete(id);
		return ResultJson.success();
	}
}
