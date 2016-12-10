package com.louiema1n.crm.staff.web.action;

import java.util.List;

import com.louiema1n.crm.base.BaseAction;
import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.department.service.DepartmentService;
import com.louiema1n.crm.staff.domain.CrmStaff;
import com.louiema1n.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends BaseAction<CrmStaff> {

	/**
	 * 登陆
	 * @param crmStaff
	 * @return
	 */
	public String login() {
		CrmStaff staff = this.getStaffService().login(this.getModel());
		//判断是否登录成功
		if (staff != null) {
			//登录成功
			//将数据放入session作用域中
			this.put("loginStaff", staff);
			//重定向至主页
			return "success";
		}
		
		//登录失败,回显错误提示信息
		this.addFieldError("", "用户名或密码不正确");
		//请求转发至登陆页面
		return "login";
	}
	
	/**
	 * 登陆成功
	 */
	public String home() {
		return "home";
	}
	
	public String findAllStaff() {
		List<CrmStaff> allStaff = this.getStaffService().findAll();
		//将所有员工信息放入值栈中
		this.set("allStaff", allStaff);
		//返回信息
		return "findAllStaff";
	}
	
	
	/**
	 * 编辑界面回显数据
	 * @return
	 */
	public String editUI() {
		//调用service根据id查询员工信息
		CrmStaff staff = this.getStaffService().findById(this.getModel().getStaffId());
		//将staff压入值栈
		ActionContext.getContext().getValueStack().push(staff);
		
		//调用DepartmentService查询所有部门
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		//将allDepartment放入valueStack
		this.set("allDepartment", allDepartment);
		
		return "editUI";
	}
	
	/**
	 * 编辑完成后保存
	 * @return
	 */
	public String edit() {
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
	
}
