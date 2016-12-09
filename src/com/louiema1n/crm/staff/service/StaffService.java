package com.louiema1n.crm.staff.service;

import java.util.List;

import com.louiema1n.crm.staff.domain.CrmStaff;


public interface StaffService {

	/**
	 * ��¼
	 * @param crmStaff
	 * @return
	 */
	public CrmStaff login(CrmStaff crmStaff);
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * ����id��ѯԱ��
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);

	/**
	 * ����Ա����Ϣ
	 * @param crmStaff
	 */
	public void updateStaff(CrmStaff crmStaff);
	
}
