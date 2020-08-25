package com.ivoiremoney.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ivoiremoney.beans.FormTransfert;
import com.ivoiremoney.beans.User;

/**
 * Servlet implementation class Transfert
 */
@WebServlet("/Transfert")
public class Transfert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/transfert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User dest = new User(request.getParameter("identifiant"));
		HttpSession session = request.getSession();
		FormTransfert form = new FormTransfert((User) session.getAttribute("user"), 
				dest, 
				Double.parseDouble(request.getParameter("amount")));
		form.makeTransfer();
		
		request.setAttribute("form", form);
		doGet(request, response);
		
		
	}

}
