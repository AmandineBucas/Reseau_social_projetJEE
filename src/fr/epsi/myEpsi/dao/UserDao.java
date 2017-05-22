package fr.epsi.myEpsi.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.User;

public class UserDao implements IUserDao {
	
	private static Logger logger = LogManager.getLogger(UserDao.class);
	
	// Constructeur 
	public UserDao() {
		super();
	}

	// Liste des utilisateuurs
	public List<User> getListOfUsers() {
		
		// Connection JDBC
		JDBC connect = new JDBC();
		
		// Cr�ation d'une liste d'utilisateurs
		List<User> users= new ArrayList<>();
		
		// R�sultats de la requ�te SQL
		ResultSet result;

		try {
			
			// R�cup�ration de tous les utilisateurs
			result = connect.sqlRequete("SELECT * FROM users");
			
			while(result.next()){
	            users.add(new User(result.getString(1), result.getString(2), result.getBoolean(3)));
	        }
			// Cr�ation d'un utilisateur avec les donn�es suivantes : id, password, administrateur ou non
		} catch (SQLException e) {
			
			logger.error("Aucune liste d'utilisateurs existe.", e);
		}
		return users;
		// Affiche la liste d'utilisateurs
	}

	// R�cup�ration d'un utilisteur
	public User getUserById(String id) {
		
		// Connection JDBC
		JDBC connect = new JDBC();
		
		// R�sultats de la requ�te SQL
		ResultSet result;
		
		// Cr�ation d'un nouvel utilisateur 
		User user = new User();
		try {
			// Lancement de la requ�te SQL permettant de r�cup�rer les utilisateurs � l'id d�fini
			result = connect.sqlRequete("SELECT * FROM users WHERE id = '" + id +"'");
			
			result.next();
			user = new User(result.getString(1), result.getString(2), result.getBoolean(3));
			// Cr�ation d'un utilisateur avec les donn�es suivantes : id, password, administrateur ou non
			
		} catch (SQLException e) {
		
			logger.debug("Aucun utilisateur correspond � cet id.", e);
		}
		return user;
		// Affichage de l'utilisateur
	}

	// Cr�ation d'un utilisateur.
	public void addUser(User user) {
		
		// Connexion JDBC
		JDBC connect = new JDBC();

		try {
			
			// Connexion 
			Connection connection = connect.getConnection();
			
			// Cr�ation de l'utilisateur 
			PreparedStatement ps = connection.prepareStatement("Utilisateurs : ");
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.getAdministrator());
			
			// Ex�cution de la requ�te
			ps.executeUpdate();
			
		} catch (Exception e) {
	
			logger.error("La cr�ation n'a pas �t� effectu�", e);
		}

	}

	// Suppression d'un utilisateur 
	public void deleteUser(User user) {
		
		// Connection JDBC
		JDBC connect = new JDBC();

		try {
			
			// Connection SQL
			connect.sqlRequete("DELETE * FROM users WHERE id = "+ user.getId());
			logger.info("L'utilisateur " + user.getId() + " a �t� supprim�");
			
		}catch (SQLException e) {
			logger.error("L'utilisateur" + user.getId() + " n'a pas pu �tre supprim�.");
		}
	}
	
	// Mise � jour d'un utilisateur 
	public void updateUser(User user) {
		
		// Connection JDBC
		JDBC connect = new JDBC();
			
		try {
			// Connection
			Connection connection = connect.getConnection();
			
			// Requ�te
			PreparedStatement ps = connection.prepareStatement("UPDATE users SET password = ?, isadministrator = ? WHERE id = ?");
			ps.setString(1, user.getPassword());
			ps.setBoolean(2, user.getAdministrator());
			ps.setString(3, user.getId());
			
			// Lancement de la requ�te 
			ps.executeUpdate();
			
			// Fermeture de la connection
			connection.close();
		        
		} catch (Exception e) {
			logger.error("La mise � jour de l'utilisateur " + user.getId() + " n'a pas pu �tre effectu�.");
		}

	}

}
