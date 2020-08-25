package com.ivoiremoney.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ivoiremoney.beans.FormConnect;
import com.ivoiremoney.beans.User;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("isConnect", true);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = new User(request.getParameter("identifiant"), request.getParameter("password"));
		FormConnect form = new FormConnect(user);
		if(form.isValid()) {
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);
			session.setAttribute("user", form.getPuser());
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("user", user);
			request.setAttribute("form", form);
			doGet(request, response);
		}
		
	}

}
