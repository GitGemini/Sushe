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


public class BuildingDel extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Building_ID ;
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String userID) {
		Building_ID = userID;
	}

	//�����û������execute����
	public String execute() throws Exception {
		CheckSession.check();
		//ɾ��
		new BuildingDao().Delete(Building_ID);
		    
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
