package com.shopmall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTool {

	private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/tmall?useSSL=false&userUnicode=true&charactorcoding=utf-8";
	private final String USER = "root";
	private final String PASSWORD = "root"; 
	
	private Connection conn;
	private PreparedStatement state;
	private ResultSet rs;
	
	public DBTool() {
		super();
		this.conn = null;
		this.state = null;
		this.rs = null;
	}
	
	public DBTool(String connection, String user, String password) {
		try {
			conn = DriverManager.getConnection(connection, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public DBTool(String sql)
	{
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
			state = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getConnection()
	{
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void close()
	{
		try {
			if(rs!=null)
			{
				rs.close();
				rs = null;
			}
			if(state!=null)
			{
				state.close();
				state = null;
			}
			if(conn!=null)
			{
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql,String...paras)
	{
		int count = 0;
		try {
			state = conn.prepareStatement(sql);
			for(int i = 0 ; i < paras.length; i++)
			{
				state.setString(i+1, paras[i]);
			}
			count = state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int executeUpdate()
	{
		int count = 0;
		try {
			count = state.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public ResultSet executeQuery(String sql)
	{
		try {
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet executeQuery(String sql , int uid, String excludedStatus, int start, int count)
	{
		try {
			state = conn.prepareStatement(sql);
			state.setInt(1, uid);
			state.setString(2, excludedStatus);
			state.setInt(3, start);
			state.setInt(4, count);
			rs = state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet executeQuery(String sql,String keyword, int start, int count)
	{
		try {
			state = conn.prepareStatement(sql);
			state.setString(1, keyword);
			state.setInt(2, start);
			state.setInt(3, count);
			rs = state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet executeQuery(String sql,int...paras)
	{
		try {
			state = conn.prepareStatement(sql);
			for(int i = 0 ; i < paras.length ; i++)
			{
				state.setInt(i+1, paras[i]);
			}
			rs = state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	} 
	
	public ResultSet executeQuery(String sql,String...paras)
	{
		try {
			state = conn.prepareStatement(sql);
			for(int i = 0 ; i < paras.length ; i++)
			{
				state.setString(i+1, paras[i]);
			}
			rs = state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet executeQuery()
	{
		try {
			rs = state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return rs;
	}
}

	
