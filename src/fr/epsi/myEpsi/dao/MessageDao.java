package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public class MessageDao implements IMessageDao{
	
	// Obtention d'une instance du logger à utiliser 
	private static Logger logger = LogManager.getLogger(UserDao.class);

	// Récupération d'une liste de messages
	public List<Message> getListOfMessages(User user) {
		
		// Connexion JDBC
		JDBC connect = new JDBC();
		
		// Création d'une liste de messages
		List<Message> messages= new ArrayList<>();
		
		// Résultats de la requête SQL
		ResultSet result;
		try {
			
			// Récupération des valeurs de la requêtes sql
			result = connect.sqlRequete("SELECT * FROM message WHERE user_id = '" + user.getId() +"' ");
			while(result.next()){
	            messages.add(new Message(result.getLong(1), result.getString(2)
	            		, result.getString(3), user, (Timestamp) result.getObject(5), (Timestamp) result.getObject(6), result.getInt(7)));
	        }
			// Création du message avec les données suivantes : id, title, content, author, creationDate, updateDate, status
			
		} catch (SQLException e) {
			
			logger.error("Aucune liste de messages correspond.", e);
		}
		return messages;
		// Affiche la liste de messages
	}

	// Récupération d'un message
	public Message getMessage(Long id) {
	
		// Connexion JDBC
		JDBC connect = new JDBC();
		
		// Résultats de la requête SQL
		ResultSet result;
		
		// Déclaration de message à NULL
		Message message = null;
		
		// Création d'un nouvel User
		User user = new User();
		try {
			
			// Connexion 
			Connection connection = connect.getConnection();
			
			// Lancement de la requête SQL
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM messages WHERE id = ?");
			
			// Exécution de la requête
			result = stmt.executeQuery();
			result.next();
			
			// Récupération de la valeur de l'id_user
			String id_user = result.getString(4);
			
			// Création d'un nouvel UserDAO
			IUserDao userDao = new UserDao();
			
			// Récupère l'user avec son id
			user = userDao.getUserById(id_user);
			message = new Message(result.getLong(1), result.getString(2)
	        		, result.getString(3), user ,(Timestamp) result.getObject(5),(Timestamp) result.getObject(6), result.getInt(7));
			// Création du message avec les données suivantes : id, title, content, author, creationDate, updateDate, status
	        
		} catch (Exception e) {
		
			logger.error("Aucun message existant correspond à cet ID.", e);
		}
		// Affiche le message
		return message;
	}

	// Création d'un nouveau message
	public void addMessage(Message message) {
		
		// Connexion JDBC
		JDBC connect = new JDBC();

		try {
			
			// Connexion
			Connection connection = connect.getConnection();
			PreparedStatement ps = connection.prepareStatement("Message :");
			ps.setLong(1, message.getId());
			ps.setString(2, message.getTitle());
			ps.setString(3, message.getContent());
			ps.setObject(4, message.getAuthor().getId());
			ps.setObject(5, message.getCreationDate());
			ps.setObject(6, message.getUpdateDate());
			ps.setObject(7, message.getStatus());
			
			// Mise à jour
			ps.executeUpdate();
			
			// Fin de la connecxion
			connection.close();
			
		} catch (Exception e) {
			logger.error("La création n'a pas été effectué", e);
		}
		
	}

	// Suppression du message
	public void deleteMessage(Message message) {
		
		// Connection JDBC
		JDBC connect = new JDBC();
		
		try {
			// Connection SQL
			connect.sqlRequete("DELETE * FROM messages WHERE id = '"+message.getId()+"'");
			logger.debug("La suppression du message " + message.getId() + " a été effectué.");
			
		}catch (SQLException e) {
			logger.error("La suppression du message " + message.getId() + " n'a pas pu être effectué.");
		}
	}
	
	// Mise à jour du statut du message
	public void updateMessageStatus(Message message, int status) {
			
		// Connexion JDBC
		JDBC connect = new JDBC();
			
		try {
				
			// Connexion
			Connection connexion = connect.getConnection();
				
			// Lancement de la requête de mise à jour du status
			PreparedStatement ps = connexion.prepareStatement("UPDATE messages SET STATUS = ? WHERE id = ?");
			ps.setInt(1, status);
			ps.setLong(2, message.getId());
				
			logger.debug("La mise à jour du message " + message.getId() + " a été effectué.");
				
			// Exécution de la requête
			ps.executeUpdate();		
			
			// Fin de la connection
			connexion.close();
		       
		} catch (Exception e) {
			logger.error("La mise à jour du message " + message.getId() + " n'a pas pu être effectué.");
		}
	}
}