
package com.shopmall.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopmall.bean.Product;
import com.shopmall.bean.ProductImage;
import com.shopmall.dao.ProductImageDAO;
import com.shopmall.util.DBTool;
 
public class ProductImageDAOImpl implements ProductImageDAO{
 
	public static final String type_single = "type_single";
	public static final String type_detail = "type_detail";
	private DBTool dbtool;
	
	public ProductImageDAOImpl()
	{
		dbtool = new DBTool();
	}
	
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from ProductImage";
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
 
    public void add(ProductImage bean) {

        String sql = "insert into ProductImage values(null,?,?)";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, String.valueOf(bean.getProduct().getId()),bean.getType());
        dbtool.close();
    }
 
    public void update(ProductImage bean) {
 
    }
 
    public void delete(int id) {
    	String sql = "delete from ProductImage where id = " + id;
    	dbtool.getConnection();
    	dbtool.executeUpdate(sql);
    	dbtool.close();
    }
 
    public ProductImage get(int id) {
        ProductImage bean = new ProductImage();
        String sql = "select * from ProductImage where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
 
        try {
			if (rs.next()) {
			    int pid = rs.getInt("pid");
			    String type = rs.getString("type");
			    Product product = new ProductDAOImpl().get(pid);
			    bean.setProduct(product);
			    bean.setType(type);
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
 
    public List<ProductImage> list(Product p, String type) {
        return list(p, type,0, Short.MAX_VALUE);
    }
 
    public List<ProductImage> list(Product p, String type, int start, int count) {
        List<ProductImage> beans = new ArrayList<ProductImage>();
 
        String sql = "select * from ProductImage where pid =? and type =? order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, p.getId(),type,start,count);

        try {
			while (rs.next()) {

			    ProductImage bean = new ProductImage();
			    int id = rs.getInt(1);


			    bean.setProduct(p);
			    bean.setType(type);
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
