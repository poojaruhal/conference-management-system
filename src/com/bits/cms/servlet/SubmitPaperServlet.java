package com.bits.cms.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;

/**
 * Servlet implementation class SubmitPaperServlet
 */
@WebServlet("/SubmitPaperServlet")
@MultipartConfig
public class SubmitPaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitPaperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
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
		
		
			//flag = facade.uploadPaper(inputStream, _title, _subjectarea, _description, _coauthor, _authorname);
			//flag = facade.uploadPaper(_paperfile, _title, _subjectarea, _description, _coauthor, _authorname);
		
		//System.out.println(flag);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/author.jsp");
		dispatcher.forward(request, response);
	}
	}

