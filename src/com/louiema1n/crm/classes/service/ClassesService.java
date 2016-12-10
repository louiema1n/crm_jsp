package com.louiema1n.crm.classes.service;

import java.util.List;

import com.louiema1n.crm.classes.domain.CrmClasses;


public interface ClassesService {
	/**
	 * ��ѯ����
	 */
	public List<CrmClasses> findAll();

	/**
	 * ����id��ѯ
	 * @param classId
	 * @return
	 */
	public CrmClasses findById(String classId);

	/**
	 * ����
	 */
	public void update(CrmClasses model);
}
