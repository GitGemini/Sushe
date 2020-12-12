package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.dao.*;
import com.entity.*;


public class TeacherAddSave extends ActionSupport implements ModelDriven<TeacherBean>{

	//ģ��������װ����
	private TeacherBean teacher=new TeacherBean();
	public TeacherBean getModel() {
		// TODO Auto-generated method stub
		return teacher;
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
		
		//��ѯ�û����Ƿ����
		List<TeacherBean> list=new TeacherDao().GetList("Teacher_Username='"+teacher.getTeacher_Username()+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('�û����Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//���
//		TeacherBean cnbean=new TeacherBean();
//		cnbean.setTeacher_Username(teacher.getTeacher_Username());
//		cnbean.setTeacher_Password(teacher.getTeacher_Password());
//		cnbean.setTeacher_Name(teacher.getTeacher_Name());
//		cnbean.setTeacher_Sex(teacher.getTeacher_Sex());
//		cnbean.setTeacher_Tel(teacher.getTeacher_Tel());
		new TeacherDao().Add(teacher);
		    
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='TeacherManager.action';</script>");
		out.flush();out.close();return null;
		
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
