package com.zjs.cashretracted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjs.cashretracted.dao.UserDAO;
import com.zjs.cashretracted.model.User;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO ;
	@Transactional
	public void persistUser(User user) {
	userDAO.persistUser(user);

	}

	
	@Transactional
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}
	@Transactional
	public void deleteUser(User user) {
		userDAO.deleteUser(user);

	}
	@Transactional
	public List<User> getAllUsers() {
		
		return userDAO.getAllUsers();
	}


	@Transactional
	public User findUserById(Integer id) {
		
		 return userDAO.findUserById(id);
	}


	@Transactional
	public User findUserByName(String nom) {
		return userDAO.findUserByName(nom);
	}

}
