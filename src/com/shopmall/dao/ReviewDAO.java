package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.Review;

public interface ReviewDAO {
	 public int getTotal();
	 public int getTotal(int pid);
	 public void add(Review bean);
	 public void update(Review bean);
	 public void delete(int id);
	 public Review get(int id);
	 public List<Review> list(int pid);
	 public int getCount(int pid);
	 public List<Review> list(int pid, int start, int count);
	 public boolean isExist(String content, int pid);
}
