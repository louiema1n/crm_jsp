package com.louiema1n.crm.page;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;

	@Override
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		//1.ͨ��hql���,���Query����
		Query queryObj = session.createQuery(hql);
		//2.��������	
		for (int i = 0; i < params.length; i++) {
			queryObj.setParameter(i, params[i]);
		}
		//3.��ҳ
		queryObj.setFirstResult(startIndex);
		queryObj.setMaxResults(pageSize);
		//4.��ѯ����
		return queryObj.list();
	}

	public PageHibernateCallback<T> setHql(String hql) {
		this.hql = hql;
		return this;
	}

	public PageHibernateCallback<T> setParams(Object[] params) {
		this.params = params;
		return this;
	}

	public PageHibernateCallback<T> setStartIndex(int startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	public PageHibernateCallback<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	
}
