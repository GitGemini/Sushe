package com.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.session.check.CheckSession;
import com.dao.*;
import com.entity.*;


public class StudentAddSave extends ActionSupport implements ModelDriven<StudentBean>{
	
	//ģ��������װѧ������
	private StudentBean studentBean=new StudentBean();
	//������Action�����ڷ�װ�û��������������
	public StudentBean getModel() {
		// TODO Auto-generated method stub
		return studentBean;
	}


	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����

		CheckSession.check();
		//���
		System.out.println(studentBean.getStudent_Sex());
		new StudentDao().Add(studentBean);
		    
		//��ת
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='StudentManager.action';</script>");
		out.flush();out.close();return null;
		//������ӵ���Ϣ��
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
