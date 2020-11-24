package com.cslg.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cslg.common.domain.CommentDO;
import com.cslg.common.domain.UserDO;

@Mapper
public interface CommentDao {

	void releaseComment(CommentDO commentDO);

	List<CommentDO> commonQueryAllComments(long id);

}
