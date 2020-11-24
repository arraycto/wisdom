package com.cslg.common.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cslg.common.domain.UserDO;

@Mapper
public interface UserDao {

	int checkUsername(@Param("username")String username);

	int register(UserDO userDO);

	UserDO login(String username);

	void updateCommonUserInformation(@Param("id")Long id, @Param("realName")String realName, @Param("sex")String sex, @Param("birth")Date birth, @Param("phone")Long phone, @Param("mail")String mail);

	UserDO queryCommonUserInformation(Long id);

}
