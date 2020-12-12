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


public class BuildingDel extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Building_ID ;
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String userID) {
		Building_ID = userID;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		CheckSession.check();
		//删除
		new BuildingDao().Delete(Building_ID);
		    
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
