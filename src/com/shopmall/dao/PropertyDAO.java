package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Property;

public interface PropertyDAO {
	public int getTotal(int cid);
	public void add(Property bean);
	public void update(Property bean);
	public void delete(int id);
	public Property get(String name, int cid);
	public Property get(int id);
	public List<Property> list(int cid);
	public List<Property> list(int cid, int start, int count);
	
}
