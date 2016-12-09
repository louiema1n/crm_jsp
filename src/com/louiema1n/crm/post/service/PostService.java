package com.louiema1n.crm.post.service;

import java.util.List;

import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.post.domain.CrmPost;

public interface PostService {

	/**
	 * ���ݲ��Ų�ѯ����ְ��
	 * @param crmDepartment
	 * @return
	 */
	public List<CrmPost> findByDepartment(CrmDepartment crmDepartment);
	
}
