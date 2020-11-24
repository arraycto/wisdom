package com.cslg.common.service;

import java.util.List;

import com.cslg.common.domain.CommentDO;

public interface CommentService {

	void releaseComment(CommentDO commentDO);

	List<CommentDO> commonQueryAllComments(long id);

}
