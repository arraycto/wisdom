package com.cslg.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.domain.CommentDO;
import com.cslg.system.dao.SysCommentDao;
import com.cslg.system.service.SysCommentService;
import com.cslg.system.utils.Query;

@Service
public class SysCommentServiceImpl implements SysCommentService{

	@Autowired
	private SysCommentDao sysCommentDao;

	@Override
	public List<CommentDO> sysAuditingComment(Query query) {
		return sysCommentDao.sysAuditingComment(query);
	}

	@Override
	public int sysAuditingCommentCount(Query query) {
		return sysCommentDao.sysAuditingCommentCount(query);
	}

	@Override
	public CommentDO getCommentById(Long id) {
		return sysCommentDao.getCommentById(id);
	}

	@Override
	public void sysAuditingCommentUpdate(Long id, int status) {
		sysCommentDao.sysAuditingCommentUpdate(id,status);
	}

}
