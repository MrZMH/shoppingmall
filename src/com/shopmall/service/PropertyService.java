package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Property;
import com.shopmall.dao.PropertyDAO;
import com.shopmall.dao.impl.PropertyDAOImpl;

public class PropertyService {

	private PropertyDAO dao;
	
	public PropertyService()
	{
		dao  = new PropertyDAOImpl();
	}
	
	public int getTotal(int cid)
	{
		return dao.getTotal(cid);
	}
	public void add(Property bean)
	{
		dao.add(bean);
	}
	public void update(Property bean)
	{
		dao.update(bean);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public Property get(String name, int cid)
	{
		return dao.get(name,cid);
	}
	public Property get(int id)
	{
		return dao.get(id);
	}
	public List<Property> list(int cid)
	{
		return dao.list(cid);
	}
	public List<Property> list(int cid, int start, int count)
	{
		return dao.list(cid, start, count);
	}
}
