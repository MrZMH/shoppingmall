
package com.shopmall.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopmall.bean.Category;
import com.shopmall.bean.Property;
import com.shopmall.dao.PropertyDAO;
import com.shopmall.util.DBTool;
 
public class PropertyDAOImpl implements PropertyDAO{
	private DBTool dbtool;
	
	public PropertyDAOImpl()
	{
		dbtool = new DBTool();
	}
	
    public int getTotal(int cid) {
        int total = 0;
        String sql = "select count(*) from Property where cid =" + cid;
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
 
    public void add(Property bean) {

        String sql = "insert into Property values(null,?,?)";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, String.valueOf(bean.getCategory().getId()),bean.getName());
        dbtool.close();
    }
 
    public void update(Property bean) {

        String sql = "update Property set cid= ?, name=? where id = ?";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, String.valueOf(bean.getCategory().getId()),
        		bean.getName(),String.valueOf(bean.getId()));
        dbtool.close();
 
    }
 
    public void delete(int id) {
 
        String sql = "delete from Property where id = " + id;
        dbtool.getConnection();
        dbtool.executeUpdate(sql);
        dbtool.close();
    }
 
    public Property get(String name, int cid) {
    	Property bean =null;
		 
		String sql = "select * from Property where name = ? and cid = ?";
		dbtool.getConnection();
		ResultSet rs = dbtool.executeQuery(sql, name,String.valueOf(cid));     
        try {
			if (rs.next()) {
			    int id = rs.getInt("id");
			    bean = new Property();
			    bean.setName(name);
			    Category category = new CategoryDAOImpl().get(cid);
			    bean.setCategory(category);
			    bean.setId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bean;
	}
    
    public Property get(int id) {
        Property bean = new Property();
        String sql = "select * from Property where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			if (rs.next()) {

			    String name = rs.getString("name");
			    int cid = rs.getInt("cid");
			    bean.setName(name);
			    Category category = new CategoryDAOImpl().get(cid);
			    bean.setCategory(category);
			    bean.setId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
 
        return bean;
    }
 
    public List<Property> list(int cid) {
        return list(cid, 0, Short.MAX_VALUE);
    }
 
    public List<Property> list(int cid, int start, int count) {
        List<Property> beans = new ArrayList<Property>();
 
        String sql = "select * from Property where cid = ? order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, cid,start,count);
       
        try {
			while (rs.next()) {
			    Property bean = new Property();
			    int id = rs.getInt(1);
			    String name = rs.getString("name");
			    bean.setName(name);
			    Category category = new CategoryDAOImpl().get(cid);
			    bean.setCategory(category);
			    bean.setId(id);
			    
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
 
}
