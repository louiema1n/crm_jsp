package com.louiema1n.crm.post.service;

import java.util.List;

import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.post.domain.CrmPost;

public interface PostService {

	/**
	 * 根据部门查询所有职务
	 * @param crmDepartment
	 * @return
	 */
	public List<CrmPost> findByDepartment(CrmDepartment crmDepartment);
	
}
