package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Category;
import com.shopmall.bean.Product;

public interface ProductDAO {
	public int getTotal(int cid);
	public void add(Product bean);
	public void update(Product bean);
	public void delete(int id);
	public Product get(int id);
	public List<Product> list(int cid);
	public List<Product> list(int cid, int start, int count);
	public List<Product> list();
	public List<Product> list(int start, int count);
	public void fill(List<Category> cs);
	public void fill(Category c);
	public void fillByRow(List<Category> cs);
	public void setFirstProductImage(Product p);
	public void setSaleAndReviewNumber(Product p);
	public void setSaleAndReviewNumber(List<Product> products);
	public List<Product> search(String keyword, int start, int count);
}
