package fr.epsi.myEpsi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.service.MessageService;

/**
 * Servlet implementation class supprimerMessage
 */
@WebServlet("/DeleteMessages")
public class DeleteMessages extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MessageService messageService = new MessageService();
	
	private static Logger logger = LogManager.getLogger(DeleteMessages.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Constructeur
    public DeleteMessages() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Demande de ressources
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Déclaration des variables
		String id = (String) request.getParameter("id");
		Message mes = messageService.getMessage(Long.valueOf(id));
		
		logger.info(mes);
		messageService.deleteMessage(mes);
		
		request.getRequestDispatcher("/Messages").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// Permet d'envoyer des informations
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

