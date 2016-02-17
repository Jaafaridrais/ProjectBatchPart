package com.zjs.cashretracted.service;

import java.util.List;

import com.zjs.cashretracted.model.CashRetracted;
import com.zjs.cashretracted.model.Compte;

public interface CashRetractedService {
	
	public void persistCashRetracted(CashRetracted cashRetracted);	  
	public  CashRetracted findCashRetractedbyId(Integer id);	 
	public  CashRetracted updateCashRetracted(CashRetracted cashRetracted); 
	public  List<CashRetracted> findCashRetractedbyCompte(Compte compte);	
	public void corrigerCashRetracted(CashRetracted cashRetracted);
	public Boolean verifierCorrectionCashRetracted(Integer id);
	public void detacherCashRetracted(CashRetracted cashRetracted);

}
