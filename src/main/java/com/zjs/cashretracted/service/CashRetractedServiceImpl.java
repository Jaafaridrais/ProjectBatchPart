package com.zjs.cashretracted.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjs.cashretracted.dao.CashRetractedDAO;
import com.zjs.cashretracted.model.CashRetracted;
import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Transaction;
@Service("cashRetractedService")
public class CashRetractedServiceImpl implements CashRetractedService {

	@Autowired
	CashRetractedDAO cashRetractedDAO ;
	
	@Autowired
	CompteService compteService;
	
	@Autowired 
	TransactionService transactionService;
	
	
	@Transactional
	public void persistCashRetracted(CashRetracted cashRetracted) {
		cashRetractedDAO.persistCashRetracted(cashRetracted);

	}
	@Transactional
	public CashRetracted findCashRetractedbyId(Integer id) {
		
		return cashRetractedDAO.findCashRetractedbyId(id);
	}
	@Transactional
	public CashRetracted updateCashRetracted(CashRetracted cashRetracted) {
		cashRetractedDAO.updateCashRetracted(cashRetracted);
		return cashRetracted;
	}
	@Transactional
	public List<CashRetracted> findCashRetractedbyCompte(Compte compte) {
		
		return cashRetractedDAO.findCashRetractedbyCompte(compte);
	}
	@Transactional
	public void corrigerCashRetracted(CashRetracted cashRetracted) {
		if(verifierCorrectionCashRetracted(cashRetracted.getId())){
		
		Date dt= new Date();
		Transaction correction = new Transaction("correction",cashRetracted.getTransaction().getMontant(),dt,cashRetracted.getCompte());
		
		cashRetracted.setTransactionCorrection(transactionService.saveTransaction(correction));
		
		compteService.debiterCompteCorrection(cashRetracted.getTransaction());
		cashRetracted.setDateCorrection(new Date());
		updateCashRetracted(cashRetracted);
		}
		
	}
	@Transactional
	public Boolean verifierCorrectionCashRetracted(Integer id) {
	String finded= cashRetractedDAO.findCashRetractedbyId(id).getEtat();
	detacherCashRetracted(cashRetractedDAO.findCashRetractedbyId(id));
	
	if(finded.equals("corrige")) return false ;
		
		return true;
	}
	@Transactional
	public void detacherCashRetracted(CashRetracted cashRetracted) {
		cashRetractedDAO.detacherCashRetracted(cashRetracted);
		
	}

}
