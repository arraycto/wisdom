package com.cslg.system.service;

import java.util.List;

import com.cslg.common.domain.ApplyLecturerDO;
import com.cslg.system.utils.Query;

public interface SysApplyLecturerService {

	int sysApplyLecturerCount(Query query);

	List<ApplyLecturerDO> sysApplyLecturer(Query query);

	ApplyLecturerDO getApplyById(Long id);

	void sysApplyLecturerUpdate(Long id, int status);

}
