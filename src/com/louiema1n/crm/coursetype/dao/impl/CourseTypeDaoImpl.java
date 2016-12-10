package com.louiema1n.crm.coursetype.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.louiema1n.crm.base.impl.BaseDaoImpl;
import com.louiema1n.crm.coursetype.dao.CourseTypeDao;
import com.louiema1n.crm.coursetype.domain.CrmCourseType;
import com.louiema1n.crm.page.PageHibernateCallback;

public class CourseTypeDaoImpl extends BaseDaoImpl<CrmCourseType> implements CourseTypeDao {

}
