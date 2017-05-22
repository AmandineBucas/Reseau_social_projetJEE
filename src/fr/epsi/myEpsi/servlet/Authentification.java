package fr.epsi.myEpsi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Pages/Connection")
public class Authentification extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Authentification.class);
	
	// Nouveau service
	UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Constructeur
    public Authentification() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Demande de ressources
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Récupération de l'id
		User user = userService.getUserById(request.getParameter("id"));
		
		// Comparaison des mots de passe
		if(user.getPassword().equals(request.getParameter("password"))){
			
			// Retourne la session de l'utilisateur
			request.getSession().setAttribute("user", user);
			
			// Inclu la ressource dans la réponse
			request.getRequestDispatcher("/Pages/Home").forward(request, response);
			
		}else{
			request.getRequestDispatcher("/Pages/Connection.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// Permet d'envoyer des informations
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
