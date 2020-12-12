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


public class TeacherManager extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private List<TeacherBean> list;
	public List<TeacherBean> getList() {
		return list;
	}
	public void setList(List<TeacherBean> list) {
		this.list = list;
	}
	private String SearchRow;
	private String SearchKey;
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		CheckSession.check();
		//查询条件
		String strWhere="1=1";
		if(isInvalid(SearchKey))
		{
			//查询所有
			list=new TeacherDao().GetList(strWhere,"Teacher_Name");
		}else {
			list=new TeacherDao().GetListSelective(SearchRow, SearchKey,"Teacher_Name");
		}
	
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
}
