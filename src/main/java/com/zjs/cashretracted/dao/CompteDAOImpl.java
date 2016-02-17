package com.zjs.cashretracted.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.User;



@Repository("compteDAO")
public class CompteDAOImpl implements CompteDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void persistCompte(Compte compte) {
		sessionFactory.getCurrentSession().persist(compte);

	}

	public Compte findCompteById(Integer id) {
	
		 return (Compte) sessionFactory.getCurrentSession().get(Compte.class, id);
	}

	public Compte updateCompte(Compte compte) {
		sessionFactory.getCurrentSession().update(compte);
		return compte;
	}

	public void deleteCompte(Compte compte) {
		sessionFactory.getCurrentSession().delete(compte);

	}

	@SuppressWarnings("unchecked")
	public List<Compte> getAllComptes() {
Query query = (Query) sessionFactory.getCurrentSession().createQuery("from Compte where 1=1");
		
		return query.list();	
	}

	public Compte findCompteByUser(User user) {
//Query query = (Query) sessionFactory.getCurrentSession().createQuery("from Compte where user");
//		
//		return query.list();
		return null ;
	}

	

	

	

}
