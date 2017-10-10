package com.bits.cms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		DBFacade facade = new DBServiceImpl();
		String _firstname = request.getParameter("firstname");
		String _lastname = request.getParameter("lastname");
		String _phonenumber = request.getParameter("phonenumber");
		String _emailaddress = request.getParameter("emailaddress");
		String _qualification = request.getParameter("qualification");
		String _city = request.getParameter("city");
		String _country = request.getParameter("country");
		String _pincode = request.getParameter("pincode");
		String _username = request.getParameter("username");
		String _password = request.getParameter("password");
		String _role = request.getParameter("role");
		Boolean flag = false;
		
		try {
			System.out.println("Calling registerUser");
			flag = facade.registerUser(_firstname, _lastname, _phonenumber, _emailaddress, _qualification, _city, _country, _pincode, _username, _password, _role);
			System.out.println("Calling registerUser successful, flag value is "+flag);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher=request.getRequestDispatcher("/register.jsp");
			dispatcher.include(request, response);
		}
		/*
		if(_firstname.isEmpty() || _phonenummber.isEmpty()||_emailaddress.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			System.out.println(" invalid fields");
			rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		*/
	}

}
