package com.louiema1n.crm.staff.dao;

import com.louiema1n.crm.staff.domain.CrmStaff;

public interface StaffDao {
	
	/**
	 * ͨ���û����������ѯ
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
}
