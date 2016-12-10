package com.louiema1n.crm.classes.service;

import java.util.List;

import com.louiema1n.crm.classes.domain.CrmClasses;


public interface ClassesService {
	/**
	 * 查询所有
	 */
	public List<CrmClasses> findAll();

	/**
	 * 根据id查询
	 * @param classId
	 * @return
	 */
	public CrmClasses findById(String classId);

	/**
	 * 更新
	 */
	public void update(CrmClasses model);
}
