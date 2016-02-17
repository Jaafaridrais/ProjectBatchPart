package com.zjs.cashretracted;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjs.cashretracted.model.CashRetracted;
import com.zjs.cashretracted.model.Compte;
import com.zjs.cashretracted.model.Role;
import com.zjs.cashretracted.model.Transaction;
import com.zjs.cashretracted.model.User;
import com.zjs.cashretracted.service.CashRetractedService;
import com.zjs.cashretracted.service.CompteService;
import com.zjs.cashretracted.service.RoleService;
import com.zjs.cashretracted.service.TransactionService;
import com.zjs.cashretracted.service.UserService;

public class AppCompte {

	public static void main(String[] args) {
		System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
// 		----------- 	CREATION DES ROLES  -------------------------------
		String[] roles = new String[3] ;
		roles[0]="ROLE_ADMIN_SYSTEM";
		roles[1]="ROLE_AGENT";
		roles[2]="ROLE_CLIENT";
		RoleService roleService = (RoleService) context.getBean("roleService");
		
		for (int i = 1; i < 4; i++) {
			Role role =  new Role();
			role.setLibelle(roles[i-1]);
			roleService.persistRole(role);
		}
		// 		----------- 	CREATION DES utilisateurs  -------------------------------
		
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		
		for (int i = 0; i <5; i++) {
			User use = new User();
			if(i%2==0) use.setActive(true);
			else use.setActive(false);
			use.setLogin("user"+i);
			use.setMotDePass(""+i);
			use.setNom("nom "+i);
			use.setPrenom("prenom "+i);
			Role  role = new Role();
			if(i>0 && i<4){
					role = roleService.findRoleById(i);
					use.setRole(role);
				}
			userService.persistUser(use);
		}

// 		----------- 	CREATION DES COMPTES  -------------------------------
		CompteService cpteService = (CompteService) context.getBean("compteService");
		Compte cpte=new Compte();
		
		
// 		----------- 	CREATION DES TransactionS & CashRetractedS -------------------------------
		
		TransactionService transactionService =(TransactionService) context.getBean("transactionService");
		CashRetractedService cashRetractedService = (CashRetractedService) context.getBean("cashRetractedService");
		
		String[] stats = new String[2] ;
		stats[0]="debit";
		stats[1]="credit";
		
		for (int i = 1; i < 19 ; i++) {
			
			// 	CREATION DES COMPTES 
			
			cpte.setRib(4353435+(i*10000000));
			cpte.setSolde(new Double(34232*i));
			cpte.setDateOuverture(new Date());
			int k = Math.round(i/5);
			User us= userService.findUserById(k);
			cpte.setUser(us);
			cpte.setType("epragne");
			if(i%3==0) user.setId(1);
			else user.setId(3);
			cpte.setUser(user);
			cpteService.persistCompte(cpte);
			
			for (String str : stats) {
				Transaction trans =new Transaction(new Double(20202),cpte);
				trans.setDate(new Date());
				trans.setType(str);
				
				if(str.equals(stats[0])) 
					{
					cpteService.debiterCompte(trans);
					CashRetracted retracted = new CashRetracted(new Date(), trans, cpte);
					cashRetractedService.persistCashRetracted(retracted);
					}
				else if(str.equals(stats[1])) cpteService.crediterCompte(trans);
				else transactionService.persistTransaction(trans);
				}
			
			
			}
		
		/*			
		 *  Affichage 
		 * */
		for(Compte cpt : cpteService.getAllComptes())
		{
			System.out.println("--------------------------- : "+cpt.getRib()+" : ------------------------------");
		for (Transaction tr : transactionService.findTransactionsByCompte(cpt)) {
			System.out.println("id : "+tr.getId() );
			System.out.println("Type : "+tr.getType());
			System.out.println("date : "+tr.getDate() );
			System.out.println("Montant : "+tr.getMontant() );
			System.out.println("********************************************************");
		}
		}
		context.close();
	}

}
