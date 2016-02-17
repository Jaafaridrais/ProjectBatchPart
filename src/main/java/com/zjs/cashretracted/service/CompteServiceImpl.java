package com.zjs.cashretracted.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjs.cashretracted.dao.CompteDAO;
import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Transaction;
import com.zjs.cashretracted.model.User;

@Service("compteService")
public class CompteServiceImpl implements CompteService {

	@Autowired
	CompteDAO compteDAO;

	@Autowired
	TransactionService transactionService;

	@Transactional
	public void persistCompte(Compte compte) {
		compteDAO.persistCompte(compte);

	}

	@Transactional
	public Compte findCompteByRib(Integer id) {

		return compteDAO.findCompteById(id);
	}

	@Transactional
	public Compte updateCompte(Compte compte) {
		return compteDAO.updateCompte(compte);

	}

	@Transactional
	public void deleteCompte(Compte compte) {
		compteDAO.deleteCompte(compte);

	}

	@Transactional
	public Compte crediterCompte(Transaction transaction) {
		transaction.setType("credit");
		Compte compte = findCompteByRib(transaction.getCompte().getRib());
		compte.setSolde(compte.getSolde() + transaction.getMontant());
		transaction.setDate(new Date());
		transactionService.persistTransaction(transaction);
		return updateCompte(compte);
	}

	@Transactional
	public Compte debiterCompte(Transaction transaction) {
		transaction.setType("debit");
		Compte compte = findCompteByRib(transaction.getCompte().getRib());
		compte.setSolde(compte.getSolde() - transaction.getMontant());
		transaction.setDate(new Date());
		transactionService.persistTransaction(transaction);
		return updateCompte(compte);
	}

	@Transactional
	public Compte debiterCompteCorrection(Transaction transaction) {

		Compte compte = findCompteByRib(transaction.getCompte().getRib());
		compte.setSolde(compte.getSolde() - transaction.getMontant());
		return updateCompte(compte);
	}

	@Transactional
	public List<Compte> getAllComptes() {
		return compteDAO.getAllComptes();
	}

	@Transactional
	public Compte findCompteByUser(User user) {
		return compteDAO.findCompteByUser(user);
	}

}
