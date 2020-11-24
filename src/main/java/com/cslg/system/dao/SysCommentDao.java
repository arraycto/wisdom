package com.cslg.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cslg.common.domain.CommentDO;
import com.cslg.system.utils.Query;

@Mapper
public interface SysCommentDao {

	List<CommentDO> sysAuditingComment(Query query);

	int sysAuditingCommentCount(Query query);

	CommentDO getCommentById(Long id);

	void sysAuditingCommentUpdate(@Param("id")Long id, @Param("status")int status);

}
