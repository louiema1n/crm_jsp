package com.louiema1n.crm.post.service.impl;

import java.util.List;

import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.post.dao.PostDao;
import com.louiema1n.crm.post.domain.CrmPost;
import com.louiema1n.crm.post.service.PostService;

public class PostServiceImpl implements PostService {

	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	@Override
	public List<CrmPost> findByDepartment(CrmDepartment crmDepartment) {
		return postDao.findByDepartment(crmDepartment);
	}

}
