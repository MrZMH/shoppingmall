package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Category;
import com.shopmall.bean.Product;
import com.shopmall.dao.ProductDAO;
import com.shopmall.dao.impl.ProductDAOImpl;
public class ProductService {
	
	private ProductDAO dao ;
	
	public ProductService()
	{
		dao = new ProductDAOImpl();
	}
	
	public int getTotal(int cid)
	{
		return dao.getTotal(cid);
	}
	public void add(Product bean)
	{
		dao.add(bean);
	}
	public void update(Product bean)
	{
		dao.update(bean);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public Product get(int id)
	{
		return dao.get(id);
	}
	public List<Product> list(int cid)
	{
		return dao.list(cid);
	}
	public List<Product> list(int cid, int start, int count)
	{
		return dao.list(cid, start, count);
	}
	public List<Product> list()
	{
		return dao.list();
	}
	public List<Product> list(int start, int count)
	{
		return dao.list(start, count);
	}
	public void fill(List<Category> cs)
	{
		dao.fill(cs);
	}
	public void fill(Category c)
	{
		dao.fill(c);
	}
	public void fillByRow(List<Category> cs)
	{
		dao.fillByRow(cs);
	}
	public void setFirstProductImage(Product p)
	{
		dao.setFirstProductImage(p);;
	}
	public void setSaleAndReviewNumber(Product p)
	{
		dao.setSaleAndReviewNumber(p);
	}
	public void setSaleAndReviewNumber(List<Product> products)
	{
		dao.setSaleAndReviewNumber(products);
	}
	public List<Product> search(String keyword, int start, int count)
	{
		return dao.search(keyword, start, count);
	}
}
