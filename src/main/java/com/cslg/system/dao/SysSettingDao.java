package com.cslg.system.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysSettingDao {

	public String queryUploadPath();
	
}
