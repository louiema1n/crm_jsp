package com.louiema1n.crm.post.dao;

import java.util.List;

import com.louiema1n.crm.base.BaseDao;
import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.post.domain.CrmPost;

public interface PostDao extends BaseDao<CrmPost> {
	
	public List<CrmPost> findByDepartment(CrmDepartment crmDepartment);
	
}
