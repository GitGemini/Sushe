package com.dao;

import com.db.util.DBUtil;
import com.entity.LogBean;

import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

public class LogDao {

	// 获取列表
	public List<LogBean> GetList(String studentid, String strorder) {

		String sql = "select * from Log,Teacher,Student,Domitory,Building where Log_TeacherID=Teacher_ID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Student_ID=? order by ?";
		Object[] objects = { studentid, strorder };
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		List<LogBean> list = new ArrayList<LogBean>();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				LogBean cnbean = new LogBean();
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_TeacherID(rs.getInt("Log_TeacherID"));
				cnbean.setLog_Date(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("Log_Date")));
				cnbean.setLog_Remark(rs.getString("Log_Remark"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				list.add(cnbean);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	// 获取指定ID的实体Bean
	public LogBean GetBean(int id) {
		String sql = "select * from Log,Teacher,Student,Domitory,Building where Log_TeacherID=TeacherID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Log_ID=?";
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		Object[] object = { id };
		rs = DBUtil.executeQuery(sql, object);
		LogBean cnbean = new LogBean();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_TeacherID(rs.getInt("Log_TeacherID"));
				cnbean.setLog_Date(rs.getString("Log_Date"));
				cnbean.setLog_Remark(rs.getString("Log_Remark"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnbean;
	}

	// 添加
	public void Add(LogBean cnbean) {

		String sql = "insert into Log (Log_StudentID,Log_TeacherID,Log_Date,Log_Remark) values(?,?,?,?)";
		Object[] objects = { cnbean.getLog_StudentID(), cnbean.getLog_TeacherID(), cnbean.getLog_Date(),
				cnbean.getLog_Remark() };
		DBUtil.executeUpdate(sql, objects);
	}

	// 修改
	public void Update(LogBean cnbean) {

		String sql = "update Log set Log_StudentID=?,Log_TeacherID=?,Log_Date=?,Log_Remark=?";
		// Statement stat = null;
		// ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		Object[] objects = { cnbean.getLog_StudentID(), cnbean.getLog_TeacherID(), cnbean.getLog_Date(),
				cnbean.getLog_Remark() };
		// DBUtil.executeUpdate(sql, params)

	}

	// 删除
	public void Delete(String strwhere) {

		String sql = "delete from Log where ?";
		Object[] objects={ strwhere };

	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public List<LogBean> GetItList(String buildingID, String domitoryID, String studentUsername, String strorder) {
		String sql = null;
		Object[] objects=null;
		if (buildingID == null) {
			sql = "select * from Log,Teacher,Student,Domitory,Building where Log_TeacherID=Teacher_ID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Student_State='入住' and Student_Username=? order by ?";
			objects= new Object[] { studentUsername, strorder };
		} else if (studentUsername== null) {
			sql = "select * from Log,Teacher,Student,Domitory,Building where Log_TeacherID=Teacher_ID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Building_ID=? and Domitory_ID=? order by ?";
			objects= new Object[] {buildingID, domitoryID,strorder};
		}else {
			sql = "select * from Log,Teacher,Student,Domitory,Building where Log_TeacherID=Teacher_ID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Student_Username=? order by ?";
			objects= new Object[] {studentUsername,strorder};
		}

		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		List<LogBean> list = new ArrayList<LogBean>();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				LogBean cnbean = new LogBean();
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_TeacherID(rs.getInt("Log_TeacherID"));
				cnbean.setLog_Date(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("Log_Date")));
				cnbean.setLog_Remark(rs.getString("Log_Remark"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				list.add(cnbean);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public List<LogBean> GetItList(String teacherid, String strorder) {

		String sql = "select * from Log,Teacher,Student,Domitory,Building where Log_TeacherID=Teacher_ID and Log_StudentID=Student_ID and Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Teacher_ID=? order by ?";
		Object[] objects = { teacherid, strorder };
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		List<LogBean> list = new ArrayList<LogBean>();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				LogBean cnbean = new LogBean();
				cnbean.setLog_ID(rs.getInt("Log_ID"));
				cnbean.setLog_StudentID(rs.getInt("Log_StudentID"));
				cnbean.setLog_TeacherID(rs.getInt("Log_TeacherID"));
				cnbean.setLog_Date(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("Log_Date")));
				cnbean.setLog_Remark(rs.getString("Log_Remark"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				list.add(cnbean);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


}
