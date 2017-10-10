package com.bits.cms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bits.cms.entity.Events;
import com.bits.cms.entity.Keydates;
import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;

/**
 * Servlet implementation class AttendeeServlet
 */
@WebServlet("/AttendeeServlet")
public class AttendeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		DBFacade facade = new DBServiceImpl();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("showvents")) {

			ArrayList<Events> conferenceEvents = null;
			ArrayList<Keydates> keydatesEvents = null;
			try {
				conferenceEvents = facade.getAllEvents();
				session.setAttribute("EVENTLIST", conferenceEvents);
				keydatesEvents = facade.getEventDates();
				session.setAttribute("EVENTDATES", keydatesEvents);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(conferenceEvents != null && keydatesEvents != null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/showEvents.jsp");
				dispatcher.forward(request, response);
			}
			else{
				System.out.println("recieved null");
			}
		} else if (action.equalsIgnoreCase("registerforevent")) {

			Boolean flag = false;
			//String eventname = (String) session.getAttribute("EVENTNAME");
			String eventname = request.getParameter("eventname");
			String username = (String) session.getAttribute("username");
			// System.out.println(eventid);
			// System.out.println(username);
			try {
				flag = facade.registerForEvents(eventname, username);
		        //session.setAttribute("EVENTNAME", "");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/navAttendee.jsp");
				dispatcher.forward(request, response);
			}
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}

}
