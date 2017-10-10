package com.bits.cms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		DBFacade facade = new DBServiceImpl();
		HttpSession session = request.getSession();
		String _username = request.getParameter("username");
		String _password = request.getParameter("password");
		String role = "";
		
		try {
			role = facade.checkUserDetails(_username, _password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(_username);
		if(role != null){
			session.setAttribute("username", _username);
			System.out.println(role);
			//RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
			//dispatcher.include(request, response);	
			//System.out.println("FLAG IS SET"+_username);
			if(role.equalsIgnoreCase("author"))
			{
			response.sendRedirect("navAuthor.jsp");
			
			}	
			if(role.equalsIgnoreCase("reviewer"))
			{
				response.sendRedirect("navReviewer.jsp");
			}
		
			if(role.equalsIgnoreCase("editor"))
			{
				response.sendRedirect("navEditor.jsp");
			}
		
			if(role.equalsIgnoreCase("admin"))
			{
				response.sendRedirect("navAdmin.jsp");
			}
			if(role.equalsIgnoreCase("attendee"))
			{
				response.sendRedirect("navAttendee.jsp");
			}
						
		}
		else{
			session.setAttribute("username", "GUEST");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);	
			//System.out.println("FLAG IS NOT SET"+_username);
		}
		//RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
	}
}
