package com.louiema1n.crm.coursetype.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.louiema1n.crm.coursetype.dao.CourseTypeDao;
import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.page.PageHibernateCallback;

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

	@Override
	public int getTotalRecord(String hql, Object[] params) {
		List list = this.getHibernateTemplate().find("select count(c) from CrmCourseType c where 1 = 1 " + hql, params);
		Long record = (Long) list.get(0);
		//包装类型转换成普通类型,调用.方法名
		return record.intValue();
	}

	@Override
	public List<CrmCourseType> findAllCourseTypes(CrmCourseType crmCourseType, String hql, Object[] params,
			int startIndex, int pageSize) {
		String condition = "from CrmCourseType where 1 = 1 " + hql;
		return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>().setHql(condition).setPageSize(pageSize).setParams(params).setStartIndex(startIndex));
	}

}
