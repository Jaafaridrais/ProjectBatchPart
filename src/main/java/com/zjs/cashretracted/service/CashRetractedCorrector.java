package com.zjs.cashretracted.service;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zjs.cashretracted.model.CashRetracted;

@Service("cashRetractedCorrector")
public class CashRetractedCorrector implements ItemWriter<CashRetracted> {

	@Autowired
	CashRetractedService cashRetractedService;

	public void write(List<? extends CashRetracted> cashRetractedList)
			throws Exception {
		for (CashRetracted crd : cashRetractedList) {
			
			if(crd!=null){
				cashRetractedService.corrigerCashRetracted(crd);
				System.out.println("CashRetracted Corrigé :---------------------------");
				System.out.println("id  : " + crd.getId());
				System.out.println(" date  : "+ crd.getDate());
				System.out.println("Montant : "+ crd.getTransaction().getMontant());
				System.out.println("------------------------------------------------");
			}
			
		}

	}

}
