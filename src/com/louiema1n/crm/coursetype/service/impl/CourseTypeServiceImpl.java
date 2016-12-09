package com.louiema1n.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.louiema1n.crm.coursetype.dao.CourseTypeDao;
import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.coursetype.service.CourseTypeService;

public class CourseTypeServiceImpl implements CourseTypeService {

	private CourseTypeDao courseTypeDao;
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	
	@Override
	public List<CrmCourseType> findAllCourseType() {
		return courseTypeDao.findAllCourseTypes();
	}

	@Override
	public List<CrmCourseType> findAllCourseType(CrmCourseType crmCourseType) {
		/**
		 * ���ݲ�ѯ������hql���Ͳ�������ƴ��
		 * ������Ҫ���ظ�,����   �ʲ���ʹ��set
		 */
		//StringBuilder��StringBuffer��
		StringBuilder hqlBuilder = new StringBuilder();
		ArrayList<Object> paramList = new ArrayList<Object>();
		
		//�ж������Ƿ�Ϊ��,����lang3�ṩ�Ĺ�����
		//�γ����
		if (StringUtils.isNotBlank(crmCourseType.getCourseName())) {
			hqlBuilder.append(" and courseName like ? ");
			paramList.add("%" + crmCourseType.getCourseName() + "%");
		}
		//�γ̼��
		if (StringUtils.isNotBlank(crmCourseType.getRemark())) {
			hqlBuilder.append(" and remark like ? ");
			paramList.add("%" + crmCourseType.getRemark() + "%");
		}
		//��ѧʱ
		if (StringUtils.isNotBlank(crmCourseType.getTotalStart())) {
			hqlBuilder.append(" and total >= ? ");
			paramList.add(Integer.parseInt(crmCourseType.getTotalStart()));
		}
		if (StringUtils.isNotBlank(crmCourseType.getTotalEnd())) {
			hqlBuilder.append(" and total <= ? ");
			paramList.add(Integer.parseInt(crmCourseType.getTotalEnd()));
		}
		
		//�γ̷���
		if (StringUtils.isNotBlank(crmCourseType.getCourseCostStart())) {
			hqlBuilder.append(" and courseCost >= ? ");
			paramList.add(Double.parseDouble(crmCourseType.getCourseCostStart()));
		}
		if (StringUtils.isNotBlank(crmCourseType.getCourseCostEnd())) {
			hqlBuilder.append(" and courseCost <= ? ");
			paramList.add(Double.parseDouble(crmCourseType.getCourseCostEnd()));
		}
		
		//ʹ��
		String hql = hqlBuilder.toString();
		Object[] params = paramList.toArray();
		
		return courseTypeDao.findAllCourseTypes(hql, params);
	}

	@Override
	public CrmCourseType findById(String courseTypeId) {
		return this.courseTypeDao.findById(courseTypeId);
	}

	@Override
	public void addOrEdit(CrmCourseType crmCourseType) {
		this.courseTypeDao.saveOrUpdate(crmCourseType);
	}

}
