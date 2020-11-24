package com.cslg.common.controller;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cslg.common.domain.CommentDO;
import com.cslg.common.domain.UserDO;
import com.cslg.common.service.CommentService;
import com.cslg.system.utils.R;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	/**
	 * 上传评论
	 * @return
	 */
	@ResponseBody
	@PostMapping("/commonUserReleaseComment")
	public R courseUpload(String comment,long id) {
		CommentDO commentDO = new CommentDO();
		commentDO.setCourseId(id);
		commentDO.setCommentContent(comment);
		commentDO.setCommentTime(new Date());
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		commentDO.setUsername(userDO.getUsername());
		commentDO.setHeadPortrait(userDO.getHeadPortrait());
		commentDO.setStatus(1);
		commentService.releaseComment(commentDO);
		return R.ok("评论成功！");
	}
	
	/**
	 * 查询所有评论
	 */
	@ResponseBody
	@PostMapping("/commonQueryAllComments")
	public List<CommentDO> showAllComments(long id) {
		List<CommentDO> commentList = commentService.commonQueryAllComments(id);
		return commentList;
	}
}
