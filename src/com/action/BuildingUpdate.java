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


public class BuildingUpdate extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Building_ID;
	private Building cnbean;
	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String studentID) {
		Building_ID = studentID;
	}

	public Building getCnbean() {
		return cnbean;
	}

	public void setCnbean(Building cnbean) {
		this.cnbean = cnbean;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		CheckSession.check();
		
		//查询
		cnbean=new BuildingDao().GetBean(Integer.parseInt(Building_ID));
		//cnbean存到值栈中
		
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
