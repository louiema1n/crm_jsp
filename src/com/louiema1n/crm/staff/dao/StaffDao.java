package com.louiema1n.crm.staff.dao;

import java.util.List;

import com.louiema1n.crm.base.BaseDao;
import com.louiema1n.crm.staff.domain.CrmStaff;

public interface StaffDao extends BaseDao<CrmStaff> {
	
	/**
	 * ͨ���û����������ѯ,��½
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
}
