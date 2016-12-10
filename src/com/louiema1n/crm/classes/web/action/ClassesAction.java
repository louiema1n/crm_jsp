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
	 * 查询所有
	 */
	public String findAll() {
		//获取所有CrmClasses
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		//放入值栈
		this.set("allClasses", allClasses);
		return "findAll";
	}
	
	/**
	 * 显示上传文件界面
	 */
	public String uploadUI() {
		//1.先根据classesId查询classes信息
		CrmClasses classes = this.getClassesService().findById(this.getModel().getClassId());
		//2.将查询的信息回显到浏览器(压入值栈)
		this.push(classes);
		
		return "uploadUI";
	}
	
	/**
	 * 上传文件
	 */
	private File schedule;					//上传的文件
	private String scheduleFileName;		//上传的原始文件名
	private String scheduleContextType;		//上传的文件类型
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

	@InputConfig(resultName="uploadInput")			//自定义错误返回值
	public String upload() throws IOException {
		//1.获取存放上传文件的父目录(没有则创建)
		String parentPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//2.更改文件名为UUID(去掉4个'-',得到32位文件名)
		String tempFileName = MyStringUtils.getUUID();
		//3.保存文件
		FileUtils.copyFile(schedule, new File(parentPath, tempFileName));
		//4.更新信息到数据库
		
		this.getModel().setUploadFilename(scheduleFileName);
		this.getModel().setUploadPath("/WEB-INF/upload" + tempFileName);
		this.getModel().setUploadTime(new Date());
		
		this.getClassesService().update(this.getModel());
		return "upload";
	}
	
	
	
	
}
