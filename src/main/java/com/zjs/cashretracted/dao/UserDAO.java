package com.zjs.cashretracted.dao;

import java.util.List;

import com.zjs.cashretracted.model.User;


public interface UserDAO {
	 
		public void persistUser(User user);	  
		public  User findUserById(Integer id);	 
		public  User findUserByName(String nom);	
		public  User updateUser(User user); 
		public  void deleteUser(User user);
		public List<User> getAllUsers();
		

}
