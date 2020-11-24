package com.cslg.common.service;

import com.cslg.common.domain.ApplyLecturerDO;

public interface ApplyLecturerService {

	void applyLecturer(ApplyLecturerDO applyLecturerDO);

	int queryApplyLecturerData(Long id);

	ApplyLecturerDO getApplyLecturerByUserId(Long id);

}
