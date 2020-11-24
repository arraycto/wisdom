package com.cslg.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.domain.UserDO;
import com.cslg.system.dao.SysSettingDao;
import com.cslg.system.dao.SysUserDao;
import com.cslg.system.service.SysSettingService;
import com.cslg.system.service.SysUserService;
import com.cslg.system.utils.Query;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public List<UserDO> querySysNormalUser(Query query) {
		return sysUserDao.querySysNormalUser(query);
	}

	@Override
	public int normalUserCountPage(Query query) {
		return sysUserDao.normalUserCountPage(query);
	}

	@Override
	public int normalUserCount() {
		return sysUserDao.normalUserCount();
	}

	@Override
	public int lecturerCount() {
		return sysUserDao.lecturerCount();
	}

	@Override
	public UserDO getUserById(Long id) {
		return sysUserDao.getUserById(id);
	}

	@Override
	public void normalUserUpdate(Long id,int status) {
		sysUserDao.normalUserUpdate(id,status);
	}

	@Override
	public List<UserDO> querySysLecturer(Query query) {
		return sysUserDao.querySysLecturer(query);
	}

	@Override
	public int lecturerCountPage(Query query) {
		return sysUserDao.lecturerCountPage(query);
	}

	@Override
	public void lecturerUpdate(Long id, int status) {
		sysUserDao.lecturerUpdate(id,status);
	}

	@Override
	public void changeRoleToLecturer(Long userId) {
		sysUserDao.changeRoleToLecturer(userId);
	}

	@Override
	public void changeRoleToNormal(Long userId) {
		sysUserDao.changeRoleToNormal(userId);
	}

	@Override
	public int applyLecturerCount() {
		return sysUserDao.applyLecturerCount();
	}

	@Override
	public int alreadyAuddingCourseCount() {
		return sysUserDao.alreadyAuddingCourseCount();
	}

	@Override
	public int notAuddingCourseCount() {
		return sysUserDao.notAuddingCourseCount();
	}

	@Override
	public int commentCount() {
		return sysUserDao.commentCount();
	}
	
}
