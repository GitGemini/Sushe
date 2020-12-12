package com.dao;

import com.db.util.DBUtil;
import com.entity.Building;
import com.entity.Domitory;
import com.entity.StudentBean;

import java.util.*;
import java.sql.*;

public class DomitoryDao {

	// 获取列表
	public List<Domitory> GetList(String strwhere, String strorder) {

		String sql = "select * from Domitory,Building where Domitory_BuildingID=Building_ID and ? order by ?";
		// Statement stat = null;
		ResultSet rs = null;
		Object[] objests = { strwhere, strorder };
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objests);
		List<Domitory> list = new ArrayList<Domitory>();
		try {

			while (rs.next()) {
				Domitory cnbean = new Domitory();
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
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
	public List<Domitory> GetListSelective(String buildingid,String key, String value, String strorder) {
		String sql = "select * from Domitory,Building where Domitory_BuildingID=Building_ID and Building_ID=? and "+key+"=? order by ?";

		Object[] objects = {buildingid,value, strorder };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		List<Domitory> list = new ArrayList<Domitory>();
		try {
			while (rs.next()) {
				Domitory cnbean = new Domitory();
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
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

	// 获取指定ID的实体Bean
	public Domitory GetBean(int id) {

		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		String sql = "select * from Domitory,Building where Domitory_BuildingID=Building_ID and Domitory_ID=?";
		Object[] objects = { id };
		Domitory cnbean = new Domitory();
		rs = DBUtil.executeQuery(sql, objects);
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return cnbean;
	}

	// 添加
	public void Add(Domitory cnbean) {

		String sql = "insert into Domitory(Domitory_BuildingID,Domitory_Name,Domitory_Type,Domitory_Number,Domitory_Tel) values(?,?,?,?,?)";
		Object[] objects = { cnbean.getDomitory_BuildingID(), cnbean.getDomitory_Name(), cnbean.getDomitory_Type(),
				cnbean.getDomitory_Number() };
		DBUtil.executeUpdate(sql, objects);

	}

	// 修改
	public void Update(Domitory cnbean) {
		String sql = "update Domitory set Domitory_BuildingID=?,Domitory_Name=?,Domitory_Type=?,Domitory_Number=?,Domitory_Tel=? where Domitory_ID=?";
		Object[] objects = { cnbean.getDomitory_BuildingID(), cnbean.getDomitory_Name(), cnbean.getDomitory_Type(),
				cnbean.getDomitory_Number(), cnbean.getDomitory_Tel(),cnbean.getDomitory_ID()};

		DBUtil.executeUpdate(sql, objects);

	}

	// 删除
	public void Delete(String strwhere) {

		String sql = "delete from Domitory where ?";
		Object[] objects = { strwhere };
		DBUtil.executeUpdate(sql, objects);

	}
	public List<Domitory> Check(String DBname, String Dname) {

		String sql = "select * from Domitory,Building where Domitory_BuildingID=? and Domitory_Name=?";
		// Statement stat = null;
		ResultSet rs = null;
		Object[] objests = { DBname, Dname };
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objests);
		List<Domitory> list = new ArrayList<Domitory>();
		try {

			while (rs.next()) {
				Domitory cnbean = new Domitory();
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
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
	public List<Domitory> GetdomList(String BuildingID,String Domitory_Name) {

		String sql = "select * from Domitory where Domitory_BuildingID=? order by?";
		// Statement stat = null;
		ResultSet rs = null;
		Object[] objests = { BuildingID, Domitory_Name };
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objests);
		List<Domitory> list = new ArrayList<Domitory>();
		try {

			while (rs.next()) {
				Domitory cnbean = new Domitory();
				cnbean.setDomitory_ID(rs.getInt("Domitory_ID"));
				cnbean.setDomitory_BuildingID(rs.getInt("Domitory_BuildingID"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
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
	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}


}
