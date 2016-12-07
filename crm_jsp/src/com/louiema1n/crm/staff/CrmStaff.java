package com.louiema1n.crm.staff;

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
	private String postId;
	
	//[多个员工] 属于 [一个职务]
	private CrmPost crmPost;
}
