package com.louiema1n.crm.department.dao;


import java.util.List;

import com.louiema1n.crm.department.domain.CrmDepartment;

public interface DepartmentDao {
	public List<CrmDepartment> findAll();
}
