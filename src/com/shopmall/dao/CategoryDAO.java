package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Category;

public interface CategoryDAO {

	public void add(Category bean);
	public void delete(int id);
	public Category get(int id);
	public int getTotal();
	public List<Category> list();
	public List<Category> list(int start, int count);
	public void update(Category bean);
}
