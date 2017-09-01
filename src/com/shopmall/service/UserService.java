package com.shopmall.service;

import java.util.List;

import com.shopmall.bean.User;
import com.shopmall.dao.UserDAO;
import com.shopmall.dao.impl.UserDAOImpl;

public class UserService {

	private UserDAO dao;
	
	 public int getTotal()
	 {
		 return dao.getTotal();
	 }
	 
	 public void add(User bean)
	 {
		 dao.add(bean);
	 }
	 
	 public void update(User bean)
	 {
		 dao.update(bean);
	 }
	 
	 public void delete(int id)
	 {
		 dao.delete(id);
	 }
	 
	 public User get(int id)
	 {
		 return dao.get(id);
	 }
	 
	 public List<User> list()
	 {
		 return dao.list();
	 }
	 
	 public List<User> list(int start, int count)
	 {
		 return dao.list(start, count);
	 }
	 
	 public boolean isExist(String name)
	 {
		 return dao.isExist(name);
	 }

	public UserService() {
		this.dao = new UserDAOImpl();
	}
	 
	 
}
