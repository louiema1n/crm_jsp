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

}
