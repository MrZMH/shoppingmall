
package com.shopmall.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopmall.bean.User;
import com.shopmall.dao.UserDAO;
import com.shopmall.util.DBTool;
 
public class UserDAOImpl implements UserDAO{
	
	private DBTool dbtool;
	
	public UserDAOImpl()
	{
		dbtool = new DBTool();
	}
 
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from User";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			while (rs.next())
			{
			     total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
        return total;
    }
 
    public void add(User bean) {
    	String sql = "insert into user values(null ,? ,?)";
    	dbtool.getConnection();
    	dbtool.executeUpdate(sql, bean.getUsername(),bean.getPassword());
    	dbtool.close();
    }
 
    public void update(User bean) {
 
        String sql = "update user set name= ? , password = ? where id = ? ";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, bean.getUsername(),bean.getPassword(),String.valueOf(bean.getUserId()));
        dbtool.close();
 
    }
 
    public void delete(int id) {

        String sql = "delete from User where id = " + id;
        dbtool.getConnection();
        dbtool.executeUpdate(sql);
        dbtool.close();
          
    }
 
    public User get(int id) {
        User bean = null;
        String sql = "select * from User where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			if (rs.next()) {
			    bean = new User();
			    String name = rs.getString("name");
			    bean.setName(name);
			    String password = rs.getString("password");
			    bean.setPassword(password);
			    bean.setUserId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
        return bean;
    }
 
    public List<User> list() {
        return list(0, Short.MAX_VALUE);
    }
 
    public List<User> list(int start, int count) {
        List<User> beans = new ArrayList<User>();
 
        String sql = "select * from User order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, start,count);
        try {
			while (rs.next()) {
			    User bean = new User();
			    int id = rs.getInt(1);

			    String name = rs.getString("name");
			    bean.setName(name);
			    String password = rs.getString("password");
			    bean.setPassword(password);
			    
			    bean.setUserId(id);
			    beans.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
        return beans;
    }

	public boolean isExist(String name) {
		User user = get(name);
		return user!=null;
	}

	public User get(String name) {
		User bean = null;
		 
		String sql = "select * from User where name = ?";
		dbtool.getConnection();
		ResultSet rs = dbtool.executeQuery(sql, name);
        try {
			if (rs.next()) {
			    bean = new User();
			    int id = rs.getInt("id");
			    bean.setName(name);
			    String password = rs.getString("password");
			    bean.setPassword(password);
			    bean.setUserId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
        return bean;
	}

	public User get(String name, String password) {
		User bean = null;
		 
		String sql = "select * from User where name = ? and password=?";
		dbtool.getConnection();
		ResultSet rs = dbtool.executeQuery(sql, name,password);
        try {
			if (rs.next()) {
			    bean = new User();
			    int id = rs.getInt("id");
			    bean.setName(name);
			    bean.setPassword(password);
			    bean.setUserId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bean;
	}
}
