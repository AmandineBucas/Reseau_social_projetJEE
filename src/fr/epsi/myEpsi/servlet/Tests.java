package fr.epsi.myEpsi.servlet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.MessageDao;
import fr.epsi.myEpsi.dao.UserDao;


public class Tests {
	
	@Test
	public void premierTest() {
		
		MessageDao msgDao = new MessageDao();
		UserDao userDao = new UserDao();
		
		Long id = new Long(100);
		
		// D�claration d'un utilisateur
		User admin = new User("50", "psw", true);
		// Ajout d'un utilisateur admin
		userDao.addUser(admin);
		
		// D�claration d'un message
		Message jeuxTest = new Message(id, "Titre", "Contenu", admin, null, null, 1);
		// Cr�ation d'un message
		msgDao.addMessage(jeuxTest);

		// Comparaison message
		Assert.assertEquals(msgDao.getMessage(id), jeuxTest);
		
		// Suppression du message
		msgDao.deleteMessage(jeuxTest);
		
		// Suppression de l'utilisateur 
		userDao.deleteUser(admin);
	}
	
	@Test
	public void deuxiemeTest() {
		
		MessageDao msgDao = new MessageDao();
		UserDao userDao = new UserDao();
		
		User admin = new User("50", "psw", true);
		userDao.addUser(admin);
		
		// D�claration d'un message
		Message jeuxTest = new Message(new Long(100), "Titre1", "Contenu1", admin, null, null, 1);
		
		// D�claration d'un second message
		Message jeuxTest2 = new Message(new Long(200), "Titre2", "Contenu2", admin, null, null, 1);
		
		// Cr�ation du premier message
		msgDao.addMessage(jeuxTest);
		
		// Cr�ation du second message
		msgDao.addMessage(jeuxTest2);
		
		// Mise � our du premier message
		msgDao.updateMessageStatus(jeuxTest, 3);

		// R�cup�ration de la liste de messages
		List<Message> messages = msgDao.getListOfMessages(admin);
		Assert.assertEquals(3, messages.size());
		
		// Comparaison du status
		Assert.assertEquals(3, messages.get(0).getStatus());
		Assert.assertEquals(jeuxTest2, messages.get(1));
		
		// Suppression du premier message
		msgDao.deleteMessage(jeuxTest);
		
		// Suppression du second message
		msgDao.deleteMessage(jeuxTest2);
		
		// Suppression de l'utilisateur
		userDao.deleteUser(admin);
		
	}
}