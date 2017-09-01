package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Cart;
import com.shopmall.bean.Order;

public interface CartDAO {

	public void add(Cart cart);
	public void delete(int id);
	public void update(Cart cart);
	public Cart get(int uid);
	public List<Cart> listByUser(int uid);
	public List<Cart> listByUser(int uid, int start, int count);
	public List<Cart> listByOrder(int orderId);
	public List<Cart> listByOrder(int oid, int start, int count);
	public void fill(List<Order> orders);
	public void fill(Order order);
	public List<Cart> listByProduct(int pid);
	public List<Cart> listByProduct(int pid, int start, int count);
	public int getSaleCount(int pid);
	public int getTotal();
	
}
