package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Product;
import com.shopmall.bean.ProductImage;

public interface ProductImageDAO {
	public int getTotal();
	public void add(ProductImage bean);
	public void update(ProductImage bean);
	public void delete(int id);
	public ProductImage get(int id);
	public List<ProductImage> list(Product p, String type);
	public List<ProductImage> list(Product p, String type, int start, int count);
}
