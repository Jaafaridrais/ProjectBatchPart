package com.zjs.cashretracted.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjs.cashretracted.model.CashRetracted;
import com.zjs.cashretracted.model.Compte;


@Repository("cashRetractedDAO")
public class CashRetractedDAOImpl implements CashRetractedDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void persistCashRetracted(CashRetracted cashRetracted) {
		sessionFactory.getCurrentSession().persist(cashRetracted);

	}

	public CashRetracted findCashRetractedbyId(Integer id) {
		 return (CashRetracted) sessionFactory.getCurrentSession().get(CashRetracted.class, id);
	}

	public CashRetracted updateCashRetracted(CashRetracted cashRetracted) {
		  sessionFactory.getCurrentSession().update(cashRetracted);
		  
		  return cashRetracted;
	}

	
	@SuppressWarnings("unchecked")
	public List<CashRetracted> findCashRetractedbyCompte(Compte compte) {
		
		Query query = (Query) sessionFactory.getCurrentSession().createQuery("from CashRetracted  where NoCompte ="+compte.getRib());
		
		return query.list();
	}

	public void detacherCashRetracted(CashRetracted cashRetracted) {
		sessionFactory.getCurrentSession().evict(cashRetracted);
		
	}

}
