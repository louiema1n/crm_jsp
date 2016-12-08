package com.louiema1n.crm.staff.service.impl;

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

}
