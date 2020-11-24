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

import com.cslg.common.domain.UserDO;
import com.cslg.system.service.SysUserService;
import com.cslg.system.utils.PageUtils;
import com.cslg.system.utils.Query;
import com.cslg.system.utils.R;

@Controller
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 普通用户数据
	 * @return
	 */
	@ResponseBody
	@GetMapping("/sysNormalUserList")
	public PageUtils sysNormalUserList(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<UserDO> userList = sysUserService.querySysNormalUser(query);
		int total = sysUserService.normalUserCountPage(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	/**
	 * 讲师数据
	 * @return
	 */
	@ResponseBody
	@GetMapping("/sysLecturerList")
	public PageUtils sysLecturerList(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<UserDO> userList = sysUserService.querySysLecturer(query);
		int total = sysUserService.lecturerCountPage(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	/**
	 * 普通用户编辑
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/normalUserEdit/{id}")
	public String normalUserEdit(Model model, @PathVariable("id") Long id) {
		UserDO userDO = sysUserService.getUserById(id);
		model.addAttribute("userDO", userDO);
		return "backend/normalUser_edit";
	}
	
	/**
	 * 讲师编辑
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/lecturerEdit/{id}")
	public String lecturerEdit(Model model, @PathVariable("id") Long id) {
		UserDO userDO = sysUserService.getUserById(id);
		model.addAttribute("userDO", userDO);
		return "backend/lecturer_edit";
	}
	
	/**
	 * 普通用户保存更新
	 * @param user
	 * @return
	 */
	@PostMapping("/normalUserUpdate")
	@ResponseBody
	public R normalUserUpdate(Long id,int status) {
		sysUserService.normalUserUpdate(id,status);
		return R.ok("操作成功！");
	}
	
	/**
	 * 讲师保存更新
	 * @param user
	 * @return
	 */
	@PostMapping("/lecturerUpdate")
	@ResponseBody
	public R lecturerUpdate(Long id,int status) {
		sysUserService.lecturerUpdate(id,status);
		return R.ok("操作成功！");
	}
	
}
