package com.louiema1n.crm.department.service.impl;

import java.util.List;

import com.louiema1n.crm.department.dao.DepartmentDao;
import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

}
