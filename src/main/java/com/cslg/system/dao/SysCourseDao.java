package com.cslg.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cslg.common.domain.CourseDetailDO;
import com.cslg.system.utils.Query;

@Mapper
public interface SysCourseDao {

	List<CourseDetailDO> sysNotAuditingCourse(Query query);

	int sysNotAuditingCourseCount(Query query);

	CourseDetailDO getCourseById(Long id);

	void sysNotAuditingCourseUpdate(@Param("id")Long id, @Param("status")int status);

	List<CourseDetailDO> sysAlreadyAuditingCourse(Query query);

	int sysAlreadyAuditingCourseCount(Query query);

	void sysAlreadyAuditingCourseUpdate(@Param("id")Long id, @Param("status")int status, @Param("recommendationIndex")int recommendationIndex);

}
