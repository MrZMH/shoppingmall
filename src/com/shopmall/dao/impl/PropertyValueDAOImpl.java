
package com.shopmall.dao.impl;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopmall.bean.Product;
import com.shopmall.bean.Property;
import com.shopmall.bean.PropertyValue;
import com.shopmall.dao.PropertyValueDAO;
import com.shopmall.util.DBTool;
  
public class PropertyValueDAOImpl implements PropertyValueDAO{
	
	private DBTool dbtool;
	
	public PropertyValueDAOImpl()
	{
		dbtool = new DBTool();
	}
	
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from PropertyValue";
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
  
    public void add(PropertyValue bean) {
 
        String sql = "insert into PropertyValue values(null,?,?,?)";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, String.valueOf(bean.getProduct().getId()),
        		String.valueOf(bean.getProperty().getId()),bean.getValue());
        dbtool.close();
        
    }
  
    public void update(PropertyValue bean) {
 
        String sql = "update PropertyValue set pid= ?, ptid=?, value=?  where id = ?";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, String.valueOf(bean.getProduct().getId()),String.valueOf(bean.getProperty().getId()),
        		bean.getValue(),String.valueOf(bean.getId()));
        dbtool.close();
    }
  
    public void delete(int id) {
    	String sql = "delete from PropertyValue where id = " + id;
    	dbtool.getConnection();
    	dbtool.executeUpdate(sql);
    	dbtool.close();
    }
  
    public PropertyValue get(int id) {
    	String sql = "select * from PropertyValue where id = " + id;
        PropertyValue bean = new PropertyValue();
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			if (rs.next()) {
			    int pid = rs.getInt("pid");
			    int ptid = rs.getInt("ptid");
			    String value = rs.getString("value");
			     
			    Product product = new ProductDAOImpl().get(pid);
			    Property property = new PropertyDAOImpl().get(ptid);
			    bean.setProduct(product);
			    bean.setProperty(property);
			    bean.setValue(value);
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
    
    public PropertyValue get(int ptid, int pid ) {
        PropertyValue bean = null;
        String sql = "select * from PropertyValue where ptid = " + ptid + " and pid = " + pid;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			if (rs.next()) {
			    bean= new PropertyValue();
			    int id = rs.getInt("id");
 
			        String value = rs.getString("value");
			     
			    Product product = new ProductDAOImpl().get(pid);
			    Property property = new PropertyDAOImpl().get(ptid);
			    bean.setProduct(product);
			    bean.setProperty(property);
			    bean.setValue(value);
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
  
    public List<PropertyValue> list() {
        return list(0, Short.MAX_VALUE);
    }
  
    public List<PropertyValue> list(int start, int count) {
        List<PropertyValue> beans = new ArrayList<PropertyValue>();
  
        String sql = "select * from PropertyValue order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql,start,count);
            try {
				while (rs.next()) {
				    PropertyValue bean = new PropertyValue();
				    int id = rs.getInt(1);
 
				    int pid = rs.getInt("pid");
				int ptid = rs.getInt("ptid");
				String value = rs.getString("value");
				 
				Product product = new ProductDAOImpl().get(pid);
				Property property = new PropertyDAOImpl().get(ptid);
				bean.setProduct(product);
				bean.setProperty(property);
				bean.setValue(value);
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
 
    public void init(Product p) {
        List<Property> pts= new PropertyDAOImpl().list(p.getCategory().getId());
         
        for (Property pt: pts) {
            PropertyValue pv = get(pt.getId(),p.getId());
            if(null==pv){
                pv = new PropertyValue();
                pv.setProduct(p);
                pv.setProperty(pt);
                this.add(pv);
            }
        }
    }
 
    public List<PropertyValue> list(int pid) {
        List<PropertyValue> beans = new ArrayList<PropertyValue>();
         
        String sql = "select * from PropertyValue where pid = ? order by ptid desc";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, String.valueOf(pid));
        try {
			while (rs.next()) {
			    PropertyValue bean = new PropertyValue();
			    int id = rs.getInt(1);
 
			    int ptid = rs.getInt("ptid");
			    String value = rs.getString("value");
			     
			    Product product = new ProductDAOImpl().get(pid);
			    Property property = new PropertyDAOImpl().get(ptid);
			    bean.setProduct(product);
			    bean.setProperty(property);
			    bean.setValue(value);
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