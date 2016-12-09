package com.louiema1n.crm.coursetype.dao;

import java.util.List;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {

	public List<CrmCourseType> findAllCourseTypes();
	
}
