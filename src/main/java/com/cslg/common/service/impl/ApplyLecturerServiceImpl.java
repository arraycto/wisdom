package com.cslg.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.dao.ApplyLecturerDao;
import com.cslg.common.domain.ApplyLecturerDO;
import com.cslg.common.service.ApplyLecturerService;

@Service
public class ApplyLecturerServiceImpl implements ApplyLecturerService {

	@Autowired
	private ApplyLecturerDao applyLecturerDao;

	@Override
	public void applyLecturer(ApplyLecturerDO applyLecturerDO) {
		applyLecturerDao.applyLecturer(applyLecturerDO);
	}

	@Override
	public int queryApplyLecturerData(Long id) {
		return applyLecturerDao.queryApplyLecturerData(id);
	}

	@Override
	public ApplyLecturerDO getApplyLecturerByUserId(Long id) {
		return applyLecturerDao.getApplyLecturerByUserId(id);
	}

}
