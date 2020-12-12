package com.dao;

import com.db.util.DBUtil;
import com.entity.TBBean;

import java.util.*;
import java.sql.*;

public class TBDao {

	// 获取列表
	public List<TBBean> GetList(String Buildingid, String strorder) {
		
		String sql = "select distinct Teacher.* from TB,Teacher where TB_TeacherID=Teacher_ID and TB_BuildingID= ? order by ?";
		Object[] objects = { Buildingid, strorder };
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		List<TBBean> list = new ArrayList<TBBean>();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				TBBean cnbean = new TBBean();
//				cnbean.setTB_ID(rs.getInt("TB_ID"));
//				cnbean.setTB_TeacherID(rs.getInt("TB_TeacherID"));
//				cnbean.setTB_BuildingID(rs.getInt("TB_BuildingID"));
				cnbean.setTeacherID(rs.getInt("Teacher_ID"));
				System.out.println("id:" + cnbean.getTeacherID());
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setTeacher_Username(rs.getString("Teacher_Username"));
//				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	// 获取指定ID的实体Bean
	public TBBean GetBean(int id) {
		String sql = "select * from TB where TB_ID=?";
		// Statement stat = null;
		Object[] objects = { id };
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		// Connection conn = new DBHelper().getConn();
		TBBean cnbean = new TBBean();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setTB_ID(rs.getInt("TB_ID"));
				cnbean.setTB_TeacherID(rs.getInt("TB_TeacherID"));
				cnbean.setTB_BuildingID(rs.getInt("TB_BuildingID"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return cnbean;
	}

	// 添加
	public void Add(TBBean cnbean) {
		
		String sql = "insert into TB (TB_TeacherID,TB_BuildingID) values(?,?)";
		Object[] objects = { cnbean.getTB_TeacherID(), cnbean.getTB_BuildingID() };

		
		DBUtil.executeUpdate(sql, objects);
		
	}

	// 修改
	public void Update(TBBean cnbean) {
		
		String sql = "update TB set TB_TeacherID=?,TB_BuildingID=? where TB_ID?";
		Object[] objects = { cnbean.getTB_TeacherID(), cnbean.getTB_BuildingID(), cnbean.getTB_ID() };
		
		DBUtil.executeUpdate(sql, objects);
		
	}

	// 删除
	public void Delete(String TeacherId,String BuildingId) {
		String sql = "delete from TB where TB_TeacherID= ? and TB_BuildingID=?";
		
		Object[] objects = {TeacherId,BuildingId };
		DBUtil.executeUpdate(sql, objects);
		
	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

public List<TBBean> GetItList(String Teacherid, String strorder) {
		
		String sql = "select * from TB,Teacher,Building where TB_TeacherID=Teacher_ID and Building_ID=TB_BuildingID and TB_TeacherID= ? order by ?";
		Object[] objects = { Teacherid, strorder };
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		List<TBBean> list = new ArrayList<TBBean>();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				TBBean cnbean = new TBBean();
				cnbean.setTB_ID(rs.getInt("TB_ID"));
				cnbean.setTB_TeacherID(rs.getInt("TB_TeacherID"));
				cnbean.setTB_BuildingID(rs.getInt("TB_BuildingID"));
				cnbean.setTeacherID(rs.getInt("Teacher_ID"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				cnbean.setTeacher_Username(rs.getString("Teacher_Username"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

}
