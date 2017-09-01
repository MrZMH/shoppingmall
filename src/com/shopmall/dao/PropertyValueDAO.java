package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Product;
import com.shopmall.bean.PropertyValue;

public interface PropertyValueDAO {
	public int getTotal();
	public void add(PropertyValue bean);
	public void update(PropertyValue bean);
	public void delete(int id);
	public PropertyValue get(int id);
	public PropertyValue get(int ptid, int pid );
	public List<PropertyValue> list();
	public List<PropertyValue> list(int start, int count);
	public void init(Product p);
	public List<PropertyValue> list(int pid);
}
