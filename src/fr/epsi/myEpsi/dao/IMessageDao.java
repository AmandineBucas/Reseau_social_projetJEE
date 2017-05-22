package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public interface IMessageDao {

	// Cr�ation d'une liste de messages
	List<Message> getListOfMessages(User user);
	
	Message getMessage(Long id);
	
	// Fonction pour cr�er un message
	void addMessage(Message message);
	
	// Fonction pour changer le statut d'un message (ex : archiv�)
	void updateMessageStatus(Message message, int status);
	
	// Fonction pour effacer un message
	void deleteMessage(Message message);
	
	// Liste de tous les messages
	List<Message> getAllMessages(User user);

}
