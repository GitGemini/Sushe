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


public class BuildingUpdate extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Building_ID;
	private Building cnbean;
	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String studentID) {
		Building_ID = studentID;
	}

	public Building getCnbean() {
		return cnbean;
	}

	public void setCnbean(Building cnbean) {
		this.cnbean = cnbean;
	}

	//�����û������execute����
	public String execute() throws Exception {
		
		CheckSession.check();
		
		//��ѯ
		cnbean=new BuildingDao().GetBean(Integer.parseInt(Building_ID));
		//cnbean�浽ֵջ��
		
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
