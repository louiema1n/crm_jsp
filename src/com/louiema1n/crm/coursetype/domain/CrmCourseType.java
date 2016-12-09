package com.louiema1n.crm.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import com.louiema1n.crm.classes.domain.CrmClasses;

public class CrmCourseType {
	/**
	 *    `courseTypeId` VARCHAR(255) NOT NULL PRIMARY KEY,
		  `courseCost` DOUBLE DEFAULT NULL,
		  `total` INT(11) DEFAULT NULL,
		  `courseName` VARCHAR(500) DEFAULT NULL,
		  `remark` VARCHAR(5000) DEFAULT NULL
	 */
	private String courseTypeId;
	private Double courseCost;
	private Integer total;
	private String courseName;
	private String remark;
	
	//[一个课程类型] 包含 [多个课程]
	private Set<CrmClasses> crmClasses = new HashSet<CrmClasses>();
	
	//由于多条件查询时,总学时  课程费用两个字段是区间值,需增加相应字段存值
	private String totalStart;
	private String totalEnd;

	private String courseCostStart;
	private String courseCostEnd;
	
	

	public String getTotalStart() {
		return totalStart;
	}

	public void setTotalStart(String totalStart) {
		this.totalStart = totalStart;
	}

	public String getTotalEnd() {
		return totalEnd;
	}

	public void setTotalEnd(String totalEnd) {
		this.totalEnd = totalEnd;
	}

	public String getCourseCostStart() {
		return courseCostStart;
	}

	public void setCourseCostStart(String courseCostStart) {
		this.courseCostStart = courseCostStart;
	}

	public String getCourseCostEnd() {
		return courseCostEnd;
	}

	public void setCourseCostEnd(String courseCostEnd) {
		this.courseCostEnd = courseCostEnd;
	}

	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public Double getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<CrmClasses> getCrmClasses() {
		return crmClasses;
	}

	public void setCrmClasses(Set<CrmClasses> crmClasses) {
		this.crmClasses = crmClasses;
	}
	
	
}
