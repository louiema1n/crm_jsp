package com.louiema1n.crm.staff.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.louiema1n.crm.base.impl.BaseDaoImpl;
import com.louiema1n.crm.staff.dao.StaffDao;
import com.louiema1n.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao {

	//ÐèÒªspring×¢Èësessionfactory
	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		List<CrmStaff> crmList = this.getHibernateTemplate().find("from CrmStaff where loginName = ? and loginPwd = ?", loginName, loginPwd);
		if (crmList.size() == 1) {
			return crmList.get(0);
		}
		return null;
	}

}
