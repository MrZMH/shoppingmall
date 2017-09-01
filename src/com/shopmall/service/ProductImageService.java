package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Product;
import com.shopmall.bean.ProductImage;
import com.shopmall.dao.ProductImageDAO;
import com.shopmall.dao.impl.ProductImageDAOImpl;

public class ProductImageService {
	
	private ProductImageDAO dao;
	
	public ProductImageService()
	{
		dao = new ProductImageDAOImpl();
	}
	
	public int getTotal()
	{
		return dao.getTotal();
	}
	public void add(ProductImage bean)
	{
		dao.add(bean);
	}
	public void update(ProductImage bean)
	{
		dao.update(bean);
	}
	public void delete(int id)
	{
		dao.delete(id);
	}
	public ProductImage get(int id)
	{
		return dao.get(id);
	}
	public List<ProductImage> list(Product p, String type)
	{
		return dao.list(p, type);
	}
	public List<ProductImage> list(Product p, String type, int start, int count)
	{
		return dao.list(p, type, start, count);
	}
	
}
