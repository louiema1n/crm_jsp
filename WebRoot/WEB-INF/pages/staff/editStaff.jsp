<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

	<s:form action="staffAction_edit">
	<s:hidden name="staffId" value="%{staffId}"></s:hidden>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><s:textfield name="loginName"></s:textfield></td>
	    <td>密码：</td>
	    <td><s:password name="loginPwd" showPassword="true"></s:password></td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><s:textfield name="staffName"></s:textfield></td>
	    <td>性别：</td>
	    <td>
	    	<s:radio list="{'男','女'}" name="gender"></s:radio>
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
			<s:select list="allDepartment" name="crmPost.crmDepartment.depId" onchange="showPost(this)"
				listKey="depId" listValue="depName"
				headerKey="" headerValue="----请--选--择----"
			></s:select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
			<%--当前员工所属职务.该职务所属部门.该部门下所有职务 --%>
			<s:select list="crmPost != null ? crmPost.crmDepartment.crmPosts : {}" name="crmPost.postId" id="selectPostId"
				listKey="postId" listValue="postName"
				headerKey="" headerValue="----请--选--择----"
			></s:select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<s:date name="onDutyDate" format="yyyy-MM-dd" var="formatOnDutyDate"/>
	    	<s:textfield name="onDutyDate" value="%{#formatOnDutyDate}" readonly="true" onfocus="c.showMoreDay=true; c.show(this);"></s:textfield>
	    </td>
	    <td width="8%"></td>
	    <td width="62%">&nbsp;</td>
	  </tr>
	</table>
</s:form>

<script type="text/javascript">
	//改变department时自动更新post
	function showPost(obj) {
		//获取当前选中的depId
		var depId = obj.value;
		
		//使用 ajax 通过depId查询post并回显
		//1.获得ajax引擎
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xmlhttp=new XMLHttpRequest();
		  }
		else{// code for IE6, IE5
		 	 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		 
		//2.设置回调函数
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//1.数据响应并回传成功,接受数据
				var textData = xmlhttp.responseText;
				
				//2.将字符串封装成json对象(eval()函数将json文本转换为js对象)
				var jsonData = eval("("+textData+")");
				
				//4.获得职务对象
				var selectPostId = document.getElementById("selectPostId"); 
				selectPostId.innerHTML = "<option value=''>----请--选--择----</option>";
				
				//3.遍历数据添加到职务是option中
				for ( var i = 0; i < jsonData.length; i++) {
					var postObj = jsonData[i];
					//获得postId
					var postId = postObj.postId;
					//获得postName
					var postName = postObj.postName;
					//将数据填充给selectPostId
					selectPostId.innerHTML += "<option value="+"'"+postId+"'>"+postName+"</option>";
				}
				
			}
		};
		
		//3.创建连接
		xmlhttp.open("GET", "${pageContext.request.contextPath}/postAction_findByDepartment?crmDepartment.depId="+depId);
		
		//4.发送请求
		xmlhttp.send(null);
		
	}
</script>

</body>
</html>
