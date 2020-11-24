package com.cslg.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cslg.common.domain.CourseDetailDO;

@Mapper
public interface CourseCollectionDao {

	void commonCourseCollection(@Param("userId")Long userId, @Param("courseId")Long courseId);

	int queryCourseCollectioned(@Param("userId")Long userId, @Param("courseId")Long courseId);

	void commonCourseCollectioned(@Param("userId")Long userId, @Param("courseId")Long courseId);

	List<CourseDetailDO> myCollectioned(Long id);

}
