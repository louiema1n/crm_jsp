package com.louiema1n.crm.coursetype.service;

import java.util.List;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeService {

	/**
	 * 查询所有课程类别
	 * @return
	 */
	public List<CrmCourseType> findAllCourseType();

	/**
	 * 高级查询
	 * @param crmCourseType
	 * @return
	 */
	public List<CrmCourseType> findAllCourseType(CrmCourseType crmCourseType);

	/**
	 * 根据id查询课程信息
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);

	/**
	 * 编辑或添加操作
	 * @param crmCourseType
	 */
	public void addOrEdit(CrmCourseType crmCourseType);
	
}
