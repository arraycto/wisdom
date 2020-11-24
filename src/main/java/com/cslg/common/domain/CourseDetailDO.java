package com.cslg.common.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CourseDetailDO implements Serializable {

	private static final long serialVersionUID = 1L;

	// id
	private Long id;
	// 课程标题
	private String courseTitle;
	// 课程图片
	private String courseImg;
	// 课程视频地址
	private String courseUrl;
	// 课程介绍
	private String courseIntroduction;
	// 课程分类
	private String courseClassify;
	// 课程作者
	private String courseAuthor;
	//上传时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date uploadTime;
	// 状态
	private Integer status;
	// 推荐指数（1-3）
	private Integer recommendationIndex;
	// 点击量
	private Long clickRate;

	public CourseDetailDO() {
		super();
	}

	public CourseDetailDO(Long id, String courseTitle, String courseImg, String courseUrl, String courseIntroduction,
			String courseClassify, String courseAuthor, Date uploadTime, Integer status, Integer recommendationIndex,
			Long clickRate) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.courseImg = courseImg;
		this.courseUrl = courseUrl;
		this.courseIntroduction = courseIntroduction;
		this.courseClassify = courseClassify;
		this.courseAuthor = courseAuthor;
		this.uploadTime = uploadTime;
		this.status = status;
		this.recommendationIndex = recommendationIndex;
		this.clickRate = clickRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseImg() {
		return courseImg;
	}

	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}

	public String getCourseUrl() {
		return courseUrl;
	}

	public void setCourseUrl(String courseUrl) {
		this.courseUrl = courseUrl;
	}

	public String getCourseIntroduction() {
		return courseIntroduction;
	}

	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}

	public String getCourseClassify() {
		return courseClassify;
	}

	public void setCourseClassify(String courseClassify) {
		this.courseClassify = courseClassify;
	}

	public String getCourseAuthor() {
		return courseAuthor;
	}

	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRecommendationIndex() {
		return recommendationIndex;
	}

	public void setRecommendationIndex(Integer recommendationIndex) {
		this.recommendationIndex = recommendationIndex;
	}

	public Long getClickRate() {
		return clickRate;
	}

	public void setClickRate(Long clickRate) {
		this.clickRate = clickRate;
	}

	@Override
	public String toString() {
		return "CourseDetailDO [id=" + id + ", courseTitle=" + courseTitle + ", courseImg=" + courseImg + ", courseUrl="
				+ courseUrl + ", courseIntroduction=" + courseIntroduction + ", courseClassify=" + courseClassify
				+ ", courseAuthor=" + courseAuthor + ", uploadTime=" + uploadTime + ", status=" + status
				+ ", recommendationIndex=" + recommendationIndex + ", clickRate=" + clickRate + "]";
	}

}
