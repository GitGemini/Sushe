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


public class TeacherDel extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Teacher_ID ;
	public String getTeacher_ID() {
		return Teacher_ID;
	}

	public void setTeacher_ID(String userID) {
		Teacher_ID = userID;
	}
	
	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����

		CheckSession.check();
		
		//ɾ��
//		System.out.println(Teacher_ID);
//		new TeacherDao().Delete("Teacher_ID="+Teacher_ID);
		new TeacherDao().Delete(Teacher_ID);
		//���������޷�ɾ��
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
