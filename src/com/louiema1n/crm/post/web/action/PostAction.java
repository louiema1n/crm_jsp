package com.louiema1n.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.louiema1n.crm.base.BaseAction;
import com.louiema1n.crm.post.domain.CrmPost;
import com.louiema1n.crm.post.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends BaseAction<CrmPost> {

	/**
	 * 通过depId查询所有的post(JSON)
	 * @return
	 * @throws IOException 
	 */
	public String findByDepartment() throws IOException {
		//1.通过depId调用postService查询post
		List<CrmPost> listPost = this.getPostService().findByDepartment(this.getModel().getCrmDepartment());
		
		//2.将Java bean封装成json数据(list,array用JSONArray;map,Javabean用JSONObject)
		//先排除不需要的crmDepartment.crmStaffs否则死循环
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"crmDepartment","crmStaffs"});
		String jsonData = JSONArray.fromObject(listPost, jsonConfig).toString();
		
		//解决发送数据编码问题
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		
		//3.将JSON数据发送给浏览器
		ServletActionContext.getResponse().getWriter().print(jsonData);
		
		//不返回值至Struts
		return "none";
	}

}
