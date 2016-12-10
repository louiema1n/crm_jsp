package com.louiema1n.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.louiema1n.crm.base.BaseAction;
import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.coursetype.service.CourseTypeService;
import com.louiema1n.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends BaseAction<CrmCourseType> {

	public String findAll() {
		/**
		 * ��ͨ��ѯ
		 * //��ѯ���пγ����
			List<CrmCourseType> allCourseType = this.courseTypeService.findAllCourseType();
			//�����ݷ���context��,jsp��Ҫ��#��ȡ
			ActionContext.getContext().put("allCourseType", allCourseType);
		 */
		
		/**
		 * �߼���ѯ + ����
		 */
		PageBean<CrmCourseType> pageBean = this.getCourseTypeService().findAllCourseType(this.getModel(), this.getPageNum(), this.getPageSiaze());
		
		//�����ݷ���context��,jsp��Ҫ��#��ȡ
		this.put("pageBean", pageBean);
		
		return "findAll";
	}
	
	/**
	 * ��ʾ��ӻ��߱༭jsp
	 * ����Ǳ༭,��Ҫ��id,����ѯ��ʾ��Ϣ
	 * @return
	 */
	public String addOrEditUI() {
		if (StringUtils.isNotBlank(this.getModel().getCourseTypeId())) {
			//����service��ѯ��CrmCourseType
			CrmCourseType findCourse = this.getCourseTypeService().findById(this.getModel().getCourseTypeId());
			//����ѯ������Ϣѹ��valueStack
			this.push(findCourse);
		}
		return "addOrEditUI";
	}
	
	/**
	 * �༭������Ӳ���
	 * �����idΪ�༭,û��Ϊ���
	 * @return
	 */
	public String addOrEdit() {
		this.getCourseTypeService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	
	

}
