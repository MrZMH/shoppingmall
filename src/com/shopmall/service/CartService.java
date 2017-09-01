package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Cart;
import com.shopmall.bean.Order;
import com.shopmall.dao.CartDAO;
import com.shopmall.dao.impl.CartDAOImpl;

public class CartService {
	
	private CartDAO dao;
	
	public CartService() {
		this.dao = new CartDAOImpl();
	}
	public void add(Cart cart)
	{
		dao.add(cart);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public void update(Cart cart)
	{
		dao.update(cart);
	}
	public Cart get(int uid)
	{
		return dao.get(uid);
	}
	public List<Cart> listByUser(int uid)
	{
		return dao.listByUser(uid);
	}
	public List<Cart> listByUser(int uid, int start, int count)
	{
		return dao.listByUser(uid, start, count);
	}
	public List<Cart> listByOrder(int orderId)
	{
		return dao.listByOrder(orderId);
	}
	public List<Cart> listByOrder(int oid, int start, int count)
	{
		return dao.listByOrder(oid, start, count);
	}
	public void fill(List<Order> orders)
	{
		dao.fill(orders);
	}
	public void fill(Order order)
	{
		dao.fill(order);
	}
	public List<Cart> listByProduct(int pid)
	{
		return dao.listByProduct(pid);
	}
	public List<Cart> listByProduct(int pid, int start, int count)
	{
		return dao.listByProduct(pid, start, count);
	}
	public int getSaleCount(int pid)
	{
		return dao.getSaleCount(pid);
	}
	public int getTotal()
	{
		return dao.getTotal();
	}
}
