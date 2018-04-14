package com.pratik.common.utils.database;

import java.sql.*;

import com.pratik.common.utils.constants.Constants;

public class DbUtils implements Constants{
	
	public static Connection getPratikDbConnection() {
		Connection  conn = null;
		try {
			Class.forName(Constants.DRIVER);
			conn= DriverManager.getConnection(Constants.PRATIKDB_URL,Constants.USER,Constants.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		return conn;
	}
	
	public static Connection getSakilaDbConnection() {
		Connection  conn = null;
		try {
			Class.forName(Constants.DRIVER);
			conn= DriverManager.getConnection(Constants.SAKILADB_URL,Constants.USER,Constants.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		return conn;
	}
	
	public static Connection getWorldDbConnection(){
		Connection  conn = null;
		try {
			Class.forName(Constants.DRIVER);
			conn= DriverManager.getConnection(Constants.WORLDDB_URL,Constants.USER,Constants.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		return conn;
	}
	
	public static PreparedStatement getPreparedStatement (Connection conn, String sql){
		PreparedStatement ps = null;
		try {
			conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	public static ResultSet getResultSet(PreparedStatement ps) {
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
