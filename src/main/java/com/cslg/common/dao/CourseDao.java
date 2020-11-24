package com.cslg.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cslg.common.domain.CourseClassifyDO;
import com.cslg.common.domain.CourseDetailDO;

@Mapper
public interface CourseDao {

	List<String> selectCourseParents();

	List<CourseClassifyDO> selectCourseChildren();

	void uploadCourse(CourseDetailDO courseDetailDO);

	List<CourseDetailDO> commonQueryLatestCourse();

	List<CourseDetailDO> commonQueryHottestCourse();
	
	CourseDetailDO commonQueryCourseInfoToPage(Long id);

	List<CourseDetailDO> commonQueryRecommendCourse();

	List<CourseDetailDO> commonCourseSearchData(String keywords);

	List<CourseDetailDO> toAlreadyReleasedCourse(String username);

	void addClickRate(Long id);

}
