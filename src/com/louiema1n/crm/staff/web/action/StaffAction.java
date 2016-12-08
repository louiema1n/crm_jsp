package com.louiema1n.crm.staff.web.action;

import com.louiema1n.crm.staff.domain.CrmStaff;
import com.louiema1n.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	//1.�Զ���װ����
	private CrmStaff crmStaff = new CrmStaff();

	@Override
	public CrmStaff getModel() {
		return crmStaff;
	}
	
	//2.�Զ�ע��StaffService
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	/**
	 * ��½
	 * @param crmStaff
	 * @return
	 */
	public String login() {
		CrmStaff staff = staffService.login(crmStaff);
		//�ж��Ƿ��¼�ɹ�
		if (staff != null) {
			//��¼�ɹ�
			//�����ݷ���session��������
			ActionContext.getContext().getSession().put("loginStaff", staff);
			//�ض�������ҳ
			return "success";
		}
		
		//��¼ʧ��,���Դ�����ʾ��Ϣ
		this.addFieldError("", "�û��������벻��ȷ");
		//����ת������½ҳ��
		return "login";
	}
	
	/**
	 * ��½�ɹ�
	 */
	public String home(){
		return "home";
	}
}
