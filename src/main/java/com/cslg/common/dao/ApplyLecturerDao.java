package com.cslg.common.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cslg.common.domain.ApplyLecturerDO;

@Mapper
public interface ApplyLecturerDao {

	void applyLecturer(ApplyLecturerDO applyLecturerDO);

	int queryApplyLecturerData(Long id);

	ApplyLecturerDO getApplyLecturerByUserId(Long id);

}
