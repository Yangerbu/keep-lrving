package com.keep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keep.mapper.UserInfoMapper;
import com.keep.pojo.UserInfo;
import com.keep.vo.InfoVo;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public InfoVo findUserInfoTable(Integer currentPage,Integer rows) {
		//select * from tb_user_info limit 
		/*
		 * QueryWrapper<UserInfo> query=new QueryWrapper<>();
		 * query.orderByDesc("modifiedTime");
		 */
		IPage<UserInfo> page=new Page<>(currentPage, rows);
		IPage<UserInfo> userInfoPage=userInfoMapper.selectPage(page, null);
		return new InfoVo(userInfoPage.getTotal(),userInfoPage.getRecords());
	}

	@Override
	public void updateUser(UserInfo user) {
		userInfoMapper.updateById(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userInfoMapper.deleteById(id);
	}

}
