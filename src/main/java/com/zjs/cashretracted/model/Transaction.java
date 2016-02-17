package com.zjs.cashretracted.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Transaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private Double montant ;
	private Date date;
	@ManyToOne
	@JoinColumn(name="NoCompte")
	private  Compte compte;
	
	
	
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(Double montant, Compte compte) {
		super();
		
		this.montant = montant;
		this.compte = compte;
	}
	
	public Transaction(String type, Double montant, Date date, Compte compte) {
		super();
		this.type = type;
		this.montant = montant;
		this.date = date;
		this.compte = compte;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}
