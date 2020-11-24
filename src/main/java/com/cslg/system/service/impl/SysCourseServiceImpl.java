package com.cslg.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.domain.CourseDetailDO;
import com.cslg.system.dao.SysCourseDao;
import com.cslg.system.service.SysCourseService;
import com.cslg.system.utils.Query;

@Service
public class SysCourseServiceImpl implements SysCourseService{

	@Autowired
	private SysCourseDao sysCourseDao;

	@Override
	public List<CourseDetailDO> sysNotAuditingCourse(Query query) {
		return sysCourseDao.sysNotAuditingCourse(query);
	}

	@Override
	public int sysNotAuditingCourseCount(Query query) {
		return sysCourseDao.sysNotAuditingCourseCount(query);
	}

	@Override
	public CourseDetailDO getCourseById(Long id) {
		return sysCourseDao.getCourseById(id);
	}

	@Override
	public void sysNotAuditingCourseUpdate(Long id, int status) {
		sysCourseDao.sysNotAuditingCourseUpdate(id,status);
	}

	@Override
	public List<CourseDetailDO> sysAlreadyAuditingCourse(Query query) {
		return sysCourseDao.sysAlreadyAuditingCourse(query);
	}

	@Override
	public int sysAlreadyAuditingCourseCount(Query query) {
		return sysCourseDao.sysAlreadyAuditingCourseCount(query);
	}

	@Override
	public void sysAlreadyAuditingCourseUpdate(Long id, int status, int recommendationIndex) {
		sysCourseDao.sysAlreadyAuditingCourseUpdate(id,status,recommendationIndex);
	}

}
