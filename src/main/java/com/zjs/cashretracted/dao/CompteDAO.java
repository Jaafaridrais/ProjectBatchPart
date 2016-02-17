package com.zjs.cashretracted.dao;

import java.util.List;

import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.User;




public interface CompteDAO {
	 
	public void persistCompte(Compte compte);	  
	public  Compte findCompteById(Integer id );	 
	public  Compte updateCompte(Compte compte); 
	public  void deleteCompte(Compte compte);
	public List<Compte> getAllComptes();
	public Compte findCompteByUser(User user);
	
	
}
