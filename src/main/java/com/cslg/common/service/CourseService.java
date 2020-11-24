package com.cslg.common.service;

import java.util.List;

import com.cslg.common.domain.CourseClassifyDO;
import com.cslg.common.domain.CourseDetailDO;

public interface CourseService {

	List<String> selectCourseParents();

	List<CourseClassifyDO> selectCourseChildren();

	void uploadCourse(CourseDetailDO courseDetailDO);

	List<CourseDetailDO> commonQueryLatestCourse();

	CourseDetailDO commonQueryCourseInfoToPage(Long id);

	List<CourseDetailDO> commonQueryHottestCourse();

	List<CourseDetailDO> commonQueryRecommendCourse();

	List<CourseDetailDO> commonCourseSearchData(String keywords);

	List<CourseDetailDO> toAlreadyReleasedCourse(String username);

	void addClickRate(Long id);

}
