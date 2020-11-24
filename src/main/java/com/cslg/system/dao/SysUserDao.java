package com.cslg.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cslg.common.domain.UserDO;
import com.cslg.system.utils.Query;

@Mapper
public interface SysUserDao {

	List<UserDO> querySysNormalUser(Query query);

	int normalUserCountPage(Query query);

	int normalUserCount();

	int lecturerCount();

	UserDO getUserById(Long id);

	void normalUserUpdate(@Param("id")Long id, @Param("status")int status);

	List<UserDO> querySysLecturer(Query query);

	int lecturerCountPage(Query query);

	void lecturerUpdate(@Param("id")Long id, @Param("status")int status);

	void changeRoleToLecturer(Long userId);

	void changeRoleToNormal(Long userId);

	int applyLecturerCount();

	int alreadyAuddingCourseCount();

	int notAuddingCourseCount();

	int commentCount();

}
