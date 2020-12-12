package com.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.session.check.CheckSession;
import com.dao.*;
import com.entity.*;


public class StudentManager extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private List<StudentBean> list=new ArrayList<StudentBean>();
	public List<StudentBean> getList() {
		return list;
	}
	public void setList(List<StudentBean> list) {
		this.list = list;
	}
	//搜索条件，从表单中获取SearchRow、SearchKey、State数据
	private String SearchRow;
	private String SearchKey;
	private String State;
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
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
		System.out.println(State);
		if(isInvalid(SearchKey))
		{
//			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
			//查询所有
			list=new StudentDao().GetAllList(strWhere, "Student_Name");
		}else {
			list=new StudentDao().GetListSelective(State,SearchRow, SearchKey,"Student_Name");
		}
		
		
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
