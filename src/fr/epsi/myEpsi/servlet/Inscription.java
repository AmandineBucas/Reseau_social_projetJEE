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
 * Servlet implementation class Inscription
 */
@WebServlet("/pages/register")

public class Inscription extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Authentification.class);
	
	// Nouveau service
	UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Constructeur
    public Inscription() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Demande de ressources
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Déclaration de l'id
		String id = request.getParameter("id");
		// Déclaration du mot de passe
		String password = request.getParameter("password");

		// Tentative de création d'un compte avec l'id (adresse mail) et le mot de passe
		try {
			userService.addUser(new User(id, password, false));
			logger.info("L'utilisateur a été créé.");
			request.getRequestDispatcher("/pages/home").forward(request, response);
		} catch (Exception e) {
			
			logger.error("L'utilisateur existe déjà", e);
			request.getRequestDispatcher("/pages/register").forward(request, response);
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
