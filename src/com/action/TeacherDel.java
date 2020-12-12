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

	//下面是Action内用于封装用户请求参数的属性
	private String Teacher_ID ;
	public String getTeacher_ID() {
		return Teacher_ID;
	}

	public void setTeacher_ID(String userID) {
		Teacher_ID = userID;
	}
	
	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出

		CheckSession.check();
		
		//删除
//		System.out.println(Teacher_ID);
//		new TeacherDao().Delete("Teacher_ID="+Teacher_ID);
		new TeacherDao().Delete(Teacher_ID);
		//存在问题无法删除
		return SUCCESS;
		
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
