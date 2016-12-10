package com.louiema1n.crm.classes.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.louiema1n.crm.base.BaseAction;
import com.louiema1n.crm.classes.domain.CrmClasses;
import com.louiema1n.crm.utils.MyStringUtils;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class ClassesAction extends BaseAction<CrmClasses> {
	/**
	 * ��ѯ����
	 */
	public String findAll() {
		//��ȡ����CrmClasses
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		//����ֵջ
		this.set("allClasses", allClasses);
		return "findAll";
	}
	
	/**
	 * ��ʾ�ϴ��ļ�����
	 */
	public String uploadUI() {
		//1.�ȸ���classesId��ѯclasses��Ϣ
		CrmClasses classes = this.getClassesService().findById(this.getModel().getClassId());
		//2.����ѯ����Ϣ���Ե������(ѹ��ֵջ)
		this.push(classes);
		
		return "uploadUI";
	}
	
	/**
	 * �ϴ��ļ�
	 */
	private File schedule;					//�ϴ����ļ�
	private String scheduleFileName;		//�ϴ���ԭʼ�ļ���
	private String scheduleContextType;		//�ϴ����ļ�����
	public File getSchedule() {
		return schedule;
	}

	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}

	public String getScheduleFileName() {
		return scheduleFileName;
	}

	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}

	public String getScheduleContextType() {
		return scheduleContextType;
	}

	public void setScheduleContextType(String scheduleContextType) {
		this.scheduleContextType = scheduleContextType;
	}

	@InputConfig(resultName="uploadInput")			//�Զ�����󷵻�ֵ
	public String upload() throws IOException {
		//1.��ȡ����ϴ��ļ��ĸ�Ŀ¼(û���򴴽�)
		String parentPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//2.�����ļ���ΪUUID(ȥ��4��'-',�õ�32λ�ļ���)
		String tempFileName = MyStringUtils.getUUID();
		//3.�����ļ�
		FileUtils.copyFile(schedule, new File(parentPath, tempFileName));
		//4.������Ϣ�����ݿ�
		
		this.getModel().setUploadFilename(scheduleFileName);
		this.getModel().setUploadPath("/WEB-INF/upload" + tempFileName);
		this.getModel().setUploadTime(new Date());
		
		this.getClassesService().update(this.getModel());
		return "upload";
	}
	
	
	
	
}
