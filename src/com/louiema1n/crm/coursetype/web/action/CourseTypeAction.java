package com.louiema1n.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.coursetype.service.CourseTypeService;
import com.louiema1n.crm.page.PageBean;
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

	//分页数据
	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	private int pageSiaze = 2;	//固定值
	public void setPageSiaze(int pageSiaze) {
		this.pageSiaze = pageSiaze;
	}
	
	public String findAll() {
		/**
		 * 普通查询
		 * //查询所有课程类别
			List<CrmCourseType> allCourseType = this.courseTypeService.findAllCourseType();
			//将数据放入context中,jsp需要用#获取
			ActionContext.getContext().put("allCourseType", allCourseType);
		 */
		
		/**
		 * 高级查询 + 条件
		 */
		PageBean<CrmCourseType> pageBean = this.courseTypeService.findAllCourseType(crmCourseType, pageNum, pageSiaze);
		
		//将数据放入context中,jsp需要用#获取
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "findAll";
	}
	
	/**
	 * 显示添加或者编辑jsp
	 * 如果是编辑,需要传id,并查询显示信息
	 * @return
	 */
	public String addOrEditUI() {
		if (StringUtils.isNotBlank(crmCourseType.getCourseTypeId())) {
			//调用service查询出CrmCourseType
			CrmCourseType findCourse = this.courseTypeService.findById(crmCourseType.getCourseTypeId());
			//将查询到的信息压入valueStack
			ActionContext.getContext().getValueStack().push(findCourse);
		}
		return "addOrEditUI";
	}
	
	/**
	 * 编辑或者添加操作
	 * 如果有id为编辑,没有为添加
	 * @return
	 */
	public String addOrEdit() {
		this.courseTypeService.addOrEdit(crmCourseType);
		return "addOrEdit";
	}
	
	

}
