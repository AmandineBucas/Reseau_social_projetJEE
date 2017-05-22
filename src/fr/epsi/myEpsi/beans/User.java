package fr.epsi.myEpsi.beans;

import java.sql.Timestamp;

public class User {

	// Initialisation des variables
	private String id;
	private String password;
	private Boolean administrator;
	
	// Constructeur
	public User(){
		super();
	}
	
	public User(String id, String password, Boolean administrator) {
		super();
		
		// Déclaration des variables 
		this.id = id;
		this.password = password;
		this.administrator = administrator;
	}
	
	/*** Initialisation des getters et des setters ***/
	
	// ID
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// PASSWORD
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// ADMINISTRATOR
	public Boolean getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	public String toString() {
		// Affiche User : id, password, administrator 
		return "User : [id=" + id + ", password=" + password + ", administrator=" + administrator + "]";
	}

	// Prend les données  stockées et les mets dans une valeur de hachage
	public int hashCode() {
		final int hash = 31;
		int result = 1;
		
		result = hash * result + ((id == null) ? 0 : id.hashCode());
		result = hash * result + ((password == null) ? 0 : password.hashCode());
		result = hash * result + ((administrator == null) ? 0 : administrator.hashCode());
		
		return result;
	}
	
}
