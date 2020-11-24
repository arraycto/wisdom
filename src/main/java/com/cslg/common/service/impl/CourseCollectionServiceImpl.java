package com.cslg.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.dao.ApplyLecturerDao;
import com.cslg.common.dao.CourseCollectionDao;
import com.cslg.common.domain.ApplyLecturerDO;
import com.cslg.common.domain.CourseDetailDO;
import com.cslg.common.service.ApplyLecturerService;
import com.cslg.common.service.CourseCollectionService;

@Service
public class CourseCollectionServiceImpl implements CourseCollectionService {

	@Autowired
	private CourseCollectionDao courseCollectionDao;

	@Override
	public void commonCourseCollection(Long userId, Long courseId) {
		courseCollectionDao.commonCourseCollection(userId,courseId);
	}

	@Override
	public int queryCourseCollectioned(Long userId, Long courseId) {
		return courseCollectionDao.queryCourseCollectioned(userId,courseId);
	}

	@Override
	public void commonCourseCollectioned(Long userId, Long courseId) {
		courseCollectionDao.commonCourseCollectioned(userId,courseId);
	}

	@Override
	public List<CourseDetailDO> myCollectioned(Long id) {
		return courseCollectionDao.myCollectioned(id);
	}


}
