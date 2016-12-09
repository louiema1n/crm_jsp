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

	@Override
	public void updateStaff(CrmStaff crmStaff) {
		/**
		 * 先查询密码,如果原密码和新密码不一致,则加密并更新除OID外所有字段
		 * 如果一致,则更新除密码和OID外的所有字段
		 * (当一级缓存中的数据被修改,与快照不符,提交时会自动执行update语句)
		 */
		//查询原员工信息
		CrmStaff oldStaff = staffDao.findById(crmStaff.getStaffId());
		//判断密码是否一致
		if (!oldStaff.getLoginPwd().equals(crmStaff.getLoginPwd())) {
			//不一致时,加密,更新
			crmStaff.setLoginPwd(new MyStringUtils().getMD5(crmStaff.getLoginPwd()));
		}
		//更新除OID外其他字段
		oldStaff.setLoginName(crmStaff.getLoginName());
		oldStaff.setStaffName(crmStaff.getStaffName());
		oldStaff.setGender(crmStaff.getGender());
		oldStaff.setOnDutyDate(crmStaff.getOnDutyDate());
		oldStaff.setCrmPost(crmStaff.getCrmPost());
	}

}
