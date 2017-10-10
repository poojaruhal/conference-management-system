package com.bits.cms.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bits.cms.entity.Deadline;
import com.bits.cms.entity.Paper;
import com.bits.cms.entity.Reviewer;
import com.bits.cms.entity.Speaker;
import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;


/**
 * Servlet implementation class EditorServlet
 */
@WebServlet("/EditorServlet")
public class EditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String delete = request.getParameter("delete");
    	String username = request.getParameter("username");
    	String importantevents = request.getParameter("importantEvents");
    	
    	boolean flag = false;
    	DBFacade facade = new DBServiceImpl();
		if(delete!= null)
		{
			if(delete.equalsIgnoreCase("reviewer"))
			{
				flag = facade.deleteReviwer(username);
				response.sendRedirect("navEditor.jsp");
			}
			else if(delete.equalsIgnoreCase("importantevents")){
				flag=facade.delDeadlines(importantevents);
				response.sendRedirect("navEditor.jsp");
			}
		}
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action.equalsIgnoreCase("createconference")) {
			String _name = request.getParameter("name");
			String _description = request.getParameter("description");
			String _startdate = request.getParameter("startdate");
			String _starttime = request.getParameter("starttime");
			String _enddate = request.getParameter("enddate");
			String _endtime = request.getParameter("endtime");
			String _subject1 = request.getParameter("subject1");
			String _subject2 = request.getParameter("subject2");
			String _subject3 = request.getParameter("subject3");
			String _subject4 = request.getParameter("subject4");
			String _subject5 = request.getParameter("subject5");
			String _venuename = request.getParameter("venuename");
			String _city = request.getParameter("city");
			String _country = request.getParameter("country");
			String _pincode = request.getParameter("pincode");
			Boolean flag = false;
			DBFacade facade = new DBServiceImpl();

			try {
				flag = facade.createConference(_name, _description, _startdate, _starttime, _enddate, _endtime,
						_subject1, _subject2, _subject3, _subject4, _subject5, _venuename, _city, _country, _pincode);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag) {
				response.sendRedirect("navEditor.jsp");
			} else {

			}
		}

				if (action.equalsIgnoreCase("modifyspeakers")) {

			DBFacade facade = new DBServiceImpl();
			ArrayList<Speaker> speakerList = new ArrayList<Speaker>();

			try {
				speakerList = facade.getspeakers();

				session.setAttribute("SPEAKERLIST", speakerList);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("showSpeakers.jsp");

		}
				
				if(action.equalsIgnoreCase("addreviewer")){
					
					String _firstname = request.getParameter("firstname");
					String _lastname = request.getParameter("lastname");
					int _phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
					String _emailaddress = request.getParameter("email");
					String _qualification = request.getParameter("qualification");
					String _city = request.getParameter("city");
					String _country = request.getParameter("country");
					int _pincode = Integer.parseInt(request.getParameter("pincode"));
					String _username = request.getParameter("username");
					String _password = request.getParameter("password");
					String _role = request.getParameter("role");
					String _expertarea = request.getParameter("expertarea");
					Boolean flag = false;
					DBFacade facade = new DBServiceImpl();
					try {
						System.out.println("Calling registerUser");
						flag = facade.addReviewer(_firstname, _lastname, _phonenumber, _emailaddress, _qualification, _city, _country, _pincode, _username, _password, _role, _expertarea);
						System.out.println("Calling registerUser successful, flag value is "+flag);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(flag){
						/*RequestDispatcher dispatcher=request.getRequestDispatcher("/navEditor.jsp");
						dispatcher.forward(request, response);*/
					    response.sendRedirect("navEditor.jsp");
					}
					else{
						   //response.sendRedirect("modifyreviewer.jsp");
					}
					
				}
				
				if (action.equalsIgnoreCase("delreviewer")) {
					System.out.println("Size+++++=====");
					ArrayList<Reviewer> showReviewrsList;
					DBFacade facade = new DBServiceImpl();
				try {
					showReviewrsList = facade.getAllreviewer();
					session.setAttribute("REVIEWERLIST", showReviewrsList);
					
					int size = showReviewrsList.size();
					System.out.println("Size "+size);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					response.sendRedirect("showReviewersList.jsp");
					
					}
				
				
				if (action.equalsIgnoreCase("deldeadlines")) {
					System.out.println("keydates Size+++++=====");
					DBFacade facade = new DBServiceImpl();	
					ArrayList<Deadline> deadlinesList;
					deadlinesList = facade.getAlldeadlines();
				    session.setAttribute("DEADLINESLIST", deadlinesList);
			
				int size = deadlinesList.size();
				System.out.println("Size "+size);
					response.sendRedirect("showdeadlines.jsp");
					
					}
				
				
				if(action.equalsIgnoreCase("adddeadlines")){
					String deadlineDate = request.getParameter("deadline");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					//surround below line with try catch block as below code throws checked exception
					java.util.Date endDate = null;
					try {
						endDate = sdf.parse(deadlineDate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String _importantevents = request.getParameter("importanteventname");
					Boolean flag = false;
					
					try {
						DBFacade facade = new DBServiceImpl();
						System.out.println("Calling registerUser");
						flag = facade.adddeadlines(_importantevents, endDate);
						System.out.println("Calling registerUser successful, flag value is "+flag);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(flag){
						   response.sendRedirect("navEditor.jsp");
					}
					else{
						   response.sendRedirect("modifyreviewer.jsp");
					}
				}
				if(action.equalsIgnoreCase("evaluatepaper")){
					DBFacade facade = new DBServiceImpl();
					ArrayList<Paper> conferencePapers = null;
					try {
						conferencePapers = facade.getPapers();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					session.setAttribute("ALLCONFERENCEPAPERS", conferencePapers);
					if(conferencePapers != null)
						System.out.println("list is not null");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/showPapersEditor.jsp");
					dispatcher.forward(request, response);
				}
				
				if(action.equalsIgnoreCase("evaluateselectedpaper")){
					Boolean flag = false;
					String title = (String) session.getAttribute("PAPTITLE");
					String status = request.getParameter("status");
					DBFacade facade = new DBServiceImpl();
					try {
						flag = facade.evaluatePaper(title, status);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(flag){
						RequestDispatcher dispatcher = request.getRequestDispatcher("/navEditor.jsp");
						dispatcher.forward(request, response);
					}
					else{
						System.out.println(title);
						System.out.println(status);
					}
				}
				if (action.equalsIgnoreCase("assignreviewer")) {
					//System.out.println(" assign reviewer paper entry+++++=====");
					DBFacade facade = new DBServiceImpl();
					ArrayList<Paper> showPaperList= null;
						try {
							showPaperList= facade.getAllPapers();
						    session.setAttribute("ASSIGNPAPERLIST", showPaperList);
							
//						    int size=showPaperList.size();
//						    
//							System.out.println("Size of paper list "+size);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					
					response.sendRedirect("showPapers2.jsp");
					
					}
					
				if (action.equalsIgnoreCase("paperassignedreviewer")) {
					System.out.println(" 1st call");
					ArrayList<Reviewer> showReviewrsList;
					DBFacade facade = new DBServiceImpl();
				try {
					showReviewrsList = facade.getAllreviewer();
					
					session.setAttribute("REVIEWERLIST2", showReviewrsList);
					
					int size = showReviewrsList.size();
					System.out.println("Size "+size);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("/showReviewerList2.jsp");
				dispatcher.forward(request, response);
					}
				if (action.equalsIgnoreCase("finalassignreviewer")) {
					System.out.println("in SERVLET!!!!!!!!!!");
						DBFacade facade = new DBServiceImpl();
						String usernameReviewer=request.getParameter("reviewername");
						String assignedpaperTitle= (String) session.getAttribute("ASSIGNPAPERTITLE");
						System.out.println("....username..."+usernameReviewer);
					   try {
					boolean hu=	facade.setPaperReviewer(assignedpaperTitle,usernameReviewer);
						System.out.println("000000000000000000 flag "+hu);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//	System.out.println("Size "+size);
						response.sendRedirect("navEditor.jsp");
						
						}
	}

}
