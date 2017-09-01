package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Order;

public interface OrderDAO {

	public void add(Order bean);
	public void delete(int id);
	public Order get(int id);
	public int getTotal();
	public List<Order> list();
	public List<Order> list(int start, int count);
	public List<Order> list(int uid, String excludedStatus);
	public List<Order> list(int uid, String excludedStatus, int start, int count);
	public void update(Order bean);
}
