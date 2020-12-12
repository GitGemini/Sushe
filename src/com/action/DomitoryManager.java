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


public class DomitoryManager extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<Domitory> list;
	public List<Domitory> getList() {
		return list;
	}
	public void setList(List<Domitory> list) {
		this.list = list;
	}
	private String SearchRow;
	private String SearchKey;
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	private List<Building> buildinglist;
	public List<Building> getBuildinglist() {
		return buildinglist;
	}
	public void setBuildinglist(List<Building> buildinglist) {
		this.buildinglist = buildinglist;
	}
	private String Domitory_BuildingID;
	public String getDomitory_BuildingID() {
		return Domitory_BuildingID;
	}
	public void setDomitory_BuildingID(String domitoryBuildingID) {
		Domitory_BuildingID = domitoryBuildingID;
	}
	//�����û������execute����
	public String execute() throws Exception {
		CheckSession.check();
		String strWhere="1=1";
		//��ѯ����¥����Ϣ���ŵ�ֵջ��
				buildinglist=new BuildingDao().GetList(strWhere,"Building_Name");
		
		
		if((isInvalid(SearchKey)))
		{
			//��ѯ����������Ϣ�ŵ�ֵջ��
			list=new DomitoryDao().GetList(strWhere,"Domitory_Name");
		}else {
			list=new DomitoryDao().GetListSelective(Domitory_BuildingID,SearchRow,SearchKey,"Building_Name");
		}
		
		
		
		
		
	
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
