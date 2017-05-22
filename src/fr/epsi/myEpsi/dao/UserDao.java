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
		
		// Création d'une liste d'utilisateurs
		List<User> users= new ArrayList<>();
		
		// Résultats de la requête SQL
		ResultSet result;

		try {
			
			// Récupération de tous les utilisateurs
			result = connect.sqlRequete("SELECT * FROM users");
			
			while(result.next()){
	            users.add(new User(result.getString(1), result.getString(2), result.getBoolean(3)));
	        }
			// Création d'un utilisateur avec les données suivantes : id, password, administrateur ou non
		} catch (SQLException e) {
			
			logger.error("Aucune liste d'utilisateurs existe.", e);
		}
		return users;
		// Affiche la liste d'utilisateurs
	}

	// Récupération d'un utilisteur
	public User getUserById(String id) {
		
		// Connection JDBC
		JDBC connect = new JDBC();
		
		// Résultats de la requête SQL
		ResultSet result;
		
		// Création d'un nouvel utilisateur 
		User user = new User();
		try {
			// Lancement de la requête SQL permettant de récupérer les utilisateurs à l'id défini
			result = connect.sqlRequete("SELECT * FROM users WHERE id = '" + id +"'");
			
			result.next();
			user = new User(result.getString(1), result.getString(2), result.getBoolean(3));
			// Création d'un utilisateur avec les données suivantes : id, password, administrateur ou non
			
		} catch (SQLException e) {
		
			logger.debug("Aucun utilisateur correspond à cet id.", e);
		}
		return user;
		// Affichage de l'utilisateur
	}

	// Création d'un utilisateur.
	public void addUser(User user) {
		
		// Connexion JDBC
		JDBC connect = new JDBC();

		try {
			
			// Connexion 
			Connection connection = connect.getConnection();
			
			// Création de l'utilisateur 
			PreparedStatement ps = connection.prepareStatement("Utilisateurs : ");
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.getAdministrator());
			
			// Exécution de la requête
			ps.executeUpdate();
			
		} catch (Exception e) {
	
			logger.error("La création n'a pas été effectué", e);
		}

	}

	// Suppression d'un utilisateur 
	public void deleteUser(User user) {
		
		// Connection JDBC
		JDBC connect = new JDBC();

		try {
			
			// Connection SQL
			connect.sqlRequete("DELETE * FROM users WHERE id = "+ user.getId());
			logger.info("L'utilisateur " + user.getId() + " a été supprimé");
			
		}catch (SQLException e) {
			logger.error("L'utilisateur" + user.getId() + " n'a pas pu être supprimé.");
		}
	}
	
	// Mise à jour d'un utilisateur 
	public void updateUser(User user) {
		
		// Connection JDBC
		JDBC connect = new JDBC();
			
		try {
			// Connection
			Connection connection = connect.getConnection();
			
			// Requête
			PreparedStatement ps = connection.prepareStatement("UPDATE users SET password = ?, isadministrator = ? WHERE id = ?");
			ps.setString(1, user.getPassword());
			ps.setBoolean(2, user.getAdministrator());
			ps.setString(3, user.getId());
			
			// Lancement de la requête 
			ps.executeUpdate();
			
			// Fermeture de la connection
			connection.close();
		        
		} catch (Exception e) {
			logger.error("La mise à jour de l'utilisateur " + user.getId() + " n'a pas pu être effectué.");
		}

	}

}
