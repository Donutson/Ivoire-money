package com.ivoiremoney.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivoiremoney.beans.Form;
import com.ivoiremoney.beans.User;
import com.ivoiremoney.models.DAOFactory;
import com.ivoiremoney.models.MySQLDAOFactory;
import com.ivoiremoney.models.UserDAO;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("isRegister", true);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/inscription.jsp"
				).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recuperation des données de l'utilisateur
		User user = new User((String) request.getParameter("nom"), 
				(String) request.getParameter("prenom"),
				(String) request.getParameter("mail"),
				(String) request.getParameter("phone"),
				(String) request.getParameter("identifiant"),
				(String) request.getParameter("password"),
				(String) request.getParameter("photo"));
		
		MySQLDAOFactory factory = (MySQLDAOFactory) DAOFactory.getFactory(DAOFactory.MySQL_DAO_FACTORY);
		UserDAO userdao = factory.getUserDAO();
		
		//vérification de la conformité des données
		Form form = new Form(user, (String) request.getParameter("confirm"));
		
		//si les données sont valide, on enregistre l'utilisateur
		//et on le rédirige vers la page de connexion
		if(form.isValid()) {
			userdao.create(user);
			if(userdao.find(user.getPhone()) != null) {
				request.setAttribute("success", "Inscription reussite!");
				request.setAttribute("user", user);
			}
				
			response.sendRedirect("connnexion");
		}else {
			request.setAttribute("user", user);
			request.setAttribute("form", form);
			doGet(request, response);
		}
	}

}
