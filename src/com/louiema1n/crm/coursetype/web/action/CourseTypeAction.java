package com.louiema1n.crm.coursetype.web.action;

import java.util.List;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.coursetype.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements
		ModelDriven<CrmCourseType> {

	//��װ����
	CrmCourseType crmCourseType = new CrmCourseType();
	
	@Override
	public CrmCourseType getModel() {
		return crmCourseType;
	}
	
	//spring�Զ�ע��
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	public String findAll() {
		//��ѯ���пγ����
		List<CrmCourseType> allCourseType = this.courseTypeService.findAllCourseType();
		//�����ݷ���context��,jsp��Ҫ��#��ȡ
		ActionContext.getContext().put("allCourseType", allCourseType);
		
		return "findAll";
	}

}
