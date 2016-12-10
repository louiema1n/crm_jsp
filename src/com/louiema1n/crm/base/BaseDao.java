package com.louiema1n.crm.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public interface BaseDao<T> {

	/**
	 * ����
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * ɾ��
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * �޸�
	 * @param t
	 */
	public void Update(T t);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * ����ID��ѯ
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	
	/**
	 * ����(��OID)���޸�
	 */
	public void saveOrUpdate(T t);
	
	/**
	 * ������ѯ
	 * @param crmCourseType
	 * @return
	 */
	public List<T> findAll(String hql, Object[] params);

	/**
	 * ��ȡ�ܼ�¼��
	 * @param hql
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String hql, Object[] params);

	/**
	 * ��������ҳ
	 * @param crmCourseType
	 * @param hql
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(T t, String hql, Object[] params, int startIndex, int pageSize);
	
	/**
	 * ����������ѯ,ʹ��QBC
	 */
	public List<T> findAll(DetachedCriteria criteria);
	
	/**
	 * ��ҳ
	 */
	public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize);
	
}
