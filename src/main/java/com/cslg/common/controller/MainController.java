package com.cslg.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cslg.common.domain.CourseDetailDO;
import com.cslg.common.service.CourseService;

@Controller
public class MainController {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 跳转至首页
	 * @return
	 */
	@RequestMapping("/")
	public String toMain() {
		return "main";
	}
	
	/**
	 * 跳转至发布课程页面
	 * @return
	 */
	@RequestMapping("/toReleaseCourse")
	public String toReleaseCourse() {
		return "release_course";
	}
	
	/**
	 * 首页查询最新课程
	 */
	@ResponseBody
	@PostMapping("/commonQueryLatestCourse")
	public List<CourseDetailDO> commonQueryLatestCourse() {
		List<CourseDetailDO> courseList = courseService.commonQueryLatestCourse();
		return courseList;
	}
	
	/**
	 * 首页查询最热门课程
	 */
	@ResponseBody
	@PostMapping("/commonQueryHottestCourse")
	public List<CourseDetailDO> commonQueryHottestCourse() {
		List<CourseDetailDO> courseList = courseService.commonQueryHottestCourse();
		return courseList;
	}
	
	/**
	 * 首页查询站长推荐课程
	 */
	@ResponseBody
	@PostMapping("/commonQueryRecommendCourse")
	public List<CourseDetailDO> commonQueryRecommendCourse() {
		List<CourseDetailDO> courseList = courseService.commonQueryRecommendCourse();
		return courseList;
	}
	
	/**
	 * 获取所点击最新课程的信息
	 */
	@ResponseBody
	@PostMapping("/commonQueryCourseInfoToPage")
	public CourseDetailDO commonQueryCourseInfoToPage(Long id, Model model) {
		CourseDetailDO courseDetailDO = courseService.commonQueryCourseInfoToPage(id);
		return courseDetailDO;
	}
	
}