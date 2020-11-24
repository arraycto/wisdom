package com.cslg.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.dao.CourseDao;
import com.cslg.common.dao.UserDao;
import com.cslg.common.domain.CourseClassifyDO;
import com.cslg.common.domain.CourseDetailDO;
import com.cslg.common.domain.UserDO;
import com.cslg.common.service.CourseService;
import com.cslg.common.service.UserService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<String> selectCourseParents() {
		return courseDao.selectCourseParents();
	}

	@Override
	public List<CourseClassifyDO> selectCourseChildren() {
		return courseDao.selectCourseChildren();
	}

	@Override
	public void uploadCourse(CourseDetailDO courseDetailDO) {
		courseDao.uploadCourse(courseDetailDO);
	}

	@Override
	public List<CourseDetailDO> commonQueryLatestCourse() {
		return courseDao.commonQueryLatestCourse();
	}

	@Override
	public CourseDetailDO commonQueryCourseInfoToPage(Long id) {
		return courseDao.commonQueryCourseInfoToPage(id);
	}

	@Override
	public List<CourseDetailDO> commonQueryHottestCourse() {
		return courseDao.commonQueryHottestCourse();
	}

	@Override
	public List<CourseDetailDO> commonQueryRecommendCourse() {
		return courseDao.commonQueryRecommendCourse();
	}

	@Override
	public List<CourseDetailDO> commonCourseSearchData(String keywords) {
		return courseDao.commonCourseSearchData(keywords);
	}

	@Override
	public List<CourseDetailDO> toAlreadyReleasedCourse(String username) {
		return courseDao.toAlreadyReleasedCourse(username);
	}

	@Override
	public void addClickRate(Long id) {
		courseDao.addClickRate(id);
	}

}
