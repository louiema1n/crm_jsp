package com.louiema1n.crm.staff.dao;

import com.louiema1n.crm.staff.domain.CrmStaff;

public interface StaffDao {
	
	/**
	 * 通过用户名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
}
