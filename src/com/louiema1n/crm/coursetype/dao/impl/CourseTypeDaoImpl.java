package com.louiema1n.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.louiema1n.crm.coursetype.dao.CourseTypeDao;
import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

	@Override
	public List<CrmCourseType> findAllCourseTypes() {
		return this.getHibernateTemplate().find("from CrmCourseType");
	}

	@Override
	public List<CrmCourseType> findAllCourseTypes(String hql,
			Object[] params) {
		return this.getHibernateTemplate().find("from CrmCourseType where 1 = 1 "+hql, params);
	}

	@Override
	public CrmCourseType findById(String courseTypeId) {
		return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
	}

	/**
	 * saveOrUpdate方法:
	 * 有OID执行update;
	 * 没有OID执行insert
	 */
	@Override
	public void saveOrUpdate(CrmCourseType crmCourseType) {
		this.getHibernateTemplate().saveOrUpdate(crmCourseType);
	}

}
