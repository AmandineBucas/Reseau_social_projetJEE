package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.MessageDao;

public class MessageService implements IMessageService {
	
	// Initialisation messageDao
	MessageDao messageDao;

	// Initialisation de la liste des messages
	public List<Message> getListOfMessages(User user) {
		return messageDao.getListOfMessages(user);
	}

	// Récupération des messages
	public Message getMessage(Long id) {
		return messageDao.getMessage(id);
	}

	// Création d'un message
	public void addMessage(Message message) {
		messageDao.addMessage(message);
	}

	// Suppression d'un message
	public void deleteMessage(Message message) {
		messageDao.deleteMessage(message);
	}

	// Mise à jour du statut d'un message
	public void updateMessageStatus(Message message, int status) {
		messageDao.updateMessageStatus(message, status);
	}



}