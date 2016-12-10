package com.louiema1n.crm.post.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.louiema1n.crm.base.impl.BaseDaoImpl;
import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.post.dao.PostDao;
import com.louiema1n.crm.post.domain.CrmPost;

public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao {

	@Override
	public List<CrmPost> findByDepartment(CrmDepartment crmDepartment) {
		return this.getHibernateTemplate().find("from CrmPost where depId = ? ", crmDepartment.getDepId());
	}

}
