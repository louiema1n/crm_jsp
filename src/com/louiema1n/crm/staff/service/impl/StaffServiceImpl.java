package com.louiema1n.crm.staff.service.impl;

import java.util.List;

import com.louiema1n.crm.staff.dao.StaffDao;
import com.louiema1n.crm.staff.domain.CrmStaff;
import com.louiema1n.crm.staff.service.StaffService;
import com.louiema1n.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	@Override
	public CrmStaff login(CrmStaff crmStaff) {
		//���������MD5����
		String md5LoginPwd = new MyStringUtils().getMD5(crmStaff.getLoginPwd());
		return staffDao.find(crmStaff.getLoginName(), md5LoginPwd);
	}

	@Override
	public List<CrmStaff> findAll() {
		return staffDao.findAll();
	}

	@Override
	public CrmStaff findById(String staffId) {
		return staffDao.findById(staffId);
	}

	@Override
	public void updateStaff(CrmStaff crmStaff) {
		/**
		 * �Ȳ�ѯ����,���ԭ����������벻һ��,����ܲ����³�OID�������ֶ�
		 * ���һ��,����³������OID��������ֶ�
		 * (��һ�������е����ݱ��޸�,����ղ���,�ύʱ���Զ�ִ��update���)
		 */
		//��ѯԭԱ����Ϣ
		CrmStaff oldStaff = staffDao.findById(crmStaff.getStaffId());
		//�ж������Ƿ�һ��
		if (!oldStaff.getLoginPwd().equals(crmStaff.getLoginPwd())) {
			//��һ��ʱ,����,����
			crmStaff.setLoginPwd(new MyStringUtils().getMD5(crmStaff.getLoginPwd()));
		}
		//���³�OID�������ֶ�
		oldStaff.setLoginName(crmStaff.getLoginName());
		oldStaff.setStaffName(crmStaff.getStaffName());
		oldStaff.setGender(crmStaff.getGender());
		oldStaff.setOnDutyDate(crmStaff.getOnDutyDate());
		oldStaff.setCrmPost(crmStaff.getCrmPost());
	}

}
