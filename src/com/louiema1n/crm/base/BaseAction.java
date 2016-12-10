package com.louiema1n.crm.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.louiema1n.crm.coursetype.service.CourseTypeService;
import com.louiema1n.crm.department.service.DepartmentService;
import com.louiema1n.crm.department.service.impl.DepartmentServiceImpl;
import com.louiema1n.crm.post.service.PostService;
import com.louiema1n.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	//------------------------
	//��װ����
	private T t;
	//��ȡ����ʱTʵ�ʴ���Ķ���--���췽��
	public BaseAction() {
		try {
			//��ȡBaseAction<CrmStaff>
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			//����ParameterizedType�ķ�����ȡCrmStaff(typeǿת)
			Class<T> clazz = (Class) paramType.getActualTypeArguments()[0];
			//ͨ�� ���� ����һ��CrmStaff���͵�crmStaff
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	@Override
	public T getModel() {
		return t;
	}
	
	//------------------------
	//spring�Զ�ע��service,���
	//�γ����
	private CourseTypeService courseTypeService;
	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	//ְ��
	private PostService postService;
	public PostService getPostService() {
		return postService;
	}
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	//����
	private DepartmentService departmentService;
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//Ա��
	private StaffService staffService;
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	//�༶

	//------------------------
	//��ҳ
	private int pageNum = 1;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	private int pageSiaze = 2;	//�̶�ֵ
	public int getPageSiaze() {
		return pageSiaze;
	}
	public void setPageSiaze(int pageSiaze) {
		this.pageSiaze = pageSiaze;
	}
	
	//------------------------
	//��ֵջ����
	public void push(Object o) {
		ActionContext.getContext().getValueStack().push(o);
	}
	
	public void set(String key, Object o) {
		ActionContext.getContext().getValueStack().set(key, o);
	}
	
	public void put(String key, Object obj) {
		ActionContext.getContext().put(key, obj);
	}
	
	public void putSession(String key, Object obj) {
		ActionContext.getContext().getSession().put(key, obj);
	}
	
	public void putApplication(String key, Object obj) {
		ActionContext.getContext().getApplication().put(key, obj);
	}
}
