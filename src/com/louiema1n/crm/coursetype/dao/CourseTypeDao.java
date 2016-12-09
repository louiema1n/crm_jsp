package com.louiema1n.crm.coursetype.dao;

import java.util.List;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {

	public List<CrmCourseType> findAllCourseTypes();

	public List<CrmCourseType> findAllCourseTypes(String hql,
			Object[] params);

	public CrmCourseType findById(String courseTypeId);

	public void saveOrUpdate(CrmCourseType crmCourseType);
	
}
