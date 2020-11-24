package com.cslg.system.service;

import java.util.List;

import com.cslg.common.domain.CommentDO;
import com.cslg.system.utils.Query;

public interface SysCommentService {

	List<CommentDO> sysAuditingComment(Query query);

	int sysAuditingCommentCount(Query query);

	CommentDO getCommentById(Long id);

	void sysAuditingCommentUpdate(Long id, int status);

}
