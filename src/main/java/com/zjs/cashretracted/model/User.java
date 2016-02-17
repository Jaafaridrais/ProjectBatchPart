package com.zjs.cashretracted.model;

import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String motDePass;
	private String nom ;
	private String prenom;
	private Boolean active ;
	@OneToOne
    @JoinTable(name="user_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
	private Role role ;
		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePass() {
		return motDePass;
	}
	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
