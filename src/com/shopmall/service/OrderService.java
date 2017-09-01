package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Order;
import com.shopmall.dao.OrderDAO;
import com.shopmall.dao.impl.OrderDAOImpl;

public class OrderService {
	
	private OrderDAO dao;
	
	public OrderService()
	{
		dao = new OrderDAOImpl();
	}
	public void add(Order bean)
	{
		dao.add(bean);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public Order get(int id)
	{
		return dao.get(id);
	}
	public int getTotal()
	{
		return dao.getTotal();
	}
	public List<Order> list()
	{
		return dao.list();
	}
	public List<Order> list(int start, int count)
	{
		return dao.list(start, count);
	}
	public List<Order> list(int uid, String excludedStatus)
	{
		return dao.list(uid, excludedStatus);
	}
	public List<Order> list(int uid, String excludedStatus, int start, int count)
	{
		return dao.list(uid, excludedStatus, start, count);
	}
	public void update(Order bean)
	{
		dao.update(bean);
	}
}
