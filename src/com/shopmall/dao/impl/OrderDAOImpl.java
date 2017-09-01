
package com.shopmall.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopmall.bean.Order;
import com.shopmall.bean.User;
import com.shopmall.dao.OrderDAO;
import com.shopmall.util.DBTool;
import com.shopmall.util.DateUtil;
 
public class OrderDAOImpl implements OrderDAO{
	public static final String waitPay = "waitPay";
	public static final String waitDelivery = "waitDelivery";
	public static final String waitConfirm = "waitConfirm";
	public static final String waitReview = "waitReview";
	public static final String finish = "finish";
	public static final String delete = "delete";
	
	private DBTool dbtool;
	
	public OrderDAOImpl()
	{
		dbtool = new DBTool();
	}
	
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from Order_";
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
 
    public void add(Order bean) {
        String sql = "insert into order_ values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
        dbtool.getConnection();
        dbtool.executeUpdate(sql, bean.getOrderCode(),bean.getAddress(),bean.getPost(),
        		bean.getReceiver(),bean.getMobile(),bean.getUserMessage(),String.valueOf(DateUtil.d2t(bean.getCreateDate())),
        		String.valueOf(DateUtil.d2t(bean.getPayDate())),String.valueOf(DateUtil.d2t(bean.getDeliveryDate())),
        		String.valueOf(DateUtil.d2t(bean.getConfirmDate())),String.valueOf(bean.getUser().getUserId()),
        		String.valueOf(bean.getStatus()));
        dbtool.close();
    }
 
    public void update(Order bean) {
    
        String sql = "update order_ set address= ?, post=?, receiver=?,mobile=?,userMessage=? ,createDate = ? , payDate =? , deliveryDate =?, confirmDate = ? , orderCode =?, uid=?, status=? where id = ?";
        dbtool.getConnection();
        dbtool.executeQuery(sql,bean.getOrderCode(),bean.getAddress(),bean.getPost(),
        		bean.getReceiver(),bean.getMobile(),bean.getUserMessage(),String.valueOf(DateUtil.d2t(bean.getCreateDate())),
        		String.valueOf(DateUtil.d2t(bean.getPayDate())),String.valueOf(DateUtil.d2t(bean.getDeliveryDate())),
        		String.valueOf(DateUtil.d2t(bean.getConfirmDate())),String.valueOf(bean.getUser().getUserId()),
        		String.valueOf(bean.getStatus()),String.valueOf(bean.getId()));
        dbtool.close();
 
    }
 
    public void delete(int id) {
    	String sql = "delete from Order_ where id = " + id;
    	dbtool.getConnection();
    	dbtool.executeQuery(sql);
    	dbtool.close();
    }
 
    public Order get(int id) {
        Order bean = new Order();
        String sql = "select * from Order_ where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);
            try {
				if (rs.next()) {
					String orderCode =rs.getString("orderCode");
				    String address = rs.getString("address");
				    String post = rs.getString("post");
				    String receiver = rs.getString("receiver");
				    String mobile = rs.getString("mobile");
				    String userMessage = rs.getString("userMessage");
				    String status = rs.getString("status");
				    int uid =rs.getInt("uid");
				    Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
				    Date payDate = DateUtil.t2d( rs.getTimestamp("payDate"));
				    Date deliveryDate = DateUtil.t2d( rs.getTimestamp("deliveryDate"));
				    Date confirmDate = DateUtil.t2d( rs.getTimestamp("confirmDate"));
				    
				    bean.setOrderCode(orderCode);
				    bean.setAddress(address);
				    bean.setPost(post);
				    bean.setReceiver(receiver);
				    bean.setMobile(mobile);
				    bean.setUserMessage(userMessage);
				    bean.setCreateDate(createDate);
				    bean.setPayDate(payDate);
				    bean.setDeliveryDate(deliveryDate);
				    bean.setConfirmDate(confirmDate);
				    User user = new UserDAOImpl().get(uid);
				    bean.setUser(user);
				    bean.setStatus(status);
				    
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
 
    public List<Order> list() {
        return list(0, Short.MAX_VALUE);
    }
 
    public List<Order> list(int start, int count) {
        List<Order> beans = new ArrayList<Order>();
 
        String sql = "select * from Order_ order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, start,count);
            try {
				while (rs.next()) {
				    Order bean = new Order();
					String orderCode =rs.getString("orderCode");
				    String address = rs.getString("address");
				    String post = rs.getString("post");
				    String receiver = rs.getString("receiver");
				    String mobile = rs.getString("mobile");
				    String userMessage = rs.getString("userMessage");
				    String status = rs.getString("status");
				    Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
				    Date payDate = DateUtil.t2d( rs.getTimestamp("payDate"));
				    Date deliveryDate = DateUtil.t2d( rs.getTimestamp("deliveryDate"));
				    Date confirmDate = DateUtil.t2d( rs.getTimestamp("confirmDate"));
				    int uid =rs.getInt("uid");                
				    
				    int id = rs.getInt("id");
				    bean.setId(id);
				    bean.setOrderCode(orderCode);
				    bean.setAddress(address);
				    bean.setPost(post);
				    bean.setReceiver(receiver);
				    bean.setMobile(mobile);
				    bean.setUserMessage(userMessage);
				    bean.setCreateDate(createDate);
				    bean.setPayDate(payDate);
				    bean.setDeliveryDate(deliveryDate);
				    bean.setConfirmDate(confirmDate);
				    User user = new UserDAOImpl().get(uid);
				    bean.setUser(user);
				    bean.setStatus(status);
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
    
    public List<Order> list(int uid,String excludedStatus) {
        return list(uid,excludedStatus,0, Short.MAX_VALUE);
    }
     
    public List<Order> list(int uid, String excludedStatus, int start, int count) {
    	List<Order> beans = new ArrayList<Order>();
    	
    	String sql = "select * from Order_ where uid = ? and status != ? order by id desc limit ?,? ";
    	dbtool.getConnection();
    	ResultSet rs = dbtool.executeQuery(sql, uid,excludedStatus,start,count);
    		try {
				while (rs.next()) {
					Order bean = new Order();
					String orderCode =rs.getString("orderCode");
					String address = rs.getString("address");
					String post = rs.getString("post");
					String receiver = rs.getString("receiver");
					String mobile = rs.getString("mobile");
					String userMessage = rs.getString("userMessage");
					String status = rs.getString("status");
					Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
					Date payDate = DateUtil.t2d( rs.getTimestamp("payDate"));
					Date deliveryDate = DateUtil.t2d( rs.getTimestamp("deliveryDate"));
					Date confirmDate = DateUtil.t2d( rs.getTimestamp("confirmDate"));
				   
					int id = rs.getInt("id");
					bean.setId(id);
					bean.setOrderCode(orderCode);
					bean.setAddress(address);
					bean.setPost(post);
					bean.setReceiver(receiver);
					bean.setMobile(mobile);
					bean.setUserMessage(userMessage);
					bean.setCreateDate(createDate);
					bean.setPayDate(payDate);
					bean.setDeliveryDate(deliveryDate);
					bean.setConfirmDate(confirmDate);
					User user = new UserDAOImpl().get(uid);
					bean.setStatus(status);
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
 
}