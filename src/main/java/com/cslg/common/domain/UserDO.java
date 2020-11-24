package com.cslg.common.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDO implements Serializable {

	private static final long serialVersionUID = 1L;

	// id
	private Long id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 头像
	private String headPortrait;
	// 真实姓名
	private String realname;
	// 性别
	private String sex;
	// 出生日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birth;
	// 联系方式
	private Long phone;
	// 邮箱
	private String mail;
	// 0：禁用 1：正常
	private Integer status;
	// 创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 角色id
	private Long roleId;

	public UserDO() {
		super();
	}

	public UserDO(Long id, String username, String password, String headPortrait, String realname, String sex,
			Date birth, Long phone, String mail, Integer status, Date createTime, Long roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.headPortrait = headPortrait;
		this.realname = realname;
		this.sex = sex;
		this.birth = birth;
		this.phone = phone;
		this.mail = mail;
		this.status = status;
		this.createTime = createTime;
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserDO [id=" + id + ", username=" + username + ", password=" + password + ", headPortrait="
				+ headPortrait + ", realname=" + realname + ", sex=" + sex + ", birth=" + birth + ", phone=" + phone
				+ ", mail=" + mail + ", status=" + status + ", createTime=" + createTime + ", roleId=" + roleId + "]";
	}

}
