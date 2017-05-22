package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;

import java.util.List;

public interface IUserService {

	// Liste des utilisateurs
	List<User> getListOfUsers();
	
	User getUserById(String id);
	
	// Création d'un utilisateur
	void addUser(User user) throws Exception;
	
	// Mise à jour d'un utilisateur
	void updateUser(User user);
	
	// Suppression d'un utilisateur
	void deleteUser(User user);
}

