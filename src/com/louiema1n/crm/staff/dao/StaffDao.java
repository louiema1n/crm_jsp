package com.louiema1n.crm.staff.dao;

import java.util.List;

import com.louiema1n.crm.staff.domain.CrmStaff;

public interface StaffDao {
	
	/**
	 * 通过用户名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
	/**
	 * 查询所有员工信息
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * 根据id查询员工信息
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);
	
}
