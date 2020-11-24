package com.cslg.common.controller;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cslg.common.domain.CourseDetailDO;
import com.cslg.common.domain.UserDO;
import com.cslg.common.service.CourseCollectionService;
import com.cslg.system.utils.R;

@Controller
public class CourseCollectionController {

	@Autowired
	private CourseCollectionService courseCollectionService;
	
	/**
	 * 查询是否收藏课程
	 */
	@ResponseBody
	@PostMapping("/queryCourseCollectioned")
	public R queryCourseCollectioned(Long userId,Long courseId) {
	    int count = courseCollectionService.queryCourseCollectioned(userId,courseId);
	    if(count>0) {
	    	return R.ok("已收藏");
	    }
		return R.error("未收藏");
	}
	
	/**
	 * 收藏课程
	 */
	@ResponseBody
	@PostMapping("/commonCourseCollection")
	public R commonCourseCollection(Long userId,Long courseId) {
	    courseCollectionService.commonCourseCollection(userId,courseId);
		return R.ok("收藏成功！");
	}
	
	/**
	 * 取消收藏课程
	 */
	@ResponseBody
	@PostMapping("/commonCourseCollectioned")
	public R commonCourseCollectioned(Long userId,Long courseId) {
	    courseCollectionService.commonCourseCollectioned(userId,courseId);
		return R.ok("取消收藏成功！");
	}
	
	/**
	 * 查询用户收藏的所有课程
	 */
	@ResponseBody
	@PostMapping("/myCollectioned")
	public List<CourseDetailDO> myCollectioned() {
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		List<CourseDetailDO> courseList = courseCollectionService.myCollectioned(userDO.getId());
		return courseList;
	}
	
}
