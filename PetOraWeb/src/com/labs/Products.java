package com.labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Products() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	@EJB(lookup="ejb/cartejb")
	private CartRemote cart;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product = request.getParameter("product");
		cart.add(product);
		
		String result="";
		
		try {
			result="shop cart items: " + Arrays.toString(cart.getItens().toArray()) + " - total:"+cart.getQuantity();
		}catch(Exception e){e.printStackTrace();}
 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='products.jsp'>go to products</a>");
		out.println("Result:"+result);	
		
		doGet(request, response);
	}

}
