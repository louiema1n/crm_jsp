package com.louiema1n.crm.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.louiema1n.crm.coursetype.domain.CrmCourseType;

public interface BaseDao<T> {

	/**
	 * 增加
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 删除
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 修改
	 * @param t
	 */
	public void Update(T t);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	
	/**
	 * 新增(无OID)或修改
	 */
	public void saveOrUpdate(T t);
	
	/**
	 * 条件查询
	 * @param crmCourseType
	 * @return
	 */
	public List<T> findAll(String hql, Object[] params);

	/**
	 * 获取总记录数
	 * @param hql
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String hql, Object[] params);

	/**
	 * 带条件分页
	 * @param crmCourseType
	 * @param hql
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(T t, String hql, Object[] params, int startIndex, int pageSize);
	
	/**
	 * 离线条件查询,使用QBC
	 */
	public List<T> findAll(DetachedCriteria criteria);
	
	/**
	 * 分页
	 */
	public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize);
	
}
