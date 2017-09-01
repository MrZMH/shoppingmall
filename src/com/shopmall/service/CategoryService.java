package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Category;
import com.shopmall.dao.CategoryDAO;
import com.shopmall.dao.impl.CategoryDAOImpl;

public class CategoryService {

	private CategoryDAO dao;
	
	public CategoryService()
	{
		dao = new CategoryDAOImpl();
	}
	
	public void add(Category bean)
	{
		dao.add(bean);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public Category get(int id)
	{
		return dao.get(id);
	}
	public int getTotal()
	{
		return dao.getTotal();
	}
	public List<Category> list()
	{
		return dao.list();
	}
	public List<Category> list(int start, int count)
	{
		return dao.list(start, count);
	}
	public void update(Category bean)
	{
		dao.update(bean);
	}
}
