
package com.shopmall.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopmall.bean.Product;
import com.shopmall.bean.Review;
import com.shopmall.bean.User;
import com.shopmall.dao.ReviewDAO;
import com.shopmall.util.DBTool;
import com.shopmall.util.DateUtil;
 
public class ReviewDAOImpl implements ReviewDAO{
 
	private DBTool dbtool;
	
	public ReviewDAOImpl()
	{
		dbtool = new DBTool();
	}
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from Review";
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
    
    public int getTotal(int pid) {
    	int total = 0;
    	String sql = "select count(*) from Review where pid = " + pid;
    	 dbtool.getConnection();
         ResultSet rs = dbtool.executeQuery(sql);
		try {
			while (rs.next()) {
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
 
    public void add(Review bean) {

        String sql = "insert into Review values(null,?,?,?,?)";
        dbtool.getConnection();
        dbtool.executeUpdate(sql,bean.getContent(),String.valueOf(bean.getUser().getUserId()),
        		String.valueOf(bean.getProduct().getId()),DateUtil.d2t(bean.getCreateDate()).toString());
        dbtool.close();

    }
 
    public void update(Review bean) {

        String sql = "update Review set content= ?, uid=?, pid=? , createDate = ? where id = ?";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, bean.getContent(),String.valueOf(bean.getUser().getUserId()),
        		String.valueOf(bean.getProduct().getId()),String.valueOf(DateUtil.d2t( bean.getCreateDate())),
        		String.valueOf(bean.getId()));
        dbtool.close();
 
    }
 
    public void delete(int id) {
 
        String sql = "delete from Review where id = " + id;
        dbtool.getConnection();
        dbtool.executeUpdate(sql);
        dbtool.close();
    }
 
    public Review get(int id) {
        Review bean = new Review();
 
        String sql = "select * from Review where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			if (rs.next()) {
			    int pid = rs.getInt("pid");
			    int uid = rs.getInt("uid");
			    Date createDate = DateUtil.t2d(rs.getTimestamp("createDate"));
			    
			    String content = rs.getString("content");
			    
			    Product product = new ProductDAOImpl().get(pid);
			    User user = new UserDAOImpl().get(uid);
			    
			    bean.setContent(content);
			    bean.setCreateDate(createDate);
			    bean.setProduct(product);
			    bean.setUser(user);
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
 
    public List<Review> list(int pid) {
        return list(pid, 0, Short.MAX_VALUE);
    }
 
    public int getCount(int pid) {
        String sql = "select count(*) from Review where pid = ? " + pid;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			while (rs.next()) {
			   return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}

        return 0;    	
    }
    public List<Review> list(int pid, int start, int count) {
        List<Review> beans = new ArrayList<Review>();
 
        String sql = "select * from Review where pid = ? order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, pid,start,count);
        try {
			while (rs.next()) {
			    Review bean = new Review();
			    int id = rs.getInt(1);

			    int uid = rs.getInt("uid");
			    Date createDate = DateUtil.t2d(rs.getTimestamp("createDate"));
			    
			    String content = rs.getString("content");
			        
			    Product product = new ProductDAOImpl().get(pid);
			    User user = new UserDAOImpl().get(uid);
  
			    bean.setContent(content);
			    bean.setCreateDate(createDate);
			    bean.setId(id);     
			    bean.setProduct(product);
			    bean.setUser(user);
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
	public boolean isExist(String content, int pid) {
	
		String sql = "select * from Review where content = ? and pid = ?";
		dbtool.getConnection();
		ResultSet rs = dbtool.executeQuery(sql, content,String.valueOf(pid));
        try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
 
		return false;
	}
}