package com.keep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keep.mapper.ClassesMapper;
import com.keep.pojo.Classes;
import com.keep.vo.InfoVo;

@Service
public class ClassesServiceImpl implements ClassesService {
	
	@Autowired
	private ClassesMapper classesMapper;

	@Override
	public InfoVo getClassesTableInfo(Integer page, Integer limit) {
		IPage<Classes> ipage=new Page(page,limit);
		IPage<Classes> selectPage = classesMapper.selectPage(ipage, null);
		return new InfoVo(selectPage.getTotal(), selectPage.getRecords());
	}

	@Override
	public void classesUpdate(Classes classes) {
		classesMapper.updateById(classes);
	}

	@Override
	public void classesDelete(Integer id) {
		classesMapper.deleteById(id);
	}

}
