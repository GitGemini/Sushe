package com.dao;

import com.db.util.DBUtil;
import com.entity.Admin;

import java.util.*;
import java.sql.*;

public class AdminDao {

	// 验证登录
	public String CheckLogin(String username, String password) {
		String id = null;
		Object[] objects = { username, password };
		String sql = "select * from Admin where Admin_Username=? and Admin_Password=?";
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		try {
			while (rs.next()) {
				id = rs.getString("Admin_ID");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
	}

	// 验证密码
	public boolean CheckPassword(String id, String password) {
		boolean ps = false;
		ResultSet rs;
		Object[] object = { id, password };
		String sql = "select * from Admin where Admin_ID=?and Admin_Password=?";
		rs = DBUtil.executeQuery(sql, object);
		try {
			while (rs.next()) {
				ps = true;
			}
		} catch (SQLException ex) {
		}
		return ps;
	}
	// 获取列表

	public List<Admin> GetList(String strwhere, String strorder) {
		String sql = "select * from Admin where ? order by ?";
		// if(!(isInvalid(strwhere)))
		// {
		// sql+=" where "+strwhere;
		// }
		// if(!(isInvalid(strorder)))
		// {
		// sql+=" order by "+strorder;
		// }
		// Statement stat = null;
		ResultSet rs = null;
		// Connection conn = new DBHelper().getConn();
		Object[] object = { strwhere, strorder };
		List<Admin> list = new ArrayList<Admin>();
		rs = DBUtil.executeQuery(sql, object);
		try {

			while (rs.next()) {
				Admin cnbean = new Admin();
				cnbean.setAdmin_ID(rs.getInt("Admin_ID"));
				cnbean.setAdmin_Username(rs.getString("Admin_Username"));
				cnbean.setAdmin_Password(rs.getString("Admin_Password"));
				cnbean.setAdmin_Name(rs.getString("Admin_Name"));
				cnbean.setAdmin_Sex(rs.getString("Admin_Sex"));
				cnbean.setAdmin_Tel(rs.getString("Admin_Tel"));
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
	public Admin GetBean(int id) {
		String sql = "select * from Admin where Admin_ID=?";
		// Statement stat = null;
		ResultSet rs = null;
		Object[] objects = { id };
		// Connection conn = new DBHelper().getConn();
		rs = DBUtil.executeQuery(sql, objects);
		Admin cnbean = new Admin();
		try {
			while (rs.next()) {
				cnbean.setAdmin_ID(rs.getInt("Admin_ID"));
				cnbean.setAdmin_Username(rs.getString("Admin_Username"));
				cnbean.setAdmin_Password(rs.getString("Admin_Password"));
				cnbean.setAdmin_Name(rs.getString("Admin_Name"));
				cnbean.setAdmin_Sex(rs.getString("Admin_Sex"));
				cnbean.setAdmin_Tel(rs.getString("Admin_Tel"));

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
	public void Add(Admin cnbean) {
		String sql = "insert into Admin(Admin_Username,Admin_Password,Admin_Name,Admin_Sex,Admin_Tel) values (?,?,?,?)";
		Object[] objects = { cnbean.getAdmin_Username(), cnbean.getAdmin_Password(), cnbean.getAdmin_Name(),
				cnbean.getAdmin_Sex() };
		try {
			PreparedStatement pStatement = DBUtil.createPreparedStatement(sql, objects);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 修改
	public void Update(Admin cnbean) {
		String sql = "update Admin set Admin_Username=?,Admin_Password=?,Admin_Name=?,Admin_Sex=?,Admin_Tel=? where Admin_ID=?";
		Object[] objects = { cnbean.getAdmin_Username(), cnbean.getAdmin_Password(), cnbean.getAdmin_Name(),
				cnbean.getAdmin_Tel(),cnbean.getAdmin_ID()};
		try {
			boolean bool = DBUtil.executeUpdate(sql, objects);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void Updatepwd(String adminid,String password) {
		String sql = "update Admin set Admin_Password=? where Admin_ID=?";
		Object[] objects = { password,adminid};
		try {
			boolean bool = DBUtil.executeUpdate(sql, objects);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 删除
	public void Delete(String strwhere) {

		String sql = "delete from Admin where ?";

		Object[] objects = { strwhere };
		DBUtil.executeUpdate(sql, objects);

	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

}
