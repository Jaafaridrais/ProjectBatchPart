package com.zjs.cashretracted.service;

import java.util.List;

import com.zjs.cashretracted.model.User;


public interface UserService {
	 
	public void persistUser(User user);	  
	public  User findUserById(Integer id);	 
	public  User findUserByName(String nom);	
	public  User updateUser(User user); 
	public  void deleteUser(User user);
	public List<User> getAllUsers();

}
