package com.cslg.common.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cslg.common.domain.CourseClassifyDO;
import com.cslg.common.domain.CourseDetailDO;
import com.cslg.common.domain.UserDO;
import com.cslg.common.service.CourseService;
import com.cslg.system.service.SysSettingService;
import com.cslg.system.utils.FileUtils;
import com.cslg.system.utils.R;

@Controller
public class CourseController {

	@Value("${wisdom.httpUrl}")
	private String httpUrl;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SysSettingService sysSettingService;
	
	/**
	 * 根据关键字搜索课程
	 */
	@ResponseBody
	@RequestMapping("/commonCourseSearch")
	public String commonCourseSearch(String keywords) {
		return keywords;
	}
	
	/**
	 * 跳转到搜索页面
	 */
	@RequestMapping("/toCourseSearch")
	public String toCourseSearch(@RequestParam("keywords") String keywords,Model model) {
		model.addAttribute("keywords", keywords);
		return "course_search";
	}
	
	/**
	 * 搜索页面拿到数据
	 */
	@ResponseBody
	@PostMapping("/commonCourseSearchData")
	public List<CourseDetailDO> commonCourseSearchData(String keywords) {
		List<CourseDetailDO> courseDetailList = courseService.commonCourseSearchData(keywords);
		return courseDetailList;
	}
	
	/**
	 * 查询课程分类的父节点
	 * @return
	 */
	@ResponseBody
	@PostMapping("/commonSelectCourseParents")
	public List<String> selectCourseParents() {
		List<String> courseParentsList = courseService.selectCourseParents();
		return courseParentsList;
	}
	
	/**
	 * 查询课程分类的子节点
	 * @return
	 */
	@ResponseBody
	@PostMapping("/commonSelectCourseChildren")
	public Map<Integer, List<String>> selectCourseChildren() {
		List<CourseClassifyDO> courseChildrenList = courseService.selectCourseChildren();
		Map<Integer, List<String>> courseChildrenMap = new HashMap<Integer, List<String>>();
		for(int i=1;i<=6;i++) {
			List<String> courseList = new ArrayList<String>();
			for (CourseClassifyDO courseDO : courseChildrenList) {
				if(courseDO.getParentId() == i) {
					courseList.add(courseDO.getClassifyName());
				}
			}
			courseChildrenMap.put(i,courseList);
		}
		return courseChildrenMap;
	}
	
	/**
	 * 上传课程
	 * @return
	 */
	@ResponseBody
	@PostMapping("/courseUpload")
	public R courseUpload(String quiz2, String courseTitle, MultipartFile courseImg, MultipartFile courseUrl, String courseIntroduction) {
		String uploadPath = sysSettingService.queryUploadPath();
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		CourseDetailDO courseDetailDO = new CourseDetailDO();
		courseDetailDO.setCourseClassify(quiz2);
		courseDetailDO.setCourseTitle(courseTitle);
		courseDetailDO.setCourseImg(FileUtils.changeFileName(uploadPath,httpUrl, courseImg, courseTitle, "cover"));
		courseDetailDO.setCourseUrl(FileUtils.changeFileName(uploadPath,httpUrl, courseUrl, courseTitle, "video"));
		courseDetailDO.setCourseIntroduction(courseIntroduction);
		courseDetailDO.setCourseAuthor(userDO.getUsername());
		courseDetailDO.setUploadTime(new Date());
		courseDetailDO.setStatus(0);
		courseDetailDO.setRecommendationIndex(1);
		courseDetailDO.setClickRate(0L);
		courseService.uploadCourse(courseDetailDO);
		return R.ok("上传成功！");
	}
	
	/**
	 * 查询讲师发布的所有课程
	 */
	@ResponseBody
	@PostMapping("/toAlreadyReleasedCourse")
	public List<CourseDetailDO> toAlreadyReleasedCourse() {
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		List<CourseDetailDO> courseList = courseService.toAlreadyReleasedCourse(userDO.getUsername());
		return courseList;
	}
}
