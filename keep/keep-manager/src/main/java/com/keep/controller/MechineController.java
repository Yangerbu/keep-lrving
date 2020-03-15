package com.keep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keep.pojo.Material;
import com.keep.service.MechineService;
import com.keep.vo.InfoVo;
import com.keep.vo.ResultJson;

@Controller
@RequestMapping("mechine")
public class MechineController {
	
	@Autowired
	private MechineService mechineService;
	@RequestMapping("getMechineTableInfo")
	@ResponseBody
	public InfoVo getMechine(Integer page,Integer limit) {
		return mechineService.getMechineTableIndo(page,limit);
	}
	@RequestMapping("update")
	public String mechineUpdate(Material material) {
		mechineService.mechineUpdate(material);
		return "redirect:/meterial";
	}
	@RequestMapping("delete")
	@ResponseBody
	public ResultJson mechineDelete(Integer id) {
		mechineService.mechineDelete(id);
		return ResultJson.success();
	}
}
