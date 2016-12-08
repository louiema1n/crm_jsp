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
		//将密码进行MD5加密
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

}
