package com.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.session.check.CheckSession;
import com.dao.*;
import com.entity.*;


public class StudentRZ extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<Building> buildinglist;
	private List<Domitory> domitorylist=new ArrayList<Domitory>();

	public List<Building> getBuildinglist() {
		return buildinglist;
	}

	public void setBuildinglist(List<Building> buildinglist) {
		this.buildinglist = buildinglist;
	}

	public List<Domitory> getDomitorylist() {
		return domitorylist;
	}

	public void setDomitorylist(List<Domitory> domitorylist) {
		this.domitorylist = domitorylist;
	}

	private String BuildingID;
	private String DomitoryID;
	public String getBuildingID() {
		return BuildingID;
	}

	public void setBuildingID(String buildingID) {
		BuildingID = buildingID;
	}

	public String getDomitoryID() {
		return DomitoryID;
	}

	public void setDomitoryID(String domitoryID) {
		DomitoryID = domitoryID;
	}

	//�����û������execute����
	public String execute() throws Exception {
		
		CheckSession.check();
		String strwhere="1=1";
		//��ѯ¥��
		buildinglist=new BuildingDao().GetList(strwhere,"Building_Name");
		//��ѯ����
		ActionContext context=ActionContext.getContext();
		ValueStack stack=context.getValueStack();
		stack.set("BuildingID", BuildingID);
		
		
		//��ѯ����
		if (BuildingID!=null) {
			Building building=new BuildingDao().GetBean(Integer.parseInt(BuildingID));
			domitorylist=new DomitoryDao().GetdomList(BuildingID,"Domitory_Name");
			stack.set("BuildingName", building.getBuilding_Name());
		}
		
		//�鵽¥�������Ϣ�ŵ�ֵջ��
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
