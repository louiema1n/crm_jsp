package com.louiema1n.crm.staff.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.louiema1n.crm.staff.dao.StaffDao;
import com.louiema1n.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

	//ÐèÒªspring×¢Èësessionfactory
	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		List<CrmStaff> crmList = this.getHibernateTemplate().find("from CrmStaff where loginName = ? and loginPwd = ?", loginName, loginPwd);
		if (crmList.size() == 1) {
			return crmList.get(0);
		}
		return null;
	}

	@Override
	public List<CrmStaff> findAll() {
		return this.getHibernateTemplate().find("from CrmStaff");
	}

	@Override
	public CrmStaff findById(String staffId) {
		return this.getHibernateTemplate().get(CrmStaff.class, staffId);
	}

}
