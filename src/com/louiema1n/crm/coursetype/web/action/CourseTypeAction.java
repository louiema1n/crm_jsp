package com.louiema1n.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
		/**
		 * ��ͨ��ѯ
		 * //��ѯ���пγ����
			List<CrmCourseType> allCourseType = this.courseTypeService.findAllCourseType();
			//�����ݷ���context��,jsp��Ҫ��#��ȡ
			ActionContext.getContext().put("allCourseType", allCourseType);
		 */
		
		/**
		 * �߼���ѯ
		 */
		List<CrmCourseType> allCourseType = this.courseTypeService.findAllCourseType(crmCourseType);
		
		//�����ݷ���context��,jsp��Ҫ��#��ȡ
		ActionContext.getContext().put("allCourseType", allCourseType);
		
		return "findAll";
	}
	
	/**
	 * ��ʾ��ӻ��߱༭jsp
	 * ����Ǳ༭,��Ҫ��id,����ѯ��ʾ��Ϣ
	 * @return
	 */
	public String addOrEditUI() {
		if (StringUtils.isNotBlank(crmCourseType.getCourseTypeId())) {
			//����service��ѯ��CrmCourseType
			CrmCourseType findCourse = this.courseTypeService.findById(crmCourseType.getCourseTypeId());
			//����ѯ������Ϣѹ��valueStack
			ActionContext.getContext().getValueStack().push(findCourse);
		}
		return "addOrEditUI";
	}
	
	/**
	 * �༭������Ӳ���
	 * �����idΪ�༭,û��Ϊ���
	 * @return
	 */
	public String addOrEdit() {
		this.courseTypeService.addOrEdit(crmCourseType);
		return "addOrEdit";
	}

}
