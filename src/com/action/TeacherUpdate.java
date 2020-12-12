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


public class TeacherUpdate extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Teacher_ID;
	private TeacherBean cnbean;
	public String getTeacher_ID() {
		return Teacher_ID;
	}

	public void setTeacher_ID(String studentID) {
		Teacher_ID = studentID;
	}

	public TeacherBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(TeacherBean cnbean) {
		this.cnbean = cnbean;
	}

	//�����û������execute����
	public String execute() throws Exception {
		
//		//������룬����ҳ�����

		CheckSession.check();
		//��ѯ
		cnbean=new TeacherDao().GetBean(Integer.parseInt(Teacher_ID));
		return SUCCESS;
		//����id�鵽¥�����Ա��Ϣ������ֵջ�У������¸�ҳ����������ʾ
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
