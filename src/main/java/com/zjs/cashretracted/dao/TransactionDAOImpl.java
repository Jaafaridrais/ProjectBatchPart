package com.zjs.cashretracted.dao;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Transaction;

@Repository("transactionDAO")
public class TransactionDAOImpl implements TransactionDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persistTransaction(Transaction transaction) {
		sessionFactory.getCurrentSession().persist(transaction);
		
	}

	public Transaction findTransactionById(Integer id) {
		// TODO Auto-generated method stub
		 return (Transaction) sessionFactory.getCurrentSession().get(Transaction.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> findTransactionsByCompte(Compte compte) {
		Query query = (Query) sessionFactory.getCurrentSession().createQuery("from Transaction  where NoCompte="+compte.getRib());
		
		return query.list();
	}

	public Transaction findTransactionByDate(Date dt) {
		
		Query query = (Query) sessionFactory.getCurrentSession().createQuery("from Transaction  where date='"+dt+"");
		if(query.list().size()==0) return null ;
		return (Transaction) query.list().get(0);
	}

	public Transaction saveTransaction(Transaction transaction) {
		Integer id = (Integer) sessionFactory.getCurrentSession().save(transaction);
		 transaction.setId(id);
		 return transaction ;
	}

}
