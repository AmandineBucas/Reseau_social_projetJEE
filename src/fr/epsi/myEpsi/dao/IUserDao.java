package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.User;

public interface IUserDao {

	// Cr�ation d'une liste d'utilisateurs
	List<User> getListOfUsers();
	
	User getUserById(String id);
	
	// Cr�ation d'un utilisateur
	void addUser(User user);
	
	// Mise � jour d'un utilisateur
	void updateUser(User user);
	
	// Suppression d'un utilisateur 
	void deleteUser(User user);
}
