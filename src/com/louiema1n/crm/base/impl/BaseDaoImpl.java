package com.louiema1n.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.louiema1n.crm.base.BaseDao;
import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.page.PageHibernateCallback;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class beanClass;

	//通过构造方法获得运行时<T>最终代表的对象
	public BaseDaoImpl() {
		//getGenericSuperclass()获取的是:BaseDaoImpl<CrmStaff>,强制转换成ParameterizedType(被参数化的类型)
		ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取所有的T(Type是class的父类),我们只需要第一个
		beanClass = (Class) paramType.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void Update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public List<T> findAll() {
		//beanClass是class类型,这里需要其全类名
		return this.getHibernateTemplate().find("from " + beanClass.getName());
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(beanClass, id);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}
	
	@Override
	public List<T> findAll(String hql, Object[] params) {
		return this.getHibernateTemplate().find("from " + beanClass.getName() + " where 1 = 1 "+hql, params);
	}

	@Override
	public int getTotalRecord(String hql, Object[] params) {
		List list = this.getHibernateTemplate().find("select count(c) from " + beanClass.getName() + " c where 1 = 1 " + hql, params);
		Long record = (Long) list.get(0);
		//包装类型转换成普通类型,调用.方法名
		return record.intValue();
	}

	@Override
	public List<T> findAll(T t, String hql, Object[] params, int startIndex, int pageSize) {
		String condition = "from " + beanClass.getName() + " where 1 = 1 " + hql;
		return (List<T>) this.getHibernateTemplate().execute(new PageHibernateCallback<T>().setHql(condition).setPageSize(pageSize).setParams(params).setStartIndex(startIndex));
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize) {
		return this.getHibernateTemplate().findByCriteria(criteria, startIndex, pageSize);
	}

	
}
