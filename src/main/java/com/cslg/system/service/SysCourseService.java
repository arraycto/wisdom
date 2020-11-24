package com.cslg.system.service;

import java.util.List;

import com.cslg.common.domain.CourseDetailDO;
import com.cslg.system.utils.Query;

public interface SysCourseService {

	List<CourseDetailDO> sysNotAuditingCourse(Query query);

	int sysNotAuditingCourseCount(Query query);

	CourseDetailDO getCourseById(Long id);

	void sysNotAuditingCourseUpdate(Long id, int status);

	List<CourseDetailDO> sysAlreadyAuditingCourse(Query query);

	int sysAlreadyAuditingCourseCount(Query query);

	void sysAlreadyAuditingCourseUpdate(Long id, int status, int recommendationIndex);

}
