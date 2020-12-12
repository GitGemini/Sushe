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

	//下面是Action内用于封装用户请求参数的属性
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

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
//		//解决乱码，用于页面输出

		CheckSession.check();
		//查询
		cnbean=new TeacherDao().GetBean(Integer.parseInt(Teacher_ID));
		return SUCCESS;
		//根据id查到楼宇管理员信息，放入值栈中，用于下个页面输入框的提示
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
