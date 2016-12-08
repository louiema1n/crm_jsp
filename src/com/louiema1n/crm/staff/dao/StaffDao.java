package com.louiema1n.crm.staff.dao;

import java.util.List;

import com.louiema1n.crm.staff.domain.CrmStaff;

public interface StaffDao {
	
	/**
	 * ͨ���û����������ѯ
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
	/**
	 * ��ѯ����Ա����Ϣ
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * ����id��ѯԱ����Ϣ
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);
	
}
