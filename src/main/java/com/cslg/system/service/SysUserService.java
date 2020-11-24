package com.cslg.system.service;

import java.util.List;

import com.cslg.common.domain.UserDO;
import com.cslg.system.utils.Query;

public interface SysUserService {

	List<UserDO> querySysNormalUser(Query query);

	int normalUserCountPage(Query query);

	int normalUserCount();

	int lecturerCount();

	UserDO getUserById(Long id);

	void normalUserUpdate(Long id, int status);

	List<UserDO> querySysLecturer(Query query);

	int lecturerCountPage(Query query);

	void lecturerUpdate(Long id, int status);

	void changeRoleToLecturer(Long userId);

	void changeRoleToNormal(Long userId);

	int applyLecturerCount();

	int alreadyAuddingCourseCount();

	int notAuddingCourseCount();

	int commentCount();

}
