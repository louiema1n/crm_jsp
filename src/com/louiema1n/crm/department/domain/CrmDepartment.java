package com.louiema1n.crm.department.domain;

import java.util.HashSet;
import java.util.Set;

import com.louiema1n.crm.post.domain.CrmPost;

public class CrmDepartment {
	/**
	 * `depId` VARCHAR(255) NOT NULL PRIMARY KEY,
  	   `depName` VARCHAR(50) DEFAULT NULL
	 */
	
	private String depId;
	private String depName;
	
	//[一个部门] 包含 [多个职务]
	private Set<CrmPost> crmPosts = new HashSet<CrmPost>();

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set<CrmPost> getCrmPosts() {
		return crmPosts;
	}

	public void setCrmPosts(Set<CrmPost> crmPosts) {
		this.crmPosts = crmPosts;
	} 
	
	
	
}
