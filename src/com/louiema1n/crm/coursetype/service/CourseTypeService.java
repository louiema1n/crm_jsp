package com.louiema1n.crm.coursetype.service;

import java.util.List;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeService {

	/**
	 * 查询所有课程类别
	 * @return
	 */
	public List<CrmCourseType> findAllCourseType();
	
}
