package com.louiema1n.crm.staff.service;

import java.util.List;

import com.louiema1n.crm.staff.domain.CrmStaff;


public interface StaffService {

	/**
	 * 登录
	 * @param crmStaff
	 * @return
	 */
	public CrmStaff login(CrmStaff crmStaff);
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * 根据id查询员工
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);

	/**
	 * 更新员工信息
	 * @param crmStaff
	 */
	public void updateStaff(CrmStaff crmStaff);
	
}
