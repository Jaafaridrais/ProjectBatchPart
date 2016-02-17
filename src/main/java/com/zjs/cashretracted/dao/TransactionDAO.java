package com.zjs.cashretracted.dao;

import java.util.Date;
import java.util.List;

import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Transaction;

public interface TransactionDAO {
	
	public void persistTransaction(Transaction transaction);	
	public Transaction saveTransaction(Transaction transaction);
	public  Transaction findTransactionById(Integer id );	 
	public  List<Transaction> findTransactionsByCompte(Compte compte  );
	public Transaction findTransactionByDate(Date dt);
	

}
