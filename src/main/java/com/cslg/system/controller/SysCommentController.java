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

import com.cslg.common.domain.CommentDO;
import com.cslg.system.service.SysCommentService;
import com.cslg.system.utils.PageUtils;
import com.cslg.system.utils.Query;
import com.cslg.system.utils.R;

@Controller
public class SysCommentController {
	
	@Autowired
	private SysCommentService sysCommentService;
	
	/**
	 * 评论
	 * @return
	 */
	@ResponseBody
	@GetMapping("/sysAuditingComment")
	public PageUtils sysAuditingComment(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<CommentDO> commentList = sysCommentService.sysAuditingComment(query);
		int total = sysCommentService.sysAuditingCommentCount(query);
		PageUtils pageUtils = new PageUtils(commentList, total);
		return pageUtils;
	}
	
	/**
	 * 评论编辑
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/sysAuditingCommentEdit/{id}")
	public String sysNotAuditingCourseEdit(Model model, @PathVariable("id") Long id) {
		CommentDO commentDO = sysCommentService.getCommentById(id);
		model.addAttribute("commentDO", commentDO);
		return "backend/additingComment_edit";
	}
	
	/**
	 * 评论更新审核
	 * @param user
	 * @return
	 */
	@PostMapping("/sysAuditingCommentUpdate")
	@ResponseBody
	public R sysAuditingCommentUpdate(Long id,int status) {
		sysCommentService.sysAuditingCommentUpdate(id,status);
		return R.ok("操作成功！");
	}
	
}
