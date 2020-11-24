package com.cslg.common.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CourseClassifyDO implements Serializable {

	private static final long serialVersionUID = 1L;

	// id
	private Long id;
	// 父节点id
	private Long parentId;
	// 课程分类名称
	private String classifyName;
	// 创建人
	private String createAuthor;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新人
	private String updateAuthor;
	// 更新时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	public CourseClassifyDO() {
		super();
	}

	public CourseClassifyDO(Long id, Long parentId, String classifyName, String createAuthor, Date createTime,
			String updateAuthor, Date updateTime) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.classifyName = classifyName;
		this.createAuthor = createAuthor;
		this.createTime = createTime;
		this.updateAuthor = updateAuthor;
		this.updateTime = updateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public String getCreateAuthor() {
		return createAuthor;
	}

	public void setCreateAuthor(String createAuthor) {
		this.createAuthor = createAuthor;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateAuthor() {
		return updateAuthor;
	}

	public void setUpdateAuthor(String updateAuthor) {
		this.updateAuthor = updateAuthor;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "CourseDO [id=" + id + ", parentId=" + parentId + ", classifyName=" + classifyName + ", createAuthor="
				+ createAuthor + ", createTime=" + createTime + ", updateAuthor=" + updateAuthor + ", updateTime="
				+ updateTime + "]";
	}

}
