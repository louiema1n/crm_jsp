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
	//封装数据
	private T t;
	//获取运行时T实际代表的对象--构造方法
	public BaseAction() {
		try {
			//获取BaseAction<CrmStaff>
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			//调用ParameterizedType的方法获取CrmStaff(type强转)
			Class<T> clazz = (Class) paramType.getActualTypeArguments()[0];
			//通过 反射 创建一个CrmStaff类型的crmStaff
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
	//spring自动注入service,多个
	//课程类别
	private CourseTypeService courseTypeService;
	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	//职务
	private PostService postService;
	public PostService getPostService() {
		return postService;
	}
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	//部门
	private DepartmentService departmentService;
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//员工
	private StaffService staffService;
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	//班级

	//------------------------
	//分页
	private int pageNum = 1;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	private int pageSiaze = 2;	//固定值
	public int getPageSiaze() {
		return pageSiaze;
	}
	public void setPageSiaze(int pageSiaze) {
		this.pageSiaze = pageSiaze;
	}
	
	//------------------------
	//简化值栈操作
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
