package com.zjs.cashretracted.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zjs.cashretracted.model.CashRetracted;
import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Tempo;
import com.zjs.cashretracted.model.Transaction;



@Service("cashRetractedProcess")
public class CashRetractedProcess implements
		ItemProcessor<Tempo, CashRetracted> {

	@Autowired
	CompteService compteService;
	@Autowired
	TransactionService transactionService;
	@Autowired
	CashRetractedService cashRetractedService;

	public CashRetracted process(Tempo tempo) throws Exception {
		CashRetracted cashRetracted =null ;
		if(cashRetractedService.verifierCorrectionCashRetracted(tempo.getIdCashRetrated())){	
			
			cashRetracted =  new CashRetracted();
			Compte compte = compteService.findCompteByRib(tempo.getRib());
			Transaction transaction = transactionService.findTransactionById(tempo.getIdTransaction());

			Date dt = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss").parse(tempo.getDate());
			
			cashRetracted.setId(tempo.getIdCashRetrated());
			cashRetracted.setCompte(compte);
			cashRetracted.setTransaction(transaction);
			cashRetracted.setDate(dt);
			cashRetracted.setEtat("corrige");

				
		}
		else System.out.println("desolé ce cas est déja corrigé \n id = "+tempo.getIdCashRetrated());
		return cashRetracted ;
	}

}
