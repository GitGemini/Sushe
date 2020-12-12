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
import com.dao.*;
import com.entity.*;


public class StudentTH extends ActionSupport {

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

	private String Building_ID;
	private String BuildingID;
	private String DomitoryID;
	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}

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

	private String Student_Username;
	
	public String getStudent_Username() {
		return Student_Username;
	}

	public void setStudent_Username(String studentUsername) {
		Student_Username = studentUsername;
	}
	private StudentBean cnbean;
	public StudentBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(StudentBean cnbean) {
		this.cnbean = cnbean;
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
		
		//��ѯ�Ƿ����
		List<StudentBean> list=new StudentDao().CheckList(Student_Username);
		if(list.size()<1)
		{
			out.print("<script language='javascript'>alert('ѧ�Ų����ڣ���ѧ��δ������ס״̬��');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		String strWhere="1=1 ";
		//��ѯ¥��
		buildinglist=new BuildingDao().GetList(strWhere,"Building_Name");
//		System.out.println(BuildingID);
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
		//��ѯ����
		
		
		//��ѯѧ����Ϣ
		cnbean=new StudentDao().GetFirstBean(Student_Username);
		
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
