package com.dao;

import com.db.util.DBUtil;
import com.entity.OutBean;

import sun.net.www.content.text.plain;

import java.util.*;
import java.sql.*;

public class OutDao {

	// ��ȡ�б�
	public List<OutBean> GetList(String strwhere, String strorder) {
		String sql = "select * from Out1 o,Student s where o.Out_StudentID=s.Student_ID and ? order by ?";
		
		Object[] objects = { strwhere, strorder };
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		List<OutBean> list = new ArrayList<OutBean>();
		try {
			
			while (rs.next()) {
				OutBean cnbean = new OutBean();
				cnbean.setOut_ID(rs.getInt("Out_ID"));
				cnbean.setOut_StudentID(rs.getInt("Out_StudentID"));
				cnbean.setOut_Date(rs.getString("Out_Date"));
				cnbean.setOut_Remark(rs.getString("Out_Remark"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// ��ȡָ��ID��ʵ��Bean
	public OutBean GetBean(int id) {
		String sql = "select * from Out where Out_ID=?";
		Object[] objects = { id };
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		OutBean cnbean = new OutBean();
		try {
			// stat = conn.createStatement();
			// rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setOut_ID(rs.getInt("Out_ID"));
				cnbean.setOut_StudentID(rs.getInt("Out_StudentID"));
				cnbean.setOut_Date(rs.getString("Out_Date"));
				cnbean.setOut_Remark(rs.getString("Out_Remark"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnbean;
	}

	// ���
	public void Add(OutBean cnbean) {
	
		String sql = "insert into Out1 (Out_StudentID,Out_Date,Out_Remark) values(?,?,?)";
		Object[] objects = { cnbean.getOut_StudentID(), cnbean.getOut_Date(), cnbean.getOut_Remark() };
		DBUtil.executeUpdate(sql, objects);
		
	}

	// �޸�
	public void Update(OutBean cnbean) {
		
		String sql = "update Out set Out_StudentID=?,Out_Date='?,Out_Remark=?";
		Object[] objects = { cnbean.getOut_StudentID(), cnbean.getOut_Date(), cnbean.getOut_Remark() };
		// Statement stat = null;
		// ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		DBUtil.executeUpdate(sql, objects);
		
	}

	// ɾ��
	public void Delete(String strwhere) {
		String sql = "delete  from Out where ?";
		Object[] objects = { strwhere };
		// sql+=strwhere;
		// Statement stat = null;
		// ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		DBUtil.executeUpdate(sql, objects);
		
	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// ����
	public static void main(String[] args) {
		System.out.println("");
	}

}
