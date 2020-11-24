package com.cslg.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cslg.common.dao.CommentDao;
import com.cslg.common.domain.CommentDO;
import com.cslg.common.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public void releaseComment(CommentDO commentDO) {
		commentDao.releaseComment(commentDO);
	}

	@Override
	public List<CommentDO> commonQueryAllComments(long id) {
		return commentDao.commonQueryAllComments(id);
	}
	
}
