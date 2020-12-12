package com.db.util;
//通用的数据操作方法

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.views.jsp.ParamTag;


public class DBUtil {
	// 通用的增删改
	private static final String URI = "jdbc:mysql://localhost:3306/sushe?useUnicode=true&characterEncoding=UTF-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rSet = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(URI, USERNAME, PASSWORD);
		return connection;
	}
	
	public static boolean executeUpdate(String sql, Object[] params) {
		try {
			getConnection();
			pstmt=createPreparedStatement(sql, params);
			int count = pstmt.executeUpdate();
			return count > 0;
		}

		catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	
	public static PreparedStatement createPreparedStatement(String sql,Object params[]) throws ClassNotFoundException, SQLException {
		pstmt=getConnection().prepareStatement(sql);
		if (params!=null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		System.out.println(pstmt.toString());
		return pstmt;
	}

	// 通用的查：返回值是一个集合(Student,List<Student>,null)
	public static ResultSet executeQuery(String sql,Object[] params) {
//		Student student=null;
//		
//		List<Student> students = new ArrayList<>();
		try {
			
			getConnection();
			
			pstmt=createPreparedStatement(sql, params);			
			
			rSet = pstmt.executeQuery();
			return rSet;
			

		}

		catch (Exception e) {
			// TODO: handle exception
		} 
		finally {
			closeAll(null, null, null);
		}
		return rSet;
	}
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
		
		try {
			if (rs != null)
				rs.close();
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//查询总数
	public static int getTotalCount(String sql) {
		int count=-1;
		
		try {
			createPreparedStatement(sql, null);
			rSet=pstmt.executeQuery();
			if (rSet.next()) {
				count=rSet.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rSet, pstmt, connection);
		}
		return count;
		
	}
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(URI,USERNAME,PASSWORD);
		}
		catch(SQLException ex){}
		return conn;		
	}
}
