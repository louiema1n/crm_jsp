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
	 * ��½
	 * @param crmStaff
	 * @return
	 */
	public String login() {
		CrmStaff staff = this.getStaffService().login(this.getModel());
		//�ж��Ƿ��¼�ɹ�
		if (staff != null) {
			//��¼�ɹ�
			//�����ݷ���session��������
			this.put("loginStaff", staff);
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
	public String home() {
		return "home";
	}
	
	public String findAllStaff() {
		List<CrmStaff> allStaff = this.getStaffService().findAll();
		//������Ա����Ϣ����ֵջ��
		this.set("allStaff", allStaff);
		//������Ϣ
		return "findAllStaff";
	}
	
	
	/**
	 * �༭�����������
	 * @return
	 */
	public String editUI() {
		//����service����id��ѯԱ����Ϣ
		CrmStaff staff = this.getStaffService().findById(this.getModel().getStaffId());
		//��staffѹ��ֵջ
		ActionContext.getContext().getValueStack().push(staff);
		
		//����DepartmentService��ѯ���в���
		List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
		//��allDepartment����valueStack
		this.set("allDepartment", allDepartment);
		
		return "editUI";
	}
	
	/**
	 * �༭��ɺ󱣴�
	 * @return
	 */
	public String edit() {
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
	
}
