package com.zjs.cashretracted.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class CashRetracted implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	private Date dateCorrection;
	private String etat;
	@OneToOne
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name="NoCompte")
	private  Compte compte;
	
	@OneToOne
	@JoinColumn(name="transactionCorrection")
	private Transaction transactionCorrection;
	
	public CashRetracted() {
		super();
		this.etat = "en attente";
	}
	public CashRetracted(Date date, Transaction transaction,
			Compte compte) {
		super();
		this.date = date;
		this.etat = "en attente";
		this.transaction = transaction;
		this.compte = compte;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Date getDateCorrection() {
		return dateCorrection;
	}
	public void setDateCorrection(Date dateCorrection) {
		this.dateCorrection = dateCorrection;
	}
	public Transaction getTransactionCorrection() {
		return transactionCorrection;
	}
	public void setTransactionCorrection(Transaction transactionCorrection) {
		this.transactionCorrection = transactionCorrection;
	}
	@Override
	public String toString() {
		return "CashRetracted [id=" + id + ", date=" + date
				+ ", dateCorrection=" + dateCorrection + ", etat=" + etat
				+ ", transaction=" + transaction + ", compte=" + compte
				+ ", transactionCorrection=" + transactionCorrection + "]";
	}
	
}
