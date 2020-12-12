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


public class DomitoryManager extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private List<Domitory> list;
	public List<Domitory> getList() {
		return list;
	}
	public void setList(List<Domitory> list) {
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
	private List<Building> buildinglist;
	public List<Building> getBuildinglist() {
		return buildinglist;
	}
	public void setBuildinglist(List<Building> buildinglist) {
		this.buildinglist = buildinglist;
	}
	private String Domitory_BuildingID;
	public String getDomitory_BuildingID() {
		return Domitory_BuildingID;
	}
	public void setDomitory_BuildingID(String domitoryBuildingID) {
		Domitory_BuildingID = domitoryBuildingID;
	}
	//处理用户请求的execute方法
	public String execute() throws Exception {
		CheckSession.check();
		String strWhere="1=1";
		//查询所有楼宇信息，放到值栈中
				buildinglist=new BuildingDao().GetList(strWhere,"Building_Name");
		
		
		if((isInvalid(SearchKey)))
		{
			//查询所有宿舍信息放到值栈中
			list=new DomitoryDao().GetList(strWhere,"Domitory_Name");
		}else {
			list=new DomitoryDao().GetListSelective(Domitory_BuildingID,SearchRow,SearchKey,"Building_Name");
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
