package com.cslg.common.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentDO implements Serializable {

	private static final long serialVersionUID = 1L;

	// id
	private Long id;
	// 评论内容
	private String commentContent;
	// 评论人名字
	private String username;
	// 评论人头像
	private String headPortrait;
	// 课程id
	private Long courseId;
	// 评论时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date commentTime;
	// 状态0：未通过 1：通过
	private int status;
	
	public CommentDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDO(Long id, String commentContent, String username, String headPortrait, Long courseId,
			Date commentTime, int status) {
		super();
		this.id = id;
		this.commentContent = commentContent;
		this.username = username;
		this.headPortrait = headPortrait;
		this.courseId = courseId;
		this.commentTime = commentTime;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CommentDO [id=" + id + ", commentContent=" + commentContent + ", username=" + username
				+ ", headPortrait=" + headPortrait + ", courseId=" + courseId + ", commentTime=" + commentTime
				+ ", status=" + status + "]";
	}

}
