package com.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.session.check.CheckSession;
import com.dao.*;
import com.entity.*;


public class StudentManager extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<StudentBean> list=new ArrayList<StudentBean>();
	public List<StudentBean> getList() {
		return list;
	}
	public void setList(List<StudentBean> list) {
		this.list = list;
	}
	//�����������ӱ��л�ȡSearchRow��SearchKey��State����
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
	//�����û������execute����
	public String execute() throws Exception {
		
		CheckSession.check();
		//��ѯ����
		String strWhere="1=1";
		System.out.println(State);
		if(isInvalid(SearchKey))
		{
//			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
			//��ѯ����
			list=new StudentDao().GetAllList(strWhere, "Student_Name");
		}else {
			list=new StudentDao().GetListSelective(State,SearchRow, SearchKey,"Student_Name");
		}
		
		
		return SUCCESS;
		
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
