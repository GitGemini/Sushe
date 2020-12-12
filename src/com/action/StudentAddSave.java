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
	
	//模型驱动封装学生数据
	private StudentBean studentBean=new StudentBean();
	//下面是Action内用于封装用户请求参数的属性
	public StudentBean getModel() {
		// TODO Auto-generated method stub
		return studentBean;
	}


	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出

		CheckSession.check();
		//添加
		System.out.println(studentBean.getStudent_Sex());
		new StudentDao().Add(studentBean);
		    
		//跳转
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('添加成功！');window.location='StudentManager.action';</script>");
		out.flush();out.close();return null;
		//这里添加的信息有
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}

	
	
}
