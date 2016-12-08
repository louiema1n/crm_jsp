package com.louiema1n.crm.staff.web.action;

import com.louiema1n.crm.staff.domain.CrmStaff;
import com.louiema1n.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	//1.自动封装数据
	private CrmStaff crmStaff = new CrmStaff();

	@Override
	public CrmStaff getModel() {
		return crmStaff;
	}
	
	//2.自动注入StaffService
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	/**
	 * 登陆
	 * @param crmStaff
	 * @return
	 */
	public String login() {
		CrmStaff staff = staffService.login(crmStaff);
		//判断是否登录成功
		if (staff != null) {
			//登录成功
			//将数据放入session作用域中
			ActionContext.getContext().getSession().put("loginStaff", staff);
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
	public String home(){
		return "home";
	}
}
