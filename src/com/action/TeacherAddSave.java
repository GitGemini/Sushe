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

	//模型驱动封装数据
	private TeacherBean teacher=new TeacherBean();
	public TeacherBean getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}


	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//查询用户名是否存在
		List<TeacherBean> list=new TeacherDao().GetList("Teacher_Username='"+teacher.getTeacher_Username()+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('用户名已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
//		TeacherBean cnbean=new TeacherBean();
//		cnbean.setTeacher_Username(teacher.getTeacher_Username());
//		cnbean.setTeacher_Password(teacher.getTeacher_Password());
//		cnbean.setTeacher_Name(teacher.getTeacher_Name());
//		cnbean.setTeacher_Sex(teacher.getTeacher_Sex());
//		cnbean.setTeacher_Tel(teacher.getTeacher_Tel());
		new TeacherDao().Add(teacher);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='TeacherManager.action';</script>");
		out.flush();out.close();return null;
		
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
