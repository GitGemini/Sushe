package com.action;

import java.io.PrintWriter;
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


public class TBManager extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Building_ID;
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}
	private List<TBBean> list;
	public List<TBBean> getList() {
		return list;
	}
	public void setList(List<TBBean> list) {
		this.list = list;
	}
	private List<TeacherBean> teacherlist;
	public List<TeacherBean> getTeacherlist() {
		return teacherlist;
	}
	public void setTeacherlist(List<TeacherBean> teacherlist) {
		this.teacherlist = teacherlist;
	}
	//�����û������execute����
	public String execute() throws Exception {
		
		CheckSession.check();
		String strwhere="1=1";
		//��ѯ���е�¥�����Ա�ŵ�ֵջ��
		teacherlist=new TeacherDao().GetList(strwhere,"Teacher_Name");
		//���ϸ����ύ������BuildingID�ŵ�ֵջ��
		ActionContext context=ActionContext.getContext();
		ValueStack stack=context.getValueStack();
		stack.set("Building_ID", Building_ID);
		
		//����id��ѯ¥������й���Ա���ŵ�ֵջ��
		list=new TBDao().GetList(Building_ID,"");
	
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
