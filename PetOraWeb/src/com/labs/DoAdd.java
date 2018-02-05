package com.labs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoAdd
 */
@WebServlet("/DoAdd")
public class DoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//@EJB(lookup="java:global/PetOraEar/PetOraEjb/PrintBean!com.labs.PrintRemote ")
    //private PrintRemote printer;
	
	@EJB(lookup="java:global/PetOraEar/PetOraEjb/PrintBean!com.labs.PrintBean")
    private PrintBean printer;
	
	//@EJB
    //private PrintBean printer;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String as=request.getParameter("a");
		int a=Integer.parseInt(as);
		as=request.getParameter("b");
		int b=Integer.parseInt(as);
		
		String result="";
		
		try {
			result=printer.sayHello("ok now servlet to ejb. a+b=" + (a+b));
		}catch(Exception e){e.printStackTrace();}
 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Results for the addition</h3>");
		out.println("Result:"+result);		
	}

}
