package com.keep.service;

import com.keep.pojo.UserInfo;
import com.keep.vo.InfoVo;

public interface UserInfoService {

	InfoVo findUserInfoTable(Integer currentPage,Integer rows);

	void updateUser(UserInfo user);

	void deleteUser(Integer id);


}
