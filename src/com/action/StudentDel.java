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


public class StudentDel extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String Student_ID ;
	public String getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(String userID) {
		Student_ID = userID;
	}

	//�����û������execute����
	public String execute() throws Exception {
		
		CheckSession.check();
		System.out.println("Student_ID="+Student_ID);
		
		//ɾ��
		new StudentDao().Delete(Student_ID);
		    
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