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

	//������Action�����ڷ�װ�û��������������
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
	//�����û������execute����
	public String execute() throws Exception {
		
		CheckSession.check();
		//��ѯ����
		String strWhere="1=1";
		if(isInvalid(SearchKey))
		{
			//��ѯ����
			list=new TeacherDao().GetList(strWhere,"Teacher_Name");
		}else {
			list=new TeacherDao().GetListSelective(SearchRow, SearchKey,"Teacher_Name");
		}
	
		return SUCCESS;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
}
