package com.bits.cms.servlet;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bits.cms.entity.Events;
import com.bits.cms.entity.Paper;
import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;

/**
 * Servlet implementation class ReviewerServlet
 */
@WebServlet("/ReviewerServlet")
public class ReviewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final int BUFFER_SIZE = 4096;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		DBFacade facade = new DBServiceImpl();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		ArrayList<Paper> conferencePapers = null;
		if (action.equalsIgnoreCase("showpapers")) {
			
			String username = (String) session.getAttribute("username");
			try {
				conferencePapers = facade.getPapers(username);
				session.setAttribute("CONFERENCEPAPERS", conferencePapers);
				if(conferencePapers != null)
					System.out.println("list is not null");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/showPapers.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("reviewselectedpaper")){
			
			Boolean flag = false;
			String rating = request.getParameter("rating");
			String comment = request.getParameter("comment");
			String title = (String)session.getAttribute("ASSIGNRATINGTOPAPER");
			try {
				flag = facade.setRating(rating, comment, title);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(flag){
				response.sendRedirect("navReviewer.jsp");
			}
				
			
		}
	}
}
