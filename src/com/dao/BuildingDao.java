package com.dao;

import com.db.util.DBUtil;
import com.entity.Building;
import com.entity.StudentBean;

import java.util.*;
import java.sql.*;

public class BuildingDao {

	// 获取列表
	public List<Building> GetList(String strwhere, String strorder) {
		
		String sql = "select * from Building where ? order by ?";
		Object[] objects = { strwhere, strorder };
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		List<Building> list = new ArrayList<Building>();
		try {
			
			while (rs.next()) {
				Building cnbean = new Building();
				cnbean.setBuilding_ID(rs.getInt("Building_ID"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setBuilding_Introduction(rs.getString("Building_Introduction"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public List<Building> GetListSelective(String name, String strorder) {
		String sql = "select * from Building where Building_Name= ? order by ?";

		Object[] objects = { name, strorder };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		List<Building> list = new ArrayList<Building>();
		try {
			while (rs.next()) {
				Building cnbean = new Building();
				cnbean.setBuilding_ID(rs.getInt("Building_ID"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setBuilding_Introduction(rs.getString("Building_Introduction"));
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
	public Building GetBean(int id) {
		
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		String sql = "select * from Building where Building_ID=?";
		Object[] objects = { id };
		rs = DBUtil.executeQuery(sql, objects);
		Building cnbean = new Building();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setBuilding_ID(rs.getInt("Building_ID"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setBuilding_Introduction(rs.getString("Building_Introduction"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnbean;
	}
	

	// 添加
	public void Add(Building cnbean) {
	
		String sql = "insert into Building (Building_Name,Building_Introduction) values(?,?)";
		Object[] objects = { cnbean.getBuilding_Name(), cnbean.getBuilding_Introduction() };
		// Statement stat = null;
		ResultSet rs = null;
		DBUtil.executeUpdate(sql, objects);
		// Connection conn = new DBHelper().getConn();

	}

	// 修改
	public void Update(Building cnbean) {
		
		String sql = "update Building set Building_Name=?,Building_Introduction=? where Building_ID=?";
		Object[] objects = { cnbean.getBuilding_Name(), cnbean.getBuilding_Introduction() ,cnbean.getBuilding_ID()};
		
		DBUtil.executeUpdate(sql, objects);
		

	}

	// 删除
	public void Delete(String strwhere) {
		
		String sql = "delete from Building where Building_ID=?";
		Object[] objects = { strwhere };
		// Connection conn = new DBHelper().getConn();
		DBUtil.executeUpdate(sql, objects);
		
	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// 测试
	// public static void main(String[] args) {
	// System.out.println("");
	// }

}
