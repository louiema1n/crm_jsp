package com.louiema1n.crm.coursetype.web.action;

import java.util.List;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.coursetype.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements
		ModelDriven<CrmCourseType> {

	//封装数据
	CrmCourseType crmCourseType = new CrmCourseType();
	
	@Override
	public CrmCourseType getModel() {
		return crmCourseType;
	}
	
	//spring自动注入
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	public String findAll() {
		//查询所有课程类别
		List<CrmCourseType> allCourseType = this.courseTypeService.findAllCourseType();
		//将数据放入context中,jsp需要用#获取
		ActionContext.getContext().put("allCourseType", allCourseType);
		
		return "findAll";
	}

}
