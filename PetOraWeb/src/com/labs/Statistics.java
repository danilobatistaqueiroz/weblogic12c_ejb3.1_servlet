package com.labs;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Statistics")
public class Statistics extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public Statistics() {
        super();
    }

	@EJB
    private StatisticsRemote statistics;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		statistics.addUser("user x");
		Integer qtd = statistics.getLoggedUsers();
		System.out.println("quantity:"+qtd);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/statistics.jsp?quantity="+qtd);
        requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
