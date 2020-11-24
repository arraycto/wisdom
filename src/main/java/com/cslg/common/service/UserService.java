package com.cslg.common.service;

import java.util.Date;

import com.cslg.common.domain.UserDO;

public interface UserService {

	int checkUsername(String username);

	int register(UserDO userDO);

	UserDO login(String username);

	void updateCommonUserInformation(Long id, String realName, String sex, Date birth, Long phone, String mail);

	UserDO queryCommonUserInformation(Long id);

}
