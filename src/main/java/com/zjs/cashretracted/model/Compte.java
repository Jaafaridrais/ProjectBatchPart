package com.zjs.cashretracted.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Compte implements Serializable {
	

	@Id
	private Integer rib;
	private Double solde;
	private String type;
	private Date dateOuverture;
	@OneToOne
	private User user ;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="compte",targetEntity=Transaction.class)
	private List<Transaction> transactions ;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="compte",targetEntity=CashRetracted.class)
	private List<CashRetracted> cashretrateds ;
	public Integer getRib() {
		return rib;
	}
	public void setRib(Integer rib) {
		this.rib = rib;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public List<CashRetracted> getCashretrateds() {
		return cashretrateds;
	}
	public void setCashretrateds(List<CashRetracted> cashretrateds) {
		this.cashretrateds = cashretrateds;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
