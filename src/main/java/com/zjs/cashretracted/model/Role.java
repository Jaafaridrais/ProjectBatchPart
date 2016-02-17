package com.zjs.cashretracted.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	@OneToMany
    @JoinTable(name="user_roles", 
        joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
    )
    private List<User> users;
	
	
		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	

	
}
