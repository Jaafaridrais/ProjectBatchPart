package com.zjs.cashretracted.service;

import java.util.List;

import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Transaction;
import com.zjs.cashretracted.model.User;

public interface CompteService {
	public void persistCompte(Compte compte);	  
	public  Compte findCompteByRib(Integer id );	 
	public  Compte updateCompte(Compte compte); 
	public  void deleteCompte(Compte compte);
	
	public Compte crediterCompte(Transaction transaction);
	public Compte debiterCompte(Transaction transaction);
	public Compte debiterCompteCorrection(Transaction transaction);
	public List<Compte> getAllComptes();
	public  Compte findCompteByUser(User user); 
	
	
}
