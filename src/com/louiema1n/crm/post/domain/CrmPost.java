package com.louiema1n.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.louiema1n.crm.department.domain.CrmDepartment;
import com.louiema1n.crm.staff.domain.CrmStaff;

public class CrmPost {
	/**
	 *    `postId` VARCHAR(255) NOT NULL PRIMARY KEY,
		  `postName` VARCHAR(100) DEFAULT NULL,
		  `depId` VARCHAR(255) DEFAULT NULL,
		  CONSTRAINT FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
	 */
	
	private String postId;
	private String postName;
	private String depId;
	
	//[多个职务] 属于 [一个部门]
	private CrmDepartment crmDepartment;

	//[一个职务] 包含 [多个员工]
	private Set<CrmStaff> crmStaffs = new HashSet<CrmStaff>();

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public CrmDepartment getCrmDepartment() {
		return crmDepartment;
	}

	public void setCrmDepartment(CrmDepartment crmDepartment) {
		this.crmDepartment = crmDepartment;
	}

	public Set<CrmStaff> getCrmStaffs() {
		return crmStaffs;
	}

	public void setCrmStaffs(Set<CrmStaff> crmStaffs) {
		this.crmStaffs = crmStaffs;
	}
	
	
	
}
