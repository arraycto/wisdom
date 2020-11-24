package com.cslg.common.service;

import java.util.List;

import com.cslg.common.domain.CourseDetailDO;

public interface CourseCollectionService {

	void commonCourseCollection(Long userId, Long courseId);

	int queryCourseCollectioned(Long userId, Long courseId);

	void commonCourseCollectioned(Long userId, Long courseId);

	List<CourseDetailDO> myCollectioned(Long id);

}
