package com.bits.cms.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("submit")){
			
			HttpSession session = request.getSession();
			Boolean flag = false;
			DBFacade facade = new DBServiceImpl();
			String _title = request.getParameter("title");
			String _subjectarea = request.getParameter("subjectarea");
			String _description = request.getParameter("description");
			String _coauthor = request.getParameter("coauthor");
			String _authorname = request.getParameter("authorname");
			
			try {
				flag = facade.uploadPaper(_title, _subjectarea, _description, _coauthor, _authorname);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			//Part _paperfile = null;
			//_paperfile = request.getPart("paperfile"); // Retrieves <input type="file" name="uploadedFile">
	        //InputStream content = _paperfile.getInputStream();

			
	        //String fileName = _paperfile.getSubmittedFileName();
	        //System.out.println(fileName);
	        
	        //byte[] pdfcontent = new byte[(int) _paperfile.getSize()];
	        //DataInputStream dis = new DataInputStream(new FileInputStream(_paperfile));
	        //content.read(pdfcontent);
	        //content.close();
	        
//	        if(_paperfile != null){
//	        	System.out.println("UPLOADED!");
//	        	try {
//					flag = facade.uploadPaper(pdfcontent, _title, _subjectarea, _description, _coauthor, _authorname);
//				} catch (ClassNotFoundException | SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
			/*
			InputStream inputStream = null; 
			DBFacade facade = new DBServiceImpl();
			Part _paperfile = request.getPart("paper");
			String _title = request.getParameter("title");
			String _subjectarea = request.getParameter("subjectarea");
			String _description = request.getParameter("description");
			String _coauthor = request.getParameter("coauthor");
			String _authorname = request.getParameter("authorname");
			Boolean flag = false;
			
			
			if (_paperfile != null) {
				
				System.out.println(_paperfile.getName());
	            System.out.println(_paperfile.getSize());
	            System.out.println(_paperfile.getContentType());
	            inputStream = _paperfile.getInputStream();
	        }
			else{
				System.out.println("no file uploaded");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/author.jsp");
				dispatcher.forward(request, response);
			}
			
			//final byte[] bytes = new byte[inputStream.available()];
			//inputStream.read(bytes);
			
			try {
				flag = facade.uploadPaper(inputStream, _title, _subjectarea, _description, _coauthor, _authorname);
				//flag = facade.uploadPaper(_paperfile, _title, _subjectarea, _description, _coauthor, _authorname);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(flag);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/author.jsp");
			dispatcher.forward(request, response);
			
			*/
	        if(flag){
	        	session.setAttribute("PAPERTOBESUBMITTED", _title);
	        	RequestDispatcher dispatcher=request.getRequestDispatcher("/submitpaper.jsp");
	        	dispatcher.forward(request, response);
	        }
		}
		
		if(action.equalsIgnoreCase("track")){
			
			DBFacade facade = new DBServiceImpl();
			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("username");
			String title = request.getParameter("title");
			try {
				String status = facade.trackPaper(username, title);
				System.out.println(status);
				request.setAttribute("status", status);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("navAuthor.jsp?").forward(request, response);
		}
		
		if(action.equalsIgnoreCase("withdraw")){
			Boolean flag=false;
			DBFacade facade = new DBServiceImpl();
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			String title = request.getParameter("title");
			try {
				flag = facade.withdrawPaper(username,title);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(flag){
	        	
	        	RequestDispatcher dispatcher=request.getRequestDispatcher("/navAuthor.jsp");
	        	dispatcher.forward(request, response);
	        }
	        else{
	        	
	        	RequestDispatcher dispatcher=request.getRequestDispatcher("");
	        	dispatcher.forward(request, response);
	        }
		}
	}
		
	

}
