
package com.shopmall.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopmall.bean.Category;
import com.shopmall.dao.CategoryDAO;
import com.shopmall.util.DBTool;
 
public class CategoryDAOImpl  implements CategoryDAO{
	
	private DBTool dbtool;
	
	public CategoryDAOImpl()
	{
		dbtool = new DBTool();
	}
	
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from Category";
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
 
    public void add(Category bean) {
 
        String sql = "insert into category values(null,?)";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, bean.getName());
        dbtool.close();
    }
 
    public void update(Category bean) {
 
        String sql = "update category set name= ? where id = ?";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, bean.getName(),String.valueOf(bean.getId()));
        dbtool.close();
 
    }
 
    public void delete(int id) {
    	String sql = "delete from Category where id = " + id;
    	dbtool.getConnection();
    	dbtool.executeUpdate(sql);
    	dbtool.close();
    }
 
    public Category get(int id) {
        Category bean = null;
        String sql = "select * from Category where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
            try {
				if (rs.next()) {
				    bean = new Category();
				    String name = rs.getString(2);
				    bean.setName(name);
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
 
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }
 
    public List<Category> list(int start, int count) {
        List<Category> beans = new ArrayList<Category>();
 
        String sql = "select * from Category order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, start,count);
            try {
				while (rs.next()) {
				    Category bean = new Category();
				    int id = rs.getInt(1);
				    String name = rs.getString(2);
				    bean.setId(id);
				    bean.setName(name);
				    beans.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return beans;
    }
 
}
