package com.zjs.cashretracted.model;



public class Tempo {
	private Integer idCashRetrated;
	private Integer rib;
	private Integer idTransaction;
	private Double montant ;
	private String date;
	public Integer getIdCashRetrated() {
		return idCashRetrated;
	}
	public void setIdCashRetrated(Integer idCashRetrated) {
		this.idCashRetrated = idCashRetrated;
	}
	public Integer getRib() {
		return rib;
	}
	public void setRib(Integer rib) {
		this.rib = rib;
	}
	public Integer getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
