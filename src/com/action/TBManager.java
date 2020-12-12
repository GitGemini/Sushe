package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.session.check.CheckSession;
import com.dao.*;
import com.entity.*;


public class TBManager extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Building_ID;
	public String getBuilding_ID() {
		return Building_ID;
	}
	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}
	private List<TBBean> list;
	public List<TBBean> getList() {
		return list;
	}
	public void setList(List<TBBean> list) {
		this.list = list;
	}
	private List<TeacherBean> teacherlist;
	public List<TeacherBean> getTeacherlist() {
		return teacherlist;
	}
	public void setTeacherlist(List<TeacherBean> teacherlist) {
		this.teacherlist = teacherlist;
	}
	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		CheckSession.check();
		String strwhere="1=1";
		//查询所有的楼宇管理员放到值栈中
		teacherlist=new TeacherDao().GetList(strwhere,"Teacher_Name");
		//将上个表单提交过来的BuildingID放到值栈中
		ActionContext context=ActionContext.getContext();
		ValueStack stack=context.getValueStack();
		stack.set("Building_ID", Building_ID);
		
		//根据id查询楼宇的所有管理员，放到值栈中
		list=new TBDao().GetList(Building_ID,"");
	
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
