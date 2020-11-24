package com.cslg.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cslg.common.domain.ApplyLecturerDO;
import com.cslg.system.utils.Query;

@Mapper
public interface SysApplyLecturerDao {
				
	List<ApplyLecturerDO> sysApplyLecturer(Query query);

	int sysApplyLecturerCount(Query query);

	ApplyLecturerDO getApplyById(Long id);

	void sysApplyLecturerUpdate(@Param("id")Long id, @Param("status")int status);

}
