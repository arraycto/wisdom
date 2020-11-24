package com.cslg.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cslg.common.domain.CourseDetailDO;
import com.cslg.common.domain.UserDO;
import com.cslg.system.service.SysCourseService;
import com.cslg.system.service.SysUserService;
import com.cslg.system.utils.PageUtils;
import com.cslg.system.utils.Query;
import com.cslg.system.utils.R;

@Controller
public class SysCourseController {
	
	@Autowired
	private SysCourseService sysCourseService;
	
	/**
	 * 未审核课程
	 * @return
	 */
	@ResponseBody
	@GetMapping("/sysNotAuditingCourse")
	public PageUtils sysNotAuditingCourse(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<CourseDetailDO> userList = sysCourseService.sysNotAuditingCourse(query);
		int total = sysCourseService.sysNotAuditingCourseCount(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	/**
	 * 未审核课程编辑
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/sysNotAuditingCourseEdit/{id}")
	public String sysNotAuditingCourseEdit(Model model, @PathVariable("id") Long id) {
		CourseDetailDO courseDetailDO = sysCourseService.getCourseById(id);
		model.addAttribute("courseDetailDO", courseDetailDO);
		return "backend/notAdditing_edit";
	}
	
	/**
	 * 未审核课程审核
	 * @param user
	 * @return
	 */
	@PostMapping("/sysNotAuditingCourseUpdate")
	@ResponseBody
	public R sysNotAuditingCourseUpdate(Long id,int status) {
		sysCourseService.sysNotAuditingCourseUpdate(id,status);
		return R.ok("操作成功！");
	}
	
	/**
	 * 已审核课程
	 * @return
	 */
	@ResponseBody
	@GetMapping("/sysAlreadyAuditingCourse")
	public PageUtils sysAlreadyAuditingCourse(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<CourseDetailDO> userList = sysCourseService.sysAlreadyAuditingCourse(query);
		int total = sysCourseService.sysAlreadyAuditingCourseCount(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	/**
	 * 已审核课程编辑
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/sysAlreadyAuditingCourseEdit/{id}")
	public String sysAlreadyAuditingCourseEdit(Model model, @PathVariable("id") Long id) {
		CourseDetailDO courseDetailDO = sysCourseService.getCourseById(id);
		model.addAttribute("courseDetailDO", courseDetailDO);
		return "backend/alreadyAdditing_edit";
	}
	
	/**
	 * 已审核课程审核
	 * @param user
	 * @return
	 */
	@PostMapping("/sysAlreadyAuditingCourseUpdate")
	@ResponseBody
	public R sysAlreadyAuditingCourseUpdate(Long id,int status,int recommendationIndex) {
		sysCourseService.sysAlreadyAuditingCourseUpdate(id,status,recommendationIndex);
		return R.ok("操作成功！");
	}
	
}
