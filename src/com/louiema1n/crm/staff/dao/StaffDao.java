package com.louiema1n.crm.staff.dao;

import java.util.List;

import com.louiema1n.crm.base.BaseDao;
import com.louiema1n.crm.staff.domain.CrmStaff;

public interface StaffDao extends BaseDao<CrmStaff> {
	
	/**
	 * 通过用户名和密码查询,登陆
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
}
