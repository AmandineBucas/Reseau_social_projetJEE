package fr.epsi.myEpsi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.MessageService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class AddMesagge
 */
@WebServlet("/pages/addMessage")
public class AddMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MessageService messageService = new MessageService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Constructeur
    public AddMessages() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Demande de ressources
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Déclaration des variables
		String title = request.getParameter("Title");
		String content = request.getParameter("Content");
		int status = Integer.parseInt(request.getParameter("Status"));
		User user = (User) request.getSession().getAttribute("user");
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		Message message = new Message(null, title, content, user,timestamp, timestamp, status);
		messageService.addMessage(message);
		
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
