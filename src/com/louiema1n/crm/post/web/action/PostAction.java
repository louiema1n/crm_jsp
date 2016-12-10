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
	 * ͨ��depId��ѯ���е�post(JSON)
	 * @return
	 * @throws IOException 
	 */
	public String findByDepartment() throws IOException {
		//1.ͨ��depId����postService��ѯpost
		List<CrmPost> listPost = this.getPostService().findByDepartment(this.getModel().getCrmDepartment());
		
		//2.��Java bean��װ��json����(list,array��JSONArray;map,Javabean��JSONObject)
		//���ų�����Ҫ��crmDepartment.crmStaffs������ѭ��
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"crmDepartment","crmStaffs"});
		String jsonData = JSONArray.fromObject(listPost, jsonConfig).toString();
		
		//����������ݱ�������
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		
		//3.��JSON���ݷ��͸������
		ServletActionContext.getResponse().getWriter().print(jsonData);
		
		//������ֵ��Struts
		return "none";
	}

}
