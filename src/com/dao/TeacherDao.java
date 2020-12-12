package com.dao;

import com.db.util.DBUtil;
import com.entity.TeacherBean;

import java.util.*;
import java.sql.*;

public class TeacherDao {

	// 验证登录
	public String CheckLogin(String username, String password) {
		String id = null;
		ResultSet rs = null;
		String sql = "select * from Teacher where Teacher_Username=? and Teacher_Password=?";
		Object[] objects = { username, password };
		rs = DBUtil.executeQuery(sql, objects);
		try {
			while (rs.next()) {
				id = rs.getString("Teacher_ID");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	// 验证密码
	public boolean CheckPassword(String id, String password) {
		boolean ps = false;
		String sql = "select * from Teacher where Teacher_ID=? and Teacher_Password=?";
		Object[] objects = { id, password };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		try {
			while (rs.next()) {
				ps = true;
			}
		} catch (SQLException ex) {
		}
		return ps;
	}

	// 获取列表
	public List<TeacherBean> GetList(String strwhere, String strorder) {
		String sql = "select * from Teacher where ? order by ?";

		Object[] objects = { strwhere, strorder };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		List<TeacherBean> list = new ArrayList<TeacherBean>();
		try {
			while (rs.next()) {
				list.add(getBeanFromResultSet(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	// 获取列表
	public List<TeacherBean> GetListSelective(String key, String value, String strorder) {
		String sql = "select * from Teacher where " + key + " = ? order by ?";

		Object[] objects = { value, strorder };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		List<TeacherBean> list = new ArrayList<TeacherBean>();
		try {
			while (rs.next()) {
				list.add(getBeanFromResultSet(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public TeacherBean GetBean(int id) {
		String sql = "select * from Teacher where Teacher_ID=?";
		Object[] objects = { id };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		TeacherBean cnbean = null;
		try {
			while (rs.next()) {
				cnbean = getBeanFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return cnbean;
	}

	// 添加
	public void Add(TeacherBean cnbean) {

		String sql = "insert into Teacher (Teacher_Username,Teacher_Password,Teacher_Name,Teacher_Sex,Teacher_Tel)values (?,?,?,?,?)";
		Object[] objects = { cnbean.getTeacher_Username(), cnbean.getTeacher_Password(), cnbean.getTeacher_Name(),
				cnbean.getTeacher_Sex(), cnbean.getTeacher_Tel() };
		DBUtil.executeUpdate(sql, objects);
	}

	// 修改
	public void Update(TeacherBean cnbean) {

		String sql = "update teacher set Teacher_Username=?,Teacher_Password=?,Teacher_Name=?,Teacher_Sex=?,Teacher_Tel=? where Teacher_ID=? ";
		Object[] objects = { cnbean.getTeacher_Username(), cnbean.getTeacher_Password(), cnbean.getTeacher_Name(),
				cnbean.getTeacher_Sex(), cnbean.getTeacher_Tel(), cnbean.getTeacher_ID() };
		DBUtil.executeUpdate(sql, objects);
	}
	public void Updatepwd(String id,String password) {
		String sql = "update Teacher set Teacher_Password=? where Teacher_ID=?";
		Object[] objects = { password,id};
		try {
			boolean bool = DBUtil.executeUpdate(sql, objects);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 删除
	public void Delete(String strwhere) {
		String sql = "delete from Teacher where teacher_id = ?";
		Object[] objects = { strwhere };
		DBUtil.executeUpdate(sql, objects);

	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public TeacherBean getBeanFromResultSet(ResultSet rs) throws SQLException {
		TeacherBean cnbean = new TeacherBean();
		cnbean.setTeacher_ID(rs.getInt("Teacher_ID"));
		cnbean.setTeacher_Username(rs.getString("Teacher_Username"));
		cnbean.setTeacher_Password(rs.getString("Teacher_Password"));
		cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
		cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
		cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
		return cnbean;

	}

}
