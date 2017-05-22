package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.MessageService;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/Messages")
public class MessagesS extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	MessagesS messageService = new MessagesS();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Constructeur
    public MessagesS() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Demande de ressources
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Création dune liste de messages
		List<Message> messages = new ArrayList<>();
		User user = (User) request.getSession().getAttribute("user");
		
		String id = request.getParameter("idMessage");
		if(id == null){
			messages = messageService.getAllMessages(user);
		}else {
			messages.add(messageService.getMessage(Long.valueOf(id)));
		}
		request.getSession().setAttribute("Messages", messages);
		request.getRequestDispatcher("/Pages/Messages.jsp").forward(request, response);
	}

	private List<Message> getAllMessages(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private Message getMessage(Long valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// Permet d'envoyer des informations
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}