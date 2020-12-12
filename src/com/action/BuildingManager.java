package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.session.check.CheckSession;
import com.dao.*;
import com.entity.*;


public class BuildingManager extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<Building> list;
	public List<Building> getList() {
		return list;
	}
	public void setList(List<Building> list) {
		this.list = list;
	}
	private String SearchKey;
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	//�����û������execute����
	public String execute() throws Exception {
		
		CheckSession.check();
		//��ѯ����
		String strWhere="1=1";
		System.out.println(SearchKey);
		if((isInvalid(SearchKey))) {
			//��ѯ����
			list=new BuildingDao().GetList(strWhere,"Building_Name");
			
		}else {
			list=new BuildingDao().GetListSelective(SearchKey,"Building_Name");
		}
		
		//list����ֵջ��
		return SUCCESS;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}
	
}
