package com.cslg.common.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.dao.UserDao;
import com.cslg.common.domain.UserDO;
import com.cslg.common.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int checkUsername(String username) {
		return userDao.checkUsername(username);
	}

	@Override
	public int register(UserDO userDO) {
		return userDao.register(userDO);
	}

	@Override
	public UserDO login(String username) {
		return userDao.login(username);
	}

	@Override
	public void updateCommonUserInformation(Long id, String realName, String sex, Date birth, Long phone,
			String mail) {
		userDao.updateCommonUserInformation(id,realName,sex,birth,phone,mail);
	}

	@Override
	public UserDO queryCommonUserInformation(Long id) {
		return userDao.queryCommonUserInformation(id);
	}

}
