
package com.shopmall.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopmall.bean.Cart;
import com.shopmall.bean.Order;
import com.shopmall.bean.Product;
import com.shopmall.bean.User;
import com.shopmall.dao.CartDAO;
import com.shopmall.util.DBTool;
 
public class CartDAOImpl implements CartDAO{
	private DBTool dbtool;
	
	public CartDAOImpl()
	{
		dbtool = new DBTool();
	}
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from Cart";
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
 
    public void add(Cart cart) {

        String sql = "insert into Cart values(null,?,?,?,?)";
        dbtool.getConnection();
        if(cart.getOrder()==null)
        {
        	dbtool.executeUpdate(sql, String.valueOf(cart.getProduct().getId()),String.valueOf(-1),
        			String.valueOf(cart.getUser().getUserId()),String.valueOf(cart.getNumber()));	
        }
        else{
        	dbtool.executeUpdate(sql, String.valueOf(cart.getProduct().getId()),String.valueOf(cart.getOrder().getId()),
        			String.valueOf(cart.getUser().getUserId()),String.valueOf(cart.getNumber()));
        }
        dbtool.close();
    }
 
    public void update(Cart cart) {

        String sql = "update Cart set pid= ?, oid=?, uid=?,number=?  where id = ?";
        if(cart.getOrder()==null)
        {
        	dbtool.executeUpdate(sql, String.valueOf(cart.getProduct().getId()),String.valueOf(-1),
        			String.valueOf(cart.getUser().getUserId()),String.valueOf(cart.getNumber()),
        			String.valueOf(cart.getId()));	
        }
        else{
        	dbtool.executeUpdate(sql, String.valueOf(cart.getProduct().getId()),String.valueOf(cart.getOrder().getId()),
        			String.valueOf(cart.getUser().getUserId()),String.valueOf(cart.getNumber()),
        			String.valueOf(cart.getId()));
        }
        dbtool.close();

    }
 
    public void delete(int id) {
    	String sql = "delete from Cart where id = " + id;
    	dbtool.getConnection();
    	dbtool.executeUpdate(sql);
    	dbtool.close();
    }
 
    public Cart get(int id) {
        Cart bean = new Cart();
        String sql = "select * from Cart where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
            try {
				if (rs.next()) {
				    int pid = rs.getInt("pid");
				    int oid = rs.getInt("oid");
				    int uid = rs.getInt("uid");
				    int number = rs.getInt("number");
				    Product product = new ProductDAOImpl().get(pid);
				    User user = new UserDAOImpl().get(uid);
				    bean.setProduct(product);
				    bean.setUser(user);
				    bean.setNumber(number);
				    
				    if(-1!=oid){
				        Order order= new OrderDAOImpl().get(oid);
				        bean.setOrder(order);               	
				    }
				    
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
 
    public List<Cart> listByUser(int uid) {
        return listByUser(uid, 0, Short.MAX_VALUE);
    }
 
    public List<Cart> listByUser(int uid, int start, int count) {
        List<Cart> beans = new ArrayList<Cart>();
 
        String sql = "select * from Cart where uid = ? and oid=-1 order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, uid,start,count);
            try {
				while (rs.next()) {
				    Cart bean = new Cart();
				    int id = rs.getInt(1);

				    int pid = rs.getInt("pid");
				    int oid = rs.getInt("oid");
				    int number = rs.getInt("number");
				    
				  
				    Product product = new ProductDAOImpl().get(pid);
				    if(-1!=oid){
				        Order order= new OrderDAOImpl().get(oid);
				        bean.setOrder(order);               	
				    }

				    User user = new UserDAOImpl().get(uid);
				    bean.setProduct(product);

				    bean.setUser(user);
				    bean.setNumber(number);
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
    
    public List<Cart> listByOrder(int orderId) {
    	return listByOrder(orderId, 0, Short.MAX_VALUE);
    }
    
    public List<Cart> listByOrder(int oid, int start, int count) {
    	List<Cart> beans = new ArrayList<Cart>();
    	
    	String sql = "select * from Cart where oid = ? order by id desc limit ?,? ";
    	dbtool.getConnection();
    	ResultSet rs = dbtool.executeQuery(sql, oid,start,count);

    		try {
				while (rs.next()) {
					Cart bean = new Cart();
					int id = rs.getInt(1);
					
					int pid = rs.getInt("pid");
					int uid = rs.getInt("uid");
					int number = rs.getInt("number");
					
					
					Product product = new ProductDAOImpl().get(pid);
					if(-1!=oid){
						Order order= new OrderDAOImpl().get(oid);
						bean.setOrder(order);               	
					}
					
					User user = new UserDAOImpl().get(uid);
					bean.setProduct(product);
					
					bean.setUser(user);
					bean.setNumber(number);
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

	public void fill(List<Order> orders) {
		for (Order o : orders) {
			List<Cart> ois=listByOrder(o.getId());
			float total = 0;
			int totalNumber = 0;
			for (Cart oi : ois) {
				 total+=oi.getNumber()*oi.getProduct().getPromotePrice();
				 totalNumber+=oi.getNumber();
			}
			o.setTotal(total);
			o.setOrderItems(ois);
			o.setTotalNumber(totalNumber);
		}
		
		
		
	}

	public void fill(Order order) {
		List<Cart> ois=listByOrder(order.getId());
		float total = 0;
		for (Cart oi : ois) {
			 total+=oi.getNumber()*oi.getProduct().getPromotePrice();
		}
		order.setTotal(total);
		order.setOrderItems(ois);
	}

    public List<Cart> listByProduct(int pid) {
        return listByProduct(pid, 0, Short.MAX_VALUE);
    }
 
    public List<Cart> listByProduct(int pid, int start, int count) {
        List<Cart> beans = new ArrayList<Cart>();
 
        String sql = "select * from Cart where pid = ? order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql,pid,start,count);
      
            try {
				while (rs.next()) {
				    Cart bean = new Cart();
				    int id = rs.getInt(1);

				    int uid = rs.getInt("uid");
				    int oid = rs.getInt("oid");
				    int number = rs.getInt("number");
				    
				  
				    Product product = new ProductDAOImpl().get(pid);
				    if(-1!=oid){
				        Order order= new OrderDAOImpl().get(oid);
				        bean.setOrder(order);               	
				    }

				    User user = new UserDAOImpl().get(uid);
				    bean.setProduct(product);

				    bean.setUser(user);
				    bean.setNumber(number);
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

	public int getSaleCount(int pid) {
		 int total = 0;
		 String sql = "select sum(number) from Cart where pid = " + pid;
		 dbtool.getConnection();
		 ResultSet rs = dbtool.executeQuery(sql);
	        try {
				while (rs.next()) {
				    total = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return total;
	}
}