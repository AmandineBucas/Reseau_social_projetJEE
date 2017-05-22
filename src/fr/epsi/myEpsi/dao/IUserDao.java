package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.User;

public interface IUserDao {

	// Création d'une liste d'utilisateurs
	List<User> getListOfUsers();
	
	User getUserById(String id);
	
	// Création d'un utilisateur
	void addUser(User user);
	
	// Mise à jour d'un utilisateur
	void updateUser(User user);
	
	// Suppression d'un utilisateur 
	void deleteUser(User user);
}
