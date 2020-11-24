package com.cslg.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.domain.ApplyLecturerDO;
import com.cslg.system.dao.SysApplyLecturerDao;
import com.cslg.system.service.SysApplyLecturerService;
import com.cslg.system.utils.Query;

@Service
public class SysApplyLecturerServiceImpl implements SysApplyLecturerService{

	@Autowired
	private SysApplyLecturerDao sysApplyLecturerDao;

	@Override
	public int sysApplyLecturerCount(Query query) {
		return sysApplyLecturerDao.sysApplyLecturerCount(query);
	}

	@Override
	public List<ApplyLecturerDO> sysApplyLecturer(Query query) {
		return sysApplyLecturerDao.sysApplyLecturer(query);
	}

	@Override
	public ApplyLecturerDO getApplyById(Long id) {
		return sysApplyLecturerDao.getApplyById(id);
	}

	@Override
	public void sysApplyLecturerUpdate(Long id, int status) {
		sysApplyLecturerDao.sysApplyLecturerUpdate(id,status);
	}

}
