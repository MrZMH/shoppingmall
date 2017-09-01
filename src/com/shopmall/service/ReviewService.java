package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.Review;
import com.shopmall.dao.ReviewDAO;
import com.shopmall.dao.impl.ReviewDAOImpl;

public class ReviewService {
	
	private ReviewDAO dao;
	
	public ReviewService()
	{
		dao = new ReviewDAOImpl();
	}
	
	 public int getTotal()
	 {
		 return dao.getTotal();
	 }
	 public int getTotal(int pid)
	 {
		 return dao.getTotal(pid);
	 }
	 public void add(Review bean)
	 {
		 dao.add(bean);
	 }
	 public void update(Review bean)
	 {
		 dao.update(bean);
	 }
	 public void delete(int id)
	 {
		 dao.delete(id);
	 }
	 public Review get(int id)
	 {
		 return dao.get(id);
	 }
	 public List<Review> list(int pid)
	 {
		 return dao.list(pid);
	 }
	 public int getCount(int pid)
	 {
		 return dao.getCount(pid);
	 }
	 public List<Review> list(int pid, int start, int count)
	 {
		 return dao.list(pid, start, count);
	 }
	 public boolean isExist(String content, int pid)
	 {
		 return dao.isExist(content, pid);
	 }
}
