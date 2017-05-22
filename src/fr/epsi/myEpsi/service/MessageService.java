package fr.epsi.myEpsi.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.JDBC;
import fr.epsi.myEpsi.dao.MessageDao;

public class MessageService implements IMessageService {
	
	private static Logger logger = LogManager.getLogger(MessageService.class);
	
	// Initialisation messageDao
	MessageDao messageDao = new MessageDao();

	// Initialisation de la liste des messages
	public List<Message> getListOfMessages(User user) {
		return messageDao.getListOfMessages(user);
	}

	// R�cup�ration des messages
	public Message getMessage(Long id) {
		return messageDao.getMessage(id);
	}

	// Cr�ation d'un message
	public void addMessage(Message message) {
		JDBC jdbc = new JDBC();
		String id = "test@test.test";
		
		try{
			ResultSet result = jdbc.sqlRequete("SELECT id FROM messages WHERE id = (SELECT max(id) FROM messages");
			result.next();
			id = result.getString(1);
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
		// Cr�ation d'un message 
		messageDao.addMessage(message);
	}

	// Suppression d'un message
	public void deleteMessage(Message message) {
		messageDao.deleteMessage(message);
	}

	// Mise � jour du statut d'un message
	public void updateMessageStatus(Message message, int status) {
		messageDao.updateMessageStatus(message, status);
	}



}