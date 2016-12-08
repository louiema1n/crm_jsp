package com.louiema1n.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		
		//�õ�session�е�loginStaff
		Object obj = ActionContext.getContext().getSession().get("loginStaff");
		//�ж�obj�Ƿ�Ϊ��,���ж��Ƿ��¼
		if (obj == null) {
			//û�е�¼,��Ҫ��¼
			//1.��ʾ��Ҫ��¼��Ϣ
			//�õ���ǰaction
			Object action = invocation.getAction();
			//�ж��Ƿ�ΪActionSupport����
			if (action instanceof ActionSupport) {
				//ǿתΪActionSupport
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("", "���¼");
			}
			//2.����login
			return "login";
		}
		
		//�Ѿ���¼,����
		return invocation.invoke();
	}

}
