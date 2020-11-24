package com.cslg.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.system.dao.SysSettingDao;
import com.cslg.system.service.SysSettingService;

@Service
public class SysSettingServiceImpl implements SysSettingService{

	@Autowired
	private SysSettingDao sysSettingDao;
	
	@Override
	public String queryUploadPath() {
		return sysSettingDao.queryUploadPath();
	}

}
