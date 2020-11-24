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

import com.cslg.common.domain.ApplyLecturerDO;
import com.cslg.system.service.SysApplyLecturerService;
import com.cslg.system.service.SysUserService;
import com.cslg.system.utils.PageUtils;
import com.cslg.system.utils.Query;
import com.cslg.system.utils.R;

@Controller
public class SysApplyLecturerController {
	
	@Autowired
	private SysApplyLecturerService sysApplyLecturerService;
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 讲师审核
	 * @return
	 */
	@ResponseBody
	@GetMapping("/sysApplyLecturer")
	public PageUtils sysApplyLecturer(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<ApplyLecturerDO> commentList = sysApplyLecturerService.sysApplyLecturer(query);
		int total = sysApplyLecturerService.sysApplyLecturerCount(query);
		PageUtils pageUtils = new PageUtils(commentList, total);
		return pageUtils;
	}
	
	/**
	 * 评论编辑
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/sysApplyLecturerEdit/{id}")
	public String sysApplyLecturerEdit(Model model, @PathVariable("id") Long id) {
		ApplyLecturerDO applyLecturerDO = sysApplyLecturerService.getApplyById(id);
		model.addAttribute("applyLecturerDO", applyLecturerDO);
		return "backend/applyLecturer_edit";
	}
	
	/**
	 * 讲师审核
	 * @param user
	 * @return
	 */
	@PostMapping("/sysApplyLecturerUpdate")
	@ResponseBody
	public R sysApplyLecturerUpdate(Long id,int status) {
		ApplyLecturerDO applyLecturerDO = sysApplyLecturerService.getApplyById(id);
		if(status == 1) {
			sysApplyLecturerService.sysApplyLecturerUpdate(id,status);
			sysUserService.changeRoleToLecturer(applyLecturerDO.getUserId());
		}else if (status == 2 || status == 0) {
			sysApplyLecturerService.sysApplyLecturerUpdate(id,status);
			sysUserService.changeRoleToNormal(applyLecturerDO.getUserId());
		}
		return R.ok("操作成功！");
	}
	
}
