package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.dao.*;
import com.entity.*;


public class MyStudentList extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<StudentBean> list;
	public List<StudentBean> getList() {
		return list;
	}
	public void setList(List<StudentBean> list) {
		this.list = list;
	}
	private String Building_ID;
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}
	private List<Domitory> domitorylist;
	public List<Domitory> getDomitorylist() {
		return domitorylist;
	}
	public void setDomitorylist(List<Domitory> domitorylist) {
		this.domitorylist = domitorylist;
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
	private String Domitory_ID;
	
	public String getDomitory_ID() {
		return Domitory_ID;
	}
	public void setDomitory_ID(String domitoryID) {
		Domitory_ID = domitoryID;
	}
	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}

		//��ѯ����
		String strwhere="1=1";
//		String strWhere="Student_State='��ס' and Building_ID="+Building_ID;
		if(!(isInvalid(SearchKey)))
		{
			list=new StudentDao().GetListSelective("��ס", SearchRow, SearchKey, "Domitory_Name");
		}else {//���Լ����key�գ�����Domitory����
			list=new StudentDao().GetListFromBuilid(Building_ID,"Domitory_Name");
			
		}
		//��ѯ��������
		domitorylist=new DomitoryDao().GetdomList(Building_ID,"Domitory_Name");
	
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
