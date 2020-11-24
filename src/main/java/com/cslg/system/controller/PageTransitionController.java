package com.cslg.system.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cslg.common.domain.UserDO;
import com.cslg.common.service.CourseService;
import com.cslg.system.service.SysUserService;

@Controller
public class PageTransitionController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping("/sysWelcome")
	public String toSysWelcome(Model model) {
		int normalUserCount = sysUserService.normalUserCount();
		int lecturerCount = sysUserService.lecturerCount();
		int applyLecturerCount = sysUserService.applyLecturerCount();
		int alreadyAuddingCourseCount = sysUserService.alreadyAuddingCourseCount();
		int notAuddingCourseCount = sysUserService.notAuddingCourseCount();
		int commentCount = sysUserService.commentCount();
		model.addAttribute("normalUser", normalUserCount);
		model.addAttribute("lecturer", lecturerCount);
		model.addAttribute("applyLecturer", applyLecturerCount);
		model.addAttribute("alreadyAuddingCourseCount", alreadyAuddingCourseCount);
		model.addAttribute("notAuddingCourseCount", notAuddingCourseCount);
		model.addAttribute("commentCount", commentCount);
		return "backend/welcome";
	}
	
	/**
	 * 普通用户页面
	 * @return
	 */
	@RequestMapping("/toNormalUserList")
	public String toNormalUserList() {
		return "backend/normalUser_list";
	}
	
	/**
	 * 讲师页面
	 * @return
	 */
	@RequestMapping("/toLecturerList")
	public String toLecturerList() {
		return "backend/lecturer_list";
	}
	
	/**
	 * 跳转到课程视频页面
	 * @return
	 */
	@RequestMapping("/toCourseVideo")
	public String toCourseVideo(@RequestParam(name = "id")Long id) {
		courseService.addClickRate(id);
		return "course_video";
	}
	
	/**
	 * 跳转到前台登录页面
	 * @return
	 */
	@RequestMapping("/toCommonLogin")
	public String toCommonLogin() {
		return "common_login";
	}
	
	/**
	 * 跳转到前台注册页面
	 * @return
	 */
	@RequestMapping("/toCommonRegister")
	public String toCommonRegister() {
		return "common_register";
	}
	
	/**
	 * 个人信息页面
	 * @return
	 */
	@RequestMapping("/showPersonalInformation")
	public String showPersonalInformation(Model model) {
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("id",userDO.getId());
		return "personal_information";
	}
	
	/**
	 * 讲师申请页面
	 * @return
	 */
	@RequestMapping("/applyLecturer")
	public String applyLecturer(Model model) {
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("id",userDO.getId());
		return "apply_lecturer";
	}
	
	/**
	 * 个人收藏页面
	 * @return
	 */
	@RequestMapping("/toMyCollectionPage")
	public String toMyCollectionPage() {
		return "my_collection";
	}
	
	/**
	 * 讲师发布的课程
	 * @return
	 */
	@RequestMapping("/toAlreadyReleasedCoursePage")
	public String toAlreadyReleasedCoursePage() {
		return "already_release";
	}
	
	/**
	 * 后台课程审核页面
	 * @return
	 */
	@RequestMapping("/notAuditingCoursePage")
	public String notAuditingCoursePage() {
		return "backend/notAuditing_course";
	}
	
	/**
	 * 后台课程已审核页面
	 * @return
	 */
	@RequestMapping("/alreadyAuditingCoursePage")
	public String alreadyAuditingCoursePage() {
		return "backend/alreadyAuditing_course";
	}
	
	/**
	 * 后台评论审核页面
	 * @return
	 */
	@RequestMapping("/auditingCommentPage")
	public String auditingCommentPage() {
		return "backend/auditing_comment";
	}
	
	/**
	 * 后台讲师申请审核页面
	 * @return
	 */
	@RequestMapping("/sysApplyLecturerPage")
	public String sysApplyLecturerPage() {
		return "backend/apply_lecturer";
	}
	
}
