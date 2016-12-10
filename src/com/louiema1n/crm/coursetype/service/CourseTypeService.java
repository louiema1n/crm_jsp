package com.louiema1n.crm.coursetype.service;

import java.util.List;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.page.PageBean;

public interface CourseTypeService {

	/**
	 * ��ѯ���пγ����
	 * @return
	 */
	public List<CrmCourseType> findAllCourseType();

	/**
	 * �߼���ѯ
	 * @param crmCourseType
	 * @return
	 */
	public List<CrmCourseType> findAllCourseType(CrmCourseType crmCourseType);

	/**
	 * ����id��ѯ�γ���Ϣ
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);

	/**
	 * �༭����Ӳ���
	 * @param crmCourseType
	 */
	public void addOrEdit(CrmCourseType crmCourseType);
	
	/**
	 * ����ҳ�����Ĳ�ѯ��ҳ����
	 * @param crmCourseType
	 * @return
	 */
	public PageBean<CrmCourseType> findAllCourseType(CrmCourseType crmCourseType, int pageNum, int pageSize);
	
}
