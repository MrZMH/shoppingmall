package com.shopmall.dao;

import java.util.List;

import com.shopmall.bean.User;

public interface UserDAO {
	 public int getTotal();
	 public void add(User bean);
	 public void update(User bean);
	 public void delete(int id);
	 public User get(int id);
	 public List<User> list();
	 public List<User> list(int start, int count);
	 public boolean isExist(String name);
}
