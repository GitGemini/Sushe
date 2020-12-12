package com.dao;

import com.db.util.DBUtil;
import com.entity.StudentBean;
import com.entity.TeacherBean;

import java.util.*;
import java.sql.*;

public class StudentDao {

	// 验证登录
	public String CheckLogin(String username, String password) {
		String id = null;
		String sql = "select * from Student where Student_Username=? and Student_Password=? and Student_State='入住'";
		Object[] objects = {username, password};
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		try {
			while (rs.next()) {
				id = rs.getString("Student_ID");
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
		String sql = "select * from Student where Student_ID=? and Student_Password=?";
		Object[] objects = {id, password};
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		try {

			while (rs.next()) {
				ps = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ps;
	}
	public List<StudentBean> GetAllList(String strwhere, String strorder) {
		String sql = "select * from Student where ? order by ?";
		Object[] objects = { strwhere, strorder };
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			while (rs.next()) {
				StudentBean cnbean = new StudentBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 获取所有列表
	public List<StudentBean> CheckList(String studentusername, String strorder) {
		String sql = "select * from Student where Student_Username=? order by ?";
		Object[] objects = { studentusername, strorder };
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			while (rs.next()) {
				StudentBean cnbean = new StudentBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 获取列表
	public List<StudentBean> GetList(String strwhere, String strorder) {
		String sql = "select * from Student,Domitory,Building where Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and ? order by ?";

		Object[] objects = { strwhere, strorder };
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {

			while (rs.next()) {
				StudentBean cnbean = new StudentBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public StudentBean GetAllFirstBean(String username) {
		String sql = "select * from Student where Student_Username=?";
		ResultSet rs = null;
		Object[] objects = { username };
		rs = DBUtil.executeQuery(sql, objects);
		StudentBean cnbean = new StudentBean();
		try {
			if (rs.next()) {
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return cnbean;
	}

	public StudentBean GetFirstBean(String username) {
		String sql = "select * from Student,Domitory,Building where Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Student_Username=?";
		Object[] objects = { username };
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		// Connection conn = new DBHelper().getConn();
		StudentBean cnbean = new StudentBean();
		try {
			if (rs.next()) {
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
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
	public List<StudentBean> GetListSelective(String State, String key, String value, String strorder) {
		String sql = "select * from Student,Domitory where Student_DomitoryID=Domitory_ID and Student_State= ? and "+ key + " = ? order by ?";

		Object[] objects = { State,value, strorder };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			while (rs.next()) {
				StudentBean cnbean=new StudentBean();
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
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
	public StudentBean GetAllBean(int id) {
		String sql = "select * from Student where Student_ID=?";
		ResultSet rs = null;
		Object[] objects = { id };
		rs = DBUtil.executeQuery(sql, objects);
		StudentBean cnbean = new StudentBean();
		try {
			while (rs.next()) {
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return cnbean;
	}

	// 获取指定ID的实体Bean
	public StudentBean GetBean(int id) {
		String sql = "select * from Student,Domitory,Building where Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Student_ID=?";

		ResultSet rs = null;
		Object[] objects = { id };

		rs = DBUtil.executeQuery(sql, objects);
		StudentBean cnbean = new StudentBean();
		try {
			while (rs.next()) {
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
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
	public void Add(StudentBean cnbean) {

		String sql = "insert into Student(Student_DomitoryID,Student_Username,Student_Password,Student_Name,Student_Sex,Student_Class,Student_State) values(?,?,?,?,?,?,?)";

		Object[] objects = { cnbean.getStudent_DomitoryID(), cnbean.getStudent_Username(), cnbean.getStudent_Password(),
				cnbean.getStudent_Name(), cnbean.getStudent_Sex(), cnbean.getStudent_Class(),
				cnbean.getStudent_State() };

	}

	// 修改
	public void Update(StudentBean cnbean) {

		String sql = "update Student set Student_DomitoryID=?,Student_Username=?,Student_Password=?,Student_Name=?,Student_Sex=?,Student_Class=?,Student_State=? where Student_ID=?";
		Object[] objects = { cnbean.getStudent_DomitoryID(), cnbean.getStudent_Username(), cnbean.getStudent_Password(),
				cnbean.getStudent_Name(), cnbean.getStudent_Sex(), cnbean.getStudent_Class(), cnbean.getStudent_State(),
				cnbean.getStudent_ID() };

	}
	public void Updatepwd(String id,String password) {
		String sql = "update Student set Student_Password=? where Student_ID=?";
		Object[] objects = { password,id};
		try {
			boolean bool = DBUtil.executeUpdate(sql, objects);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void UpdateState(String studentUsername) {

		String sql = "update Student set Student_State=? where Student_Username=?";
		Object[] objects = { "入住",studentUsername};
		DBUtil.executeUpdate(sql, objects);
	}public void UpdateState_out(String studentUsername) {

		String sql = "update Student set Student_State=? where Student_Username=?";
		Object[] objects = { "迁出",studentUsername};
		DBUtil.executeUpdate(sql, objects);
	}

	// 删除
	public void Delete(String Student_ID) {
		String sql = "delete from Student where Student_ID=?";

		Object[] objects = { Student_ID };
		DBUtil.executeUpdate(sql, objects);

	}
	public List<StudentBean> CheckList(String Username) {
		String sql = "select * from Student where Student_Username= ?";

		Object[] objects = { Username };
		ResultSet rs = DBUtil.executeQuery(sql, objects);
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			while (rs.next()) {
				StudentBean cnbean=new StudentBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}
	public List<StudentBean> GetListFromBuilid(String buildingid, String strorder) {
		String sql = "select * from Student,Domitory,Building where Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Building_ID=? order by ?";

		Object[] objects = { buildingid, strorder };
		ResultSet rs = null;
		rs = DBUtil.executeQuery(sql, objects);
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {

			while (rs.next()) {
				StudentBean cnbean = new StudentBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				cnbean.setStudent_Username(rs.getString("Student_Username"));
				cnbean.setStudent_Password(rs.getString("Student_Password"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

}
