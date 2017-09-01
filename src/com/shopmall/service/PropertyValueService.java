package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Product;
import com.shopmall.bean.PropertyValue;
import com.shopmall.dao.PropertyValueDAO;
import com.shopmall.dao.impl.PropertyValueDAOImpl;

public class PropertyValueService {
	
	private PropertyValueDAO dao;
	
	public PropertyValueService()
	{
		dao = new PropertyValueDAOImpl();
	}
	
	public int getTotal()
	{
		return dao.getTotal();
	}
	public void add(PropertyValue bean)
	{
		dao.add(bean);
	}
	public void update(PropertyValue bean)
	{
		dao.update(bean);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public PropertyValue get(int id)
	{
		return dao.get(id);
	}
	public PropertyValue get(int ptid, int pid )
	{
		return dao.get(ptid, pid);
	}
	public List<PropertyValue> list()
	{
		return dao.list();
	}
	public List<PropertyValue> list(int start, int count)
	{
		return dao.list(start, count);
	}
	public void init(Product p)
	{
		dao.init(p);
	}
	public List<PropertyValue> list(int pid)
	{
		return dao.list(pid);
	}
}
