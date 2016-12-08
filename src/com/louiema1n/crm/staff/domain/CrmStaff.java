package com.louiema1n.crm.staff.domain;

import java.util.Date;

import com.louiema1n.crm.post.domain.CrmPost;


public class CrmStaff {
	/**
	 *    `staffId` VARCHAR(255) NOT NULL PRIMARY KEY,
		  `loginName` VARCHAR(100) DEFAULT NULL,
		  `loginPwd` VARCHAR(100) DEFAULT NULL,
		  `staffName` VARCHAR(100) DEFAULT NULL,
		  `gender` VARCHAR(20) DEFAULT NULL,
		  `onDutyDate` DATETIME DEFAULT NULL,
		  `postId` VARCHAR(255) DEFAULT NULL,
		  CONSTRAINT FOREIGN KEY (`postId`) REFERENCES `crm_post` (`postId`)
	 */
	private String staffId;
	private String loginName;
	private String loginPwd;
	private String staffName;
	private String gender;
	private Date onDutyDate;
	
	//[多个员工] 属于 [一个职务]
	private CrmPost crmPost;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getOnDutyDate() {
		return onDutyDate;
	}

	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}

	public CrmPost getCrmPost() {
		return crmPost;
	}

	public void setCrmPost(CrmPost crmPost) {
		this.crmPost = crmPost;
	}
	
	
}
