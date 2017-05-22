package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public interface IMessageService {

	// Liste des messages
	List<Message> getListOfMessages(User user);
	
	Message getMessage(Long id);
	
	// Création d'un message
	void addMessage(Message message);
	
	// Suppression d'un message
	void deleteMessage(Message message);	
	
	// Mise à jour d'un message
	void updateMessageStatus(Message message, int status);
}

