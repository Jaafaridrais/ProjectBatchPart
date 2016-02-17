package com.zjs.cashretracted.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjs.cashretracted.dao.TransactionDAO;
import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Transaction;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDAO transactionDAO ;
	
	@Transactional
	public void persistTransaction(Transaction transaction) {
		transactionDAO.persistTransaction(transaction);

	}
	@Transactional
	public Transaction findTransactionById(Integer id) {
		
		return transactionDAO.findTransactionById(id);
	}
	@Transactional
	public List<Transaction> findTransactionsByCompte(Compte compte) {
		
		return transactionDAO.findTransactionsByCompte(compte);
	}
	@Transactional
	public Transaction findTransactionByDate(Date dt) {
		
	 return transactionDAO.findTransactionByDate(dt);
	}
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {
		
		return transactionDAO.saveTransaction(transaction);
	}

}
