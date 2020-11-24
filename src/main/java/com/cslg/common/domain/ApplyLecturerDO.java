package com.cslg.common.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApplyLecturerDO implements Serializable {

	private static final long serialVersionUID = 1L;

	// id
	private Long id;
	// 个人优势
	private String advantage;
	// 理由
	private String reason;
	// 用户id
	private Long userId;
	// 用户姓名
	private String username;
	// 申请时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date applyTime;
	// 状态
	private int status;
		
	public ApplyLecturerDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplyLecturerDO(Long id, String advantage, String reason, Long userId, String username, Date applyTime,
			int status) {
		super();
		this.id = id;
		this.advantage = advantage;
		this.reason = reason;
		this.userId = userId;
		this.username = username;
		this.applyTime = applyTime;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApplyLecturerDO [id=" + id + ", advantage=" + advantage + ", reason=" + reason + ", userId=" + userId
				+ ", username=" + username + ", applyTime=" + applyTime + ", status=" + status + "]";
	}

}
