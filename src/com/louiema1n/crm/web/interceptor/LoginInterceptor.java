package com.louiema1n.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		
		//得到session中的loginStaff
		Object obj = ActionContext.getContext().getSession().get("loginStaff");
		//判断obj是否为空,来判断是否登录
		if (obj == null) {
			//没有登录,需要登录
			//1.提示需要登录信息
			//得到当前action
			Object action = invocation.getAction();
			//判断是否为ActionSupport对象
			if (action instanceof ActionSupport) {
				//强转为ActionSupport
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("", "请登录");
			}
			//2.返回login
			return "login";
		}
		
		//已经登录,放行
		return invocation.invoke();
	}

}
