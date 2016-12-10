package com.louiema1n.crm.classes.service.impl;

import java.util.List;

import com.louiema1n.crm.classes.dao.ClassesDao;
import com.louiema1n.crm.classes.domain.CrmClasses;
import com.louiema1n.crm.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {

	private ClassesDao classesDao;
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@Override
	public List<CrmClasses> findAll() {
		return classesDao.findAll();
	}

	@Override
	public CrmClasses findById(String classId) {
		return classesDao.findById(classId);
	}

	@Override
	public void update(CrmClasses model) {
		//�ȸ���id��ѯ
		CrmClasses classes = classesDao.findById(model.getClassId());
		//ʹ�ÿ��պ�һ�������Զ���������
		classes.setUploadFilename(model.getUploadFilename());
		classes.setUploadPath(model.getUploadPath());
		classes.setUploadTime(model.getUploadTime());
	}

}
