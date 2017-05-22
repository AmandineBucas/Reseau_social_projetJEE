package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.UserDao;

public class UserService implements IUserService {
	UserDao userDao = new UserDao();
	
	// Constructeur 
	public UserService() {
		super();
	}

	// Liste des utilisateurs
	public List<User> getListOfUsers() {
		return userDao.getListOfUsers();
	}

	// R�cup�ration d'un utilisateur
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	// Cr�ation d'un utilisateur
	public void addUser(User user) throws Exception {
		User getUser = userDao.getUserById(user.getId());
		if(getUser.getId() == null){
			userDao.addUser(user);
			// Si l'utilisateur n'existe pas, cr�ation de l'utilisateur
		}else{
			throw new Exception("L'utilisateur existe d�j�.");
			// Sinon, message d'erreur
		}
	}
	
	// Suppression d'un utilisateur
	public void deleteUser(User user) {
		userDao.deleteUser(user);
		
	}

	// Mise � jour d'un utilisateur
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}
}