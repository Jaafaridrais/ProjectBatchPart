package com.zjs.cashretracted.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjs.cashretracted.model.User;



@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persistUser(User user) {
		sessionFactory.getCurrentSession().persist(user);

	}

	public User findUserById(Integer id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Query qr = sessionFactory.getCurrentSession().createQuery("from User where 1=1");
		return qr.list();
	}

	public User findUserByName(String nom) {
		Query qr = sessionFactory.getCurrentSession().createQuery("from User where nom Like '"+nom+"' OR prenom LIKE '"+nom+"'");
		if(qr.list().size()==0) return null;
		return (User) qr.list().get(0);
	}

}
