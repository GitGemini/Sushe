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


public class DomitoryAdd extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<Building> list;
	public List<Building> getList() {
		return list;
	}
	public void setList(List<Building> list) {
		this.list = list;
	}
	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		CheckSession.check();
		String strwhere="1=1";
		//��ѯ����¥��
		list=new BuildingDao().GetList(strwhere,"Building_Name");
	
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
